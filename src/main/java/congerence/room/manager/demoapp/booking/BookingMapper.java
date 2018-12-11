package congerence.room.manager.demoapp.booking;


import congerence.room.manager.demoapp.room.Room;
import congerence.room.manager.demoapp.user.User;

public class BookingMapper {

    static BookingDto toDto(Booking booking) {
        BookingDto dto = new BookingDto();
        dto.setId(booking.getId());
        dto.setLogin(booking.getUser().getLogin());
        dto.setRoomName(booking.getRoom().getRoomName());
        dto.setStart(booking.getStart());
        dto.setEnd(booking.getEnd());
        return dto;
    }

    static Booking toEntity(BookingDto booking, User user, Room room) {
        Booking bookingEntity = new Booking();
        bookingEntity.setId(booking.getId());
        bookingEntity.setUser(user);
        bookingEntity.setRoom(room);
        bookingEntity.setStart(booking.getStart());
        bookingEntity.setEnd(booking.getEnd());
        return bookingEntity;
    }


}