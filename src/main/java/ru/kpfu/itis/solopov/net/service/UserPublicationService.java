package ru.kpfu.itis.solopov.net.service;

import ru.kpfu.itis.solopov.net.dto.UserPublicationDto;
import ru.kpfu.itis.solopov.net.model.UserPublication;

import java.util.List;

public interface UserPublicationService {
    List<UserPublicationDto> getAll();
    List<UserPublicationDto> getAllByUserID(long id);

    UserPublicationDto get(long id);
    void save(UserPublication userPublication);

}
