package ru.kpfu.itis.solopov.net.service;

import ru.kpfu.itis.solopov.net.dto.UserDto;
import ru.kpfu.itis.solopov.net.model.User;

import java.util.List;

public interface UserService {
    List<UserDto> getAll();
    UserDto get(String login);
    UserDto get(Long id);
    void save(User user);
    void update(UserDto userDto);
}
