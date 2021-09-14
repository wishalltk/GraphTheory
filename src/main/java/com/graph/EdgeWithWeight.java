package com.graph;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EdgeWithWeight {
    private final int from;
    private final int to;
    private int cost;
}
