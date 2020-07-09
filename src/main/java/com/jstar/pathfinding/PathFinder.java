package com.jstar.pathfinding;

import java.util.ArrayList;
import java.util.HashMap;

public class PathFinder {

    private final ArrayList<PathNode> openSet = new ArrayList<PathNode>();

    private final HashMap<PathNode, Float> gScoreMap = new HashMap<PathNode, Float>();
    private PathNode currentPoint;

    public Path calculatePath(PathNode start, PathNode goal, float hCost){
        openSet.add(start);
        return null;
    }

}
