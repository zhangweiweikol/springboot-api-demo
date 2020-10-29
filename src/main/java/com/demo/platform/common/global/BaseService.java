package com.demo.platform.common.global;

import java.util.List;

public interface BaseService<T,F> {

    int insert(F entity);

    int delete(String id);

    int update(F entity);

    T getById(String id);

    List<T> findList(F entity);

}
