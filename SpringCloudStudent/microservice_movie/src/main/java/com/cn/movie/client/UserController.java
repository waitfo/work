package com.cn.movie.client;

import com.cn.movie.entiy.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 用户微服务远程接口
 * 三个注意事项：
 *  1》使用@FeignClient，声明续约调用微服务
 *  2> 检查@RequestMapping注解，路径是否完整
 *  3> @Pathvariable注解地value不能省略
 */
@FeignClient(value = "microservice-user")
public interface UserController {
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    User findById(@PathVariable(value = "id") Integer id);
}
