package pl.kostkiewicz.tasks.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kostkiewicz.tasks.dto.UserDTO;
import pl.kostkiewicz.tasks.mapper.UserMapper;
import pl.kostkiewicz.tasks.model.User;
import pl.kostkiewicz.tasks.repository.UserRepository;
import pl.kostkiewicz.tasks.service.UserService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDTO create(UserDTO userDTO) {
        User user = userMapper.from(userDTO);
        userDTO.setId(userRepository.save(user).getId());
        return userDTO;
    }

    @Override
    public List<UserDTO> findAll() {
        List<User> users = userRepository.findAll();

        return users.stream()
                .map(user -> userMapper.from(user))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO findById(long id) {
        Optional<User> result = userRepository.findById(id);
        return result.map(userMapper::from).orElseThrow(() -> new RuntimeException());
    }
}
