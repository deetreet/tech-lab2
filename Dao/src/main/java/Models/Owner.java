package Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Model of owner
 * Matches with table "users" in database
 */
@Entity
@Table(name = "users")
@Getter
@Setter
public class Owner {
    public Owner() {
        cats = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private Integer ownerId;

    private String name;

    @Column(name = "dateofbirth")
    private Date dateOfBirth;

    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Cat> cats;
}
