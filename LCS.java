/*  Time Complexity -- O(m*n)
    where n,m-->lenght of both the strings...

    Space Complexity=O(n*m)
*/


import java.util.*;

public class LCS
{
    public static int lcs (char[]x,char []y,int n,int m)
    {
        // Array to store the length of commom subsequence...
        int l[][] = new int[n + 1][m + 1];
        
        for(int i=0;i<n+1;i++)
        {
            for (int j = 0; j < m+1; j++) {
                if (i == 0 || j == 0) {
                    l[i][j] = 0;
                } else if (x[i - 1] == y[j - 1]) {   // If the character matches ,length +=1
                    l[i][j] = 1 + l[i - 1][j - 1];
                } else {
                    //If the character do not match,it takes the max of upper row and left column
                    l[i][j] = Math.max(l[i][j - 1], l[i - 1][j]);
                }
                
            }
        }
        return l[n][m]; //last index holds the max. length of subsequence
        

    }

    public static void main(String []args)
    {
        Scanner s = new Scanner(System.in);
        String s1 = s.nextLine();
        String s2 = s.nextLine();
        int n = s1.length();
        int m = s2.length();
        System.out.println(lcs(s1.toCharArray(), s2.toCharArray(), n, m));
        s.close();
    }
}