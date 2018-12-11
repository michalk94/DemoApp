package congerence.room.manager.demoapp.booking;


import congerence.room.manager.demoapp.exception.RoomNotFoundException;
import congerence.room.manager.demoapp.exception.UserNotFoundException;
import congerence.room.manager.demoapp.room.Room;
import congerence.room.manager.demoapp.room.RoomRepository;
import congerence.room.manager.demoapp.user.User;
import congerence.room.manager.demoapp.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoomRepository roomRepository;

    BookingService(BookingRepository bookingRepository
            , UserRepository userRepository, RoomRepository roomRepository) {
        this.bookingRepository = bookingRepository;
        this.roomRepository = roomRepository;
        this.userRepository = userRepository;
    }


    List<BookingDto> findAll() {
        return bookingRepository.findAll()
                .stream()
                .map(BookingMapper::toDto)
                .collect(Collectors.toList());
    }

    BookingDto createBooking(BookingDto bookingDto) {
        checkIfUserExists(bookingDto.getLogin());
        checkCredentialsForUser(bookingDto.getLogin(), bookingDto.getPassword());
        checkIfRoomExists(bookingDto.getRoomName());
        checkIfRoomIsOccupied(bookingDto.getRoomName());
        Booking createdBooking = processBooking(bookingDto);
        return BookingMapper.toDto(createdBooking);
    }

    private void checkIfUserExists(String login) {
        userRepository.findById(login).orElseThrow(() -> new UserNotFoundException("Login" + login));
    }

    private void checkCredentialsForUser(String login, String password) {

    }

    private void checkIfRoomExists(String roomName) {
        roomRepository.findById(roomName).orElseThrow(() -> new RoomNotFoundException("Room" + roomName));
    }

    private void checkIfRoomIsOccupied(String roomName) {
    }

    private Booking processBooking(BookingDto bookingDto) {
        User user = userRepository.getOne(bookingDto.getLogin());
        Room room = roomRepository.getOne(bookingDto.getRoomName());
        Booking bookingEntity = BookingMapper.toEntity(bookingDto, user, room);
        user.getBookings().add(bookingEntity);
        room.getBookings().add(bookingEntity);
        Booking createdBooking = bookingRepository.save(bookingEntity);
        userRepository.save(user);
        roomRepository.save(room);
        return createdBooking;
    }

    List<BookingDto> getBookinForSingleRoom(String roomName) {
        checkIfRoomExists(roomName);
        Room room = roomRepository.findById(roomName).get();
        List<BookingDto> bookingDtos = room.getBookings().stream().map(BookingMapper::toDto).collect(Collectors.toList());
        return bookingDtos;
    }

    List<BookingDto> getBookinForSingleUser(String login) {
        checkIfUserExists(login);
        User user = userRepository.findById(login).get();
        List<BookingDto> bookingDtos = user.getBookings().stream().map(BookingMapper::toDto).collect(Collectors.toList());
        return bookingDtos;
    }


}



