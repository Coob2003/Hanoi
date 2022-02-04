package model;

import java.util.ArrayList;

public class Tower {
    private ArrayList<Ring> rings;

    public Tower() {
        rings = new ArrayList<Ring>();
    }

    public ArrayList<Ring> getRings() {
        return rings;
    }

    public Ring getRing(int index) {
        Ring ring = null;
        if (index >= 0 && index < rings.size()) {
            ring = rings.get(index);
        }
        return ring;
    }

    public void push(Ring ring) throws RingSizeException {
        if (rings.size() > 0) {
            if (rings.get(rings.size() - 1).getSize() <= ring.getSize()) {
                throw new RingSizeException("Trying to place a ring of size " + ring.getSize() + " on a ring of size " + rings.get(rings.size() - 1).getSize());
            }
        }
        rings.add(ring);
    }

    public Ring pop() {
        Ring ring = rings.get(rings.size() - 1);
        rings.remove(rings.size() - 1);
        return ring;
    }

    public int height() {
        return rings.size();
    }

    public int width() {
        int width = 0;
    if (rings.size() != 0) {
            width = rings.get(0).getSize();
        } 
        return width;
    }

    public void printRow(int height, int maxWidth) {
        Ring ring = getRing(height - 1);
        if (ring == null) {
            for (int i = 0; i < maxWidth; i++) {
                System.out.print(" ");
            }
            System.out.print("|");
            for (int i = 0; i < maxWidth; i++) {
                System.out.print(" ");
            }
        } else {
            for (int i = 0; i < maxWidth - ring.getSize(); i++) {
                System.out.print(" ");
            }
            for (int i = 0; i < ring.getSize(); i++) {
                System.out.print("X");
            }
            System.out.print("X");
            for (int i = 0; i < ring.getSize(); i++) {
                System.out.print("X");
            }
            for (int i = 0; i < maxWidth - ring.getSize(); i++) {
                System.out.print(" ");
            }
        }
    }
}
