package com.test2.getit.config;

import com.test2.getit.Repository.UserRepository;
import com.test2.getit.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;

/**
 * @ClassName: RouterFunctionConfiguration
 * @Description: 路由器函数
 * @Author Chen Gavin
 * @Date 2021/10/13
 * @Version 1.0
 */

@Configuration
public class RouterFunctionConfiguration {

    @Bean
    @Autowired
    public RouterFunction<ServerResponse> personFindAll(UserRepository userRepository){

        return RouterFunctions.route(RequestPredicates.GET("/person/find/all"),
                request -> {
                    Collection<User> users = userRepository.findAll();

                    Flux<User> userFlux = Flux.fromIterable(users);

                    return ServerResponse.ok().body(userFlux, User.class);
                });
    }

}
