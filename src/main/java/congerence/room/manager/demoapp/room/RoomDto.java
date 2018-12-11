package congerence.room.manager.demoapp.room;


import lombok.Data;

@Data
public class RoomDto {

    private String roomName;

    private String locationDescription;

    private Integer numberOfSeats;

    private boolean projector;

    private String phoneNumber;
}
