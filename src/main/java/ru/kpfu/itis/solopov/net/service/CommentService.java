package ru.kpfu.itis.solopov.net.service;

import ru.kpfu.itis.solopov.net.dto.CommentDto;
import ru.kpfu.itis.solopov.net.model.Comment;

import java.util.List;

public interface CommentService {
    List<CommentDto> getAll();
    List<CommentDto> getAllByPublicationID(long id);

    CommentDto get(long id);
    void save(Comment comment);


//    void update(CommentDto commentDto);
}
