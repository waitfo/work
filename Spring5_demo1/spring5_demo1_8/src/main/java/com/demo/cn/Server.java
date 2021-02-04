package com.demo.cn;

import com.demo.cn.handler.UserHandler;
import com.demo.cn.service.UserService;
import com.demo.cn.service.impl.UserServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.netty.http.server.HttpServer;

import javax.xml.ws.spi.http.HttpHandler;

import java.io.IOException;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

public class Server {

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.createReactorServer();
        System.out.println("enter to exit");
        System.in.read();
    }

    //1.创建Router路由
    public RouterFunction<ServerResponse> routerFunction(){
        UserService service = new UserServiceImpl();
        UserHandler handler = new UserHandler(service);

        return RouterFunctions.route(
            GET("/users/{id}").and(accept(MediaType.APPLICATION_JSON)),handler::getUserById)
                .andRoute(GET("/users").and(accept(MediaType.APPLICATION_JSON)),handler::getAllUsers);

    }

    //3.创建服务完成适配
    public void createReactorServer(){
        //路由和handler适配
        RouterFunction<ServerResponse> route = routerFunction();
        HttpHandler httpHandler = toHttpHandler(route);
        ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(httpHandler);

        //创建服务器
        HttpServer httpServer = HttpServer.create();
        httpServer.handle(adapter).bindNow();

    }
}
