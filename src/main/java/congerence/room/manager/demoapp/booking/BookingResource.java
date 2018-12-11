package congerence.room.manager.demoapp.booking;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingResource {

    @Autowired
    BookingService bookingService;

    public BookingResource(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("")
    List<BookingDto> findAll() {
        return bookingService.findAll();
    }

    @GetMapping("/room/{roomName}")
    List<BookingDto> findBookinForSingleRoom(@PathVariable String roomName) {
        return bookingService.getBookinForSingleRoom(roomName);
    }

    @GetMapping("/user/{login}")
    List<BookingDto> findBookinForSingleUser(@PathVariable String login) {
        return bookingService.getBookinForSingleUser(login);
    }

    @PostMapping("/create")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<BookingDto> createRoom(@RequestBody BookingDto bookingDto) {
        BookingDto savedBooking = bookingService.createBooking(bookingDto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedBooking.getId())
                .toUri();
        return ResponseEntity.created(location).body(savedBooking);

    }
}


