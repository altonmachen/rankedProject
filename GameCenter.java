import acm.util.*;

import java.util.ArrayList;

import acm.program.*;

public class GameCenter extends ConsoleProgram {

private Team[] teamList;
int leagueSize;
String homeName;
String awayName;
int homeIndex;
int awayIndex;


public void run() {
	setup();
	playGames();
	sortTeams();
}



	public void setup() {
	leagueSize = readInt("How many teams are in the leauge?: ");
	teamList = new Team[leagueSize];
	for (int i=0; i<leagueSize; i++) {
	String teamName = readLine("Enter the name of the team: ");
	Team a = new Team(teamName, 80);
//	teams have initial rating of 80
	teamList[i]= a;
}
}

	
	
	public void playGames() {
		println("You will now be prompted to enter the scores of games between these teams. Then we will rank the teams using goal differential and strength of schedule data.");
		int gameTotal = readInt("How many games would you like to sumbit?: ");
		int gameCounter=0;
		while(gameCounter<gameTotal) {
		println("Enter the game score.");
		homeName = readLine("Enter the name of the home team: ");
		for (int i=0; i<teamList.length; i++) {
			if (teamList[i].getName().equals(homeName)) {
				homeIndex=i;
			}
			
		}
		awayName = readLine("Enter the name of the away team: ");
		for (int i=0; i<teamList.length; i++) {
			if (teamList[i].getName().equals(awayName)) {
				awayIndex=i;
			}
		}
		int win = readInt("Did " + teamList[homeIndex].getName() + " defeat " + teamList[awayIndex].getName() + "? Type 1 for yes, 2 for no: ");
		if (win==1) {
			double winDiff = readDouble("How many goals did they win by?: ");
			teamList[homeIndex].getGameScores().add(teamList[awayIndex].getRating()+winDiff);
			double temp = teamList[homeIndex].getRating();
			teamList[homeIndex].calculateRating();
			teamList[awayIndex].getGameScores().add(temp-winDiff);
			teamList[awayIndex].calculateRating();
		}
		if (win==2) {
			double loseDiff = readDouble("How many goals did they lose by?: ");
			teamList[homeIndex].getGameScores().add(teamList[awayIndex].rating-loseDiff);
			double temp = teamList[homeIndex].getRating();
			teamList[homeIndex].calculateRating();
			teamList[awayIndex].getGameScores().add(temp+loseDiff);
			teamList[awayIndex].calculateRating();
		}
		println("The rating of " +teamList[homeIndex].getName() + " is: " +teamList[homeIndex].getRating());
		println("The rating of " +teamList[awayIndex].getName() + " is: " +teamList[awayIndex].getRating());
		gameCounter++;
		}
	}

	


public Team[] selectionSort(Team[] arr) {
	for (int i=0;i<arr.length;i++) {
		int maxIndex = i;
		for (int j=maxIndex+1;j<arr.length;j++) {
			if(arr[j].getRating()> arr[i].getRating()) {
				maxIndex=j;
				Team temp=arr[maxIndex];
				arr[maxIndex]=arr[i];
				arr[i]=temp;
			}
		}
		
	}
		return arr;
}
public void sortTeams() {
	println("The algorithm will now produce rankings of the teams.");
	selectionSort(teamList);
	for (int i=0; i<teamList.length;i++) {
		println(+i+1+ ": " +teamList[i].getName() + "(" +teamList[i].rating+ ")");
	}
}



}
