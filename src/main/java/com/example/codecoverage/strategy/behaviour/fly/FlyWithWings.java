package com.example.codecoverage.strategy.behaviour.fly;

import com.example.codecoverage.strategy.api.FlyBehaviour;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@Primary
public class FlyWithWings implements FlyBehaviour {
    @Override
    public void fly() {
        log.info("Flying with wings");
    }
}
