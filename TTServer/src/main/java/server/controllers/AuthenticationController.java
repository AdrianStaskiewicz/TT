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
import others.LoginPack;
import server.services.AuthenticationService;
import server.services.CommentService;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {
    @PersistenceContext
    private EntityManager em;

    @Inject
    private AuthenticationService authenticationService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody @Valid LoginPack loginPack, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        Long userId = authenticationService.login(loginPack);

        return new ResponseEntity(userId, new HttpHeaders(), HttpStatus.OK);
    }

}
