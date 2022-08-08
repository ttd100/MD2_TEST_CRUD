package rikkei.academy.service;

import rikkei.academy.model.ClassRoom;

import java.util.List;

public interface IGeneric<T> {
    List<T> findAll();
    void save(T t);

    void edit(T element);
    void create(T element);
}
