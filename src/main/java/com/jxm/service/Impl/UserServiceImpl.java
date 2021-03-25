package com.jxm.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxm.dao.UserDao;
import com.jxm.entity.User;
import com.jxm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.selectList(null);
    }

    @Override
    public User findById(int id) {
        return userDao.selectById(id);
    }

    @Override
    public void deleteById(int id) {
        userDao.deleteById(id);
    }

    @Override
    public void updateById(User user) {
        userDao.updateById(user);
    }

    @Override
    public void save(User user) {
        userDao.insert(user);
    }

    @Override
    public Integer saveUser(User user) {
        return userDao.insert(user);
    }

    @Override
    public Integer updateUser(User user) {
        return userDao.updateById(user);
    }

    @Override
    public Integer deleteUser(Integer id) {
        return userDao.deleteById(id);
    }

    @Override
    public IPage<User> findByPage(int currentPage, int countOfPage) {
        IPage<User> userIPage = new Page<>(currentPage, countOfPage);
        return userDao.selectPage(userIPage, null);
    }
}
