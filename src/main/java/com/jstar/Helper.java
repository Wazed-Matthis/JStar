package com.jstar;

import com.jstar.pathfinding.PathNode;

public class Helper {
    private static transient Helper helperSingleton;

    public Helper() {
        helperSingleton = this;
    }

    public static Helper getHelperSingleton() {
        return helperSingleton;
    }

    public float getTentativeGCost(PathNode from, PathNode to, PathNode goal) {
        return from.getDistanceSq(to) + from.getDistanceSq(goal);
    }
}
