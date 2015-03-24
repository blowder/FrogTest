package com.company;


public class Main {
    public static void main(String... arg) {
        FrogTest frog = new FrogTest(10,16);
        frog.setLookedPoint(9,8);
        frog.setLockPoint(8,13);
        frog.setLockPoint(7,4);
        frog.FrogJump(6,10,0);
        System.out.print(frog.getJumps());
    }
}
