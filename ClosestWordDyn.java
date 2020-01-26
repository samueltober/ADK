import java.util.ArrayList;

public class ClosestWordDyn {
	ArrayList<String> closestWords = null;
	int minDist = -1;
	
	int delta = 1; //Cost of blank space
	int alpha = 1; //Cost of mismatch
	
	
	int Distance(String word1, String word2) {
		int n = word1.length();
		int m = word2.length();
		int T[][] = new int[n+1][m+1];
		
		T[0][0] = 0;
		
		for (int i=1; i<=n; i++) {T[i][0] = i*delta;}
		for (int j=1; j<=m; j++) {T[0][j] = j*delta;}
		
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=m; j++) {
				int m1 = T[i-1][j] + delta;
				int m2 = T[i][j-1] + delta;
				int m3 = T[i-1][j-1] + id(i-1,j-1, word1, word2)*alpha;
				
				T[i][j] = minThreeNumbers(m1, m2, m3);
			}
		}
		
		return T[n][m];
	}
	
	int id(int i, int j, String w1, String w2) {
		return w1.charAt(i)==w2.charAt(j) ? 0:1;
	}
	
	int minThreeNumbers(int a, int b, int c) {
		return Math.min(Math.min(a, b), c);
	}
	
	int getMinDistance() {
		return minDist;
	}
	
	ArrayList<String> getClosestWords() {
		return closestWords;
	}
	
	public ClosestWordDyn(String word, ArrayList<String> dictionary) {
		for (String s : dictionary) {
			int dist = Distance(word, s);
			
			if (dist < minDist || minDist == -1) {
				minDist = dist;
				closestWords = new ArrayList<String>();
			    closestWords.add(s);
			}
			else if (dist == minDist) {
				closestWords.add(s);
			}
		}
	}
}
