package congerence.room.manager.demoapp.room;


import congerence.room.manager.demoapp.booking.Booking;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class Room {

    @Id
    private String roomName;

    private String locationDescription;

    private Integer numberOfSeats;

    private boolean projector;

    private String phoneNumber;

    @OneToMany(mappedBy = "room")
    private List<Booking> bookings;

    public Room() {
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
}
