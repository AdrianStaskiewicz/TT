package server.services;

import dtos.UserDto;
import entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import server.repositories.UserRepository;

import javax.inject.Inject;
import java.util.List;

/**
 * Service for User
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Inject
    UserRepository userRepository;

    @Override
    public UserDto getById(Long userId) {
        return userRepository.getById(userId);
    }

    @Override
    public List<UserDto> getAllAssignedToProjectByProjectId(Long projectId){
        return userRepository.getAllAssignedToProjectByProjectId(projectId);
    }

    @Override
    public User save(User user) {
        return userRepository.saveCustom(user);
    }

    @Override
    public List<User> save(List<User> users) {
        return userRepository.saveCustom(users);
    }

    @Override
    public void delete(User user) {
        userRepository.deleteCustom(user);
    }

    @Override
    public void delete(List<User> users) {
        userRepository.deleteCustom(users);
    }
}
