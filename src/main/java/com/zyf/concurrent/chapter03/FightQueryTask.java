package com.zyf.concurrent.chapter03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author Hero
 * @description com.zyf.concurrent.chapter03
 * @date 2019/8/14
 */
public class FightQueryTask extends Thread implements FightQuery {

    private final String origin;

    private final String destination;

    private final List<String> fightList = new ArrayList<>();

    public FightQueryTask(String airline, String origin, String destination) {
        super("[" + airline + "]");
        this.origin = origin;
        this.destination = destination;
    }

    @Override
    public void run() {
        System.out.printf("%s-query from %s to %s \n", getName(), origin, destination);
        int randomVal = ThreadLocalRandom.current().nextInt(10);
        try {
            TimeUnit.SECONDS.sleep(randomVal);
            this.fightList.add(getName() + "-" + randomVal);
            System.out.printf("The Fight:%s list query successful\n", getName());
        } catch (InterruptedException e) {

        }
    }

    @Override
    public List<String> get() {
        return this.fightList;
    }
}
