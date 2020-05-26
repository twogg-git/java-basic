import java.util.ArrayList;
import java.util.Arrays;

public class ArrayTests {
 
  public static void main(final String[] args) {   
    String input = "1,2,3.1,4";
    outputs("Sum of numbers in a string", input, "10", sumOfNumbersInString(input));   

    input = "b,2,a,10";
    outputs("Swap numbers in a string", input, "b,10,a,2", swapOnlyNumbersInString(input));    

  }

  // -----------------------------------------------
  // Swap only numbers in a string

  // >>> Test Cases
  // "" > ""
  // "1" > "1"
  // "1,c" > "1,c"
  // "1,2" > "2,1"
  // "a,b,c" > "a,b,c"
  // "b,2,a,10" > b,10,a,2
  // "a,3,c" > "a,3,c"
  // "e,7,f,0,4" > "e,4,f,0,7"
  // "a1,2,3" > "a1,3,2"
  
  // >>> Format and validations
  // could items to swap not an odd number? YES
  // only swap numbers? YESalways same separator? YES 
  // always same separator? YES

  // >>> Pseudocode
  // if stirng is empty RETURN input
  // split string
  // if array lenght == 0 or 1 end, RETURN input
  // find first item and last items index to swap
  // two indexs first=0 last=array.lenght-1
  // loop validate [first] if number then validate [last] else first++ 
  // validate [last] if number and last != first else RETURN input
  // save locally [last] item
  // replace [last] with [first] item
  // replace [first] with saved [last] item  
  // them move indexs i++ --j index
  // validate first < last
  // repite loop

  private static String swapOnlyNumbersInString(String input) {
    if( input.isEmpty()){
      return input;
    }
    String[] inputAsArray = input.split(",");
    if(inputAsArray.length == 1){
      return input;
    }
    String saved = null;
    int last = 0;
    for(int first=0; first<inputAsArray.length-1 && first < last; first++){
      try{
        for(; last > 0 && last < first; last--){
          try {
            Integer.parseInt(inputAsArray[last]);
            saved = inputAsArray[last];
            inputAsArray[last] = inputAsArray[first];
            inputAsArray[first] = saved;
          } catch(NumberFormatException ex){
          }
        }
      }catch(NumberFormatException ex){}
    }
    return Arrays.toString(inputAsArray);
  }

  // -----------------------------------------------
  // Sum of numbers in a string

  // >>> Test Cases
  // "1,2,3,4" > 10
  // "1,2.8,3,4" > 10.8
  // "" > 0
  // "a" > 0
  // "a,1" > 1

  // >>> Format and validations
  // accepts letters or charrachters? NO
  // seprator always a coma? YES
  // could be a null string? YES
  // could be non integer numbers? YES
  
  // >>> Pseudocode
  // if string empty return 0
  // split the string
  // start a result in 0, worst case return 0
  // if item is viable to sum, add it to sum, if not ignore
  // return sum

  private static double sumOfNumbersInString(String input){
    double sum = 0;
    if (input.isEmpty()) {
      return sum;
    }
    String[] arrayInput = input.split(",");
    if (arrayInput.length == 1) {
      try {
        return Double.parseDouble(arrayInput[0]);
      } catch (NumberFormatException e) {
        System.out.println("Item not number [" + arrayInput[0] + "]");
        return sum;
      }
    }
    for (String item : arrayInput) {
      try {
        sum += Double.parseDouble(item);
      } catch (NumberFormatException e) {
        System.out.println("Item not number ["+item+"]");
      }      
    }
    return sum;
  }

  private static void outputs(String title, Object input, Object expected, Object result) {
    System.out
        .println("\n> " + title + "\nInput    = " + input + "\nResult   = " + result + "\nExpected = " + expected);
  }  

}