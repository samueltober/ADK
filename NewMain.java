/* Labb 2 i DD1352 Algoritmer, datastrukturer och komplexitet    */
/* Se labbanvisning under kurssidan http://www.csc.kth.se/DD1352 */
/* Ursprunglig författare: Viggo Kann KTH viggo@nada.kth.se      */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class NewMain {

  public static ArrayList<String> readWordList(BufferedReader input) throws IOException {
    ArrayList<String> list = new ArrayList<String>();
    while (true) {
      String s = input.readLine();
      if (s.equals("#"))
        break;
      list.add(s);
    }
    return list;
  }

  public static void main(String args[]) throws IOException {
    long t1 = System.currentTimeMillis();
    BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
    // Säkrast att specificera att UTF-8 ska användas, för vissa system har annan
    // standardinställning för teckenkodningen.
    ArrayList<String> wordList = readWordList(stdin);
    String word;
    
    while ((word = stdin.readLine()) != null) {
      ClosestWordDyn closestWords = new ClosestWordDyn(word, wordList);
      System.out.print(word + " (" + closestWords.getMinDistance() + ")");
      
      for (String w : closestWords.getClosestWords())
        System.out.print(" " + w);
      System.out.println();
      long tottime = (System.currentTimeMillis() - t1);
      System.out.println("CPU time: " + tottime + " ms");
    }


  }
}
