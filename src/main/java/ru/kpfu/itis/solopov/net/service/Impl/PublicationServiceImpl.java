package ru.kpfu.itis.solopov.net.service.Impl;

import ru.kpfu.itis.solopov.net.dao.Dao;
import ru.kpfu.itis.solopov.net.dao.Impl.PublicationDaoImpl;
import ru.kpfu.itis.solopov.net.dto.PublicationDto;
import ru.kpfu.itis.solopov.net.model.Publication;
import ru.kpfu.itis.solopov.net.service.PublicationService;

import java.util.List;

public class PublicationServiceImpl implements PublicationService {
    private final Dao<Publication> dao = new PublicationDaoImpl();
    @Override
    public List<PublicationDto> getAll() {
        return null;
    }

    @Override
    public PublicationDto get(Long id) {
        return null;
    }

    @Override
    public void save(Publication publication) {
        dao.save(publication);
    }
}
