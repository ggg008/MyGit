package _191118_FileIO;

import java.util.ArrayList;
import java.util.List;

class Element {
	public int r;
	public int c;
	
	public Element(int r, int c)
	{
		this.r = r;
		this.c = c;
	}
	
}


public class MyMazeRunner
{
	private final static int MAX_STACK_SIZE = 100;
	private final static int MAZE_SIZE = 6;
		

	Element here = new Element(1, 0);
	Element entry = new Element(1, 0);
	
	char[][] maze = 
		{
			{'1', '1', '1', '1', '1', '1'},//row
			{'e', '0', '1', '0', '1', '1'},
			{'1', '0', '1', '0', '1', '1'},
			{'1', '0', '1', '0', '0', 'x'},
			{'1', '0', '1', '1', '0', '1'},
			{'1', '0', '1', '1', '0', '1'},
			{'1', '0', '0', '0', '0', '1'},
			{'1', '1', '1', '0', '0', '1'},
			{'1', '1', '1', '1', '0', '1'},
			{'1', '1', '1', '1', '1', '1'},
		};

	List<Element> stackList = new ArrayList<Element>();
	
	void pushLoc(int r, int c) {
		if(r < 0 || c < 0) {
			return;
		}
		
		if(maze[r][c] != '1' && maze[r][c] != '.' ) {
			Element tmp = new Element(r, c);
			
			stackList.add(tmp);
			
		}
		
		
	}
	
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		MyMazeRunner mmr = new MyMazeRunner();
		
		int r, c;
		
		mmr.here = mmr.entry;
		while(mmr.maze[mmr.here.r][mmr.here.c] != 'x') {
			r = mmr.here.r;
			c = mmr.here.c;
			
			mmr.maze[r][c] = '.';
			mmr.pushLoc(r-1, c);
			mmr.pushLoc(r+1, c);
			mmr.pushLoc(r, c-1);
			mmr.pushLoc(r, c+1);
			if(MAX_STACK_SIZE <= mmr.stackList.size()) {
				System.out.println("실패");
				return;
			}
			else {
				
				for(int iR = 0 ; iR < mmr.maze.length; ++iR) {					
					for(int iC = 0; iC < mmr.maze[iR].length; ++iC) {

						switch (mmr.maze[iR][iC]) {
						case '0':
							System.out.print(" □ ");
							break;
						case '1':
							System.out.print(" ■ ");
							break;
						case 'x':
						case 'e':
							System.out.print(" ◎ ");
							break;
						case '.':
							System.out.print(" ⊙ ");
							break;

						default:
							throw new IllegalArgumentException("Unexpected value: " + mmr.maze[iR][iC]);
						}
						
									
					}
					System.out.println();
				}
				
				mmr.here = mmr.stackList.remove(mmr.stackList.size()-1);
				System.out.printf("[ c:%d r:%d ]\n", mmr.here.c, mmr.here.r);
				
			}
			
		}
		System.out.println("성공");
		
		
	}

}