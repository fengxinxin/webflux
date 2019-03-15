package com.iolo.webflux.router;

import com.iolo.webflux.handler.TimeHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.LogFactory;
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
@Slf4j
public class RouterConfig {
    @Autowired
    private TimeHandler timeHandler;

    @Bean
    public RouterFunction<ServerResponse> timerRouter() {
        log.info("11");
        return RouterFunctions.route(RequestPredicates.GET("/times"), timeHandler::sendTimePerSec);
    }
}
