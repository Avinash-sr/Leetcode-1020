class Solution {
    int ans=0;
    public boolean isvalid(int m, int n, int[][] grid, int x, int y){
        if(x>=0 && x<m && y>=0 && y<n && grid[x][y]==1){
            return true;
        }
        return false;
    }
    public void dfs(int m, int n, int[][] grid, int x, int y) {
        ans++;
        grid[x][y]=0;
        int[] row = {-1, 1, 0, 0};
        int[] col = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int r = x + row[i];
            int c = y + col[i];
            if (isvalid(m,n,grid,r,c)) {
                dfs(m, n, grid, r, c);
            }
        }
}

    public int numEnclaves(int[][] grid) {
        int m= grid.length;
        int n= grid[0].length;
      
        for(int i=0;i<m;i++){
            for(int j=0; j<n; j++){
                if(i*j==0 || i==m-1 || j==n-1){
                    if(grid[i][j]==1)
                        dfs(m,n,grid, i, j);
                }
            }
        }
        ans=0;
       
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    dfs(m,n,grid,i,j);
                }
            }
        }

        return ans;
    }
}