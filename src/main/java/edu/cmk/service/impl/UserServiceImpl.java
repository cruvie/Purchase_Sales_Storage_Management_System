package edu.cmk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import edu.cmk.entity.User;
import edu.cmk.mapper.UserMapper;
import edu.cmk.service.UserService;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}




