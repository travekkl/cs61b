package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    private static final long SEED = 2873122;
    private static final Random RANDOM = new Random(SEED);
    private static class Position {
        private int x;
        private int y;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int calPointSart(Position p, int s, int line) {
        //return null;
        int x1;
        if (line > s) {
            x1 =  p.x + line - s - 1;
        } else {
            x1 =  p.x + s - line;
        }
        return x1;

    }

    private static int calPointStop(Position p, int s, int line) {
        //return null;
        int a;
        if (line > s) {
            a = p.x + s * 3 - 2 - (line - s - 1);
        } else {
            a = p.x + s * 3 - 2 - (s - line);
        }
        return a;
    }

    public static void initialTiles(TETile[][] tiles) {
        int Length = tiles[0].length;
        for (int i = 0; i < Length; i++) {
            for (int j = 0; j < Length; j++) {
                tiles[i][j] = Tileset.NOTHING;
            }
        }
    }

    /** Picks a RANDOM tile with a 33% change of being
     *  a wall, 33% chance of being a flower, and 33%
     *  chance of being empty space.
     */
    private static TETile randomTile() {
        int tileNum = RANDOM.nextInt(7);
        switch (tileNum) {
            case 0: return Tileset.WALL;
            case 1: return Tileset.FLOWER;
            case 2: return Tileset.GRASS;
            case 3: return Tileset.SAND;
            case 4: return Tileset.TREE;
            case 5: return Tileset.WATER;
            default: return Tileset.MOUNTAIN;

        }
    }

    public static void fillWithTiles(TETile[][] tiles, Position p, int len) {
        int m;
        int n;
        TETile t = randomTile();
        for (int i = 0; i < len * 2; i++) {
            m = calPointSart(p, len, i + 1);
            n = calPointStop(p, len, i + 1);
            for (int j = m; j < n; j++) {
                tiles[j][i + p.y] = t;
            }
        }
    }


    public static void drawHexes(TETile[][] tiles, Position p, int n, int len) {
        Position a = new Position(p.x, p.y);
        for (int i = 0; i < n; i++) {
            fillWithTiles(tiles, a, len);
            a.y += len * 2;
        }
    }

    public static void drawHexWorld(TETile[][] tiles, Position p, int n, int len) {
        Position a = new Position(p.x, p.y);
        int[] b = new int[]{3, 4, 5, 4, 3};
        for (int i = 0; i < b.length; i++) {
            a.x = p.x + (i - 2) * (2 * len - 1);
            a.y = p.y + Math.abs(i - 2) * len;

            drawHexes(tiles, a, b[i], len);
        }
    }

    public static void main(String[] args) {
        Position p = new Position(20, 5);
        TERenderer ter = new TERenderer();
        ter.initialize(50, 50);

        TETile[][] randomTiles = new TETile[50][50];
        initialTiles(randomTiles);
        //fillWithTiles(randomTiles, p, 4);
        drawHexWorld(randomTiles, p, 0, 3);
        //drawHexes(randomTiles, p, 4, 3);

        ter.renderFrame(randomTiles);
    }
}
