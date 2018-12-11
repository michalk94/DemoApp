package congerence.room.manager.demoapp.room;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Room {

    @Id
    private String roomName;

    private String locationDescription;

    private Integer numberOfSeats;

    private boolean projector;

    private String phoneNumber;

    public Room() {
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
}
