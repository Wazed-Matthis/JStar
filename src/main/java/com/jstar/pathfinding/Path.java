package com.jstar.pathfinding;

import java.util.ArrayList;

public class Path {

    private final ArrayList<PathNode> nodes = new ArrayList<PathNode>();

    private final PathNode start, goal;

    private float tentativeGCost;

    public Path(ArrayList<PathNode> nodes, PathNode start, PathNode goal) {
        this.start = start;
        this.goal = goal;
        this.nodes.addAll(nodes);
    }

    public ArrayList<PathNode> getNodes() {
        return nodes;
    }


    public void setTentativeGCost(float tentativeGCost) {
        this.tentativeGCost = tentativeGCost;
    }

    public float getTentativeGCost() {
        return tentativeGCost;
    }
}
