package controller;

import model.Game;
import model.RingSizeException;

public class Play {
    public static void main(String[] args) throws RingSizeException {
        int ringCount = 4;
        Game g = new Game(ringCount);
        win(g, ringCount, 1, 3);
    }

    public static void win(Game g, int rootSize, int currTower, int targetTower) throws RingSizeException {
        if (rootSize == 1) {
            g.move(currTower, targetTower);
        } else {
            int spareTower = 6 - currTower - targetTower;
            win(g, rootSize - 1, currTower, spareTower);
            g.move(currTower, targetTower);
            win(g, rootSize - 1, spareTower, targetTower);
        }
    }
}
