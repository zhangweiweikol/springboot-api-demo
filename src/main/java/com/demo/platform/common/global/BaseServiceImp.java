package com.demo.platform.common.global;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BaseServiceImp<D extends BaseDao<T,F>, T,F> implements BaseService<T,F> {

    @Autowired
    public D dao;


    @Override
    public int insert(F entity) {
        return dao.insert(entity);
    }

    @Override
    public int delete(String id) {
        return dao.delete(id);
    }

    @Override
    public int update(F entity) {
        return dao.update(entity);
    }

    @Override
    public T getById(String id) {
        return dao.getById(id);
    }

    @Override
    public List<T> findList(F entity) {
        return dao.findList(entity);
    }
}
