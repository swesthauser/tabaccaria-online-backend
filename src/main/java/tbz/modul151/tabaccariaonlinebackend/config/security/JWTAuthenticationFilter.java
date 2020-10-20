package tbz.modul151.tabaccariaonlinebackend.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;
import tbz.modul151.tabaccariaonlinebackend.domainModels.user.User;
import tbz.modul151.tabaccariaonlinebackend.domainModels.user.UserDetailsImpl;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class JWTAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private PropertyReader propertyReader;

    JWTAuthenticationFilter(
            RequestMatcher requiresAuthenticationRequestMatcher,
            AuthenticationManager authenticationManager,
            PropertyReader propertyReader
    ) {
        super(requiresAuthenticationRequestMatcher);
        setAuthenticationManager(authenticationManager);
        this.propertyReader = propertyReader;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
            throws AuthenticationException {
        try {
            User creds = new ObjectMapper().readValue(req.getInputStream(), User.class);
            return getAuthenticationManager()
                    .authenticate(new UsernamePasswordAuthenticationToken(creds.getEmail(), creds.getPassword()));
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain, Authentication auth)
        throws IOException {

        // Adds the UserDetailsImpl logic to the authenticated user
        UserDetailsImpl userDetailsImpl = (UserDetailsImpl) auth.getPrincipal();
        User user = userDetailsImpl.getUser();
        String subject = user.getId();

        //Builds the JWT
        String token = Jwts.builder().setSubject(subject)
                .setExpiration(
                        new Date(System.currentTimeMillis() + propertyReader.getIntProperty("jwt.expiration-time")))
                .signWith(SignatureAlgorithm.HS512, propertyReader.getStringProperty("jwt.secret").getBytes())
                .compact();
        res.addHeader(propertyReader.getStringProperty("jwt.header-string"),
                propertyReader.getStringProperty("jwt.token-prefix") + token);
        // Expose the Headers
        res.addHeader("Access-Control-Expose-Headers", propertyReader.getStringProperty("jwt.header-string") );

        // Put the user into the response body
        String userString = new ObjectMapper().writeValueAsString(user);

        res.getWriter().write(userString);

        res.setContentType("application/json");
    }
}

