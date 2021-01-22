package com.example.exception.util;

import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

public class ReturnedObject extends HashMap<String,Object> {
    private static final long serialVersionUID = 1L;

    public ReturnedObject(){
        put("code",0);
    }

    public static ReturnedObject error(){
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "未知异常，请联系管理员");
    }

    public static ReturnedObject error(String msg){
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(),msg);
    }

    public static ReturnedObject error(int code,String msg){
        ReturnedObject r = new ReturnedObject();
        r.put("code",code);
        r.put("msg",msg);
        return r;
    }

    public static ReturnedObject ok(String msg){
        ReturnedObject r = new ReturnedObject();
        r.put("msg",msg);
        return r;
    }

    public static ReturnedObject ok(Map<String,Object> map){
        ReturnedObject r = new ReturnedObject();
        r.putAll(map);
        return r;
    }

    public static ReturnedObject ok(){
        return new ReturnedObject();
    }

    public ReturnedObject put(String key,Object value){
        super.put(key,value);
        return this;
    }

    public ReturnedObject data(Object value){
        super.put("data",value);
        return this;
    }

//    public ReturnedObject data(Object value){
//        super.put("data",value);
//        return this;
//    }

    public static ReturnedObject apiError(String msg){
        return error(1,msg);
    }
}
