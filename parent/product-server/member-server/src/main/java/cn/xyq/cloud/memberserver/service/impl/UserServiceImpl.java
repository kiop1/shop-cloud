package cn.xyq.cloud.memberserver.service.impl;

import cn.xyq.cloud.common.utils.AssertUtil;
import cn.xyq.cloud.common.utils.RequestUtil;
import cn.xyq.cloud.domain.User;
import cn.xyq.cloud.memberserver.mapper.UserMapper;
import cn.xyq.cloud.memberserver.service.IUserService;
import cn.xyq.cloud.memberserver.utils.JSONUtil;
import cn.xyq.cloud.memberserver.utils.MD5Util;
import cn.xyq.cloud.memberserver.vo.LoginVo;
import cn.xyq.cloud.memberserver.web.msg.MessageCodeMsg;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements IUserService {

    private UserMapper userMapper;

    private StringRedisTemplate redisTemplate;

    @Autowired
    public void setRedisTemplate(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User get(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    public String login(LoginVo vo) {
        String username = vo.getUsername();
        AssertUtil.hasLength(username, MessageCodeMsg.USERNAME_NULL_MSG);
        User user = get(Long.parseLong(username));
        AssertUtil.notNull(user, MessageCodeMsg.USERNAME_ERROR_MSG);
        String inputPass = MD5Util.formPassToDbPass(vo.getPassword(), user.getSalt());
        AssertUtil.notEquals(user.getPassword(), inputPass, MessageCodeMsg.PASSWORD_ERROR_MSG);
        return createToken(user);
    }

    private String createToken(User user) {
        String json = JSONUtil.objToJsonStr(user);
        String ip = RequestUtil.getIPAddress();
        return JWT.create()
                .withClaim("ip", ip)
                .withClaim("user", json)
                .withExpiresAt(new Date(System.currentTimeMillis() + 30 * 60 * 1000))
                .sign(Algorithm.HMAC256(user.getSalt()));
    }
}
