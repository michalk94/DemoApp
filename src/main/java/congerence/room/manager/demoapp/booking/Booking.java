package congerence.room.manager.demoapp.booking;


import congerence.room.manager.demoapp.room.Room;
import congerence.room.manager.demoapp.user.User;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date start;

    private Date end;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_login")
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "room_name")
    private Room room;

    public Booking() {
    }
}
