package com.iolo.webflux;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class WebfluxApplicationTests {

    @Test
    public void contextLoads() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test01() {
        StepVerifier.create(Flux.just(1, 2, 3, 4, 5, 6).doOnNext(System.out::print))
                .expectNext(1, 2, 3, 4, 5, 6)
                .expectComplete()
                .verify();
        System.out.println("123");
    }

    @Test
    public void test02() {
        WebClient webClient = WebClient.create("http://127.0.0.1:8080");
        webClient
                .get()
                .uri("/times1?id=2")
                .accept(MediaType.TEXT_EVENT_STREAM)
                .retrieve()
                .bodyToFlux(String.class)
                .log()
                .take(10).blockLast();
    }

}
