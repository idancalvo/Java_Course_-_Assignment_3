/*
* Dividing Numbers by characteristic strings
*/
public class NumberPartition{

    /*
	* Check if a characteristic string defines a partition 
    * of the numbers 1...n  such that:
    * (1) both sides are of equal length
    * (2) both sides are of equal sum
    * (3) both sides have equal sums of squared elements.
    * returns false if arguments are null / "incorrect"
	*/
    
	public static boolean isNumberPartition(int n, String s){

		boolean ans=false;
		int Amount=0; /*Checking if the number of elements equal*/
		int Sum=0; /*Checking if the sum of elements equal*/
		int SumSquare=0; /*Checking if the Sum Square of elements equal*/
		
		if (s!=null && s.length()>0){/*Checking if the string is not null */
			if (n==s.length()){/*Checks the string length suitable to n*/
				for (int i =1;i<=n;i=i+1){ /*loop index on the string */
					if(s.charAt(i-1)=='0'){/*Checking if the element is zero*/
						Amount=Amount+1;
						Sum=Sum+i;
						SumSquare=SumSquare+(i*i);
					}
					if(s.charAt(i-1)=='1'){/*Checking if the element is one*/
						Amount=Amount-1;
						Sum=Sum-i;
						SumSquare=SumSquare-(i*i);
					}
					if (s.charAt(i-1)!='0'&s.charAt(i-1)!='1'){/*Checking if the element is not standard (!0&!1)*/
						i=n+1;/*promote the index to exit the loop*/
						Amount=1;/*factor to unbalance*/
					}
				}
				if(Amount==0&Sum==0&SumSquare==0){ /*checking if the string Meet the criteria */
					ans=true;
				}
			}
		}
		return ans;
	}

 // Get a Number n and print all the characteristic string that are Number Partition
    public static void numberPartition(int n){
		if (n<0){
			throw new RuntimeException(); /*If the value is not right pop error*/
		}
    	String s ="";
		if (n%2==0){ /*Initial screening - Did he odd*/
			numberPartition(n,s);
		}
    }
	
// Checking the characteristic string and n
    private static void numberPartition(int n,String s){
    	if (n<0){
			throw new RuntimeException(); /*If the value is not right pop error*/
    	}
    	if (n==0){/*Breakpoint condition- the string reached the desired size*/
    		int n2=n+s.length();
			if (isNumberPartition(n2,s)){ /*Checking if the string is "Great string" */
				System.out.println(s);
			}		
		}
		if (n>0){ /*2 Recursive call  that build all the strings in size n*/
			numberPartition(n-1,s+'0');
			numberPartition(n-1,s+'1');
		}
    }
}
