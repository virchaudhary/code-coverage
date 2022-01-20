package com.example.codecoverage.strategy.behaviour.quack;

import com.example.codecoverage.strategy.api.QuackBehaviour;
import org.springframework.stereotype.Service;

@Service
public class MuteQuack implements QuackBehaviour {
    @Override
    public void quack() {
        // do nothing
    }
}
