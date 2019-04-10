package com.iolo.webflux.controller;

import com.iolo.webflux.domain.City;
import com.iolo.webflux.handler.CityHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Fengxinxin
 * @date 2019-04-10
 */
@Controller
@RequestMapping("/cityRedirect")
@Slf4j
public class CityRedirectController {
    @Autowired
    private CityHandler cityHandler;

    private static final String CITY_LIST_PATH_NAME = "cityList";

    private static final String CITY_PATH_NAME = "city";

    @GetMapping("/test")
    @ResponseBody
    public String queryTest(String param) {
        return param;
    }

    @GetMapping("/page/list")
    public String listPage(final Model model) {
        final Flux<City> cityFluxList = cityHandler.findAllCity();
        model.addAttribute("cityList", cityFluxList);
        return CITY_LIST_PATH_NAME;
    }

    @GetMapping("/getByName")
    public String getByCityName(final Model model,
            @RequestParam("cityName") String cityName) {
        final Mono<City> city = cityHandler.getByCityName(cityName);
        model.addAttribute("city", city);
        return CITY_PATH_NAME;
    }
}
