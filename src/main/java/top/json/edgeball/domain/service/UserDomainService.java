package top.json.edgeball.domain.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.json.edgeball.domain.UserDO;
import top.json.edgeball.domain.repo.UserMapper;

@Service
public class UserDomainService {
    @Autowired
    private UserMapper userMapper;

    public UserDO get(Long userId) {
        return userMapper.get(userId);
    }

    @Transactional
    public Long add(UserDO userDO) {
        return userMapper.insert(userDO);
    }

    public UserDO queryByName(String name) {
        return userMapper.queryByName(name);
    }

    public UserDO queryByMobile(String mobile) {
        return userMapper.queryByMobile(mobile);
    }
}
