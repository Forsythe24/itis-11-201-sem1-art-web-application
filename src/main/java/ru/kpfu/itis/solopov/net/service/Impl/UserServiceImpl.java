package ru.kpfu.itis.solopov.net.service.Impl;

import ru.kpfu.itis.solopov.net.dao.Dao;
import ru.kpfu.itis.solopov.net.dao.Impl.PublicationDaoImpl;
import ru.kpfu.itis.solopov.net.dao.Impl.UserDaoImpl;
import ru.kpfu.itis.solopov.net.dto.UserDto;
import ru.kpfu.itis.solopov.net.model.Publication;
import ru.kpfu.itis.solopov.net.model.User;
import ru.kpfu.itis.solopov.net.service.UserService;
import ru.kpfu.itis.solopov.net.util.PasswordUtil;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
    private final UserDaoImpl dao;
    public UserServiceImpl(Dao<User> dao) {
        this.dao = (UserDaoImpl) dao;
    }

    @Override
    public List<UserDto> getAll() {
        return dao.getAll().stream().map(
                u -> new UserDto(u.getUsername(), u.getEmail(), u.getGender(), u.getLogin(), u.getPassword(), u.getBirthDate(), u.getGenre(), u.getId(), u.getImage())
        ).collect(Collectors.toList());
    }

    @Override
    public UserDto get(String login) {
        User user = dao.get(login);
        return new UserDto(user.getUsername(), user.getEmail(), user.getGender(), user.getLogin(), user.getPassword(), user.getBirthDate(), user.getGenre(), user.getId(), user.getImage());
    }

    @Override
    public void save(User user) {
        user.setPassword(PasswordUtil.encrypt(user.getPassword()));
        dao.save(user);
    }

    @Override
    public void update(UserDto userDto) {
        User user = dao.get(userDto.getLogin());
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setGender(userDto.getGender());
        user.setBirthDate(userDto.getBirthDate());
        user.setGenre(userDto.getGenre());
        user.setImage(userDto.getImage());
        dao.update(user);
    }

    @Override
    public UserDto get(Long id) {
        User user = dao.get(id);
        return new UserDto(user.getUsername(), user.getEmail(), user.getGender(), user.getLogin(), user.getPassword(), user.getBirthDate(), user.getGenre(), user.getId(), user.getImage());
    }



}
