package server.repositories;

import dtos.CommentDto;
import entities.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepositoryCustom {

    CommentDto getById(Long commentId);

    Comment saveCustom(Comment comment);

    List<Comment> saveCustom(List<Comment> comments);

    void deleteCustom(Comment comment);

    void deleteCustom(List<Comment> comments);
}
