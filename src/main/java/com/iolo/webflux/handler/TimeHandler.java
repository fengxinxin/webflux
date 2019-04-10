package com.iolo.webflux.handler;

import com.iolo.webflux.domain.City;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * 时间测试
 *
 * @author Fengxinxin
 * @date 2019-03-14
 */
@Component
@Slf4j
public class TimeHandler {
    @Autowired
    private CityHandler cityHandler;

    public Mono<ServerResponse> sendTimePerSec(ServerRequest serverRequest) {
        return ok().contentType(MediaType.TEXT_EVENT_STREAM).body(
                Flux.interval(Duration.ofSeconds(5))
                        .map(l -> {
                            Flux<City> results = cityHandler.findAllCity();
                            log.info(String.valueOf(l));
                            log.info(serverRequest.queryParam("id").orElse("other"));
                            String dateStr = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss").format(new Date());
//                            return serverRequest.queryParam("id").orElse("other") + dateStr;
                            return results.count().toString();
                        }),
                String.class
        );
    }
}
