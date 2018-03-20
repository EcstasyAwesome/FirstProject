package com.github.firstproject.dao;

import com.github.firstproject.dao.impl.PositionImpl;
import com.github.firstproject.dao.impl.UserImpl;
import com.github.firstproject.dao.model.PositionDao;
import com.github.firstproject.dao.model.UserDao;

public class DaoService {

    private DaoService() {
    }

    private static DaoService instance;

    public static DaoService getInstance() {
        if (instance == null) return instance = new DaoService();
        return instance;
    }

    public UserDao getUserDao(){
        return UserImpl.getInstance();
    }

    public PositionDao getPositionDao(){
        return PositionImpl.getInstance();
    }
}