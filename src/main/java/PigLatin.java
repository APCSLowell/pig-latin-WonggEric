import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PigLatin {

  public void tester() {
    // String[] lines = loadStrings("words.txt");
    String[] lines = new String[8]; 
    try {
      File myFile = new File("words.txt");
      Scanner myReader = new Scanner(myFile);
      int counter = 0;
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        lines[counter] = data;
        counter++;
      }
      myReader.close();
    }
    catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    System.out.println("there are " + lines.length + " lines");
    for (int i = 0; i < lines.length; i++) {
      System.out.println(pigLatin(lines[i]));
    }
  }
  public int findFirstVowel(String sWord) {
    if (sWord.length() > 1) {
      for (int i = 0; i<sWord.length(); i++) {
        if (sWord.charAt(i) =='a'|| sWord.charAt(i)=='e'|| sWord.charAt(i)=='i'|| sWord.charAt(i)=='o'|| sWord.charAt(i)=='u') {
          return i;
        }
      }
    }
    return -1;
  }

  public String pigLatin(String sWord) {
    //precondition: sWord is a valid String of length greater than 0
    //postcondition: returns the pig latin equivalent of sWord
    // more code should go here
   int firstVowelIndex = findFirstVowel(sWord); // Find the index of the first vowel
    
    if (firstVowelIndex == -1) {
        return sWord + "ay";
    }
    
    if (firstVowelIndex == 0) {
        return sWord + "way";
    }
    
    if (sWord.startsWith("qu")) {
        return sWord.substring(2) + "quay";
    }
    
    return sWord.substring(firstVowelIndex) + sWord.substring(0, firstVowelIndex) + "ay";
}//end PigLatin class
