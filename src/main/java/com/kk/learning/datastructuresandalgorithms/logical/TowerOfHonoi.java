package com.kk.learning.datastructuresandalgorithms.logical;

public class TowerOfHonoi {

    public void move(int disks, String from, String to, String temp){
        if(disks < 1) return;
        move(disks-1, from, temp, to);
        System.out.println(String.format("Moving %d from %s to %s ", disks, from, to));
        move(disks-1, temp, to, from);
    }

    public static void main(String[] args) {
        TowerOfHonoi towerOfHonoi = new TowerOfHonoi();
        towerOfHonoi.move(3, "A", "C", "B");
    }
}
