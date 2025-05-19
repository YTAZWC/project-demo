package top.ytazwc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.ytazwc.entity.User;
import top.ytazwc.mapper.UserMapper;
import top.ytazwc.service.UserService;

import java.util.List;

/**
 * @author 00103943
 * @date 2025-04-09 17:15
 * @package top.ytazwc.service.impl
 * @description
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public List<User> getUser(String name) {
        return this.lambdaQuery().like(User::getUsername, name).list();
    }

}
