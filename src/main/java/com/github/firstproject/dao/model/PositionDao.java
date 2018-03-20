package com.github.firstproject.dao.model;

import com.github.firstproject.dao.pojo.Position;

import java.util.List;

public interface PositionDao extends GeneralDao<Long, Position> {
    List<Position> getList();
}