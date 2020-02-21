//
//Problem statement: 
//Accept a list of email addresses and return an integer indicating the number of unique email addresses. 
//Where "unique" email addresses means they will be delivered to the same account using Gmail account matching. 
//Specifically: Gmail will ignore the placement of "." in the username. And it will ignore any portion of the username after a "+".
//
//Examples:test.email@gmail.com, test.email+spam@gmail.com and testemail@gmail.com will all go to the same address, and thus the result should be 1.
//
//For any requirements not specified via an example, use your best judgement to determine expected result.
//
import java.util.*; 
public class totalUniqueEmails{
    public static int uniqueEmails(String[] emailList) {
        String[] userEmailBefore;
        String[] userEmailAfter;
      
        // Set is used to ignore duplicates
        Set<String> unique = new HashSet<>();
        
        // for email in emailLists, find the portion before the domain
        for (String email : emailList) {
            
            // remove domain
            userEmailBefore = email.split("@"); 
            
            // account for "+"
            userEmailAfter = userEmailBefore[0].split("\\+"); 
            
            // remove periods, add to total
            userEmailAfter[0] = userEmailAfter[0].replace(".", "");
            
            // concatenate the @ and original domain
            unique.add(userEmailAfter[0] + "@" + userEmailBefore[1]); 
        }
        return unique.size();
    }
     // tester function using the testcase specified
     public static void main(){
            String[] testEmails = {"test.email@gmail.com", "test.email+spam@gmail.com", "testemail@gmail.com"};
            System.out.println(uniqueEmails(testEmails));
         }
}

