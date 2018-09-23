package com.cafemanagement.facade;

import com.cafemanagement.dto.UserDTO;
import com.cafemanagement.entity.User;
import com.cafemanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceFacade {

    @Autowired
    UserService userService;

    public List<UserDTO> findAll() {

        List<UserDTO> userDTOS = new ArrayList<>();
        List<User> users = userService.findAll();

        for(int i = 0; i < users.size(); ++i) {
            User user = users.get(i);
            UserDTO userDTO = new UserDTO();

            userDTO.setId(user.getId());
            userDTO.setUserType(user.getUserType());
            userDTO.setName(user.getName());
            userDTO.setPassword(user.getPassword());
            userDTO.setEmail(user.getEmail());

            userDTOS.add(userDTO);
        }
        return userDTOS;
    }

    public UserDTO findById(Long id) {
        User user = userService.findById(id);
        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setUserType(user.getUserType());
        userDTO.setName(user.getName());
        userDTO.setPassword(user.getPassword());
        userDTO.setEmail(user.getEmail());

        return userDTO;
    }


    public void deleteById(Long id) {
        userService.deleteById(id);
    }

    public UserDTO create(User user) {
        return createEdit(user);
    }

    public UserDTO edit(User user) {

        return createEdit(user);
    }

    private UserDTO createEdit(User user) {
        UserDTO userDTO = new UserDTO();
        User edittedUser = userService.edit(user);

        userDTO.setId(edittedUser.getId());
        userDTO.setName(edittedUser.getName());
        userDTO.setPassword(edittedUser.getPassword());
        userDTO.setUserType(edittedUser.getUserType());
        userDTO.setEmail(edittedUser.getEmail());

        return userDTO;
    }
}
