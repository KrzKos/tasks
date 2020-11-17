package pl.kostkiewicz.tasks.mapper;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.kostkiewicz.tasks.dto.UserDTO;
import pl.kostkiewicz.tasks.model.User;

@Component
@Slf4j
public class UserMapper {

    public UserDTO from(User user) {
        log.info("User before: {}", user);
        ModelMapper modelMapper = new ModelMapper();
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        log.info("User after: {}", userDTO);
        return userDTO;
    }
    public User from(UserDTO userDTO){
        log.info("User before: {}", userDTO);
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userDTO, User.class);

        log.info("User after: {}", userDTO);
        return user;
    }
}
