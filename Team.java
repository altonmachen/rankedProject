import java.util.ArrayList;

public class Team {
	
	public String name;
	public double rating;
	public ArrayList <Double> gameScores;




public Team (String n, double r) {
		gameScores = new ArrayList <Double>();
		rating = r;
		name=n;
	}



public String getName() {
	return name;
}
public double getRating() {
	return rating;
}
public ArrayList<Double> getGameScores() {
	return gameScores;
}
public void setName(String n) {
	n=name;
}
public void setRating(double r) {
	r=rating;
}
public void calculateRating() {
	double sum=0;
	for (int i=0; i<gameScores.size(); i++) {
		sum+=gameScores.get(i);
	}
	rating = (sum/gameScores.size());

}
















}
