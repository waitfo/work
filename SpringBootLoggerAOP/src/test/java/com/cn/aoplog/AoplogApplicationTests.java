package com.cn.aoplog;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class AoplogApplicationTests {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
    }

    //在每个测试方法执行之前都初始化MockMvc对象
    @BeforeEach
    @Test
    @DisplayName("测试访问接口")
    public void test1() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        //perform,执行一个RequestBuilders请求，会自动执行SpringMVC的流程并映射到相应的控制器执行处理
        mockMvc.perform(MockMvcRequestBuilders
                //构造一个get请求
                .get("/annotationClassTest?id=111&name=wang")///annotationMethodTest?id=111&name=wang
                                                                        // test1
                                                                        ///annotationClassTest?id=111&name=wang
                //请求类型 json
                .contentType(MediaType.APPLICATION_JSON))
                // 期待返回的状态码是4XX，因为我们并没有写/user/{id}的get接口
                //.andExpect(MockMvcResultMatchers.status().is4xxClientError());
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                //添加ResultHandler结果处理器，比如调试时 打印结果(print方法)到控制台
                .andDo(MockMvcResultHandlers.print());
    }

//    @BeforeEach
//    @Test
//    @DisplayName("测试访问接口2")
//    public void test2() throws Exception {
//        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//
//        //perform,执行一个RequestBuilders请求，会自动执行SpringMVC的流程并映射到相应的控制器执行处理
//        mockMvc.perform(MockMvcRequestBuilders
//                //构造一个get请求
//                .get("/annotationMethodTest?id=111&name=wang")
//                //请求类型 json
//                .contentType(MediaType.APPLICATION_JSON))
//                // 期待返回的状态码是4XX，因为我们并没有写/user/{id}的get接口
//                //.andExpect(MockMvcResultMatchers.status().is4xxClientError());
//                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
//                //添加ResultHandler结果处理器，比如调试时 打印结果(print方法)到控制台
//                .andDo(MockMvcResultHandlers.print());
//    }

}
