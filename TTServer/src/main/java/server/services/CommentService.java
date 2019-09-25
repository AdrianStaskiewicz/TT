package server.services;

import dtos.CommentDto;
import entities.Comment;

import java.util.List;

public interface CommentService {

    CommentDto getById(Long commentId);

    Comment save(Comment comment);

    List<Comment> save(List<Comment> comments);

    void delete(Comment comment);

    void delete(List<Comment> comments);
}
