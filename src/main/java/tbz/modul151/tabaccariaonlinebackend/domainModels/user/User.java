package tbz.modul151.tabaccariaonlinebackend.domainModels.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.*;
import tbz.modul151.tabaccariaonlinebackend.domainModels.article.Article;
import tbz.modul151.tabaccariaonlinebackend.domainModels.role.Role;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Generated(GenerationTime.ALWAYS)
    @Column(name = "id")
    private String id;


    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "firstname", nullable = false)
    private String firstName;

    @Column(name = "lastname", nullable = false)
    private String lastName;

    @Column(name = "account_expiration_date")
    private LocalDate accountExpirationDate;

    @Column(name = "credentials_expiration_date")
    private LocalDate credentialsExpirationDate;

    @Column(name = "locked")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean locked;

    @Column(name = "enabled")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean enabled;

   /* @Column(name = "enabled", nullable = false)
    private boolean enabled;

    */

    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private String addressId;

    @JoinColumn(name = "place_id", referencedColumnName = "id")
    private String placeId;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "users_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<Role> roles;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "users_articles",
            joinColumns = @JoinColumn(name = "users_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "article_id", referencedColumnName = "id")
    )
    private List<Article> articles;

    /*
    @JsonManagedReference(value="user-order")
    @OneToMany(mappedBy="user")
    private List<Order> orders;

     */

    // Standard empty constructor
    public User() {
        this.accountExpirationDate = LocalDate.now().plusYears(2);
        this.credentialsExpirationDate = LocalDate.now().plusYears(2);
        this.locked = false;
        this.enabled = true;
    }

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getAccountExpirationDate() {
        return accountExpirationDate;
    }

    public void setAccountExpirationDate(LocalDate accountExpirationDate) {
        this.accountExpirationDate = accountExpirationDate;
    }

    public LocalDate getCredentialsExpirationDate() {
        return credentialsExpirationDate;
    }

    public void setCredentialsExpirationDate(LocalDate credentialsExpirationDate) {
        this.credentialsExpirationDate = credentialsExpirationDate;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    /*
    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

     */
}
