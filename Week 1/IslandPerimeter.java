class IslandPerimete {
    public int islandPerimeter(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        int perimeter = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) { // if land
                
                    perimeter += 4; //add this first nad then subtract from land around the cell
                    
                    //subtracting works by only checking valid i,j and without checking if land or not because water value is 0 anyway.
                    if (i > 0) perimeter -= grid[i - 1][j]; //up
                    if (i < r - 1) perimeter -= grid[i + 1][j]; // down
                    if (j > 0) perimeter -= grid[i][j - 1]; //left
                    if (j < c - 1) perimeter -= grid[i][j + 1]; //right
                }
            }
        }

        return perimeter;
    }
}
