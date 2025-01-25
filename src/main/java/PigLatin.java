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
        if (sWord.toLowerCase().charAt(i) =='a'|| sWord.toLowerCase().charAt(i)=='e'|| sWord.toLowerCase().charAt(i)=='i'|| sWord.toLowerCase().charAt(i)=='o'|| sWord.toLowerCase().charAt(i)=='u') {
          return i;
        }
      }
    }
    return -1;
  }

  public String pigLatin(String sWord) {
    //precondition: sWord is a valid String of length greater than 0
    //postcondition: returns the pig latin equivalent of sWord
    int firstVowelIndex = findFirstVowel(sWord);
    
    if (firstVowelIndex == -1) {
      return sWord + "ay";
    }else if(firstVowelIndex == 0){
      return sWord +"way";
    }else if(sWord.substring(0,2).toLowerCase().equals("qu")){
      return sWord.substring(2)+"quay";
    }else if(firstVowelIndex>0){
      return sWord.substring(firstVowelIndex)+sWord.substring(0,firstVowelIndex)+"ay";
    }else{
      return "ERROR!";
    }
  }

 
}
