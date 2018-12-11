package congerence.room.manager.demoapp.user;

public class UserMapper {

    static UserDto toDto(User user){
        UserDto dto = new UserDto();
        dto.setName(user.getName());
        dto.setLastName(user.getLastName());
        dto.setLogin(user.getLogin());
        dto.setPassword(user.getPassword());
        return dto;
    }

    static User toEntity(UserDto userDto) {
        User entity = new User();
        entity.setName(userDto.getName());
        entity.setLastName(userDto.getLastName());
        entity.setLogin(userDto.getLogin());
        entity.setPassword(userDto.getPassword());
        return entity;
    }


}
