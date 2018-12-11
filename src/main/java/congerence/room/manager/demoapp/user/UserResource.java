package congerence.room.manager.demoapp.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    List<UserDto> findAll() {
        return userService.findAll();
    }

    @PostMapping("/register")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto savedUser = userService.createUser(userDto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{login}")
                .buildAndExpand(savedUser.getLogin())
                .toUri();
        return ResponseEntity.created(location).body(savedUser);

    }

    @PutMapping("/{login}")
    public ResponseEntity<UserDto> update(@PathVariable String login, @RequestBody UserDto userDto){
        UserDto updateUser = userService.editUser(userDto);
        return ResponseEntity.ok(updateUser);
    }

    @DeleteMapping("/delete/{login}")
    public ResponseEntity<UserDto> deleteUser(@PathVariable String login){
        userService.deleteUser(login);
        return ResponseEntity.ok().build();
    }
}
