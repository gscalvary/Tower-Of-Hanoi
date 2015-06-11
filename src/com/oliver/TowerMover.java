package com.oliver;

public class TowerMover {

    TowerStake[] stakes;

    TowerMover(TowerStake[] stakes) {

        this.stakes = stakes;
    }

    public void moveTowers() {

        moveRing(stakes[1], stakes[0].removeRing());

        while(stakes[1].getNumRings() < 6) {
            moveRing(stakes[2], stakes[0].removeRing());
            stakes[2].placeAll(stakes[1].removeAll());
            stakes[1].placeAll(stakes[2].removeAll());
        }
    }

    private void moveRing(TowerStake stake, TowerRing ring) {

        try {
            stake.addRing(ring);
        } catch(TooManyRingsException te) {
            System.out.println(te.toString());
        } catch(RingSizeException re) {
            System.out.println(re.toString());
        }
    }
}
