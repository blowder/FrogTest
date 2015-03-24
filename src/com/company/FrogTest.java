package com.company;

/**
 * Created by sesshoumaru on 24.03.15.
 */
public class FrogTest {
    private int Rings;
    private int Sectors;
    private int lookedRing;
    private int lookedSector;
    private int[][] field;


    public FrogTest(int Rings, int Sectors) {
        this.Rings = Rings;
        this.Sectors = Sectors;
        this.field = new int[Rings][Sectors];
    }

    public int getJumps() {
        return field[lookedRing][lookedSector];
    }

    void setLookedPoint(int Ring, int Sector) {
        this.lookedRing = Ring;
        this.lookedSector = Sector;
    }

    void setLockPoint(int Ring, int Sector) {
        field[Ring][Sector] = -1;
    }

    void FrogJump(int Ring, int Sector, int waveFront) {
        int safeSector = Sector % Sectors;
        if (Ring < 0 || Ring >= Rings) {
            return;
        }
        if (field[Ring][safeSector] == -1) {
            return;
        }
        if (field[Ring][safeSector] > waveFront || field[Ring][safeSector] == 0) {
            int newWave = waveFront + 1;
            field[Ring][safeSector] = waveFront;
            if (Ring == lookedRing && safeSector == lookedSector) {
                return;
            }
            FrogJump(Ring, safeSector + 3, newWave);
            FrogJump(Ring + 1, safeSector + 2, newWave);
            FrogJump(Ring - 1, safeSector + 2, newWave);
            FrogJump(Ring + 2, safeSector + 1, newWave);
            FrogJump(Ring - 2, safeSector + 1, newWave);
        }
    }


}
