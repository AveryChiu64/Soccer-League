/*=================================================================
Program name - Coin
Author - Avery Chiu 
Date - 2018/10/20
Programming Language, version number - Java 9
=================================================================
	Problem Definition – Alice and Bob are playing a coin game, the player
that gets the last coin is the winner. On their turns, they can pick 1,2
or 4 coins. The program finds the winner of the coin game and the number
of strategies he/she can use to win the game.
	Input – The number of coins and the order of players (Alice or Bob).
	Output – The winner and the number of strategies to win.
	Process – Finds the winner by checking if the number of coins is divisible by 3,
		if so that means the 2nd player will win. Finds the different number of
		ways to win by going through each winning strategy and counting them.
=================================================================
 */
import java.io.*;
public class Coin {//Beginning of class Coin
	/**main method:
	 * This procedural method is called automatically and is used to organize the calling 
	 * of other methods defined in the class
	 *
	 * -----------------------------List of Local Variables------------------------
	 * co-object used to access methods in the Coin class <type Coin>
	 * cn-object used to access methods in the CoinNum class<type CoinNum>
	 * @param args <type String>
	 * @throws IO Exception
	 * @return void
	 */
	public static void main(String [] args) throws IOException {//Beginning of main method

		//System objects
		Coin co=new Coin();
		CoinNum cn= new Coin().new CoinNum();

		//Method calls
		co.menu();
		co.inputCoins(cn);
		co.output(cn, co);
	}//End of main method

	/**
	 * menu method: This procedural method outputs the menu which
	 * provides details for the user regarding the program.
	 * 
	 * @param  None
	 * @throws None
	 * @return void
	 */
	public void menu() {//Beginning of menu method
		System.out.println("		COIN GAME			");
		System.out.println("=============================================================");
		System.out.println("Alice and Bob are playing a coin game.");
		System.out.println("The player picks out 1,2 or 4 coins on their turn.");
		System.out.println("The player that gets the last coin wins.");
		System.out.println("Both characters will try their best to win and are smart.");
		System.out.println("You will enter the number of coins that they");
		System.out.println("have and decide who goes first.");
		System.out.println("The program will output the winner of the game and the.");
		System.out.println("number of strategies there are for them to win the game.");
		System.out.println("=============================================================");
	}//End of menu method


	/**
	 * inputCoins method: This procedural method accepts the
	 *  number of coins entered by the user 
	 *
	 * -----------------------------List of Local Variables------------------------
	 * br - an object used to read input from a file <type BufferedReader>.
	 * @param  cn- object used to access methods in the CoinNum class <type CoinNum>
	 * @throws IOException
	 * @return void
	 */
	public void inputCoins(CoinNum cn) throws IOException {//Beginning of inputCoins method
		//System Objects
		BufferedReader br=new BufferedReader (new InputStreamReader(System.in));

		System.out.println("Please enter the number of coins you want in the game.");
		cn.setCoins(Integer.parseInt(br.readLine()));
	}//End of inputCoins method
	
	/**
	 * output method: This procedural method outputs the results of the match and the
	 * number of ways to win
	 * 
	 * @param  cn-object used to access methods in the CoinNum class <type CoinNum>
	 * 		   co-object used to access methods in the Coin class <type Coin>
	 * @throws IOException
	 * @return void
	 */
	public void output(CoinNum cn,Coin co) throws IOException{//Beginning of output method
		if(co.aliceOrBob()==co.winner(cn))

			System.out.println("Alice is the winner");
		else
			System.out.println("Bob is the winner.");

		System.out.println("There were "+ cn.getCoins()+" coins in the game.");
		System.out.println("There are "+ co.strategies(cn.getCoins())+" ways to win.");
	}//End of output method
	
	/**
	 * aliceOrBob method: A functional method that sees whether 
	 * the user wants Alice or Bob to go first
	 *
	 * -----------------------------List of Local Variables------------------------
	 * br - an object used to read input from a file <type BufferedReader>.
	 * @param  None
	 * @throws IOException
	 * @return true(if Alice goes first) or false(if Bob goes first) <type boolean>
	 */
	public boolean aliceOrBob() throws IOException {//Beginning of aliceOrBob method
		//System Objects
		BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
		System.out.println("1. Enter 1 to let Alice go first");
		System.out.println("2. Enter 2 to let Bob go first");
		return (Integer.parseInt(br.readLine())==1);
	}//End of aliceOrBob method

	/**
	 * winner method: A functional method that finds out who will win

	 * @param  cn-object used to access methods in the CoinNum class <type CoinNum>
	 * @throws None
	 * @return will return true if player 1 wins, will return false 
	 * if player 2 wins <type boolean>
	 */
	public boolean winner(CoinNum cn){//Beginning of winner method
		return (cn.getCoins()%3!=0);

	}//End of winner method

	/**
	 * strategies: A functional method that finds the number 
	 * of ways a player can win through recursion

	 * @param  coins- The number of coins <type int>
	 * @throws None
	 * @return Will return the number of ways a player can win <type int>
	 */
	public int strategies(int coins) {//Beginning of strategies method
		if(coins==1)
			return 1;
		if(coins>1&&coins<5)
			return coins-1;
		if(coins%3==0)
			return strategies(coins-1) + strategies(coins-2) + strategies(coins-4);
		else if((coins-1)%3==0&&(coins-4)%3==0)
			return strategies(coins-1) + strategies(coins-4);
		return strategies(coins-(coins%3));
	}//End of strategies method

	class CoinNum {// Declare class CoinNum with private numOfCoins and accessor methods
		//Class Variables
		private int numOfCoins;
		/**
		 * CoinNum() method: Default constructor for the class CoinNum
		 *
		 * -----------------------------List of Local Variables------------------------
		 * numOfCoins - the number of coins (type int)
		 * @param  None
		 * @throws None
		 * @return void
		 */
		public CoinNum() { //Beginning of CoinNum method
			numOfCoins = 1;
		}//End of CoinNum method

		/**
		 * CoinNum() method: Sets numOfCoins equal to a certain number of coins
		 *
		 * -----------------------------List of Local Variables------------------------
		 * numOfCoins - the number of coins (type int)
		 * @param  n - a certain number of coins (type int)
		 * @throws None
		 * @return void
		 */
		public CoinNum(int n) {//Beginning of CoinNum method
			numOfCoins = n;
		}//End of CoinNum method

		/**
		 * getCoins() method: Getter(accessor) method for numOfCoins
		 *
		 * @param  None
		 * @throws None
		 * @return numOfCoins- the number of coins (type int)
		 */
		public int getCoins() {//Beginning of getCoins method
			return numOfCoins;
		}//End of getCoins method
		/**
		 * setCoins() method: Setter (mutator) method for 
		 * the # of coins
		 *
		 * -----------------------------List of Local Variables------------------------
		 * numOfCoins - the number of coins (type int)
		 * @param  newNumOfCoins - the new number of coins (type int)
		 * @throws None
		 * @return void
		 */
		public void setCoins(int newNumOfCoins) {//Beginning of setCoins method
			numOfCoins = newNumOfCoins;
		}//End of setCoin method

	}//End of class CoinNum

}//End of class Coin
