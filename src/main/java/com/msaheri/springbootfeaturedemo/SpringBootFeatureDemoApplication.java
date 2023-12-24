package com.msaheri.springbootfeaturedemo;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Arrays;
import java.util.logging.Logger;
import java.util.stream.Stream;

@SpringBootApplication
@EnableFeignClients
@Slf4j
public class SpringBootFeatureDemoApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringBootFeatureDemoApplication.class, args);

        int[] numbers = {1,2,3,4,3,2,3,4,5,6,7,8,4,6,8,6};

        double avg = Arrays.stream(numbers).filter(i->i<4).map(i->i*2).col.average().getAsDouble();

        log.info("avg :"+ avg);
    }







}
