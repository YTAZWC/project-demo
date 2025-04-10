package top.ytazwc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.ytazwc.entity.User;
import top.ytazwc.service.UserService;

import java.util.List;

/**
 * @author 00103943
 * @date 2025-04-09 17:16
 * @package top.ytazwc
 * @description
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    public List<User> getUser(@RequestParam String name) {
        return userService.getUser(name);
    }

}
