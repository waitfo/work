package com.example.exception.controller;

import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

//@Controller
public class MyBasicErrorController extends BasicErrorController {
    public MyBasicErrorController(){
        super(new DefaultErrorAttributes(),new ErrorProperties());
    }

    /**
     * 定义500的ModelAndView
     */
    //@RequestMapping(produces = MediaType.TEXT_HTML_VALUE,value="/500")
    public ModelAndView errorHtml500(HttpServletRequest request, HttpServletResponse response){
        HttpStatus status = getStatus(request);
        response.setStatus(status.value());
        Map<String,Object> model = getErrorAttributes(request,getErrorAttributeOptions(request,MediaType.TEXT_HTML));
        model.put("msg","自定义错误信息");
        return new ModelAndView("error.html",model);
    }

    /**
     * 定义500的错误JSON信息
     */
    //@RequestMapping(value = "/500")
    //@ResponseBody
    public ResponseEntity<Map<String,Object>> error500(HttpServletRequest request){
        HttpStatus status = getStatus(request);
        if(status == HttpStatus.NO_CONTENT){
            return new ResponseEntity<>(status);
        }
        Map<String,Object> body = getErrorAttributes(request,getErrorAttributeOptions(request,MediaType.ALL));
        return new ResponseEntity<>(body,status);
    }

    /**
     * 代码很简单，只是实现了自定义的500错误的映射解析，分别对浏览器请求以及json请求做了回应。
     * BasicErrorController默认对应的@RequestMapping是/error，所以我们方法里面对应的
     * @RequestMapping(produces = MediaType.TEXT_HTML_VALUE, value = “/500”)，
     * MediaType.TEXT_HTML_VALUE的值就是“text/html”，实际上完整的映射请求是/error/500，
     * 这就跟之前自定义方法的映射路径对上了。
     * errorHtml500 方法中，返回的是模板页面，对应/templates/error/t500.html，
     * 这里顺便自定义了一个message信息，在500.html也输出这个信息<p th:text="${message}"></p>，
     * 如果输出结果有这个信息，则表示我们配置正确了。
     */

}
