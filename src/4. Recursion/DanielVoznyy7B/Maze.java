/**
 * The Maze class will recursively check whether a maze has a valid path of 0s from its leftmost or topmost positions
 * to its rightmost or bottommost positions
 *
 * <h2>Course Info</h2>
 * ICS4U0 with Krasteva V.
 *
 * @author Daniel Voznyy
 * @version 15.04.19
 */

public class Maze {
    /**
     * Runs the program. Creates a 2d array which acts as the maze.
     * Prints whether or not that maze has a valid traversable path of 0s.
     *
     * @param args passed command line arguments
     */
    public static void main(String[] args) {
        int[][] maze = {
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 1},
                {1, 1, 1, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 0, 1}};
        System.out.println(aMazeMe(maze));
    }

    /**
     * Overflown method which stops the aMazeMe method from editing the original maze.
     * It also defines the starting coordinates as 0, 0
     *
     * @param maze the maze to clone
     * @return the result of the other aMazeMe
     */
    public static boolean aMazeMe(int[][] maze) {
        //clone the 2d array so we are not directly modifying it
        int[][] tempMaze = new int[maze.length][];
        for (int i = 0; i < maze.length; i++)
            tempMaze[i] = maze[i].clone();

        return aMazeMe(tempMaze, 0, 0);
    }

    /**
     * Checks if the current position in the maze is a 0, marks it as traversed with a 2.
     * Then, checks whether it is at the right or bottom edge of the maze (i.e. at a valid exit).
     * If it is, returns true, if not continues. Then, it calls aMazeMe() with the coordinates of its four neighbouring
     * cells.
     * Will not call if the up or left positions are < 0 (i.e. out of bounds).
     * Only returns true if one of the 4 aMazeMe() calls returned true, otherwise continues.
     * If the current position was not 0 (i.e. a wall or already traversed) will return false, unless that position
     * is a valid entrance (with an x or y position of 0), in which case it will call aMazeMe() with the next entrance
     * at x = 0 or y = 0, unless such an entrance is out of bounds.
     *
     * @param maze   the maze array
     * @param startX the x position to start checking from
     * @param startY the y position to start checking from
     * @return whether the maze is traversable
     */
    private static boolean aMazeMe(int[][] maze, int startX, int startY) {
        int startValue = maze[startX][startY]; //find out what our start value is
        if (startValue == 0) { //if value is traversable
            maze[startX][startY] = 2; //mark as visited

            //print out what the algorithm does step by step
            /*for(int[] row: maze)
                System.out.println(Arrays.toString(row));
            System.out.println("\n");*/

            //check neighbouring squares
            //Going Down-Right
            if (startX == maze.length - 1 || startY == maze[0].length - 1 //a max value is an exit! (also avoids out of bounds errors)
                    || aMazeMe(maze, startX + 1, startY) || aMazeMe(maze, startX, startY + 1)) //check squares down and right
                return true;

            //Going Up-Left
            if (startX <= 0 || startY <= 0)
                return false; //if we are at a starting position, prevent out of bounds from negatives
            return (aMazeMe(maze, startX - 1, startY) || aMazeMe(maze, startX, startY - 1)); //check the squares up and left
        } else {
            if (startY == 0 && startX < maze.length - 2 //startX + 1 < length -1 simplified
                    && aMazeMe(maze, startX + 1, startY)) //check next x = 0 value
                return true;
            if (startX == 0 && startY < maze[0].length - 2)
                return aMazeMe(maze, startX, startY + 1); //no need for if statement since it's the last check
        }
        return false; //if we went through all those loops and nothing returned true, there must not be an exit
    }
}