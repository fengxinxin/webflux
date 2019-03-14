package com.iolo.webflux.handler;

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
public class TimeHandler {
    public Mono<ServerResponse> sendTimePerSec(ServerRequest serverRequest) {
        return ok().contentType(MediaType.TEXT_EVENT_STREAM).body(
                Flux.interval(Duration.ofMinutes(1))
                        .map(l -> new SimpleDateFormat("YYYY-MM-DD hh:mm:ss").format(new Date())),
                String.class
        );
    }
}
