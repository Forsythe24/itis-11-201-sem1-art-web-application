package ru.kpfu.itis.solopov.net.service.Impl;

import ru.kpfu.itis.solopov.net.dao.Impl.PublicationDaoImpl;
import ru.kpfu.itis.solopov.net.dao.Impl.UserPublicationDaoImpl;
import ru.kpfu.itis.solopov.net.dto.QuoteDto;
import ru.kpfu.itis.solopov.net.dto.UserPublicationDto;
import ru.kpfu.itis.solopov.net.model.User;
import ru.kpfu.itis.solopov.net.model.UserPublication;
import ru.kpfu.itis.solopov.net.service.UserPublicationService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserPublicationServiceImpl implements UserPublicationService {
    private final UserPublicationDaoImpl dao = new UserPublicationDaoImpl();
    @Override
    public List<UserPublicationDto> getAll() {
        return dao.getAll().stream().map(
                u -> new UserPublicationDto(u.getId(), u.getUserID(), u.getPublicationID())
        ).collect(Collectors.toList());
    }

    @Override
    public List<UserPublicationDto> getAllByUserID(long id) {
        return dao.getAllByUserID(id).stream().map(
                u -> new UserPublicationDto(u.getId(), u.getUserID(), u.getPublicationID())
        ).collect(Collectors.toList());
    }

    @Override
    public UserPublicationDto get(long id) {
        return null;
    }

    @Override
    public void save(UserPublication userPublication) {
        dao.save(userPublication);
    }

    @Override
    public void delete(long id) {
        dao.delete(id);
    }

    @Override
    public void deleteByIDs(long userID, long publicationID) {
        dao.deleteByIDs(userID, publicationID);
    }
}
