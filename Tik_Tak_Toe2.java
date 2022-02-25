import java.io.*;
import java.util.*;
public class Tik_Tak_Toe2
{
    static String board[][];
    static int n;
    static int ko;
    static int b,x,y,comp;
    static Scanner sc=new Scanner(System.in);
    Tik_Tak_Toe2(int n)
    {
        this.n=  n;
        board=new String[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                board[i][j]="";
            }
        } 
    }

    static void display1() //displaying the positions(0-n) in matrix format
    {
        System.out.println();
        System.out.println();
        System.out.println();x=0;
        System.out.println("ALL THE POSITIONS ARE SHOWN. YOU NEED TO ENTER 'X' OR 'O' AT THE POSITIONS MARKED BY THE NUMBERS:");
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(j<n-1)
                {
                    if(x<=9)
                    {
                        System.out.print(x++ +"  |");
                    }
                    else
                    {
                        System.out.print(x++ +" |");
                    }
                }
                else
                    System.out.print(x++);

            }
            System.out.println();
            for(int k=0;k<n;k++)
            {
                if(i<n-1)
                    System.out.print("----");
            }
            System.out.println();
        }
    }

    static void display2()
    {
        int yi=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(j<n-1)
                {
                    if(yi<=9)
                        System.out.print(+yi++ +"  |");
                    else
                        System.out.print(yi++ +"  |");
                }
                else
                {
                    if((i*n+j%n)<10)
                        System.out.print(yi++ +"  ");
                    else
                        System.out.print(yi++ +"  ");
                }

            }
            if(n==5)
            {
                System.out.print("       ");
            }
            else if(n==7)
            {
                System.out.print("         ");
            }
            else
            {
                System.out.print("  ");
            }
            for(int j=0;j<n;j++)
            {
                if(j<n-1)
                {
                    System.out.print(board[i][j]+" |");
                }
                else
                    System.out.print(board[i][j]);
            }
            System.out.println();
            for(int k=0;k<n;k++)
            {
                if(i<n-1)
                    System.out.print("---");
            }
            if(n==5)
            {
                System.out.print("           ");
            }
            else if(n==7)    
            {
                System.out.print("              ");
            }
            else
            {
                System.out.print("   ");
            }
            for(int k=0;k<n;k++)
            {
                if(i<n-1)
                    System.out.print("---");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("_________________________________________________________");
    }

    static void UserVsUser()throws IOException
    {
        int count=n*n,draw=0;;
        System.out.println("                              USER_1 HAS TO ENTER 'X' AND USER2 HAS TO ENTER 'O'  ");
        System.out.println("                            ---------------------------------------------------------");
        int temp1=0;b=0;
        System.out.print("Enter user_1s name:");
        String user1=sc.next();
        System.out.print("Enter user_2s name:");
        String user2=sc.next();
        int user1win=0,user2win=0,total=0;
        while(count!=0)
        {
            if(b==0)
            {
                int temp2=0;int p=0;
                System.out.print("Enter "+user1+"'s choice of position : ");
                y=sc.nextInt();
                while (y<0 || y>=(n*n) ||board[y/n][y%n]=="O" ||(y<0) || y>=(n*n) ||board[y/n][y%n]=="X" )
                {
                    Scanner scan=new Scanner(System.in);
                    System.out.println("Please enter your move: ");
                    y = scan.nextInt();
                    if ((y>0 && y<=(n*n)&&board[y/n][y%n]!="O" )&&((y>0 )&& y<=(n*n)&&board[y/n][y%n]!="X" ))
                    {
                        break;
                    }
                }                            
                for(int i=0;i<n;i++)
                {
                    for(int j=0;j<n;j++)
                    {
                        if(p==y)
                            board[i][j]="X";
                        p++;
                    }
                }
                display2();count=count-1;++b;String usp="X";
                boolean chk=check(usp);
                user1win++;                
                if(chk==true)
                {                    
                    System.out.println(user1+" WINS!!");
                    double win=((double)user1win)/total*100;
                    System.out.println("WIN PREDICTION =" +win);
                    draw++;
                    break;
                }               
            }
            else
            {
                int temp2=0;int p=0;
                System.out.print("Enter "+user2+"'s choice of position : ");
                y=sc.nextInt();
                while ((y<0 || y>=(n*n) ||board[y/n][y%n]=="O" )||(y<0 || y>=(n*n) ||board[y/n][y%n]=="X" ))
                {
                    Scanner scan=new Scanner(System.in);
                    System.out.println("Please enter your move: ");
                    y = scan.nextInt();
                    if ((y>0 && y<=(n*n)&&board[y/n][y%n]!="O" )&&((y>0 )&& y<=(n*n)&&board[y/n][y%n]!="X" ))
                    {                               
                        break;
                    }
                }
                for(int i=0;i<n;i++)
                {
                    for(int j=0;j<n;j++)
                    {
                        if(p==y)
                            board[i][j]="O";
                        p++;
                    }
                }
                display2();
                --b;
                count=count-1;
                String usp="O";
                boolean chk=check(usp);
                user2win++;
                if(chk==true)
                {
                    System.out.println(user2+" WINS!!");
                    double win=((double)user2win/(double)total*100.0);
                    System.out.println("WIN PERCENTAGE ="+ win);
                    draw++;
                    break;
                }
            }
            total++;
        }
        if(draw==0)
            System.out.println("MATCH ENDED IN A DRAW!! TRY AGAIN ... :)");

                    
    }

    static void UserVsComputer()throws FileNotFoundException,IOException
    {
        int count=n*n,draw=0;
        System.out.println("                              USER_1 HAS TO ENTER 'X' AND COMPUTER HAS TO ENTER 'O'  ");
        System.out.println("                            ---------------------------------------------------------");
        int temp1=0;
        while(temp1!=1)
        {
            System.out.print("Enter 1 if user wants to enter 1st or 2 if the user wants the computer to enter 1st :");
            int choice=sc.nextInt();
            if(choice==1)
            {
                b=1;temp1++;
            }
            else if(choice==2)
            {
                b=0;temp1++;
            }
            else
            {
                System.out.println("WRONG INPUT !!");
            }
        }
        while(count!=0)
        {
            if(b==1)
            {
                System.out.println("USER'S TURN");
                int temp2=0;int p=0;
                System.out.print("Enter User_1's choice of position : ");
                y=sc.nextInt();
                while ((y<0 || y>=(n*n) ||(board[y/n][y%n]=="O")||(board[y/n][y%n]=="X")))
                {
                    Scanner scan=new Scanner(System.in);
                    System.out.println("Please enter your move: ");
                    y = scan.nextInt();
                    if((y>0 && y<(n*n)&&(board[y/n][y%n]!="O")&&(board[y/n][y%n]!="X")))
                    {                            
                        break;
                    }
                }    
                board[y/n][y%n]="X";
                display2();
                count=count-1;--b;String usp="X";
                boolean chk=check(usp);
                int e=0,w=0,t=0,G=0;
                if(chk==true)
                {
                    e=1;
                    G=1;
                    draw=1;
                    System.out.println("YOU WIN!!");
                }
                File tr=new File("TicTacToe.txt");
                if(tr.exists()==true)
                {
                    Scanner sc=new Scanner(new File("TicTacToe.txt"));
                    while(sc.hasNext()==true)
                    {
                        String to=sc.next();
                        String win=sc.next();
                        t=Integer.parseInt(to)+G;
                        w=Integer.parseInt(win);
                    }    
                }
                FileWriter fw =new FileWriter("TicTacToe.txt");
                BufferedWriter bw=new BufferedWriter(fw);
                PrintWriter pw=new PrintWriter(bw); 
                w=w+e;
                pw.println(t);
                pw.println(w);
                pw.close();
                bw.close();
                fw.close();

                if(G==1)
                {
                    double Z=w;
                    double Y=t;
                    double d=((Z/Y)*100);
                    System.out.println("WIN PERCENTAGE "+d);
                    break;
                }
            }
            else
            {
                System.out.println("COMPUTER'S TURN");
                String var="X";
                int pill=0;
                for(int j=0;j<n;j++)
                {
                    for(int i=0;i<n;i++)
                    { 
                        if(board[i][j]!="O"&&board[i][j]!="X" && pill!=1)
                        {
                            board[i][j]="O";
                            if(check("O")==true)
                            {
                                board[i][j]="O";
                                pill=1;
                            }
                            else
                            {
                                board[i][j]="";
                            }
                        }
                        if(board[i][j]!="O"&&board[i][j]!="X"&& pill!=1)
                        {
                            board[i][j]="X";
                            if(check("X")==true)
                            {
                                board[i][j]="O";
                                pill=1;
                            }
                            else
                            {
                                board[i][j]="";
                            }
                        }
                    }
                }
                for(int j=0;j<n;j++)
                {
                    for(int i=0;i<n;i++)
                    {   
                        if(board[i][j]!="O"&&board[i][j]!="X" & pill!=1)
                        {
                            if((i+1)<n && (j+1)<n)
                            {
                                if(board[i+1][j+1]=="X")
                                {
                                    board[i][j]="O";
                                    pill=1;
                                }
                            }
                            if((i-1)>=0 && (j-1)>=0)
                            {
                                if(board[i-1][j-1]=="X")
                                {
                                    board[i][j]="O";
                                    pill=1;                                            
                                }
                            }
                        }
                        if(board[i][j]!="O"&&board[i][j]!="X" & pill!=1)
                        {
                            if((i-1)>=0 && (j+1)<n)
                            {
                                if(board[i-1][j+1]=="X")
                                {
                                    board[i][j]="O";
                                    pill=1;
                                }
                            }
                            if((i+1)<n && (j-1)>=0)
                            {
                                if(board[i+1][j-1]=="X")
                                {
                                    board[i][j]="O";
                                    pill=1;
                                }
                            }
                        }
                        if(board[i][j]!="O"&&board[i][j]!="X" && pill!=1)
                        {     
                            if((j+1)<n)
                            {
                                if(board[i][j+1]=="X")
                                {
                                    board[i][j]="O";
                                    pill=1;
                                }
                            }
                            else if((i+1)<n)
                            {
                                if(board[i+1][j]=="X")
                                {
                                    board[i][j]="O";
                                    pill=1;
                                } 
                            }    
                        }
                        if(board[i][j]!="O"&&board[i][j]!="X" && pill!=1)
                        {     
                            if((j-1)>=0)
                            {
                                if(board[i][j-1]=="X")
                                {
                                    board[i][j]="O";
                                    pill=1;
                                }
                            }
                            else if((i-1)>=0)
                            {
                                if(board[i-1][j]=="X")
                                {
                                    board[i][j]="O";
                                    pill=1;
                                } 
                            }    
                        }
                    }
                } 
                if(pill==0)
                {
                    comp=(int)(Math.random()*((n*n)));
                    y = comp;
                    while ((y<0 || y>=(n*n) ||board[y/n][y%n]=="O"||board[y/n][y%n]=="X" ))
                    {                        
                        comp=(int)(Math.random()*((n*n)+1));
                        y = comp;
                        if((y>0 && y<(n*n)&&board[y/n][y%n]!="O"&&board[y/n][y%n]!="X" ))
                        {                            
                            break;
                        }
                    }     
                    board[y/n][y%n]="O";
                }
                display2();
                ++b;
                count=count-1;
                String usp="O";
                int t=0,w=0;
                boolean chk=check(usp);    
                int G=0;
                if(chk==true)
                {
                    System.out.println("COMPUTER WINS!!");
                    G=1;
                    draw=1;
                }
                File tr=new File("TicTacToe.txt");
                if(tr.exists()==true)
                {
                    Scanner sc=new Scanner(new File("TicTacToe.txt"));
                    while(sc.hasNext()==true)
                    {
                        String to=sc.next();
                        String win=sc.next();
                        t=Integer.parseInt(to)+G;
                        w=Integer.parseInt(win);
                    }    
                }
                FileWriter fw =new FileWriter("TicTacToe.txt");
                BufferedWriter bw=new BufferedWriter(fw);
                PrintWriter pw=new PrintWriter(bw);                
                pw.println(t);
                pw.println(w);
                pw.close();
                bw.close();
                fw.close();
                if(G==1)
                {
                    double Z=w;
                    double Y=t;
                    double d=((Z/Y)*100);
                    System.out.println("WIN PERCENTAGE "+d);
                    break;
                }
            }
        }
        if(draw==0)
        {
            int t=0,w=0;
            System.out.println("MATCH Ended in draw" );
            File tr=new File("TicTacToe.txt");
            if(tr.exists()==true)
            {
                Scanner sc=new Scanner(new File("TicTacToe.txt"));
                while(sc.hasNext()==true)
                {
                    String to=sc.next();
                    String win=sc.next();
                    t=Integer.parseInt(to)+1;
                    w=Integer.parseInt(win);
                }    
            }        
            FileWriter fw =new FileWriter("TicTacToe.txt");
            BufferedWriter bw=new BufferedWriter(fw);
            PrintWriter pw=new PrintWriter(bw);                
            pw.println(t);
            pw.println(w);
            pw.close();
            bw.close();
            fw.close();
            double Z=w;
            double Y=t;
            double d=((Z/Y)*100);                
            System.out.println("WIN PERCENTAGE "+d);                  
        }
    }

    static boolean check(String usp)
    {
        int i,row=0,col=0,chk=0,k=0;
        for(i=1;i<=(n*2)+2;i++)
        {
            if(i<=n)
            {
                chk=0;
                for(int j=0;j<n;j++)
                {
                    if(board[row][j]==usp)
                        chk++;
                }
                row++;
                if(chk==n)
                {
                    k++;
                    break;
                }

            }
            else if(i>n && i<=(n*2))
            {
                chk=0;
                for(int j=0;j<n;j++)
                {
                    if(board[j][col]==usp)
                        chk++;
                }                    
                col++;
                if(chk==n)
                {
                    k++;
                    break;
                }
            }
            else if(i==((n*2)+1))  //checking right diagonal
            {
                chk=0;
                for(int j=0;j<n;j++)
                {
                    if(board[j][j]==usp)
                        chk++;
                }
                if(chk==n)
                {
                    k++;
                    break;
                }
            }
            else
            {
                chk=0;int tem=(n-1);
                for(int j=0;j<n;j++)
                {
                    if(board[j][tem]==usp)
                        chk++;
                    tem--;
                }
                if(chk==n)
                {
                    k++;
                    break;
                }
            }
        }
        if(k==1)
        {
            return true;
        }
        else 
        {
            return false;
        }
    }

    static void main()throws IOException
    {        
        System.out.println("       ***    *     ***  ==*****  *        ==******   *********   ||*       *||  ==*****                                                                          ");
        System.out.println("        **    *    **    ||       *        ||         ||     ||   || *     * ||  ||                                                       ");
        System.out.println("         **   *   **     ==*****  *        ||         ||     ||   ||  *   *  ||  ==*****                                                    ");
        System.out.println("          **** ****      ||       *        ||         ||     ||   ||    *    ||  ||                                                       ");
        System.out.println("           **   **       ==*****  *******  ==******   *********   ||         ||  ==*****                                                                           ");
        System.out.println("                                                                                                         ");
        System.out.println("                                  ===========    *********                                                                      ");
        System.out.println("                                       ||        ||     ||                                                           ");
        System.out.println("                                       ||        ||     ||                                                           ");
        System.out.println("                                       ||        ||     ||                                                           ");
        System.out.println("                                       ||        *********                                                           ");
        System.out.println("                                                                                                         ");
        System.out.println("                                                                                                         ");
        System.out.println("  ===========  ||     *********   ==========   ******   *********    ==========  *********  ==*****                                                   ");
        System.out.println("       ||      ||     ||              ||      **    **  ||               ||      ||     ||  ||            ");
        System.out.println("       ||      ||     ||              ||      ********  ||               ||      ||     ||  ==*****                 ");
        System.out.println("       ||      ||     ||              ||      **    **  ||               ||      ||     ||  ||              ");
        System.out.println("       ||      ||     *********       ||      **    **  *********        ||      *********  ==*****              ");
        System.out.println("                                                                                                         ");
        System.out.println("                                                                                                         ");
        System.out.println("                              **********    ******   ||*       *||   ==*****                                                                                          ");
        System.out.println("                              **           **    **  || *     * ||   ||                                                                                   ");
        System.out.println("                              **    ****   ********  ||  *   *  ||   ==*****                                                                                      ");
        System.out.println("                              **      **   **    **  ||    *    ||   ||                                                                                     ");
        System.out.println("                              **********   **    **  ||         ||   ==*****                                                                                           ");
        System.out.println("                                                                                                         ");
        int q=1;
        while(q==1)
        {
            System.out.print("Enter 3 for 3X3 mode,5 for 5X5 mode and 7 for 7X7 mode:");
            int n=sc.nextInt();
            while(n!=3 && n!=5 && n!=7)
            {
                System.out.print("Enter 3 for 3X3 mode,5 for 5X5 mode and 7 for 7X7 mode:");
                n=sc.nextInt();
                if(n==3||n==5||n==7)
                {
                    break;
                }
            }
            Tik_Tak_Toe2 ob=new Tik_Tak_Toe2(n); 
            ob.display1();int temp1=0;

            while(temp1!=1)
            {
                System.out.print("ENTER 1 IF USER WANTS TO PLAY WITH ANOTHER USER ELSE 2 IF USER WANTS TO PLAY AGAINST COMPUTER :");
                int choice_init=sc.nextInt();
                if(choice_init==2)
                {
                    ob.UserVsComputer();temp1++;
                }
                else if(choice_init==1)
                {
                    ob.UserVsUser();temp1++;
                }
                else
                {
                    System.out.println("WRONG INPUT !!");
                    System.out.println("TRY AGAIN !!");
                }
            }
            System.out.println("TO PLAY THE GAME  AGAIN ENTER 1");
            System.out.println("TO QUIT THE GAME ENTER 2");
            q=sc.nextInt();
        }
    }
}