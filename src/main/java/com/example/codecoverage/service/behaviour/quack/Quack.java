package com.example.codecoverage.service.behaviour.quack;

import com.example.codecoverage.service.api.QuackBehaviour;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@Primary
public class Quack implements QuackBehaviour {
    @Override
    public void quack() {
        log.info("quacking");
    }
}
