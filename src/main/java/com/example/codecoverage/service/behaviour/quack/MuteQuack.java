package com.example.codecoverage.service.behaviour.quack;

import com.example.codecoverage.service.api.QuackBehaviour;
import org.springframework.stereotype.Service;

@Service
public class MuteQuack implements QuackBehaviour {
    @Override
    public void quack() {
        // do nothing
    }
}
