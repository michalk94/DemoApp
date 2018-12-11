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

    static User toEntity(User dbUser, UserDto userDto){
        if (userDto.getName() != null && !userDto.getName().trim().isEmpty()){
            dbUser.setName(userDto.getName());
        }
        if (userDto.getLastName() != null && !userDto.getLastName().trim().isEmpty()){
            dbUser.setLastName(userDto.getLastName());
        }
        if (userDto.getPassword() != null && !userDto.getPassword().trim().isEmpty()){
            dbUser.setPassword(userDto.getPassword());
        }
        return dbUser;
    }


}
