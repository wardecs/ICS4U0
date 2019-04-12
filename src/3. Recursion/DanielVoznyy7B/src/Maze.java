import java.sql.SQLOutput;
import java.util.Arrays;

public class Maze {
    public static void main(String[] args) {
        int[][] maze = {
                {0, 0, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 1},
                {0, 1, 0, 1, 0, 1},
                {0, 1, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1}};
        System.out.println(aMazeMe(maze, 0, 0));
    }

    public static boolean aMazeMe(int[][] maze, int startX, int startY) {
        int startValue = maze[startX][startY]; //find out what our start value is
        if (startValue == 0) { //if value is traversable
            maze[startX][startY] = 2; //mark as visited

            //print out
            for(int[] row: maze)
                System.out.println(Arrays.toString(row));
            System.out.println("\n");

            //check neighbouring squares
            //Going Down-Right
            System.out.println(startX + " " + startY);
            if (startX == maze[0].length - 1) //if x at max
                return true; //a max value is an exit!
            else if (aMazeMe(maze, startX + 1, startY)) //keep going unless it succeeds
                return true;
            if (startY == maze.length - 1)
                return true;
            else if (aMazeMe(maze, startX, startY + 1))
                return true;

            //Going Up-Left
            if (startX <= 0) return false; //if we are at a starting position, prevent out of bounds from negatives
            else if (aMazeMe(maze, startX - 1, startY))
                return true;
            if (startY <= 0) return false;
            return aMazeMe(maze, startX, startY - 1); //no need to do if check for last return statement
        }
        //TODO WE ARE REPEATING CODE
        else {
            if (startY == 0 && startX < maze[0].length - 2) //startX + 1 < length -1 simplified
                if (aMazeMe(maze, startX + 1, startY))
                    return true;
            if (startX == 0 && startY < maze.length - 2)
                return aMazeMe(maze, startX, startY + 1); //no need for if statement either
        }
        //if we went through all those loops and nothing returned true, there must not be an exit
        return false;
    }
}