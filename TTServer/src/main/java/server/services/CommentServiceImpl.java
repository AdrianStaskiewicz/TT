package server.services;

import dtos.CommentDto;
import entities.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import server.repositories.CommentRepository;

import javax.inject.Inject;
import java.util.List;

/**
 * Service for Comment
 */
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    @Inject
    CommentRepository commentRepository;

    @Override
    public CommentDto getById(Long commentId) {
        return commentRepository.getById(commentId);
    }

    @Override
    public Comment save(Comment comment) {
        return commentRepository.saveCustom(comment);
    }

    @Override
    public List<Comment> save(List<Comment> comments) {
        return commentRepository.saveCustom(comments);
    }

    @Override
    public void delete(Comment comment) {
        commentRepository.deleteCustom(comment);
    }

    @Override
    public void delete(List<Comment> comments) {
        commentRepository.deleteCustom(comments);
    }
}
