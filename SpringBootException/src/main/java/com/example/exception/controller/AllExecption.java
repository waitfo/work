package com.example.exception.controller;

import com.example.exception.util.BusinessException;
import com.example.exception.util.ReturnedObject;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpServletRequest;

/**
 * 异常处理器
 */

@RestControllerAdvice
public class AllExecption {
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder){
        System.out.println("请求有参数才进来");
    }

    /**
     * 把值绑定到Model中，使全局@RequestMapping可以获取到改制
     * @param model
     */
    @ModelAttribute
    public void addAttributes(Model model){
        model.addAttribute("author","wanghaha");
    }

    @ExceptionHandler(Exception.class)
    public Object handleException(Exception e, HttpServletRequest request){
        ReturnedObject r = new ReturnedObject();
        //业务异常
        if(e instanceof BusinessException){
            r.put("code",((BusinessException) e).getCode());
            r.put("msg",((BusinessException) e).getMsg());
        }else {//系统异常
            r.put("code","500");
            r.put("msg","未知异常，请联系管理员");
        }

        //使用HttpServletRequest中的header检测请求是否未ajax，如果是
        //ajax则返回json，如果为非ajax则返回view(即ModelAndView)
        String contentTypeHeader = request.getHeader("Content-Type");
        String acceptHeader = request.getHeader("Accept");
        String xRequestedWith = request.getHeader("X-Requested-With");
        if(contentTypeHeader != null && contentTypeHeader.contains("application/json")){
            return r;
        }else if(acceptHeader != null && acceptHeader.contains("application/json")){
            return r;
        }else if("XMLHttpRequest".equalsIgnoreCase(xRequestedWith)){
            return r;
        }else {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("msg",e.getMessage());
            modelAndView.addObject("url", request.getRequestURI());
            modelAndView.addObject("stackTrace",e.getStackTrace());
            return modelAndView;
        }

    }


}
