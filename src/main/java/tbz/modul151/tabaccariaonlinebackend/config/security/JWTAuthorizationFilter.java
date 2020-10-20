package tbz.modul151.tabaccariaonlinebackend.config.security;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import tbz.modul151.tabaccariaonlinebackend.domainModels.user.User;
import tbz.modul151.tabaccariaonlinebackend.domainModels.user.UserDetailsImpl;
import tbz.modul151.tabaccariaonlinebackend.domainModels.user.UserService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTAuthorizationFilter extends OncePerRequestFilter {

    private UserService userService;
    private PropertyReader propertyReader;

    JWTAuthorizationFilter(UserService userService, PropertyReader propertyReader) {
        this.userService = userService;
        this.propertyReader = propertyReader;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String header = request.getHeader(propertyReader.getStringProperty("jwt.header-string"));
        if (header != null && header.startsWith(propertyReader.getStringProperty("jwt.token-prefix"))) {
            SecurityContextHolder.getContext().setAuthentication(getAuthentication(request, header));
        }
        filterChain.doFilter(request, response);
    }

    private Authentication getAuthentication(HttpServletRequest request, String header){
        String subject;
        try {
            subject = Jwts.parser()
                    .setSigningKey(propertyReader.getStringProperty("jwt.secret").getBytes())
                    .parseClaimsJws(header.replace(propertyReader.getStringProperty("jwt.token-prefix"), "")).getBody()
                    .getSubject();
        } catch (ExpiredJwtException ex) {
            return null;
        }

        if (subject != null) {
            User user = userService.getUserById(subject);
            UserDetailsImpl userDetails = new UserDetailsImpl(user);

            return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        }
        return null;
    }

}
