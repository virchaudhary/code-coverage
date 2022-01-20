package com.example.codecoverage.strategy;

import com.example.codecoverage.strategy.api.FlyBehaviour;
import com.example.codecoverage.strategy.api.QuackBehaviour;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@Primary
public class MallardDuck extends Duck {

    private static final String NAME = "Mallard Duck";

    public MallardDuck(FlyBehaviour flyBehaviour, QuackBehaviour quackBehaviour) {
        super(flyBehaviour, quackBehaviour);
    }

    @Override
    protected String getDuckName() {
        return NAME;
    }

    @Override
    public void display() {
        log.info("looks like a " + getDuckName());
    }
}
