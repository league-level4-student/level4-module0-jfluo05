package _04_Maze_Maker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;


public class MazeMaker{
	
	private static int width;
	private static int height;
	
	private static Maze maze;
	
	private static Random rand = new Random();
	private static Stack<Cell> uncheckedCells = new Stack<Cell>();
	static ArrayList <Cell> uv;
	
	
	public static Maze generateMaze(int w, int h){
		width = w;
		height = h;
		maze = new Maze(width, height);
		
		//4. select a random cell to start
		Random r1 = new Random();
		int i = r1.nextInt(width);
		Random r2= new Random();
		int k = r2.nextInt(height);
		 
		//5. call selectNextPath method with the randomly selected cell
		selectNextPath(maze.getCell(i,k));
		return maze;
	}

	//6. Complete the selectNextPathMethod
	private static void selectNextPath(Cell currentCell) {
		//A. mark cell as visited
		currentCell.hasBeenVisited();
		//B. Get an ArrayList of unvisited neighbors using the current cell and the method below
		 uv= getUnvisitedNeighbors(currentCell);
		//C. if has unvisited neighbors,
		if(!currentCell.hasBeenVisited()) {
			//C1. select one at random.
			int random=rand.nextInt(uv.size());
			//C2. push it to the stack
			uncheckedCells.push(uv.get(random));
			//C3. remove the wall between the two cells
			removeWalls(currentCell,uv.get(random));
			//C4. make the new cell the current cell and mark it as visited
			currentCell=uv.get(random);
			currentCell.setBeenVisited(true);
			//C5. call the selectNextPath method with the current cell
			selectNextPath(currentCell);
		}
		//D. if all neighbors are visited
		if(currentCell.hasBeenVisited()) {
			//D1. if the stack is not empty
			if(!uncheckedCells.empty()) {
				// D1a. pop a cell from the stack
				Cell c=uncheckedCells.pop();
				// D1b. make that the current cell
				currentCell=c;
				// D1c. call the selectNextPath method with the current cell
				selectNextPath(currentCell);
			}
		}
	}

	//7. Complete the remove walls method.
	//   This method will check if c1 and c2 are adjacent.
	//   If they are, the walls between them are removed.
	private static void removeWalls(Cell c1, Cell c2) {
		if(c1.getX()-c2.getX()==1) {
			c1.setWestWall(false);
			c2.setEastWall(false);
		}if(c1.getX()-c2.getX()==-1) {
			c1.setEastWall(false);
			c2.setWestWall(false);
		}if(c1.getY()-c2.getY()==1) {
			c1.setNorthWall(false);
			c2.setSouthWall(false);
		}if(c1.getY()-c2.getY()==-1) {
			c1.setSouthWall(false);
			c2.setNorthWall(false);
		}
		}
	
	//8. Complete the getUnvisitedNeighbors method
	//   Any unvisited neighbor of the passed in cell gets added
	//   to the ArrayList
	private static ArrayList<Cell> getUnvisitedNeighbors(Cell c) {
		ArrayList<Cell> un=new ArrayList<Cell>();
		if(c.hasBeenVisited()==false) {
			un.add(c);
		}
		return un;
	}
}
