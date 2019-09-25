package server.controllers;

import dtos.UserDto;
import entities.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import server.services.UserService;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserService userService;

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public ResponseEntity findById(@RequestBody @Valid Long userId, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        UserDto userDto = userService.getById(userId);

        return new ResponseEntity(userDto, new HttpHeaders(), HttpStatus.OK);
    }

    @Transactional
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity save(@RequestBody @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        user = userService.save(user);
        return new ResponseEntity(user, new HttpHeaders(), HttpStatus.OK);
    }

    @Transactional
    @RequestMapping(value = "/savelist", method = RequestMethod.POST)
    public ResponseEntity save(@RequestBody @Valid List<User> users, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        users = userService.save(users);
        return new ResponseEntity(users, new HttpHeaders(), HttpStatus.OK);
    }

    @Transactional
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(@RequestBody @Valid User user, BindingResult result) {

        userService.delete(user);

    }

    @Transactional
    @RequestMapping(value = "/deletelist", method = RequestMethod.DELETE)
    public void delete(@RequestBody @Valid List<User> users, BindingResult result) {

        userService.delete(users);

    }

}
