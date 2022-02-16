class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        if(rows == 0) return 0;
        
        int cols = grid[0].length;
        
        int islands = 0;
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j] == '1'){
                    helper(grid, i,j,rows,cols);
                    islands++;
                }
            }
        }
        
        return islands;
    }
    
    void helper(char [][] grid, int x, int y, int r, int c){
        if(x<0 || x>=r || y<0 || y>=c || grid[x][y] != '1')
            return;
        grid[x][y] = '2';
        
        helper(grid, x+1,y,r,c);
        helper(grid, x,y+1,r,c);
        helper(grid, x-1,y,r,c);
        helper(grid, x,y-1,r,c);
    }
}