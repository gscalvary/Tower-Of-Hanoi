package com.oliver;

import java.util.LinkedList;

public class TowerStake {

    private String name;
    private int maxSize;
    private LinkedList<TowerRing> rings;

    TowerStake(String name, int maxSize) {

        this.name = name;
        this.maxSize = maxSize;
        rings = new LinkedList<TowerRing>();
    }

    public void addRing(TowerRing ring) throws TooManyRingsException, RingSizeException {

        if(rings.size() + 1 > maxSize) {
            throw new TooManyRingsException(maxSize);
        } else if(rings.size() > 0 && ring.getSize() > rings.getFirst().getSize()) {
            throw new RingSizeException(ring.getSize(), rings.getFirst().getSize());
        } else {
            rings.addFirst(ring);
        }
    }

    public TowerRing removeRing() {

        if(rings.size() > 0) {
            return rings.removeFirst();
        } else {
            return null;
        }
    }

    public LinkedList<TowerRing> removeAll() {

        LinkedList<TowerRing> temp = new LinkedList<TowerRing>();
        temp.addAll(rings);
        rings.clear();
        return temp;
    }

    public void placeAll(LinkedList<TowerRing> newRings) {

        while(!newRings.isEmpty()) {
            rings.addFirst(newRings.removeLast());
        }
    }

    public int getNumRings() {

        return rings.size();
    }

    public void print() {

        if(rings.size() == 0) {
            System.out.print("\nStake " + name + " is empty.");
        } else {
            System.out.print("\nStake " + name + " has rings of size: ");
            for (TowerRing ring : rings) {
                System.out.print(ring.getSize() + " ");
            }
            System.out.print("from top to bottom.");
        }
    }
}
