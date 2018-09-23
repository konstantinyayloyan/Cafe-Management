package com.cafemanagement.resource;

import com.cafemanagement.dto.UserDTO;
import com.cafemanagement.entity.User;
import com.cafemanagement.facade.UserServiceFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserResource {

    @Autowired
    UserServiceFacade userServiceFacade;


    @RequestMapping(value = "users", method = RequestMethod.GET)
    public  List<UserDTO> findAll() {
        return userServiceFacade.findAll();
    }

    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ResponseEntity<UserDTO> createUser(@RequestBody User user) {
        System.out.println("Creating User " + user.getName());

        UserDTO userDTO = userServiceFacade.create(user);
        return new ResponseEntity<UserDTO>(userDTO, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<UserDTO> updateUser(@PathVariable("id") long id, @RequestBody User user) {

        UserDTO currentUserDTO = userServiceFacade.edit(user);

        return new ResponseEntity<UserDTO>(currentUserDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<UserDTO> deleteUser(@PathVariable("id") long id) {

        userServiceFacade.deleteById(id);

        return new ResponseEntity<UserDTO>(HttpStatus.NO_CONTENT);
    }

}
