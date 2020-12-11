package com.example.cn;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.*;

@SpringBootTest
class SpringTrainApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;

	//在每个测试方法执行之前都初始化MockMvc对象
	@BeforeEach
	public void setupMockMvc() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	void contextLoads() {
	}

	/**
	 * @DisplayName 自定义测试方法展示的名称
	 * @throws Exception
	 */
	@DisplayName("测试根据Id获取User")
	@Test
	void test1(){
		try{
			//perform,执行一个RequestBuilders请求，会自动执行SpringMVC的流程并映射到相应的控制器执行处理
			mockMvc.perform(MockMvcRequestBuilders
					//构造一个get请求
					.get("/test1")
					//请求类型 json
					.contentType(MediaType.APPLICATION_JSON))
					// 期待返回的状态码是4XX，因为我们并没有写/user/{id}的get接口
					.andExpect(MockMvcResultMatchers.status().is4xxClientError());
		}catch (Exception e){
			e.printStackTrace();
		}

	}

}
