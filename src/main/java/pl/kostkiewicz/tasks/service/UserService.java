package pl.kostkiewicz.tasks.service;

import pl.kostkiewicz.tasks.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserDTO create(UserDTO userDTO);
    List<UserDTO> findAll();
    UserDTO findById(long id);
}
