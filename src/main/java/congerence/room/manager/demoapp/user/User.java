package congerence.room.manager.demoapp.user;


import congerence.room.manager.demoapp.booking.Booking;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class User {

    private String name;

    private String LastName;

    @Id
    private String login;

    private String password;

    @OneToMany(mappedBy = "user")
    private List<Booking> bookings;

    public User() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
