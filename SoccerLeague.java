
﻿//==============================================================================
// Program name - SoccerLeague
// Author - Avery Chiu
// Date - 2018/04/15
// Programming Language, version number - Java 9
// ==============================================================================
//Definition:The program accepts user input of the results of a soccer game
// and stores it in another file. The program processes the information to be stored.
//Input: The user inputs results of the game in the form 
// <teamcode1><teamscore1><teamcode2><teamscore2> eg B3D2 means that Team B
// scored 3 points while Team D scored 2 points in a match
//Output: Sorted results in a chart.
//Process: The program will check the user input and divide the String into several parts
//	to make sure that the user has entered proper input. It will then store the results and
// 	sort them. Once this is done it will display the sorted results.
//==============================================================================

/**main method:
 * This procedural method is called automatically and is used to organize the calling of other methods defined in the class
 *
 * -----------------------------List of Local Variables------------------------
 * results -an array that stores the information of the results of the matches (type int[][]).
 * organizedResults - an array that has the organized information of the results of the matches (type int[][]).
 * fileName - the name of the file that the results come from (type String).
 * sl - object used to access methods in the SoccerLeague class(type SoccerLeague).
 * averageGoals - The average number of goals (type int).
 * mostFrequentGoals -The most frequent goals per game (type int[])
 * 
 *
 * @param args;type String;
 * @throws IO Exception
 * @return void
 */
import java.io.*;//Imports the io library.
import java.util.*;//Imports the util library

public class SoccerLeague {// Start of class SoccerLeague.
	public static void main(String[] args) throws IOException {// Beginning of main method

		// Variables
		int[][] results=new int[48][4];
		String fileName;
		int [][] organizedResults=new int[8][8];
		int [] mostFrequentGoals=new int[48];
		int averageGoals;

		/*The organizedResults 2D integer array is formated to match the chart.
		 * Column 1 stores the team names (in order from A to H)
		 * Each row represents a team name (from A to H)
		 * Column 2 stores the number of games played.
		 * Column 3 stores the number of wins each team has.
		 * Column 4 stores the number of ties each team has.
		 * Column 5 stores the number of losses each team has.
		 * Column 6 stores the number of goals for each team has.
		 * Column 7 stores the number of goals against each team has.
		 * Column 8 stores the number of points each team gets
		 * Note: A team gets two points for a win, one point for a tie, 
		 * and no points for a loss.
		 */

		// System objects
		SoccerLeague sl = new SoccerLeague();

		//Details for the user
		System.out.println("		SOCCER LEAGUE SCORING PROGRAM");
		System.out.println("=============================================================");
		System.out.println("This program keeps track of team standings in a soccer league.");
		System.out.println("The teams are A,B,C,D,E,F,G and H.");
		System.out.println("When all the results have been submitted a table will be created.");
		System.out.println("to show each team's standings.");
		System.out.println("The headings for the table are");
		System.out.println("=============================================================");
		System.out.println("Team\tGames\t\t\t\tGoals\tGoals\tPoints");
		System.out.println("Name\tPlayed \tWins\tTies\tLosses\tFor\tAgainst  ");
		System.out.println("=============================================================");
		System.out.println("They will be ordered from highest to lowest based off of the numbers of points.");
		System.out.println("If teams have the same number of points,");
		System.out.println("they will be ordered based off of their goal difference");
		System.out.println("(Goals For-Goal Against=Goal Difference).");
		System.out.println("There is a maximum of 48 games.");
		System.out.println("A team gets two points for a win, one point for a tie,");
		System.out.println("but no points for a loss.");
		System.out.println("=============================================================");

		// Method Calls
		fileName = sl.nameOfTheFile();// Calls upon the nameOfTheFile method to accept a file name.
		results = sl.inputResults(fileName);// Calls upon the inputResults method to read the file
		// and store results.
		averageGoals=sl.averageGoals(results);//Calls upon the averageGoals method to find the average
		//number of goals scored per game.
		mostFrequentGoals=sl.mostFrequentGoal(results);//Calls upon the mostFrequentGoals
		//method to find the most frequent occurrence of goals per game.
		organizedResults = sl.storedResultsForGraph(results);
		// Calls upon the storedResultsForGraph method to accumulate all the results
		// from the user input
		organizedResults = sl.sortResults(organizedResults);
		// Calls upon the sortResults method to sort all the accumulated results
		sl.displayResults(organizedResults,averageGoals,mostFrequentGoals);
		// Calls upon the displayResults method to display the results
		sl.outputResultsToAFile(organizedResults,averageGoals,mostFrequentGoals);
		// Calls upon the outputResultsToAFile method to write the results to a file
	}// end of main method
	/**
	 * nameOfTheFile Method: This functional method gets the name the file
	 * that stores the results
	 *
	 * -----------------------------List of Local Variables------------------------
	 * fileName - The name of the file that stores the results (type String).
	 * in - an object used to get user input(type BufferedReader).
	 * br - an object used to read input from a file(type BufferedReader).
	 * 
	 * @param  None
	 * @throws IOException
	 * @return fileName-The name of the file that stores the results(type String).
	 */

	String nameOfTheFile() throws IOException {//Beginning of method nameOfTheFile 

		//System objects
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));

		//Variables
		String fileName="h://data.txt";

		//Prompts the user to enter a result 
		System.out.println("=============================================================");
		System.out.println("Please enter the results of the games in a file.");
		System.out.println("Each entry should be in the form");
		System.out.println("<teamcode1><teamscore1><teamcode2><teamscore2>");
		System.out.println("After you have printed one score out, move to the next line.");
		System.out.println("=============================================================");
		System.out.println("                        EXAMPLE                              ");
		System.out.println("B3D2");
		System.out.println("A300C500");
		System.out.println("H250D300");
		System.out.println("=============================================================");
		System.out.println("Please enter the directory of the file.");
		System.out.println("eg. h://data.txt");
		System.out.println("NOTE: Improper input within the file will be ommited.");
		System.out.println("=============================================================");


		while(true) {//Beginning of while loop.
			try{//Beginning of the try and catch. 
				fileName=in.readLine();//Accepts a file name. 
				BufferedReader br = new BufferedReader (new FileReader(fileName));
				//Reads the file that the user entered.
				br.close();//closes the file 
				break;//Breaks out of the loop if there is proper input.
			} //End of try.
			catch(Exception e) {//Catches any exceptions if the file
				//cannot be read.

				//Prompts the user to enter a proper file name.
				System.out.println("Unable to open file '" +fileName + "'");           
				System.out.println("Please enter a proper directory of the file.");
			}//End of catch.
		}//End of while loop.

		return fileName;
		//Returns the file name to the main method.
	}//End of method nameOfTheFile.


	/**
	 * inputResults Method: This functional methods finds the results of a match
	 * from user input. 
	 * 
	 *-----------------------------List of Local Variables------------------------
	 * input – used to accept results from a match (type String)
	 * teamOneScoreLine- the score of the first team (type String)
	 * teamTwoScoreLine - the score of the second team (type String)
	 * posistionOfTeamTwo - the index value of the character of
	 * 						 the second team in the user input(type int)
	 * teamOneScore - the score of team one(type int)
	 * teamTwoScore - the score of team two(type int)
	 * teamOne - the name of team one (type char)
	 * teamTwo - the name of team two(type char)
	 * firstCharacter - the first character of the user input (type char)
	 * results -a 2D array that stores the information of the results of the matches  (type int[][])
	 * br – object used to read input from a file (type BufferedReader)
	 * sl - object used to access methods in the SoccerLeague class(type SoccerLeague)
	 * count- counts the number of games that have been played 
	 * @param fileName - the name of the file to be opened(type String)
	 * @throws IO Exception
	 * @return the results from a match (type int[][])
	 */

	int[][] inputResults(String fileName) throws IOException {// Start of inputResults method.

		// System Objects
		BufferedReader br = new BufferedReader (new FileReader(fileName));
		SoccerLeague sl = new SoccerLeague();

		// Variables
		String input="a" ,teamOneScoreLine, teamTwoScoreLine;
		char teamOne='a', teamTwo='a',firstCharacter;
		int positionOfTeamTwo=0,teamOneScore,teamTwoScore,count=0;
		int [][] results=new int[48][4];

		//Tells the user the file is being processed.
		System.out.println("The file is being read...");

		while (input!=null||count==48) {// Loop to check to make sure the user enters proper input
			//that will exit out when the file ends or when 48 games have been played.

			try {// Beginning of try catch.
				input = br.readLine();// Accepts user input.

				if (input==null||count==48) //Checks if the file ends or if 48 games have been played.
					break;//Breaks out of the loop to return to the main method.


				firstCharacter= input.charAt(0);// Gets the first value of the String input.

				teamOne = sl.teamOneCheck(firstCharacter);//Calls upon the teamOneCheck method.
				teamTwo = sl.teamTwoCheck(input);//Calls upon the teamTwoCheck method.

				positionOfTeamTwo=input.indexOf((int) teamTwo, 1);
				//Finds the index value of the second team.
				if(positionOfTeamTwo==-1)//If the second team cannot be found in as an 
					//upper case letter, the lower case letter will be checked.
					positionOfTeamTwo=input.indexOf((int) Character.toLowerCase(teamTwo), 1);
				//Finds the index value of the second team.

				//Gets the score of the first team and turns it into an integer.
				teamOneScoreLine=input.substring(1,positionOfTeamTwo);
				teamOneScore=Integer.parseInt(teamOneScoreLine);

				//Gets the score of the second team and turns it into an integer.
				teamTwoScoreLine=input.substring(positionOfTeamTwo+1);
				teamTwoScore=Integer.parseInt(teamTwoScoreLine);


				if (teamOne != 'z'&& teamTwo!='z'&&teamOne!=teamTwo
						&&teamOneScore >= teamTwoScore) {
					// Checks if the user has entered a proper input and if the winning team
					// was entered into the first index of the input.
					//If the scores are tied it does not matter where they are stored.

					results[count][0]=teamOne;//Stores the winning team name into
					//the first column of the "count" row.

					results[count][1]=teamOneScore;//Stores the winning team score into the
					//second column of the "count" row.

					results[count][2]=teamTwo;//Stores the teamTwo name into
					//the third column of the "count" row.

					results[count][3]=teamTwoScore;//Stores the losing team score into
					//the fourth column of the "count" row.

					count++;//Adds one to count to indicate that there is another line of results.
				}//End of if statement.

				else if (teamOne != 'z'&& teamTwo!='z'&&teamOne!=teamTwo
						&&teamOneScore < teamTwoScore) {
					// Checks if the user has entered a proper input and if the losing team
					// was entered into the first index of the input.

					results[count][0]=teamTwo;//Stores the winning team name into
					//the first column of the "count" row.

					results[count][1]=teamTwoScore;//Stores the winning team score into the
					//second column of the "count" row.

					results[count][2]=teamOne;//Stores the losing team name into
					//the third column of the "count" row.

					results[count][3]=teamOneScore;//Stores the losing team name into
					//the fourth column of the "count" row.

					count++;//Adds one to count to indicate that there is another line of results.
				}//End of if statement.

				else {// If the user does not enter proper input he will be prompted to
					// enter proper input.

					// Prompts the user to enter proper input.
					System.out.println("=============================================================");
					System.out.println("The input "+input+" is invalid");
					System.out.println("Make sure it is formatted properly and that there are no extra spaces");
					System.out.println("This will not be entered into the chart");
					System.out.println("=============================================================");
				}//end of else to tell user which input is invalid 

			} catch (Exception e) {// Catches any exceptions if the user tries to crash the program.

				// Prompts the user to enter proper input.
				System.out.println("=============================================================");
				System.out.println("The input "+input+" is invalid");
				System.out.println("Make sure it is formatted properly and that there are no extra spaces");
				System.out.println("This will not be entered into the chart");
				System.out.println("=============================================================");
			}//end of catch
		}//end of while loop
		br.close();//closes the file 
		return results;// Returns the user input to the main method
	}// end of inputResults method


	/**
	 * teamOneCheck Method: This functional method checks if the user has
	 * entered a proper name for the first team
	 *
	 * -----------------------------List of Local Variables------------------------
	 * check- A variable in a for loop used to check if the first value entered is a team name(type char)
	 * 
	 * @param firstCharacter- The first character from the user input
	 * @throws None
	 * @return The team name of teamOne (type char) will be returned 
	 * if a proper team name was entered.
	 * Otherwise the character 'z' will be returned
	 */

	protected char teamOneCheck(char firstCharacter) {//Beginning of teamOneCheck method

		//Variables
		char check;
		char teamOne='a';

		firstCharacter=Character.toUpperCase(firstCharacter);
		//Changes the first character to upper case in case the user
		//entered a lower case letter 

		for (check = 'A'; check <= 'H'; check++) {// Checks through all the possible teams
			// to make sure the user entered a proper team.

			if (firstCharacter == check) {// Searches through each team name to see
				// if the first character of the string represents a team.
				teamOne=check;
				//Sets teamOne equal to the team name that was checked.
				//This also indicates that the user has entered proper input.
				break;// Breaks out of the for loop

			} else // If a proper team cannot be found from the first character
				// of the user input, then the user did not input a proper result.
				teamOne='z';
			//Sets teamOne equal to 'z' if a team cannot be found.
			//'z' indicates that the user has not entered proper input.

		} // End of for loop to check through all the teams for a winning team
		return teamOne;
		//Returns teamOne to the inputResults method
	}//End of teamOneCheck method


	/**
	 * teamTwoCheck Method: This functional method checks if the user has
	 * entered a proper name for the second team.
	 *
	 * -----------------------------List of Local Variables------------------------
	 * posistionOfTeamTwo- The index value of the second team from the user input(type int).
	 * check- A variable in a for loop used to check if the first value entered is a team name(type char).
	 * teamTwo- The name of the second team (type char).
	 * @param input- The user input(type String)
	 * @throws None
	 * @return The team name of teamTwo(type char) will be returned
	 * if a proper team name was entered.
	 * Otherwise the character 'z' will be returned.
	 */
	protected char teamTwoCheck(String input) {//Start of teamTwoCheck method 
		//Variables
		int positionOfTeamTwo;
		char check,teamTwo='z';

		for (check = 'A'; check <= 'H'; check++) {//Checks through all possible teams (from A-H).
			positionOfTeamTwo = input.indexOf((int) check, 1);

			//Starts from the first character of the String and searches for the second team index 
			//value in the rest of the string that the user inputed.

			if (positionOfTeamTwo > 0) {//If a second team name can be found in the string
				//it's index value will be greater than 0
				teamTwo = input.charAt(positionOfTeamTwo);
				//Gets the name of the second team from the String.
				break;

			} else if (positionOfTeamTwo == -1&&check=='H') {//If none of the team names are found 
				//the program will check lower case letters

				for (check = 'a'; check <= 'h'; check++) {//Checks through all possible teams (from a-h)
					//in case the user entered  a lower case letter
					positionOfTeamTwo = input.indexOf((int) check, 1);
					//Starts from the first character of the String and searches for the second team index 
					//value in the rest of the string that the user inputed.

					if (positionOfTeamTwo > 0) {//If a second team name can be found in the string
						//it's index value will be greater than 0
						teamTwo = input.charAt(positionOfTeamTwo);
						//Gets the name of the second team from the String.
						teamTwo=Character.toUpperCase(teamTwo);
						//Sets the second team to upper case so it can be read later in
						//the code.
						break;

					}//End of if statement to check if another character exist in the user input.
					else if (positionOfTeamTwo == -1) {//If none of the team names are found 
						//posistionOfTeamTwo will be -1.
						teamTwo='z';
						//Sets the teamTwo equal to 'z' which indicates that the user
						//has not entered proper input and a second team cannot be found.
					}//End of else if statement to confirm that the user has not entered
					//proper input.

				} //End of the inner for loop to check for a second team.
			} // End of else if statement to check if any team name appeared in the String
			//(other than the winning team's).
		}// End of for loop to check for the second team.
		return teamTwo;//Returns teamTwo to inputResults method.
	}//end of teamTwoCheck method



	/**
	 * storedResultsForGraph method: This method accumulates the results from
	 * the user input.

	 * -----------------------------List of Local Variables------------------------
	 * teams-A variable to represent the ASCII value of the team names (type int)
	 * 
	 * resultRow- A variable used to represent the row that a result 
	 * 		is stored in (eg the first result would be in the 0th row)
	 * 
	 * count-A variable used to count how many times a loop runs to store 
	 * 		values in the correct row (type int)
	 * 
	 * organizedResults-A 2D array used to store the accumulated results 
	 * 
	 * 
	 * @param results(type int[][]) is a 2D array that stores the information 
	 * of the results from the matches.
	 * @throws None
	 * @return organizedResults(type int[][]) 
	 */



	int [][] storedResultsForGraph (int [][] results) {//Beginning of storedResultsForGraph method.

		//Variables
		int teams,resultRow=0,count=0;
		int [][] organizedResults=new int[8][8];
		/*The organizedResults 2D integer array is formated to match the chart.
		 * Column 1 stores the team names (in order from A to H)
		 * Each row represents a team name (from A to H)
		 * Column 2 stores the number of games played.
		 * Column 3 stores the number of wins each team has.
		 * Column 4 stores the number of ties each team has.
		 * Column 5 stores the number of losses each team has.
		 * Column 6 stores the number of goals for each team has.
		 * Column 7 stores the number of goals against each team has.
		 * Column 8 stores the number of points each team gets
		 * Note: A team gets two points for a win, one point for a tie, 
		 * and no points for a loss.
		 */



		// This loop sets all the rows to represent one of the teams
		for (teams = 'A'; teams <= 'H'; teams++) {// Beginning of for loop
			organizedResults[count][0] = teams;
			// Sets the team name to one of the rows
			count++;
			// Adds one to count to move down one row
		} // end of for loop

		// This loop goes through each result that was entered and stores information.
		for (resultRow = 0; resultRow < 48; resultRow++) {// Beginning of for loop.
			count = 0;// This resets the count to 0 to make sure it isn't carried over from
			// a previous loop.

			if (results[resultRow][0] == 0)// Checks if there is still input
				break;// If there is no more input, the computer will break
			// out of the loop.

			if (results[resultRow][1] == results[resultRow][3]) {// Checks for a tie.
				for (teams = 'A'; teams <= 'H'; teams++) {// Inner loop to check through each team
					// to see which ones are mentioned from the results.
					if (results[resultRow][0] == teams) {// Checks to see which team tied.
						organizedResults[count][1]++;
						// Counts the number of games a team has played.
						organizedResults[count][3]++;
						// Counts the number of ties a team has.
						organizedResults[count][5] += results[resultRow][1];
						// Adds up the number of goals a team scored.
						organizedResults[count][6] += results[resultRow][3];
						// Adds up the number of goals that were scored against the team.
						organizedResults[count][7]++;
						// Gives the team one point for a tie.

					} // End of if statement to check which teams tied
					// and to record results.

					if (results[resultRow][2] == teams) {// Checks to see the other team that tied.
						organizedResults[count][1]++;
						// Counts the number of games a team has played.
						organizedResults[count][3]++;
						// Counts the number of ties a team has.
						organizedResults[count][5] += results[resultRow][3];
						// Adds up the number of goals a team scored.
						organizedResults[count][6] += results[resultRow][1];
						// Adds up the number of goals that were scored against the team.
						organizedResults[count][7]++;
						// Gives the team one point for a tie.

					} // End of if statement to check which other team tied
					// and to record results.

					count++;// Adds up the number of times the loop goes
					// so that the result can be stored in the proper row.

				} // End of inner for loop.
			} else {// Beginning of else statement to record scores
				// for the games that are not tied
				for (teams = 'A'; teams <= 'H'; teams++) {// Inner loop to check through each team
					// to see which ones are mentioned from the results.
					if (results[resultRow][0] == teams) {// Checks which team has won.
						organizedResults[count][1]++;
						// Counts the number of games a team has played.
						organizedResults[count][2]++;
						// Counts the number of wins a team has.
						organizedResults[count][5] += results[resultRow][1];
						// Adds up the number of goals a team scored.
						organizedResults[count][6] += results[resultRow][3];
						// Adds up the number of goals that were scored against the team.
						organizedResults[count][7] += 2;
						// Gives the team two points for a win.

					} // End of if statement to record results for a winning team

					if (results[resultRow][2] == teams) {// Checks which team has lost.
						organizedResults[count][1]++;
						// Counts the number of games a team has played.
						organizedResults[count][4]++;
						// Counts the number of losses a team has.
						organizedResults[count][5] += results[resultRow][3];
						// Adds up the number of goals a team scored.
						organizedResults[count][6] += results[resultRow][1];
						// Adds up the number of goals that were scored against the team.

					} // End of if statement to record results for the losing team
					count++;// Adds up the number of times the loop goes
					// so that the result can be stored in the
					// proper row.

				} // end of inner for loop to check through each team.
			} // End of else statement to record scores for the games that are not tied.
		} // end of for loop that goes through each result and stores information.

		return organizedResults;
		//Returns the organized results to the main method.
	}//End of storedResultsForGraph method.




	/**
	 * averageGoals method: This method finds the average number of goals scored
	 * per game.

	 * -----------------------------List of Local Variables------------------------
	 * row- A variable to count the numbers of rows in a for loop(type int).
	 * count- Counts the number of rows that are filled with results(type int).
	 * goals - The total number of goals(type int).
	 * averageGoals - The average number of goals(type int).
	 * 
	 * 
	 * @param results(type int[][]) is a 2D array that stores the information 
	 * of the results from the matches.
	 * @throws None
	 * @return averageGoals
	 */
	int averageGoals(int[][] results) {// Beginning of averageGoals method

		// Variables
		int row, count = 0, averageGoals = 0, goals = 0;

		for (row = 0; row < 48; row++) {// For loop to count the
			// number of results and to add up the total number of goals.

			if (results[row][0] != 0)// Checks to make sure that the row is
				// filled with values.
				count++;// Adds one to count.

			goals += results[row][1];// Adds the winning team score into
			// the total goals.
			goals += results[row][3];// Adds the losing team score into
			// the total goals.
		} // End of for loop to count the number of results and to add up the
		// total number of goals.

		try {// Tries to divide the total amount of goals in a game by the
			// number of games
			// played to find an average.
			averageGoals = Math.round(goals / (count));
		} catch (ArithmeticException e) {// Catches ArithmeticException if count
			// is 0
			// since we cannot divide by 0.
			System.out.println("There are no results");
			// Since count is 0, that means there are no results, so the
			// computer notifies the user the file is empty.
		} // End of catch for ArithmeticException.

		return averageGoals;
		// Returns the average goals to the main method.

	}// End of averageGoals method



	/**
	 * mostFrequentGoal method: This method finds the most frequent number
	 * of goals scored.

	 * -----------------------------List of Local Variables------------------------
	 * goalList - An array that stores the total goals from each game (type int[]).
	 * 
	 * row- A variable to count the numbers of rows in a for loop(type int).
	 * count- Counts the number of rows that are filled with results(type int).
	 * goals - The total number of goals(type int).
	 * averageGoals - The average number of goals(type int).
	 * search -A variable to search through the array goalList (type int).
	 * check - A variable to check values of the array goalList(type int).
	 * mostFrequentGoals -The most frequent goals per game (type int[])
	 * occurrences - Counts the number of times the same score is repeated(type int).
	 * greatestOccurence - The greatest number of times a score is repeated(type int).
	 * 
	 * 
	 * @param results(type int[][]) is a 2D array that stores the information 
	 * of the results from the matches.
	 * @throws None
	 * @return mostFrequentGoals (type int[])
	 */

	int[] mostFrequentGoal(int[][] results) {// Beginning of mostFrequentGoal
		// method

		// Variables
		int row, count = 0, search, check, occurences, greatestOccurence = 1,multiModesCount=0;
		int[] goalList = new int[48];
		int[] mostFrequentGoals = new int[48];

		for (row = 0; row < 48; row++) {// For loop to count the
			// number of results and to find the number of goals
			// per game to store in the array 'goalList'.

			if (results[row][0] != 0) {// Checks to make sure that the row is
				// filled with values.
				goalList[count] += results[row][1] + results[row][3];
				// Stores the number of goals in a game into
				// an index of the array 'goalList'.
				count++;// Adds one to count.
			} // End of if statement to make sure the row is filled with values.
		} // End of for loop to count the number of results and to find the
		// number of goals
		// per game to store in the array 'goalList'.

		for (search = 0; search < count - 1; search++) {// Beginning of
			// outer for loop to search through each number of the array
			// 'goalList'.
			occurences = 1;// Sets occurrences equal to 1 as default.
			for (check = search + 1; check < count; check++) {// An inner
				// for loop to allow the computer to compare each value of
				// 'goalList'.
				if (goalList[search] == goalList[check])// Checks if
					// the 'search' value of goalList is equal to
					// another value in that same array.
					occurences++;
				// Adds one to occurrences to indicate that the same number has
				// appeared.
			} // End of inner for loop to check through each value of 'goalList'

			if (occurences > greatestOccurence) {// If statement
				// to check if the number of occurrences is greater
				// than the greatest number of occurrences.
				Arrays.fill(mostFrequentGoals, 0);
				// Fills the array with zeroes to reset everything in the array.
				multiModesCount = 0;
				// Resets multiModesCount back to 0.
				mostFrequentGoals[0] = goalList[search];
				// Sets the most frequent goals equal to the 'search'
				// value of goalList.
				greatestOccurence = occurences;
				// Sets the greatestOccurence equal to the number of
				// occurrences as a new standard, since occurrences is
				// greater than greatestOccurence.
			} // End of if statement to check if the number of
			// occurrences is greater than the greatest number of
			// occurrences.
			else if (occurences == greatestOccurence) {// Beginning of
				// else if statement to check if there are the same
				// number of occurrences.
				multiModesCount++;// Adds one to multiModesCount so
				// more modes can be added to the array mostFrequentGoals.
				mostFrequentGoals[multiModesCount] = goalList[search];
				// Sets another most frequent goal equal to the 'search'
				// value of goalList.

			} // End of else if statement to check if there are the
			// same number of occurrences.
		} // End of outer for for loop to search through
		// each number of the array 'goalList'.

		return mostFrequentGoals;
		// Returns the most frequent goal to the main method.

	}// End of mostFrequentGoal method

	/**
	 * sortResults-This method sorts the organizedResults based off of the points

	 * -----------------------------List of Local Variables------------------------
	 * tempRow[]-Stores a temporary row that is used to swap rows (type int[]).
	 * temp-Stores a temporary value(a point) that is used to swap rows based off of its value (type int).
	 * count-A variable used to count how many times a loop runs to check through
	 * 		 each value in a column/row (type int).
	 * counter- A variable used to compare the "count" row/column with the previous row/column (type int).
	 * goalDifferenceAbove - A variable used to see the goal difference (goals for minus goals against)
	 * 		of a the team above the temporary team(type int).
	 * goalDifferenceOfTempRow -A variable used to see the goal difference (goals for minus goals against)
	 * 		of the temporary team (same row was temp and tempRow)(type int).
	 * 
	 * @param organizedResults(type int[][]) is a 2D array that stores the
	 * accumulated results.
	 * @throws None
	 * @return organizedResults(type int[][]) - These results are fully sorted and ready to be displayed.
	 */

	int[][] sortResults(int[][] organizedResults) {// Beginning of the sortResults method.

		// Variables
		int tempRow[];
		int temp, count, counter, goalDifferenceAbove = 0, goalDifferenceOfTempRow = -1;

		// Modified insertion sort to sort the 2D array organizedResults
		for (count = 1; count < 8; count++) {// Beginning of loop
			// that checks through each row of points

			temp = organizedResults[count][7];
			// Sets the "count": row of the points column into a
			// temporary variable
			tempRow = organizedResults[count];
			// Sets the "count" row into a temporary array
			counter = count - 1;
			// Sets counter equal to 1 less than count
			goalDifferenceOfTempRow = organizedResults[count][5] - organizedResults[count][6];
			// This sets goalDifferenceOfTempRow to the goal difference of another team
			// (goals for
			// minus goals against)

			while ((counter >= 0) && (organizedResults[counter][7] < temp)) {
				// Beginning of while loop that makes sure counter is greater than 0 and that
				// a row of the point column(7) is less than the next row of the point
				// column that is beside it (temp).
				organizedResults[counter + 1] = organizedResults[counter];
				// Swaps the rows if the point column below is greater than the
				// column above

				counter--;
				// Subtracts one from counter, this allows the program to
				// continue to shift the rows along the already sorted
				// rows until it is in the right position.

			} // End of while loop that checks the points columns.

			if ((counter >= 0) && (organizedResults[counter][7] == temp)) {
				// If statement that checks for ties for points
				goalDifferenceAbove = organizedResults[counter][5] - organizedResults[counter][6];
				// This sets goalDifferenceAbove to the goal difference of a team (goals for
				// minus
				// goals against)
			} // End of if statement that checks for ties for points

			while ((counter >= 0) && (organizedResults[counter][7] == temp)
					&& goalDifferenceAbove < goalDifferenceOfTempRow) {
				// This if statement checks if there are ties within the sorted points column.

				organizedResults[counter + 1] = organizedResults[counter];
				// Swaps the rows if the goalDifference of the temporary team is greater than
				// the
				// row above.

				counter--;
				// Subtracts one from counter, this allows the program to
				// continue to shift the rows along the already sorted
				// rows until it is in the right position.

				if (counter >= 0) {
					// If statement makes sure that counter is greater than 0
					// so the program does not crash.
					goalDifferenceAbove = organizedResults[counter][5] - organizedResults[counter][6];
					// This sets goalDifferenceAbove to the goal difference of a team (goals for
					// minus goals against)

				} // End of if statement that makes sure counter is greater than 0.
			} // End of while loop that checks for ties.

			organizedResults[counter + 1] = tempRow;
			// Sets the row that is 1 above "counter"
			// equal to row that was overridden during the
			// swapping process.

		} // End of the for loop to check through each row of sorted points.

		return organizedResults;
		//Returns the sorted results to the main method.

	}// End of the sortResults method.


	/**
	 * displayResults- This method displays the accumulated/sorted results in a chart.
	 * -----------------------------List of Local Variables------------------------
	 * 
	 * row-Counts the rows printed out (type int)
	 * column-Counts the columns printed out(type int)
	 * 
	 * count- Counts
	 * 
	 * @param 
	 * organizedResults - a 2D array that stores the
	 * accumulated/sorted results(type int).
	 * 
	 *averageGoals - The average number of goals (type int)
	 *
	 *mostFrequentGoals -The most frequent goals per game (type int[])
	 * @throws None
	 * @return void
	 */

	void displayResults(int [][] organizedResults,int averageGoals,int[] mostFrequentGoals) {//Beginning of displayResults method.

		//Variables
		int row,column;

		/*The organizedResults 2D integer array is formated to match the chart.
		 * Column 1 stores the team names
		 * Each row represents a team name (from A to H)
		 * Column 2 stores the number of games played.
		 * Column 3 stores the number of wins each team has.
		 * Column 4 stores the number of ties each team has.
		 * Column 5 stores the number of losses each team has.
		 * Column 6 stores the number of goals for each team has.
		 * Column 7 stores the number of goals against each team has.
		 * Column 8 stores the number of points each team gets.
		 */

		// Displays the menu which shows the results
		System.out.println("=============================================================");
		System.out.println("Team\tGames\t\t\t\tGoals\tGoals\tPoints");
		System.out.println("Name\tPlayed \tWins\tTies\tLosses\tFor\tAgainst  ");
		System.out.println("=============================================================");

		// These loops print out all the results of organizedResults
		for (row = 0; row < 8; row++) {// Beginning of outer for loop.
			for (column = 0; column < 8; column++) {// Beginning of inner for loop.
				if (column == 0)// Checks if it is the first column
					// If so it will display the team name as a character instead
					// of the ASCII value
					System.out.print((char) organizedResults[row][column] + "\t");
				else// Displays the sorted results
					System.out.print(organizedResults[row][column] + "\t");

			} // End of inner for loop.
			System.out.println();// Adds a line for the next row.
		} // End of outer for loop.
		System.out.println("=============================================================");

		if(averageGoals>0)//Checks if there is an average number of goals.
			//Displays the average number of goals
			System.out.println("The average number of goals per game is "+averageGoals);
		else//Tells the user there is no average goal, if there is none.
			System.out.println("There is no average number of goals");

		column=0;//Initializes column to 0
		if(mostFrequentGoals[0]>0&&mostFrequentGoals[1]>0) {//Checks to make sure there is actually a mostFrequentGoal
			System.out.print("The most frequent goals are ");
			while(mostFrequentGoals[column]!=0) {//Beginning of while loop to 
				//check through the number of most frequent goals
				if(mostFrequentGoals[column+1]==0)
					//Checks if the next column is empty
					System.out.print("and "+mostFrequentGoals[column]+".");
				else//If it is not empty it will continue to print
					//out commas after the point is displayed.
					System.out.print(mostFrequentGoals[column]+", ");
				//Prints out the most frequent goals.
				column++;//Adds one to column to go to the next column.
			}//End of while loop to check through the number
			//of most frequent goals.
			System.out.println();//Adds a space
		}//End of if statement to see if there are multiple most frequent goals.
		else if(mostFrequentGoals[0]>0)
			//Displays the most frequent goal
			System.out.println("The most frequent goals per game is "+mostFrequentGoals[0]);	
		else//Tells the user there is no most frequent goals, if there is none.
			System.out.println("There is no most frequent goal");

		//Displays the average number of goals
	}// End of displayResults method.

	/**
	 * outputResultsToAFile- This method writes the accumulated/sorted results to a file
	 * that the user chooses.
	 * -----------------------------List of Local Variables------------------------
	 * br- object used to get user input (type BufferedReader)
	 * bw- object used to write to a file (type BufferedWriter)
	 * fileName-The name of the file that the data will be written to (type String).
	 * row-Counts the rows printed out (type int).
	 * column-Counts the columns printed out(type int).
	 * 
	 * @param 
	 * organizedResults - a 2D array that stores the
	 * accumulated/sorted results(type int[][]).
	 * 
	 * averageGoals - The average number of goals (type int)
	 * 
	 * mostFrequentGoals -The most frequent goals per game (type int[])
	 * @throws IOException
	 * @return void
	 */

	void outputResultsToAFile(int[][] organizedResults,int averageGoals,int[] mostFrequentGoals) throws IOException {// Beginning of the outputResults method

		// System Objects
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Variables
		String fileName = "h://temp.txt";
		int row, column;

		// Prompts the user to enter a file directory to store the results
		System.out.println("=============================================================");
		System.out.println("Please enter the directory where you would like");
		System.out.println("to store these results.");
		System.out.println("If you do not wish to store the results please type 'stop'.");
		System.out.println("=============================================================");

		while (true) {// Beginning of while loop to get a file name.
			try {// Beginning of the try and catch to check.
				// if the user enters a proper directory.
				fileName = br.readLine();// Accepts a file name and directory.
				if (fileName.equalsIgnoreCase("stop"))// Checks if the user has
					// entered 'stop'.
					break;// If so the computer will break out the loop.

				// System object that allows us to write to a file.
				BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));

				// Writes out the menu for the graph of data.
				bw.write("=============================================================");
				bw.newLine();
				bw.write("Team\tGames\t\t\t\tGoals\tGoals\tPoints");
				bw.newLine();
				bw.write("Name\tPlayed \tWins\tTies\tLosses\tFor\tAgainst  ");
				bw.newLine();
				bw.write("=============================================================");
				bw.newLine();

				// These loops writes out all the results of organizedResults
				for (row = 0; row < 8; row++) {// Beginning of outer for loop.
					for (column = 0; column < 8; column++) {// Beginning of
						// inner for loop.
						if (column == 0)// Checks if it is the first column
							// If so it will write the team name as a character
							// instead
							// of the ASCII value.

							bw.write((char) organizedResults[row][column] + "\t");
						else// Writes the sorted results.
							bw.write(organizedResults[row][column] + "\t");

					} // End of inner for loop.
					bw.newLine();// Adds a line for the next row.
				} // End of outer for loop.
				if(averageGoals>0)//Checks if there is an average number of goals.
					bw.write("The average number of goals per game is " + averageGoals);
				else//Tells the user there is no average goal, if there is none.
					bw.write("There is no average number of goals");
				bw.newLine();// Adds a line for the next row.
				// Writes the average number of goals.
				column=0;//Initializes column to 0
				if(mostFrequentGoals[0]>0&&mostFrequentGoals[1]>0) {//Checks to make sure there is actually a mostFrequentGoal
					bw.write("The most frequent goals are ");
					while(mostFrequentGoals[column]!=0) {//Beginning of while loop to 
						//check through the number of most frequent goals
						if(mostFrequentGoals[column+1]==0)
							//Checks if the next column is empty
							bw.write("and "+mostFrequentGoals[column]+".");
						else//If it is not empty it will continue to write
							//out commas after the point is displayed.
							bw.write(mostFrequentGoals[column]+", ");
						//Prints out the most frequent goals.
						column++;//Adds one to column to go to the next column.
					}//End of while loop to check through the number
					//of most frequent goals.
					bw.newLine();//Adds a space
				}//End of if statement to see if there are multiple most frequent goals.
				else if(mostFrequentGoals[0]>0)//Checks to make sure there is a mostFrequentGoal
					bw.write("The most frequent goals per game is "+mostFrequentGoals[0]);
				//Writes the most frequent goal per game
				else //Tells the user there is no most frequent goal, if there is none.
					bw.write("There is no most frequent goal");
				bw.newLine();// Adds a line for the next row.


				System.out.println("The results have been written in " + fileName);
				// Tells the user that the results have been written in the file.

				bw.close();// Closes the file.
				break;// Breaks out of the loop if there is proper input.
			} // End of try.
			catch (IOException ex) {// Catches any exceptions if the file
				// cannot be written to.

				// Prompts the user to enter a proper file name.
				System.out.println("Error writing to file '" + fileName + "'");
				System.out.println("Please enter a proper directory of the file.");
			} // End of catch.

		} // End of while loop.

		// Thanks the user.
		System.out.println("Thank you for using the Soccer League Scoring program");
		System.out.println("Please come back soon!");
	}// End of outputResultsToAFile method.

}// End of class SoccerLeague.
