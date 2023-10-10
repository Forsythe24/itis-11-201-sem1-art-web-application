package ru.kpfu.itis.solopov.net.dao;

import java.util.List;
import java.util.Map;

public interface Dao<T> {

    T get(String login);

    List<T> getAll();

    void save(T t);
    void update(T t);
}
