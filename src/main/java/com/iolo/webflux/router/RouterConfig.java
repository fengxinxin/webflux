package com.iolo.webflux.router;

import com.iolo.webflux.handler.TimeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * 路由配置
 *
 * @author Fengxinxin
 * @date 2019-03-14
 */
@Configuration
public class RouterConfig {
    @Autowired
    private TimeHandler timeHandler;

    @Bean
    public RouterFunction<ServerResponse> timerRouter() {
        return RouterFunctions.route(RequestPredicates.GET("/times"), timeHandler::sendTimePerSec);
    }
}
