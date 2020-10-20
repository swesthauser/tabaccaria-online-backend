package tbz.modul151.tabaccariaonlinebackend.domainModels.authority;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "authority")
public class Authority  {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Generated(GenerationTime.ALWAYS)
    @Column(name = "id")
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    public Authority() {
        super();
    }

    public String getName() {
        return name;
    }

    public Authority setName(String name) {
        this.name = name;
        return this;
    }

}
