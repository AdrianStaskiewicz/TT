package server.services;

import dtos.CommentDto;
import entities.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import others.LoginPack;
import server.repositories.CommentRepository;
import server.repositories.UserRepository;

import javax.inject.Inject;
import java.util.List;

/**
 * Service for Comment
 */
@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    @Inject
    UserRepository userRepository;

    @Override
    public Long login(LoginPack loginPack) {
        return userRepository.getUserIdByLoginAndPassword(loginPack);
    }

}
