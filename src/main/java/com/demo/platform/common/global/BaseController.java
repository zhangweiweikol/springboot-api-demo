package com.demo.platform.common.global;

import com.demo.platform.common.annotation.LoginRequired;
import com.demo.platform.common.enums.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public class BaseController<S extends BaseService<T, F>, T, F> {

    @Autowired
    public S service;

    /**
     * 添加用户
     * @param f
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @LoginRequired
    public ResponeData<String> addUser(@Valid @RequestBody F f ){
        //调用业务逻辑，处理业务
        service.insert(f);
        return new ResponeData<>("添加成功");
    }

    @ResponseBody
    @RequestMapping(value = "del/{id}",method = RequestMethod.GET)
    @LoginRequired
    public ResponeData<String> delById(@PathVariable("id") String id){
        service.delete(id);
        return new ResponeData<>(ResultEnum.SUCCESS,"删除成功");
    }

    @ResponseBody
    @RequestMapping(value = "update",method = RequestMethod.POST)
    @LoginRequired
    public ResponeData<String> update(@Valid @RequestBody F f){
        //调用业务逻辑，处理业务
        service.update(f);
        return new ResponeData<>("更新成功");
    }


    @ResponseBody
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @LoginRequired
    public ResponeData<List> findList(F f){
        //调用业务逻辑，处理业务
        List<T> list = service.findList(f);
        return new ResponeData<List>(ResultEnum.SUCCESS,list);
    }

    @ResponseBody
    @RequestMapping(value = "get/{id}",method = RequestMethod.GET)
    @LoginRequired
    public ResponeData<T> getById(@PathVariable("id") String id){
        T account = service.getById(id);
        return new ResponeData<T>(ResultEnum.SUCCESS,account);
    }



}
