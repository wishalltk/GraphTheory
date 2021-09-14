package com.graph;

import java.util.LinkedList;

public class Dungeon {
    /**
     * Shortest path problem using graph theory
     * */
    char[][] matrix = new char[4][4];

    LinkedList<Integer> rowQ = new LinkedList<>();
    LinkedList<Integer> colQ = new LinkedList<>();

    int currentLayers = 1;
    int nextLayers = 0;

    int distanceTravelled = 0;

    boolean[][] visited = new boolean[4][4];

    private void visit(int row, int col) {
        visited[row][col] = true;
    }

    private boolean hasVisited(int row, int col) {
        return visited[row][col];
    }

    private void prepareMatrix(){
        matrix[0][0]='.';
        matrix[0][1]='.';
        matrix[0][2]='#';
        matrix[0][3]='.';

        matrix[1][0]='.';
        matrix[1][1]='.';
        matrix[1][2]='E';
        matrix[1][3]='#';

        matrix[2][0]='#';
        matrix[2][1]='#';
        matrix[2][2]='.';
        matrix[2][3]='.';

        matrix[3][0]='#';
        matrix[3][1]='.';
        matrix[3][2]='.';
        matrix[3][3]='.';
    }

    public Dungeon() {
        prepareMatrix();
    }

    void explore(int currentRow, int currentCol) {
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        for(int i=0;i<4;i++) {
            int nextRow = currentRow + dr[i];
            int nextCol = currentCol + dc[i];
            if(nextRow <0 || nextRow >= 4 || nextCol < 0 || nextCol >= 4 || matrix[nextRow][nextCol] == '#' || hasVisited(nextRow, nextCol))
                continue;
            rowQ.add(nextRow); colQ.add(nextCol);
            visit(nextRow, nextCol);
            nextLayers += 1;
        }
    }

    int findShortestDistance(int startRow, int startCol) {
        boolean hasFound = false;
        rowQ.add(startRow); colQ.add(startCol);
        visit(startRow, startCol);

        while (!rowQ.isEmpty()) {
            int currentRow = rowQ.pop();
            int currentCol = colQ.pop();
            if(matrix[currentRow][currentCol]=='E') {
                hasFound = true;
                break;
            }
            explore(currentRow, currentCol);
            currentLayers--;
            if(currentLayers==0) {
                currentLayers = nextLayers;
                nextLayers = 0;
                distanceTravelled += 1;
            }
        }
        return hasFound?distanceTravelled:-1;
    }

    public static void main(String[] args) {
        int distance = new Dungeon().findShortestDistance(0,0);
        System.out.println(distance);
    }


}
