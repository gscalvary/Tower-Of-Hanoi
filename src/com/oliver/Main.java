package com.oliver;

public class Main {

    public static void main(String[] args) {

        TowerStake one = new TowerStake("one", 6);
        TowerStake two = new TowerStake("two", 6);
        TowerStake three = new TowerStake("three", 6);

        buildTower(one, new TowerRing(6));
        buildTower(one, new TowerRing(5));
        buildTower(one, new TowerRing(4));
        buildTower(one, new TowerRing(3));
        buildTower(one, new TowerRing(2));
        buildTower(one, new TowerRing(1));

        one.print();
        two.print();
        three.print();

        TowerMover mover = new TowerMover(new TowerStake[]{one, two, three});
        mover.moveTowers();

        System.out.println("\n\nMove has occurred.");

        one.print();
        two.print();
        three.print();
    }

    public static void buildTower(TowerStake stake, TowerRing ring) {

        try {
            stake.addRing(ring);
        } catch(TooManyRingsException te) {
            System.out.println(te.toString());
        } catch(RingSizeException re) {
            System.out.println(re.toString());
        }
    }
}
