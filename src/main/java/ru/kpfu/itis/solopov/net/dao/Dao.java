package ru.kpfu.itis.solopov.net.dao;

import java.util.List;

public interface Dao<T> {
    T get(long id);

    T get(String login);

    List<T> getAll();

    void save(T t);
    void update(T t);
}
