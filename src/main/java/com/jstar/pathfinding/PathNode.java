package com.jstar.pathfinding;

import java.util.Arrays;

public class PathNode {

    private final int hash;
    private PathNode[] neighbouringNodes = new PathNode[27];
    private PathNode previousNode;
    private int x;
    private int y;
    private int z;
    private float gCost;
    private float wCost;
    private float hCost;
    private boolean valid;
    private boolean visited;

    /**
     * TODO: This is not working like it should, please fix
     * TODO: improve performance or find another solution to add neighbours
     */
    public PathNode(int x, int y, int z, boolean addNeighbours) {
        if (addNeighbours) this.addNeighbours();

        this.hash = hashCode();
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public PathNode(int x, int y, int z) {
        this(x, y, z, false);
    }

    public void addNeighbours() {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                for (int k = -1; k <= 1; k++) {
                    final int index = (i + 1) + 3 * ((j + 1) + 3 * (k + 1));
                    neighbouringNodes[index] = add(i, j, k);
                }
            }
        }
    }

    public int getDistanceSq(PathNode other) {
        int dX = this.x - other.getX();
        int dY = this.y - other.getY();
        int dZ = this.z - other.getZ();
        return dX * dX + dY * dY + dZ * dZ;
    }

    public PathNode add(int x, int y, int z) {
        final int aX = this.x + x;
        final int aY = this.y + y;
        final int aZ = this.z + z;
        return new PathNode(aX, aY, aZ);
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

    public PathNode getPreviousNode() {
        return previousNode;
    }

    public boolean hasPreviousNode() {
        return previousNode != null;
    }

    public void setPreviousNode(PathNode previousNode) {
        this.previousNode = previousNode;
    }

    public float getgCost() {
        return gCost;
    }

    public void setgCost(float gCost) {
        this.gCost = gCost;
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

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PathNode pathNode = (PathNode) o;
        return x == pathNode.x &&
                y == pathNode.y &&
                z == pathNode.z &&
                valid == pathNode.valid;
    }

    @Override
    public String toString() {
        if (this.neighbouringNodes[0] == null) return "PathNode{x=" + x + ", y=" + y + ", z=" + z + "}";
        return "PathNode{" +
                "hash=" + hash +
                ", neighbouringNodes=" + Arrays.toString(neighbouringNodes) +
                ", previousNode=" + previousNode +
                ", x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", gCost=" + gCost +
                ", wCost=" + wCost +
                ", hCost=" + hCost +
                ", valid=" + valid +
                ", visited=" + visited +
                '}';
    }
}
