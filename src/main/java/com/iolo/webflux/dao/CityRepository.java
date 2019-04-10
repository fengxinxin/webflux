package com.iolo.webflux.dao;

import com.iolo.webflux.domain.City;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * @author Fengxinxin
 * @date 2019-04-10
 */
@Repository
public interface CityRepository extends ReactiveMongoRepository<City, Long> {
    Mono<City> findByCityName(String cityName);
}
