package game.tictac;

import java.util.HashSet;
import java.util.Scanner;

public class TicTacToe {
	
	static HashSet<Integer> iset=new HashSet<>();
	static HashSet<Integer> uset=new HashSet<>();
	
	public static void main(String[] args) {
		char[][] board= {
				{' ','|',' ','|',' '},
				{'-','|','-','|','-'},
				{' ','|',' ','|',' '},
				{'-','|','-','|','-'},
				{' ','|',' ','|',' '}
				
		};
		print_board(board);
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			System.out.println("Enter the values from 1-9");
			int ipos=sc.nextInt();
			while(iset.contains(ipos)|| uset.contains(ipos))
			{
				System.out.println("This is position is already taken");
				System.out.println("Retry! values from 1-9");
				ipos=sc.nextInt();				
			}
			playGame(board,ipos,"I");
			System.out.println();
			String res=winner();
			if(res.length()>0)
			{
				System.out.println(res);
				break;
			}
		
			
			int cpos=gen_random();
			while(iset.contains(cpos)|| uset.contains(cpos))
			{
			
				cpos=gen_random();
			}
			playGame(board,cpos,"U");
			res=winner();
			if(res.length()>0)
			{
				System.out.println(res);
				break;
			}
		}
	}
	
	

	private static String winner() {
		HashSet<Integer> r1=new HashSet<>();
		r1.add(1);r1.add(2);r1.add(3);
		HashSet<Integer> r2=new HashSet<>();
		r2.add(4);r2.add(5);r2.add(6);
		HashSet<Integer> r3=new HashSet<>();
		r3.add(7);r3.add(8);r3.add(9);
		HashSet<Integer>  c1=new HashSet<>();
		c1.add(1);c1.add(4);c1.add(7);
		HashSet<Integer>  c2=new HashSet<>();
		c2.add(2);c2.add(5);c2.add(8);
		HashSet<Integer>  c3=new HashSet<>();
		c3.add(3);c3.add(6);c3.add(9);
		HashSet<Integer> d1=new HashSet<>();
		d1.add(1);d1.add(5);d1.add(9);
		HashSet<Integer> d2=new HashSet<>();
		d2.add(3);d2.add(5);d2.add(7);
		
		HashSet<HashSet> set=new HashSet<HashSet>();
		set.add(r1);set.add(r2);set.add(r2);set.add(c1);
		set.add(c2);set.add(c3);set.add(d1);set.add(d2);
		
		for(HashSet ch : set)
		{
			if(iset.containsAll(ch))
			{
				return "Flawless Victory!";
			}else if(uset.containsAll(ch))
			{
				return "Crushed!";
			}
		}
		
		if(iset.size()+uset.size()==9)
		{
			return "A Perfect Balance!";
		}
		
		return "";
	}



	private static int gen_random() {
		int max=9,min=1;
		int range=max-min+1;
		int res=(int) (Math.random()*range+min);
		return res;
	}


	private static void print_board(char [][]board) {
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board[i].length;j++)
			{
			System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	public static void playGame(char[][] board,int pos,String user)
	{
		char sym='X';
		if(user.equals("I"))
		{
			sym='X';
			iset.add(pos);
		}else if(user.equals("U"))
		{
			sym='O';
			uset.add(pos);
		}
		switch(pos)
		{
		case 1:
			board[0][0]=sym;
			break;
		case 2:
			board[0][2]=sym;
			break;
		case 3:
			board[0][4]=sym;
			break;
		case 4:
			board[2][0]=sym;
			break;
		case 5:
			board[2][2]=sym;
			break;
		case 6:
			board[2][4]=sym;
			break;
		case 7:
			board[4][0]=sym;
			break;
		case 8:
			board[4][2]=sym;
			break;
		case 9:
			board[4][4]=sym;
			break;
			default:
				System.out.println("Please Invalid input");
		}
		print_board(board);
	}

}
