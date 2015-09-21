package pas.au.ibm.ctp.cba.parking.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ParkingUsers
{
    @Id @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private String email;
    private String accPassword;
    private String mobileno;

    public ParkingUsers() {
    }

    public ParkingUsers(String accPassword, String email, String mobileno) {
        this.accPassword = accPassword;
        this.email = email;
        this.mobileno = mobileno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getAccPassword() {
        return accPassword;
    }

    public void setAccPassword(String accPassword) {
        this.accPassword = accPassword;
    }

    @Override
    public String toString() {
        return "ParkingUsers{" +
                "accPassword='" + accPassword + '\'' +
                ", id=" + id +
                ", email='" + email + '\'' +
                ", mobileno='" + mobileno + '\'' +
                '}';
    }
}
