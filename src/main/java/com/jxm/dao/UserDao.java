package com.jxm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jxm.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends BaseMapper<User> {
}
