package com.example.codecoverage.strategy;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class Main {

    private Duck mallardDuck;
    private Duck rubberDuck;

    public Main(@Qualifier("mallardDuck") Duck mallardDuck, @Qualifier("rubberDuck") Duck rubberDuck) {
        this.mallardDuck = mallardDuck;
        this.rubberDuck = rubberDuck;
    }

    public void test() {
        mallardDuck.performFly();
        mallardDuck.performQuack();
        mallardDuck.display();

        rubberDuck.performFly();
        rubberDuck.performQuack();
        rubberDuck.display();
    }

}
