package server.controllers;

import dtos.CommentDto;
import entities.Comment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import server.services.CommentService;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @PersistenceContext
    private EntityManager em;

    @Inject
    private CommentService commentService;

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public ResponseEntity findById(@RequestBody @Valid Long commentId, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        CommentDto commentDto = commentService.getById(commentId);

        return new ResponseEntity(commentDto, new HttpHeaders(), HttpStatus.OK);
    }

    @Transactional
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity save(@RequestBody @Valid Comment comment, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        comment = commentService.save(comment);
        return new ResponseEntity(comment, new HttpHeaders(), HttpStatus.OK);
    }

    @Transactional
    @RequestMapping(value = "/savelist", method = RequestMethod.POST)
    public ResponseEntity save(@RequestBody @Valid List<Comment> comments, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        comments = commentService.save(comments);
        return new ResponseEntity(comments, new HttpHeaders(), HttpStatus.OK);
    }

    @Transactional
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(@RequestBody @Valid Comment comment, BindingResult result) {

        commentService.delete(comment);

    }

    @Transactional
    @RequestMapping(value = "/deletelist", method = RequestMethod.DELETE)
    public void delete(@RequestBody @Valid List<Comment> comments, BindingResult result) {

        commentService.delete(comments);

    }

}
