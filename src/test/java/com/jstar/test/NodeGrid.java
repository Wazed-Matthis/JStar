package com.jstar.test;

import com.jstar.pathfinding.PathNode;

public class NodeGrid {
    private PathNode[] nodes;

    private final int sizeX, sizeY, sizeZ;

    public NodeGrid(int sizeX, int sizeY, int sizeZ) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.sizeZ = sizeZ;

//        // TODO: fix this
//        this.nodes = new PathNode[(sizeX == 0 ? 1 : sizeX) * (sizeY == 0 ? 1 : sizeY) * (sizeZ == 0 ? 1 : sizeZ)];
//
//        for (int x = 0; x <= sizeX; x++) {
//            for (int y = 0; y <= sizeY; y++) {
//                for (int z = 0; z <= sizeZ; z++) {
//                    final int index = x + (sizeX + 1) * (y + (sizeY + 1) * z);
//                    nodes[index] = new PathNode(x, y, z);
//                }
//            }
//        }
    }

    public void display() {
        for (int z = 0; z <= sizeZ; z++) {
            for (int y = 0; y <= sizeY; y++) {
                for (int x = 0; x <= sizeX; x++) {
                    final int index = x + (sizeX + 1) * (y + (sizeY + 1) * z);
                    final String s = String.valueOf(index);
                    System.out.print(s + (s.length() == 1 ? "  " : (s.length() == 2 ? " " : "")) + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

}
