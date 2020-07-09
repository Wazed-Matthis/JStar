package com.jstar.pathfinding;

public class PathNode {

    private PathNode[] neighbouringNodes;

    private PathNode previousNode;

    private final int x, y, z;
    private float gCost, wCost, hCost;
    private boolean valid;
    private final int hash;

    public PathNode(int x, int y, int z) {
        this.hash = hashCode();
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getDistanceSq(PathNode other) {
        int dX = this.x - other.getX();
        int dY = this.y - other.getY();
        int dZ = this.z - other.getZ();
        return dX * dX + dY * dY + dZ * dZ;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public float getgCost() {
        return gCost;
    }

    public float gethCost() {
        return hCost;
    }

    public float getwCost() {
        return wCost;
    }

    public PathNode[] getNeighbouringNodes() {
        return neighbouringNodes;
    }

    public int getHash() {
        return hash;
    }

    public boolean isValid() {
        return this.valid;
    }
}
