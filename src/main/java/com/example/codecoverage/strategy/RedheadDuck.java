package com.example.codecoverage.strategy;

import com.example.codecoverage.strategy.api.FlyBehaviour;
import com.example.codecoverage.strategy.api.QuackBehaviour;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class RedheadDuck extends Duck {

    private static final String NAME = "Redhead Duck";

    public RedheadDuck(FlyBehaviour flyBehaviour, QuackBehaviour quackBehaviour) {
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
