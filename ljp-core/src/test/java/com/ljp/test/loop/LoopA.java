package com.ljp.test.loop;

public class LoopA {

    private LoopB loopB;

    public LoopB getLoopB() {
        return loopB;
    }

    public void setLoopB(LoopB loopB) {
        this.loopB = loopB;
    }

    public void say() {
        System.out.println("LoopA.say()...");
    }

}
