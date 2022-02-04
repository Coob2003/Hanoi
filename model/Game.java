package model;

import java.util.ArrayList;

public class Game {
    private ArrayList<Tower> towers;

    public Game(int ringCount) throws RingSizeException {
        towers = new ArrayList<Tower>();
        for (int i = 0; i < 3; i++) {
            towers.add(new Tower());
        }

        Tower startTower = towers.get(0);
        for (int i = 0; i < ringCount; ringCount--) {
            startTower.push(new Ring(ringCount));
        }

        printGame();
    }

    public void move(int t1, int t2) throws RingSizeException {
        Tower tower1 = towers.get(t1 - 1);
        Tower tower2 = towers.get(t2 - 1);
        tower2.push(tower1.pop());
        printGame();
    }

    public void printGame() {
        int maxHeight = 0;
        int maxWidth = 0;
        for (Tower t : towers) {
            int tHeight = t.height();
            int tWidth = t.width();
            if (tHeight > maxHeight) {
                maxHeight = tHeight;
            }
            if (tWidth > maxWidth) {
                maxWidth = tWidth;
            }
        }

        for (int i = maxHeight; i > 0; i--) {
            for (Tower t : towers) {
                t.printRow(i, maxWidth);
                System.out.print("   ");
            }
            System.out.println("");
        }
        for (int i = 0; i < ((((maxWidth * 2) + 1) + 3) * towers.size()) - 3; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
