class Solution {
    public Node construct(int[][] grid) {
        //call recursive helper
    }

    //a recursive helper
    //takes grid with some sub-grid bounds
    //attempt to represent region with node
    //
    public Node helper(int[][] grid, int tl_x, int tl_y, int br_x, int br_y) {
        //base case--subgrid is 1x1
        //top left and bottom right bounds are EQUAL
        //return a leaf node with correct val
        if(tl_x==br_x && tl_y==br_y) {
            return new Node(grid[tl_x][tl_y]==1,true);
        }

        //subdivide into four regions and recurse into them
        //use the return nodes to determine if the current
        //bounded region is also a leaf node
        Node tl = helper(grid,tl_x,tl_y,tl_x+(br_x-tl_x)/2,tl_y+(br_y-tl_y)/2);



    }
}
