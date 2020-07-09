package com.jstar.pathfinding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class PathFinder {

    private final ArrayList<PathNode> openSet = new ArrayList<PathNode>();
    private final ArrayList<PathNode> closedSet = new ArrayList<PathNode>();

    private final HashMap<PathNode, Float> gScoreMap = new HashMap<PathNode, Float>();
    private PathNode currentPoint;

    public Path calculatePath(PathNode start, PathNode goal, float hCost) {
        openSet.add(start);

        while (!openSet.isEmpty()) {
            currentPoint = openSet.stream().min(Comparator.comparingDouble(PathNode::getwCost)).orElse(null);

            if (currentPoint.equals(goal)) {

            }

            closedSet.add(currentPoint);
            //TODO: renaming (I am bad at naming things)
            for (PathNode currentNode : currentPoint.getNeighbouringNodes()) {
                if (closedSet.contains(currentNode))
                    continue;
                //TODO: implement Heuristic G function
                final float tentG = /*g(currentPoint,currentNode) + */ currentPoint.getDistanceSq(currentNode);

                if (openSet.contains(currentNode) && tentG >= currentNode.getgCost())
                    continue;

                currentNode.setPreviousNode(currentPoint);
                currentNode.setgCost(tentG);
                //TODO: finish
            }
        }
        return null;
    }

    private Path backTrace(PathNode current) {

    }

}
