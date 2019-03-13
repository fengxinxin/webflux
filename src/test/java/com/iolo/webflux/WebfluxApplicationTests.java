package com.iolo.webflux;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
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

}
