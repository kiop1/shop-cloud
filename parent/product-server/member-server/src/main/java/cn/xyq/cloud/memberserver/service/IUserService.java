package cn.xyq.cloud.memberserver.service;

import cn.xyq.cloud.domain.User;
import cn.xyq.cloud.memberserver.vo.LoginVo;

public interface IUserService {
    User get(Long id);

    /**
     * 用户登录
     *
     * @param vo 登录信息
     * @return 返回token
     */
    String login(LoginVo vo);
}
