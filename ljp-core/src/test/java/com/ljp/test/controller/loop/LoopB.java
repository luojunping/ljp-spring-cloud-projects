package com.ljp.test.controller.loop;

public class LoopB {

    private LoopA loopA;

    public LoopA getLoopA() {
        return loopA;
    }

    public void setLoopA(LoopA loopA) {
        this.loopA = loopA;
    }

    public static void say() {
        System.out.println("LoopB.say()...");
    }

}
