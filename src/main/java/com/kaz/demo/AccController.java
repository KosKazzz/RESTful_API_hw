package com.kaz.demo;

import com.kaz.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class AccController {
    @Autowired
    MyDTO myDTO;

    @PostMapping("/new_user")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        String result = myDTO.addNewUser(user);
        switch (result) {
            case "invalid pin!" -> {
                return new ResponseEntity<>("invalid pin!", HttpStatus.BAD_REQUEST);
            }
            case "userName is null!" -> {
                return new ResponseEntity<>("userName is null!", HttpStatus.BAD_REQUEST);
            }
            case "New user added!" -> {
                return new ResponseEntity<>("New user added!", HttpStatus.I_AM_A_TEAPOT);
            }
        }
        return new ResponseEntity<>("Something going wrong...!", HttpStatus.BAD_REQUEST);
    }

}
