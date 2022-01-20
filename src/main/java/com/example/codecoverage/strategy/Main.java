package com.example.codecoverage.strategy;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public record Main(List<Duck> ducks) {

    public void test() {
        for (var duck : ducks) {
            duck.performFly();
            duck.performQuack();
            duck.display();
        }
    }

}
