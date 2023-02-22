//ben schwartz
//MineSweeper.java
//yup
//@EvanKoschik

//WHAT I NEED TO FIX
/*
 * I dont care, im not adjusting the frame size
 *get rid of printlns
 */

//package hh;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;
import java.util.Scanner;
//import java.util.Collections;

class MAIN
{
	static Scanner reader = new Scanner(System.in);
	static int startRows = 16;
	static int startCols = 30;
	static int startBombs = -1;
	static String mode = "";
	static String funString = "";
	public static boolean continueGame;
	public static int seconds = 0;
	public static boolean timerGo = true;
	public static boolean specialWin = false;
	static TimerClass timerBoy = new TimerClass();
//@SuppressWarnings("deprecation")
public static void main(String[] args)
{	
	//put here a menu to choose what board size to play
	int choice = -1;
	System.out.println("\n\n**********\nWELCOME TO BEN'S MINESWEEPER GAME!\n**********\n");
	while(choice != 0)
	{	
		//myJPanel.isFirstClicked = true;
		timerGo = true;
		continueGame = true;
		System.out.print("\n 1.  baby (not recommended)"
									   +"\n 2.  okay"
									   +"\n 3.  kind of"
									   +"\n 4.  expert(recommended)"
									   +"\n 5.  Custom"
									   +"\n 6.  I want errors"
									   //0.        +"\n 7.  Check highscores for the run!"
									   +"\n 0.	 Exit \n"
									   +"\nWhat is your selection?   ");
		choice = reader.nextInt();
		if(choice == 1)
			{startRows = 4; startCols = 4; mode = "baby";}
		else if(choice == 2)
			{startRows = 8; startCols = 8; mode = "beginner";}
		else if(choice == 3)
			{startRows = 10; startCols = 10; mode = "medium";}
		else if(choice == 4)
			{startRows = 16; startCols = 30;mode = "expert";}
		else if(choice == 5)
			{System.out.println("ROWS = ");
			startRows = reader.nextInt();
			System.out.println("COLS = ");
			startCols = reader.nextInt();
			System.out.println("BOMBS(-1 if u want average amount) = ");
			startBombs = reader.nextInt();
			mode = "custom";}
		else if(choice == 6)
		{
			try{
			while(true)
			{
				MAIN.mode = null;
				if(MAIN.mode.equals("neesh platter"))
				{
					myJPanel.gameOver();
				}
			}}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		else if(choice == 0)
		{//something else
			System.out.println("BYE");
			System.exit(0);
		}
		System.out.print("\nCONTROLS"
							+ "If you don't know how to play, leave"
							+ "\n 'SHIFT' = reset board"
							+"\n ',' = new game "
							+"\n 'ESC' = exit game"
							+"\n ';' = reset funCount (expert only)"
							+"\n 'frontSlash' = display all bombs"
							+"\n 'backSlash' = go for the win (hint = 10)"
							+"\n go ahead and try typing (expert only)"
							+"\n '.' = reset string (expert only)");
		myJFrame frame = new myJFrame();	
		//frame.show();
		funString = "WELCOME!";
		frame.setVisible(true);
		frame.startGame();
		frame.setVisible(false);

	}
}

}
class myJFrame extends JFrame
{
		private static final long serialVersionUID = 1L;
		myJPanel panel;
		
public myJFrame()
{
	//setSize(new Dimension(600,382));
	setSize(new Dimension((int)(MAIN.startCols*21.667)+50,myJPanel.shift+(int)(MAIN.startRows*23.75)+50));
	//setSize(new Dimension(1000,1000));
	//static Tile[][] = new Tile[MAIN.startRows][MAIN.startCols];
	//KeyListener
	addKeyListener(new KeyList());
	
	//PANELS
	panel = new myJPanel(this);
	Container container = getContentPane();
	container.add(panel);
}

public void startGame()
{
	panel.startGame();
}
private class KeyList implements KeyListener
{
	public void keyPressed(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
			 
			case KeyEvent.VK_ESCAPE: {System.exit(0); break;}
			case KeyEvent.VK_COMMA: {
				if(MAIN.timerBoy.timer != null) {
					MAIN.timerBoy.stopTimer();
					
					System.out.println("new timer created");
					MAIN.seconds = 0;}
					MAIN.continueGame = false;
					myJPanel.firstTimer = true; 
					myJPanel.isFirstClicked = true;
				break;
				}
			case KeyEvent.VK_SHIFT: {myJPanel.resetBoard(); break;}
			case KeyEvent.VK_SEMICOLON: {myJPanel.funCount = 0; break;}
			case KeyEvent.VK_SLASH: {myJPanel.gameOver(); break;}
			case KeyEvent.VK_PERIOD: {MAIN.funString = ""; break;}
			case KeyEvent.VK_BACK_SLASH:
			{
				if(myJPanel.funCount%10 == 0 && myJPanel.funCount!=0) {
					MAIN.specialWin = true; 
					myJPanel.winGame(); }
					break;
			}
			case KeyEvent.VK_A: {MAIN.funString+="A"; break;}
			case KeyEvent.VK_B: {MAIN.funString+="B"; break;}
			case KeyEvent.VK_C: {MAIN.funString+="C"; break;}
			case KeyEvent.VK_D: {MAIN.funString+="D"; break;}
			case KeyEvent.VK_E: {MAIN.funString+="E"; break;}
			case KeyEvent.VK_F: {MAIN.funString+="F"; break;}
			case KeyEvent.VK_G: {MAIN.funString+="G"; break;}
			case KeyEvent.VK_H: {MAIN.funString+="H"; break;}
			case KeyEvent.VK_I: {MAIN.funString+="I"; break;}
			case KeyEvent.VK_J: {MAIN.funString+="J"; break;}
			case KeyEvent.VK_K: {MAIN.funString+="K"; break;}
			case KeyEvent.VK_L: {MAIN.funString+="L"; break;}
			case KeyEvent.VK_M: {MAIN.funString+="M"; break;}
			case KeyEvent.VK_N: {MAIN.funString+="N"; break;}
			case KeyEvent.VK_O: {MAIN.funString+="O"; break;}
			case KeyEvent.VK_P: {MAIN.funString+="P"; break;}
			case KeyEvent.VK_Q: {MAIN.funString+="Q"; break;}
			case KeyEvent.VK_R: {MAIN.funString+="R"; break;}
			case KeyEvent.VK_S: {MAIN.funString+="S"; break;}
			case KeyEvent.VK_T: {MAIN.funString+="T"; break;}
			case KeyEvent.VK_U: {MAIN.funString+="U"; break;}
			case KeyEvent.VK_V: {MAIN.funString+="V"; break;}
			case KeyEvent.VK_W: {MAIN.funString+="W"; break;}
			case KeyEvent.VK_X: {MAIN.funString+="X"; break;}
			case KeyEvent.VK_Y: {MAIN.funString+="Y"; break;}
			case KeyEvent.VK_Z: {MAIN.funString+="Z"; break;}
			case KeyEvent.VK_BACK_SPACE: 
			{
				if(MAIN.funString.length()>0){
					MAIN.funString = MAIN.funString.substring(0,MAIN.funString.length()-1);} break;	
			}
		}
	}
	public void keyReleased(KeyEvent e){}
	public void keyTyped(KeyEvent e){}
}
}
class myJPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	JFrame frame;
	public static boolean graphicsYes = false;
	static Tile[][] board;
	//For eclipse graphics
	String blankTile = "images//blankTile.png";
	String bombTile = "images//bombTile.png";
	String flagTile = "images//flagTile.png";
	String frown = "images//Frown.png";
	String glasses = "images//Glasses1.png";
	String smile = "images//Smile.png";
	//
	static int funCount = 0;
	static boolean firstTimer = true;
	private final static int tileWidth = 20;
	final static int shift = 40; // shift downward
	static int bombs; // how many bombs will be placed
	private static int bombCount;
	static boolean isFirstClicked = true;
	static ArrayList<Tile> tileList = new ArrayList<Tile>();
	private static String buttonState; //what the reset button looks like
	
public myJPanel(JFrame f)
{
	board = new Tile[MAIN.startRows][MAIN.startCols];
	if(MAIN.startBombs == -1)
		bombs = (int)(board.length*board[0].length*0.20417)+1;
	else
		bombs = MAIN.startBombs;
	bombCount = bombs;
	MAIN.timerGo = true;
	//set Background Color
	setBackground(Color.darkGray);
	
	MouseList ML = new MouseList();
	addMouseMotionListener(ML);
	addMouseListener(ML);
	
	frame=f;
	
	buttonState = "smile";
	
	//initializing board with new tile objects with adjusted coordinates
	//int shift = getShift();
	int w = tileWidth;
	for(int i = 0; i < board.length; i++)
		for(int j = 0; j < board[0].length; j++)
			board[i][j] = new Tile(j*w,i*w+shift,w,frame);
	
	//making arraylist of tiles for bombs and other things
	tileList = new ArrayList<Tile>();
	for(Tile[] a: board)
		for(Tile b: a)
			tileList.add(b);
	
	//initializing the tiles with bombs for however many bombs there should be
	int count = bombs;
	while(count > 0 && count < board.length*board[0].length)
	{
		int num = (int)(Math.random()*tileList.size());
		Tile bombedTile = tileList.get(num);
		if(!bombedTile.hasBomb)
		{
			bombedTile.setBombed(true);
			count--;
		}
	}
	
	//initialize tiles with numbers
	for(int i = 0; i < board.length; i++)
		for(int j = 0; j < board[0].length; j++) {
			board[i][j].setNumber(getTileNum(i,j));
		}
}
public static void startGameTimer()
{
	//right here just maybe make the new timer object here so it dont happen
	MAIN.timerBoy = new TimerClass();
	System.out.println(myJPanel.firstTimer);
	if(myJPanel.firstTimer)
	{
	System.out.println("timer started");
	MAIN.timerBoy.runTimer();}
	firstTimer = false;
	
}
public void paintComponent(Graphics g)	//this needs to be called this
{
	//idk what this does
	super.paintComponent(g);
	
	//draws the board
	for(int i = 0; i < board.length; i++)
		for(int j = 0; j < board[0].length; j++)
			{
				if(graphicsYes)
					setTileImage(board[i][j], g);
				board[i][j].draw(g);
			}
	
	//draws menu bar
	g.setColor(Color.gray);
	g.fillRect(0,0,tileWidth*board[0].length,shift);
	
	//checks form game over
	if(winGame())
	{
		MAIN.funString = "YOU WIN!";
		buttonState = "win";
		/*g.setColor(Color.pink);
		g.fillRect(0,shift,board[0].length*tileWidth,board.length*tileWidth);
		g.setFont(new Font("Times New Roman", 1, tileWidth));
		g.setColor(Color.black);
		g.drawString("You WON", 10, shift/2+((int)(board.length/2.0*tileWidth)));*/
	}
	//paints button
	setButton(buttonState, g);
	//reset too long of string
	if(MAIN.funString.length() > 19)
		MAIN.funString = "";
	//will print stuff
		if(MAIN.mode.equals("expert")) {
		g.setColor(Color.black);
		g.setFont(new Font("ZapfDingbats", 1, 20));
		g.drawString(MAIN.funString, 65, 25);}
		
	
		//draws funccountBOX
		if(MAIN.startRows > 8 && MAIN.startCols > 8) {
		g.setFont(new Font("Courier New", 1, 15));
		g.setColor(Color.white);
		g.drawString(""+funCount, (int)(tileWidth*board[0].length/2+(.1867*board[0].length*tileWidth)), 25);}
	
		//restart game/smile box
		g.setColor(Color.black);
		g.drawRect(tileWidth*board[0].length/2-1, 5, (int)(shift*0.75), (int)(shift*0.75));
		//draws bombcount box
		g.drawRect(10, 5, (int)(shift*0.75), (int)(shift*0.75));
		g.setFont(new Font("Courier New", 1, 20));
		g.drawString(""+bombCount, 6+(int)(shift*0.26), (int)(shift*0.625));
		//draws timer
		g.setColor(Color.white);
		g.fillRect(board[0].length*tileWidth-(int)(shift*0.75)-16, 5, shift, (int)(shift*0.75));
		g.setFont(new Font("Courier New", 1, 20));
		g.setColor(Color.black);
		g.drawString(""+MAIN.seconds, board[0].length*tileWidth-(int)(shift*0.75)-14, (int)(shift*0.625));
		//g.drawRect(tileWidth*board[0].length/2-1, 5, 30, 30);
}
public static void resetBoard()
{//resets everything that was done in constructor
	MAIN.timerGo = true;
	myJPanel.funCount = 0;
	MAIN.specialWin = false;
	if(MAIN.timerBoy.timer != null) {
		MAIN.timerBoy.timer.cancel();
		MAIN.timerBoy = new TimerClass();
		MAIN.seconds = 0;}
	
	MAIN.funString = "BOARD RESET";
	bombCount = bombs;
	firstTimer = true;
	isFirstClicked = true;
	buttonState = "smile";
	for(int i = 0; i < board.length; i++)
		for(int j = 0; j < board[0].length; j++)
		{
			board[i][j].setFlagged(false);
			board[i][j].setClicked(false);
			board[i][j].setBombed(false);
		}

	int count = bombs;
	while(count > 0)
	{
		int num = (int)(Math.random()*tileList.size());
		Tile bombedTile = tileList.get(num);
		if(!bombedTile.hasBomb)
		{
			bombedTile.setBombed(true);
			count--;
		}
	}
	for(int i = 0; i < board.length; i++)
		for(int j = 0; j < board[0].length; j++) {
			board[i][j].setNumber(getTileNum(i,j));
		}
	isFirstClicked = true;	
}
public static int getTileNum(int row, int col)
{//will return what the number should be for a specific tile
	int count = 0;
	if(board[row][col].hasBomb) 
		return -1;
	ArrayList<Tile> adjacentTileList = getAdjacentTiles(row,col);
	for(Tile t: adjacentTileList)
	{
		if(adjacentTileList.size() > 0)
			if(t.hasBomb)
				count++;
	}
	return count;
}
public static boolean isValid(int row, int col)
{
	return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
}
public Tile getTile(int x, int y)
{//easy
	for(Tile[] row : board)
		for(Tile t : row)
			if(t.isInTile(x,y))
				return t;
	return null;
}
public static boolean winGame()
{	//for when wingame, this was harder because its constantly called by paintcomponent
	//i didnt have time to figure out how to not make this happen
	if(MAIN.specialWin){
		if(MAIN.timerBoy.timer != null && MAIN.timerGo)
			MAIN.timerBoy.stopTimer();
		MAIN.seconds = -69;
		MAIN.timerGo = false;
		return true;
	}	
	for(Tile t: tileList)
	{//the return here is VERY useful for efficiency
		if(!t.hasBomb && !t.hasBeenClicked) 
			return false;
	}
	if(MAIN.timerBoy.timer != null)
		MAIN.timerBoy.stopTimer();
	//add highscore array here
	return true;

}


public static void gameOver()
{	//when game over fust happen
	if(MAIN.timerBoy.timer != null) {
		MAIN.timerBoy.stopTimer();
	}
	MAIN.funString = "YOU LOSE!";
	buttonState = "frown";
	for(Tile t: tileList)
	{//so that they all show up
		if(t.hasBomb)
			t.setClicked(true);
	}
}
public void setButton(String s, Graphics g)
{
		ImageIcon imageIcon;
		//BufferedImage img = null;
		if(s.equals("smile"))
		{
			/*ImageIcon n = new ImageIcon(smile);
			Image img = n.getImage();
			Image newimg = img.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH);
			ImageIcon i = new ImageIcon(newimg);
			i.paintIcon(this, g, tileWidth*board[0].length/2-1, 5);*/
			
			
			imageIcon = new ImageIcon("Smile.png");
			g.drawImage(imageIcon.getImage(), tileWidth*board[0].length/2-1, 5, 30,30, frame);
	
		}
		else if(s.equals("frown"))
		{
			
			/*ImageIcon n = new ImageIcon(frown);
			Image img = n.getImage();
			Image newimg = img.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH);
			ImageIcon i = new ImageIcon(newimg);
			i.paintIcon(this, g, tileWidth*board[0].length/2-1, 5);*/
			
			imageIcon = new ImageIcon("Frown.png");
			g.drawImage(imageIcon.getImage(), tileWidth*board[0].length/2-1, 5, 30,30, frame);
		}
		else if(s.equals("win"))
		{
			/*ImageIcon n = new ImageIcon(glasses);
			Image img = n.getImage();
			Image newimg = img.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH);
			ImageIcon i = new ImageIcon(newimg);
			i.paintIcon(this, g, tileWidth*board[0].length/2-1, 5);*/
			
			imageIcon = new ImageIcon("Glasses1.png");
			g.drawImage(imageIcon.getImage(),tileWidth*board[0].length/2-1, 5,(int)(shift*0.75),(int)(shift*0.75), frame);
		}
}
public void setTileImage(Tile t, Graphics g)
{
	ImageIcon imageIcon;
	if(t.isFlagged && !t.hasBeenClicked)
	{
		if(graphicsYes) {
		/*ImageIcon n = new ImageIcon(flagTile);
		Image img = n.getImage();
		Image newimg = img.getScaledInstance(t.width, t.width,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon i = new ImageIcon(newimg);
		i.paintIcon(this, g, t.x, (int)t.y);*/
		
		imageIcon = new ImageIcon("flagTile.png");
		g.drawImage(imageIcon.getImage(),t.x, (int)t.y, t.width, t.width, frame);
		}
	}
	else if(t.hasBeenClicked && t.hasBomb)
	{
		if(graphicsYes) {
		/*ImageIcon n = new ImageIcon(bombTile);
		Image img = n.getImage();
		Image newimg = img.getScaledInstance(t.width, t.width,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon i = new ImageIcon(newimg);
		i.paintIcon(this, g, t.x, (int)t.y);*/
		
		imageIcon = new ImageIcon("bombTile.png");
		g.drawImage(imageIcon.getImage(),t.x, (int)t.y, t.width, t.width, frame);
		}
	}
	else if(!t.hasBeenClicked)
	{
		if(graphicsYes) {
		/*ImageIcon n = new ImageIcon(blankTile);
		Image img = n.getImage();
		Image newimg = img.getScaledInstance(t.width, t.width,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon i = new ImageIcon(newimg);
		i.paintIcon(this, g, t.x, (int)t.y);*/
		
		imageIcon = new ImageIcon("blankTile.png");
		g.drawImage(imageIcon.getImage(),t.x, (int)t.y, t.width, t.width, frame);
		}
	}
}
public boolean isInButton(int x1, int y1)
{//for when button is clicked
	int x = tileWidth*board[0].length/2-1;
	int y = 5;
	int width = 30;
	return (x1 >= x && x1 <= x+width) && (y1 >= y && y1 <= y+width);
}
public void startGame()
{	//so that i can make a new board
	while(MAIN.continueGame)
	{
		repaint();
		//it was there and i dont know if i need it but it works so im keeping it
		try{Thread.sleep(1);}
		catch(Exception e){}
	}
}
public static ArrayList<Tile> getAdjacentTiles(int row, int col)
{ // this was very helpful
	ArrayList<Tile> adjacentTileList = new ArrayList<Tile>();
	int tempRow = row, tempCol = col;
	
	tempRow = row-1;
	tempCol = col-1;
	if(isValid(tempRow, tempCol))
			adjacentTileList.add(board[tempRow][tempCol]);
	tempRow = row-1;
	tempCol = col;
	if(isValid(tempRow, tempCol))
			adjacentTileList.add(board[tempRow][tempCol]);;
	tempRow = row-1;
	tempCol = col+1;
	if(isValid(tempRow, tempCol))
			adjacentTileList.add(board[tempRow][tempCol]);
	tempRow = row;
	tempCol = col-1;
	if(isValid(tempRow, tempCol))
			adjacentTileList.add(board[tempRow][tempCol]);
	tempRow = row;
	tempCol = col+1;
	if(isValid(tempRow, tempCol))
			adjacentTileList.add(board[tempRow][tempCol]);
	tempRow = row+1;
	tempCol = col-1;
	if(isValid(tempRow, tempCol))
			adjacentTileList.add(board[tempRow][tempCol]);
	tempRow = row+1;
	tempCol = col;
	if(isValid(tempRow, tempCol))
			adjacentTileList.add(board[tempRow][tempCol]);
	tempRow = row+1;
	tempCol = col+1;
	if(isValid(tempRow, tempCol))
			adjacentTileList.add(board[tempRow][tempCol]);
	return adjacentTileList;
}
private void uncover(Tile t)
{//for when a clicked tile is blank
	MAIN.funString  = "LUCKY BOY";
	TileCoordinate coordinates = new TileCoordinate(t);
	ArrayList<Tile> adjTiles = getAdjacentTiles(coordinates.row,coordinates.col);
	ArrayList<Tile> goodTiles = new ArrayList<Tile>();
	for(Tile tile: adjTiles)
	{
		if(!tile.hasBomb && !tile.isFlagged && !tile.hasBeenClicked)
		{
			goodTiles.add(tile);
		}
	}
	//goodTiles will contain all of the tiles to be uncovered
	if(goodTiles.size() == 0)
		return;
	for(Tile tile: goodTiles)
	{//will recursively call this until there are no tiles left  to be uncovered
		tile.setClicked(true);
		if(tile.number == 0)
			uncover(tile);
	}
}
public void isFirstClick(Tile tile)
{//because you cant lose on the first click, i need this
		MAIN.funString  = ";)";
		while(true)
		{//will keep going unti it finds a place to put a bomb
			int num = (int)(Math.random()*tileList.size());
			Tile bombedTile = tileList.get(num);
			if(!bombedTile.hasBomb && bombedTile != tile)
			{
				bombedTile.setBombed(true);
				break;
			}
		}
		//takes bomb off first tile then sets numbers again
		tile.setBombed(false);
		for(int i = 0; i < board.length; i++)
			for(int j = 0; j < board[0].length; j++)
				board[i][j].setNumber(getTileNum(i,j));	
}
private class MouseList implements MouseMotionListener, MouseListener
{
	public void mouseClicked(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mouseDragged(MouseEvent e){}
	public void mousePressed(MouseEvent e){}//ill explain later
	public void mouseMoved(MouseEvent e) {funCount++;if(funCount%10 == 9 && funCount > 10)funCount++;}
	public void mouseReleased(MouseEvent e)
		{
			//if reset button is clicked
			if(isInButton(e.getX(), e.getY()))
				resetBoard();
			//nothing should happen if game is over and not reset
			if(buttonState.equals("frown") || buttonState.equals("win")) 
				return;
			//gets the clicked tile
			Tile clickedTile = getTile(e.getX(), e.getY());
			//if something else was clicked
			if(clickedTile == null) 
				return;
			//will set tile as flagged for a right click
			if(clickedTile.hasBomb && e.getButton() != MouseEvent.BUTTON3)
			{//needs to go before for if you click a flagged tile
				if(isFirstClicked)
					isFirstClick(clickedTile);
				else {
					gameOver();
					MAIN.funString  = "YOU LOSE!";
				}
			}
			if (e.getButton() == MouseEvent.BUTTON3)
			{//for a right click, will flag tiles and adjust bomb count
				if(clickedTile.isFlagged) {
					MAIN.funString  = "UNFLAGGED!";
					clickedTile.setFlagged(false);
					bombCount++;}
				else{
					if(clickedTile.hasBomb)
						MAIN.funString  = "FLAGGED!";
					else
						MAIN.funString  = "FLAGGED¡";
					clickedTile.setFlagged(true);
					bombCount--;}
				return;
			}
			else if(clickedTile.number == 0 && !clickedTile.hasBeenClicked)
				uncover(clickedTile);
			else if(clickedTile.isFlagged)
				bombCount++;
			if(isFirstClicked)
			{//starts game timer
				myJPanel.startGameTimer();
			}
			//will uncover the specific tile
			if(!clickedTile.hasBomb && clickedTile.number > 0 && !clickedTile.hasBeenClicked)
				MAIN.funString  = "smart decision";
			clickedTile.setClicked(true);
			isFirstClicked = false;
			repaint();
		}

}
private class Tile
{//each tile has many of its own properties
	private int x;
	private double y;
	private int width;
	private boolean isFlagged;
	private boolean hasBeenClicked;
	private boolean hasBomb;
	private int number;

	public Tile(int x1, int y1, int width1, JFrame f)
	{
		x = x1;
		y = y1;
		width = width1;
		isFlagged = false;
		hasBeenClicked = false;
		hasBomb = false;
	}
	public boolean isInTile(int x1, int y1)
	{
		return (x1 >= x && x1 <= x+width) && (y1 >= y && y1 <= y+width);
	}
	public void draw(Graphics g)
	{//where all the printing and filling is done, less is done when graphics is on
		if(hasBeenClicked && !hasBomb)
		{
			if(!graphicsYes)
			{
				g.setColor(Color.gray);
				g.fillRect(x,(int)y,width,width);
			}
			g.setColor(Color.lightGray);
			g.fillRect(x,(int)y,width,width);
			Font f1= new Font("Dialog" ,Font.BOLD,15);
			g.setFont(f1);
			if(number > 0)
			{
				if(number == 1)
					g.setColor(Color.blue);
				else if(number == 2)
					g.setColor(new Color(0,100,0));
				else if(number == 3)
					g.setColor(Color.red);
				else
					g.setColor(Color.MAGENTA);
				g.drawString(""+number, x+width/4, (int)y-width/4+width);
			}
			g.setColor(Color.gray);
			g.drawRect(x,(int)y,width,width);
			g.setColor(Color.black);
			
		}
		else if(hasBeenClicked && hasBomb)
		{
			if(!graphicsYes)
			{
				g.setColor(Color.RED);
				g.fillRect(x,(int)y,width,width);
				
				g.drawRect(x,(int)y,width,width);
				g.setFont(new Font("Times New Roman", 1, 15));
				g.drawString("B", x, (int)y-1+width);
			}
		}
		else if(isFlagged)
		{
			if(!graphicsYes)
			{
				g.setColor(Color.green);
				g.fillRect(x,(int)y,width,width);
				g.setColor(Color.black);
				g.drawRect(x,(int)y,width,width);
				g.setFont(new Font("Times New Roman", 1, 15));
				g.drawString("ff", x, (int)y-1+width);
			}
		}
		else
		{
			if(!graphicsYes)
			{
				g.setColor(Color.cyan);
				g.fillRect(x,(int)y,width,width);
				g.setColor(Color.black);
				g.drawRect(x,(int)y,width,width);
			}
		}	
	}
	//mutators
	public void setFlagged(boolean a){isFlagged = a;}
	public void setNumber(int a){number = a;}
	public void setBombed(boolean a){hasBomb = a;}
	public void setClicked(boolean a){hasBeenClicked = a;}
}
private class TileCoordinate
{//this is to easily get the index coordinates on board of a given tile
	public int row, col;
	public TileCoordinate(Tile t)
	{
		row = -1;
		col = -1;
		for(int i = 0; i < board.length; i++)
			for(int j = 0; j < board[0].length; j++)
				if(board[i][j] == t) 
				{
					row = i;
					col = j;
					return;
				}
	}
	public String toString()
	{
		return "{row = "+row+", col = "+col+"}";
	}
}

}