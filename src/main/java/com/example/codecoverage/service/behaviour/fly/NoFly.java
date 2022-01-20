package com.example.codecoverage.service.behaviour.fly;

import com.example.codecoverage.service.api.FlyBehaviour;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class NoFly implements FlyBehaviour {
    @Override
    public void fly() {
        // nothing here
    }
}
