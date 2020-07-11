package com.jstar.pathfinding;

import com.jstar.Helper;

import java.util.*;

public class PathFinder {
    private final ArrayList<PathNode> openSet = new ArrayList<PathNode>();
    private final ArrayList<PathNode> closedSet = new ArrayList<PathNode>();

    private final HashMap<PathNode, Float> gScoreMap = new HashMap<PathNode, Float>();

    public Path calculatePath(PathNode start, PathNode goal, float hCost) {
        openSet.add(start);

        PathNode currentNode = start;
        while (!openSet.isEmpty()) {
            PathNode temp = currentNode;
            currentNode = openSet.stream().min(Comparator.comparingDouble(PathNode::getgCost)).orElse(null);
            currentNode.setPreviousNode(temp);
            currentNode.addNeighbours();

            if (currentNode.equals(goal)) {
                return backTrace(currentNode);
            }

            closedSet.add(currentNode);

            for (PathNode neighbour : currentNode.getNeighbouringNodes()) {
                if (closedSet.contains(neighbour))
                    continue;

                final float tentG = Helper.getHelperSingleton().getTentativeGCost(currentNode, neighbour, goal);

                if ((openSet.contains(neighbour) && tentG >= neighbour.getgCost()) || !neighbour.isValid())
                    continue;

                openSet.add(neighbour);
                neighbour.setgCost(tentG);
            }

            openSet.remove(currentNode);
        }
        throw new IllegalStateException("Failed to find path");
    }

    private Path backTrace(PathNode current) {
       ArrayList<PathNode> nodes = new ArrayList<>();

        while (current.hasPreviousNode()) {
            nodes.add(current);
            current = current.getPreviousNode();
        }

        Collections.reverse(nodes);
        return new Path(nodes, nodes.get(0), nodes.get(nodes.size() - 1));
    }
}
