package ru.kpfu.itis.solopov.net.service;

import ru.kpfu.itis.solopov.net.dto.PublicationDto;
import ru.kpfu.itis.solopov.net.dto.UserDto;
import ru.kpfu.itis.solopov.net.model.Publication;
import ru.kpfu.itis.solopov.net.model.User;

import java.util.List;

public interface PublicationService {
    List<PublicationDto> getAll();
    PublicationDto get(Long id);
    void save(Publication publication);
//    void update(PublicationDto publicationDto);
}

