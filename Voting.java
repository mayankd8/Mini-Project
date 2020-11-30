package Day1;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
interface Voting_
{
    // by default public abstract
   void displayResult();
   void casteVote();
}
class Voters implements Voting_
{
	String x="Rahul Gandhi";
	String y="Sharad Pawar";
	String z="Narendra Modi";
	 String choice, candid;
	char candidcode;
	int a, b, c;
        
        Scanner sc = new Scanner(System.in);
boolean isVoterId(Long m)
    {
	if(m>=1)
	return true;
		
        else
        return false;
    }
	
public	void displayResult()    //overriding method of interface
	{       
		float total=a + b + c;
			
                System.out.println(" LOKSABHA  ELECTION");
		System.out.println("\tCandidates\tResult \tVoting Percent");
		System.out.println("A: "+x+"\t\t" + a + "\t" + a/total * 100);
		System.out.println("B: "+y+"\t\t" + b + "\t" + b/total * 100);
		System.out.println("C: "+z+" \t" + c + "\t" + c/total * 100);
		System.out.println("TOTAL VOTES: " + (a+b+c));
                
		String winner="";
			
		if(a>b && a>c)
                {
                    winner=x;
                }
                else if(b>a && b>c)
                {
                    winner=y;
                }
                else if(c>a && c>b)
                {
                    winner=z;
                }
                else
                {
                    System.out.println("*Election has been tie");
                }
		
		System.out.println("*And the winner is: " + winner);
		System.out.println("----------------------");
		
	}
	
	
public void casteVote()     ////overriding method of interface
	{

		System.out.print("*Enter your vote for: ");
		candid = sc.next().toLowerCase();
		candidcode = candid.charAt(0);
		System.out.println("Vote is Submitted Successfully\n");
		System.out.println("[**Thank you for your valuable vote**](:\n");
		
		switch(candidcode)
		{
                    case 'a': a++;
                            break;
                    case 'b': b++; 
                            break;
                    case 'c': c++;
                            break;
                    default: System.out.println("Invalid candidates code");
		}
		
	}
 public void login()
        {
            System.out.println("*Enter your choice \n1.User\n2.Admin");
            int ad=sc.nextInt();
            if(ad==1)
            {
                user();     //caling user method
            }
            else if(ad==2)
            {
                admin();    ////caling admin method
            }
            else
            	System.out.println("Invalid Choice");
        }
        
   public  void user()
        {   
            System.out.println("[Satara Constituency Voting]\n----------------------");
            System.out.print("*Enter Your Name:");
            sc.next();
            String sl=sc.nextLine();
            System.out.print("*Enter VoterId No:");
            Long m=sc.nextLong();
            
            System.out.println("**********************");

                if(isVoterId(m)) 
                {
                  do
                    {

                    System.out.println("[Candidate List:]\n----------------------");
                    System.out.println("A: "+x);
                    System.out.println("B: "+y);
                    System.out.println("C: "+z);
                    System.out.println("----------------------");
                    System.out.println("[Press V to vote]");
                    System.out.print("*Enter your choice: ");
                    choice = sc.next().toLowerCase();
                   
                    switch(choice)
                    {
                        case "v":
                                casteVote();    //caling method to casteVote
                             break;
                        default:
                           System.out.println("Invalid Choice,Please try again!!");
                           System.out.println("----------------------");
                    }
                   }while(!(choice.equalsIgnoreCase("V"))); 
                }
        }
      public  void admin()
        {
            String ch;
              do
              {
            
                   System.out.println("Type R-result, Q-quit");
                   System.out.print("Enter your choice: ");
                   ch = sc.next().toLowerCase();
                
                 switch(ch)
                 {
                    case "r":    
                             displayResult();
                          break;
                    case "q":
                            System.out.println("Succefully Logged out");    //after successful excecution of admin
                          break;
                          default:
                            System.out.println("Invalid choice");
                 }
            
               } while(!(ch.equalsIgnoreCase("Q")));
              
        }
              
}

//driver class
    public class Voting
    {	
    public static void main( String[] args )
    {
         int count=0;              //keeping track of votes
         int no_OfVoter=3;       //total no of voters
         Voters v=new Voters();
         SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");  
         Date date = new Date();  
	    
	    {
	        System.out.println("\t*************************");
	        System.out.println("\t******[VOTING SYSTEM]****");
	        System.out.println("\t*************************");
	       
	        
	    }
	    System.out.println("Voting Date and Time-  "+sdf.format(date)); //print date and time in format
	    System.out.println("[WELCOME TO LOKSABHA ELECTION 2020]\n----------------------");
     
   while(count<no_OfVoter)   // condition for voters
      {
        v.login();   //calling login method of voter class
        count++;  
      }
        v.admin();    ////calling admin method of voter class after reciving all votes
      
      System.out.println("\nPROJECT done by: [AMIT PAWAR(200940381011) and MAYANK DWIVEDI(200940381045)]");
    }
    }