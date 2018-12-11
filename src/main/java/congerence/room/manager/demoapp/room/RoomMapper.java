package congerence.room.manager.demoapp.room;

public class RoomMapper {

    static RoomDto toDto(Room room) {
        RoomDto dto = new RoomDto();
        dto.setRoomName(room.getRoomName());
        dto.setLocationDescription(room.getLocationDescription());
        dto.setNumberOfSeats(room.getNumberOfSeats());
        dto.setProjector(room.isProjector());
        dto.setPhoneNumber(room.getPhoneNumber());
        return dto;
    }

    static Room toEntity(RoomDto roomDto) {
        Room entity = new Room();
        entity.setRoomName(roomDto.getRoomName());
        entity.setLocationDescription(roomDto.getLocationDescription());
        entity.setNumberOfSeats(roomDto.getNumberOfSeats());
        entity.setProjector(roomDto.isProjector());
        entity.setProjector(roomDto.isProjector());
        entity.setPhoneNumber(roomDto.getPhoneNumber());
        return entity;
    }

    static Room toEntity(Room dbRoom, RoomDto room) {
        if (room.getRoomName() != null && !room.getRoomName().trim().isEmpty()) {
            dbRoom.setRoomName(room.getRoomName());
        }

        if (room.getLocationDescription() != null && !room.getLocationDescription().trim().isEmpty()) {
            dbRoom.setLocationDescription(room.getLocationDescription());
        }
        if (room.getNumberOfSeats() != null) {
            dbRoom.setNumberOfSeats(room.getNumberOfSeats());
        }
        if (room.getPhoneNumber() != null && !room.getPhoneNumber().trim().isEmpty()) {
            dbRoom.setPhoneNumber(room.getPhoneNumber());
        }

        return dbRoom;
    }
}


