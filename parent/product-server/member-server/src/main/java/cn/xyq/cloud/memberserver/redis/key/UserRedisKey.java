package cn.xyq.cloud.memberserver.redis.key;

import lombok.Getter;

import java.util.concurrent.TimeUnit;

@Getter
public enum UserRedisKey {
    USER_TOKEN("userToken:", 30, TimeUnit.MINUTES);

    private String prefix;
    private final int expireTime;
    private final TimeUnit timeUnit;

    UserRedisKey(String prefix, int expireTime, TimeUnit timeUnit) {
        this.prefix = prefix;
        this.expireTime = expireTime;
        this.timeUnit = timeUnit;
    }

    public String setKey(String key) {
        return prefix += key;
    }
}
