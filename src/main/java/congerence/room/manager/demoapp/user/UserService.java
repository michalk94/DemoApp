package congerence.room.manager.demoapp.user;


import congerence.room.manager.demoapp.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    List<UserDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toDto)
                .collect(Collectors.toList());
    }

    UserDto createUser(UserDto userDto){
        User userEntity = UserMapper.toEntity(userDto);
        User createdUser = userRepository.save(userEntity);
        return UserMapper.toDto(createdUser);
    }

    UserDto editUser(UserDto userDto){
        User dbUser = userRepository
                .findById(userDto.getLogin())
                .orElseThrow(() -> new UserNotFoundException("Login" + userDto.getLogin()));
        return mapAndSaveUser(dbUser, userDto);
    }
    private UserDto mapAndSaveUser(User dbUser, UserDto userDto){
        dbUser = UserMapper.toEntity(dbUser,userDto);
        User savedUser = userRepository.save(dbUser);
        return UserMapper.toDto(savedUser);
    }

}
