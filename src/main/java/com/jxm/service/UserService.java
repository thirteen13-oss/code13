package com.jxm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxm.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(int id);
    void deleteById(int id);
    void updateById(User user);
    void save(User user);
    Integer saveUser(User user);
    Integer updateUser(User user);
    Integer deleteUser(Integer id);
    IPage<User> findByPage(int currentPage, int countOfPage);
}
