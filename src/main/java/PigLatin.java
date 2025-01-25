public void setup() 
{
  String[] lines = loadStrings("words.txt");
  System.out.println("there are " + lines.length + " lines");
  for (int i = 0 ; i < lines.length; i++) 
  {
    System.out.println(pigLatin(lines[i]));
  }
}
public void draw(){/*not used*/}

public int findFirstVowel(String sWord)
{
  if (sWord.length() > 1) {
      for (int i = 0; i<sWord.length(); i++) {
        if (sWord.charAt(i) =='a'|| sWord.charAt(i)=='e'|| sWord.charAt(i)=='i'|| sWord.charAt(i)=='o'|| sWord.charAt(i)=='u') {
          return i;
        }
      }
    }
    return -1;
  }
public String pigLatin(String sWord){
 int firstVowelIndex = findFirstVowel(sWord);
    
    if (firstVowelIndex == -1) {
      return sWord + "ay";
    }else if(firstVowelIndex == 0){
      return sWord +"way";
    }else if(sWord.substring(0,2).equals("qu")){
      return sWord.substring(2)+"quay";
    }else if(firstVowelIndex>0){
      return sWord.substring(1)+sWord.charAt(0)+"ay";
    }else{
      return "ERROR!";
    
}
