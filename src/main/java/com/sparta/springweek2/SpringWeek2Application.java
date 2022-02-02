package com.sparta.springweek2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing // 타임스탬프 사용 시 반드시 넣어줘야 함.
@SpringBootApplication
public class SpringWeek2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringWeek2Application.class, args);
    }

}
