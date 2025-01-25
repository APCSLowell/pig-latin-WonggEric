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
    if (sWord == null || sWord.isEmpty()) {
      return "Invalid input"; // Handle null or empty strings
    }

    sWord = sWord.toLowerCase(); // Make lowercase for consistency
    int vowelIndex = findFirstVowel(sWord);

    if (vowelIndex == -1) {
      // No vowels, add "ay" at the end
      return sWord + "ay";
    } else if (vowelIndex == 0) {
      // Starts with a vowel, add "way" at the end
      return sWord + "way";
    } else if (vowelIndex > 0 && sWord.startsWith("qu")) {
      // Starts with "qu", move "qu" to the end and add "ay"
      return sWord.substring(2) + "quay";
    } else {
      // Move all letters before the first vowel to the end and add "ay"
      return sWord.substring(vowelIndex) + sWord.substring(0, vowelIndex) + "ay";
    }
  }
