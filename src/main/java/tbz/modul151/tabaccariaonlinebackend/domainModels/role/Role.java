package tbz.modul151.tabaccariaonlinebackend.domainModels.role;

import org.hibernate.annotations.*;
import tbz.modul151.tabaccariaonlinebackend.domainModels.authority.Authority;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role  {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Generated(GenerationTime.ALWAYS)
    @Column(name = "id")
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinTable(
            name = "role_authority",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id")
    )
    private Set<Authority> authorities;

    public Role() {
        super();
    }

    public String getName() {
        return name;
    }

    public Role setName(String name) {
        this.name = name;
        return this;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public Role setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
        return this;
    }
}

