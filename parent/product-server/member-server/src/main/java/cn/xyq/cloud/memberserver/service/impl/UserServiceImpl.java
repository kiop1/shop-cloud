package cn.xyq.cloud.memberserver.service.impl;

import cn.xyq.cloud.domain.User;
import cn.xyq.cloud.memberserver.mapper.UserMapper;
import cn.xyq.cloud.memberserver.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User get(Long id) {
        return userMapper.selectById(id);
    }
}
