package ru.kpfu.itis.solopov.net.service.Impl;

import ru.kpfu.itis.solopov.net.dao.Impl.CommentDaoImpl;
import ru.kpfu.itis.solopov.net.dto.CommentDto;
import ru.kpfu.itis.solopov.net.model.Comment;
import ru.kpfu.itis.solopov.net.service.CommentService;

import java.util.List;
import java.util.stream.Collectors;

public class CommentServiceImpl implements CommentService {
    private final CommentDaoImpl dao = new CommentDaoImpl();
    @Override
    public List<CommentDto> getAll() {
        return dao.getAll().stream().map(
                c -> new CommentDto(c.getId(), c.getPublID(), c.getUserID(), c.getText(), c.getDate(), c.getTime())
        ).collect(Collectors.toList());
    }

    @Override
    public List<CommentDto> getAllByPublicationID(long id) {
        return dao.getAllByPublicationID(id).stream().map(
                c -> new CommentDto(c.getId(), c.getPublID(), c.getUserID(), c.getText(), c.getDate(), c.getTime())
        ).collect(Collectors.toList());
    }

    @Override
    public CommentDto get(long id) {
        return null;
    }

    @Override
    public void save(Comment comment) {
        dao.save(comment);
    }
}
