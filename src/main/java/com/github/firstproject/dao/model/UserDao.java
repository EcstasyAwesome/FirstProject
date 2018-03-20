package com.github.firstproject.dao.model;

import com.github.firstproject.dao.pojo.User;

import java.util.List;

public interface UserDao extends GeneralDao<Long, User> {
    List<User> getList();
}