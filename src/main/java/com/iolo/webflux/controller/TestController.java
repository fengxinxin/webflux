package com.iolo.webflux.controller;

import com.iolo.webflux.handler.TimeHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.print.attribute.standard.Media;
import java.time.Duration;

/**
 * 测试
 *
 * @author Fengxinxin
 * @date 2019-03-13
 */
@RestController
@Slf4j
public class TestController {
    @Autowired
    private TimeHandler timeHandler;

    @GetMapping("hello")
    public Mono<String> hell() {
        return Mono.just("welcome webflux");
    }

    @GetMapping(value = "times1", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> times1(String id) {
        log.info(id);
        return Flux.interval(Duration.ofSeconds(5)).map(l -> {
            boolean flag = false;
            if (l / 2 == 0) {
                flag = true;
            }
            return flag ? id + " " + l : "false";
        });
    }

    @GetMapping(value = "times2")
    public Flux<String> times2(String id) {
        log.info(id);
        return Flux.interval(Duration.ofSeconds(5)).map(l -> {
            return id + " " + l;
        });
    }
}
