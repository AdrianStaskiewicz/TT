package server.services;

import dtos.UserDto;
import entities.User;

import java.util.List;

public interface UserService {

    UserDto getById(Long userId);

    List<UserDto> getAllAssignedToProjectByProjectId(Long projectId);

    User save(User user);

    List<User> save(List<User> users);

    void delete(User user);

    void delete(List<User> users);
}
