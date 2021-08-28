package com.vnpt.eoffice.controller.listener;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

public  abstract class HandlerListener <T> {
    @Autowired
    MessageHandlerReal messageHandlerReal;

    @PostConstruct
    public void register(){
        messageHandlerReal.addHandlerListeners(this);
    }
     public void execute(Map map) {
         Type genericType = this.getClass().getGenericSuperclass();
         Type actualType = ((ParameterizedType) genericType).getActualTypeArguments()[0];
         ModelMapper modelMapper=new ModelMapper();
         T t = modelMapper.map(map, actualType);
         execute(t);
    }
    protected abstract void execute(T t);
}