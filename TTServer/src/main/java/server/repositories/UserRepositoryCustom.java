package server.repositories;

import dtos.UserDto;
import entities.User;
import org.springframework.stereotype.Repository;
import others.LoginPack;

import java.util.List;

@Repository
public interface UserRepositoryCustom {

    UserDto getById(Long userId);

    List<UserDto> getAllAssignedToProjectByProjectId(Long projectId);

    User saveCustom(User user);

    List<User> saveCustom(List<User> users);

    void deleteCustom(User user);

    void deleteCustom(List<User> users);

    Long getUserIdByLoginAndPassword(LoginPack loginPack);
}
