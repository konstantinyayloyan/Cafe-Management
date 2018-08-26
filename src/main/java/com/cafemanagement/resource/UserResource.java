package com.cafemanagement.resource;

import com.cafemanagement.dto.UserDTO;
import com.cafemanagement.facade.UserServiceFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

}
