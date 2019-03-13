package com.iolo.webflux.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * 测试
 *
 * @author Fengxinxin
 * @date 2019-03-13
 */
@RestController
public class TestController {
    @GetMapping("hello")
    public Mono<String> hell() {
        return Mono.just("welcome webflux");
    }
}
