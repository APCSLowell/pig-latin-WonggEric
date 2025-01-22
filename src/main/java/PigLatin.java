import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PigLatin {
    
    public void tester() {
        // String[] lines = loadStrings("words.txt");
        String[] lines = new String[8]; 
        try{
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
	    for (int i = 0 ; i < lines.length; i++) {
	        System.out.println(pigLatin(lines[i]));
	    }
    }
  public int findFirstVowel(String sWord)
  if (sWord>0) {
  for (int i = 0; i<word.length(); i++) {
    if (word.charAt(i) =='a'|| word.charAt(i)=='e'|| word.charAt(i)=='i'|| word.charAt(i)=='o'|| word.charAt(i)=='u') {
      return i;
    }
    return -1;
  }
}
}

public String pigLatin(String sWord)
  if (sWord>0) {
  {
    if (findFirstVowel(sWord) == -1)
    {
      return sWord + "ay";
    } else
    {
      return "ERROR!";
    }
 
