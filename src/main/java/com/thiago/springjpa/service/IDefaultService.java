package com.thiago.springjpa.service;

import java.util.List;

public interface IDefaultService<T, F, M> {

    List<T> getAll();
    T get(M id);
    T create(F form);
    T update(M id, F form);
    boolean delete(M id);

}
