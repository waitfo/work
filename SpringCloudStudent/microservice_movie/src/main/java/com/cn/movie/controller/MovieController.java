package com.cn.movie.controller;

import com.cn.movie.client.UserController;
import com.cn.movie.entiy.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 电影购票Controller
 */
@RequestMapping("/movie")
@RestController
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    //没有使用Eureka
//    /**
//     * 购票方法
//     */
//    @PostMapping("/order")
//    public String order(){
//        //读取当前用户
//        Integer id = 2;
//
//        //查询用户微服务，获取用户具体信息
//        //使用RestTemplate远程调用用户微服务
//        /**
//         * 参数一：调用url地址
//         * 参数二：需要封装的对象类型
//         */
//        User user = restTemplate.getForObject("http://localhost:9001/user/"+id, User.class);
//
//        System.out.println(user+"正在购票。。。");
//
//        return "购票成功";
//    }

//    /**
//     * 购票方法--->使用Eureka
//     */
//    @PostMapping("/order")
//    public String order(){
//        //读取当前用户
//        Integer id = 2;
//
//        //到Eureka发现用户微服务
//        //返回值为什么是List集合？获取到所有同名的微服务
//        List<ServiceInstance> instances = discoveryClient.getInstances("microservice_user");
//        //没有使用负载均衡，只能获取第一个服务
//        ServiceInstance serviceInstance = instances.get(0);
//
//        User user = restTemplate.getForObject("http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/user/"+id, User.class);
//
//        System.out.println(user+"正在购票。。。");
//
//        return "购票成功";
//    }

    /**
     * 购票方法--->使用Ribbon负载均衡组件
     */
//
//    @Autowired
//    private LoadBalancerClient loadBalancerClient;

//    @PostMapping("/order")
//    public String order(){
//        //读取当前用户
//        Integer id = 2;
//
////        //到Eureka发现用户微服务
////        //返回值为什么是List集合？获取到所有同名的微服务
////        List<ServiceInstance> instances = discoveryClient.getInstances("microservice_user");
////        //没有使用负载均衡，只能获取第一个服务
////        ServiceInstance serviceInstance = instances.get(0);
//
//        //使用Ribbon帮助我们选择一个合适地服务实例
//        ServiceInstance choose = loadBalancerClient.choose("microservice_user");
//
//        User user = restTemplate.getForObject("http://"+choose.getHost()+":"+choose.getPort()+"/user/"+id, User.class);
//
//        System.out.println(user+"正在购票。。。");
//
//        return "购票成功";
//    }

    /**
     * 购票方法--->使用Ribbon负载均衡组件简化版
     */

    @PostMapping("/order")
    @HystrixCommand(fallbackMethod = "fallback")
    public String order(){
        //读取当前用户
        Integer id = 2;

        //todo 有问题,我没有LoadBalancerInterceptor这个拦截器，不对，是因为服务名带了下划线！！！
        User user = restTemplate.getForObject("http://microservice-user/user/"+id, User.class);

        System.out.println(user+"正在购票。。。");

        return "购票成功";
    }


//    @Autowired
//    private UserController userController;
//    /**
//     * 购票方法（使用OpenFeign组件来简化调用代码）
//     * 不再续约RestTemplate
//     * @return
//     */
//    @PostMapping("/order")
//    public String order(){
//        //模拟当前用户
//        Integer id = 2;
//        userController.findById(id);
//        return "购票成功";
//    }

    public String fallback(){
        return "服务暂时不可用，发生熔断";
    }
}
