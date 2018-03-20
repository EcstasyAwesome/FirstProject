package com.github.firstproject.dao.model;

public interface GeneralDao<T,E> {
    void create(E instance);
    E read(T id);
    void update(E instance);
    void delete(T id);
}