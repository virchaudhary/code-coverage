package com.example.codecoverage.strategy;

import com.example.codecoverage.strategy.api.FlyBehaviour;
import com.example.codecoverage.strategy.api.QuackBehaviour;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@Primary
public class RubberDuck extends Duck {

    private static final String NAME = "Rubber Duck";

    public RubberDuck(@Qualifier("noFly") FlyBehaviour flyBehaviour, @Qualifier("squeak") QuackBehaviour quackBehaviour) {
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