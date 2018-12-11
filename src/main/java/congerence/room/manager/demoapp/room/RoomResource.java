package congerence.room.manager.demoapp.room;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomResource {

    @Autowired
    private RoomService roomService;

    public RoomResource(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("")
    List<RoomDto> findAll() {
        return roomService.findAll();
    }

    @PostMapping("/create")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<RoomDto> createRoom(@RequestBody RoomDto roomDto) {
        RoomDto savedRoom = roomService.createRoom(roomDto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{roomName}")
                .buildAndExpand(savedRoom.getRoomName())
                .toUri();
        return ResponseEntity.created(location).body(savedRoom);
    }

    @PutMapping("/{roomName}")
    public ResponseEntity<RoomDto> update(@PathVariable String roomName, @RequestBody RoomDto roomDto) {
        RoomDto updatedRoom = roomService.editRoom(roomDto);
        return ResponseEntity.ok(updatedRoom);
    }

    @DeleteMapping("/delete/{roomName}")
    public ResponseEntity<RoomDto> deleteRoom(@PathVariable String roomName) {
        roomService.deleteUser(roomName);
        return ResponseEntity.ok().build();
    }

}
