package server.services;

import dtos.CommentDto;
import entities.Comment;
import others.LoginPack;

import java.util.List;

public interface AuthenticationService {

    Long login(LoginPack loginPack);

}
