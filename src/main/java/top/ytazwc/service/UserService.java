package top.ytazwc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.ytazwc.entity.User;

import java.util.List;

/**
 * @author 00103943
 * @date 2025-04-09 17:14
 * @package top.ytazwc.service
 * @description
 */
public interface UserService extends IService<User> {
    List<User> getUser(String name);

}
