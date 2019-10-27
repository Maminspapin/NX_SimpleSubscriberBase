package nx_alc.subscriber;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "subscribers")
@Getter @Setter @ToString @NoArgsConstructor
public class Subscriber {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "msisdn")
    private String msisdn;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "balance")
    private double balance;

    @Column(name = "status")
    private Status status;

    public Subscriber(String name, String lastname, String msisdn, double balance) {
        this.name = name;
        this.lastname = lastname;
        this.msisdn = msisdn;
        this.balance = balance;
        this.status = this.balance > 0 ? Status.ACTIVE : Status.BLOCKED;
    }
}
