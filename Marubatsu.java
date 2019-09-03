import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class Marubatsu{
	public static void main(String args[]) {
		String place[][] = new String[3][3];
		for(String[] x: place){
	    	Arrays.fill(x, " ");
		}
		int loop_number = 0;
		String mark ="";
		do{
			if(loop_number%2 == 0){
				mark ="@";
			}else{
				mark ="*";
			}
			if(loop_number%2 == 0){
				put_marubatsu(mark,place);
			}else{
				put_marubatsu_automatic(mark,place);
			}
			show_marubatsu(mark,place);
			loop_number++;
		}while(judge(mark,place));
	}

	static void put_marubatsu(String mark,String place[][]){
		Scanner scan = new Scanner(System.in);
		System.out.println(mark +"をどこに置きますか? ") ;
		int vertical = scan.nextInt()-1;
		int horizontal = scan.nextInt()-1;
		while ( vertical<0 || vertical >2 || horizontal<0 || horizontal > 2 || place[vertical][horizontal] != " " ){
			System.out.println("もう一度おいてください ") ;
			vertical = scan.nextInt()-1;
			horizontal = scan.nextInt()-1;
		}
		place[vertical][horizontal] = mark ;
	}
	static void put_marubatsu_automatic(String mark,String place[][]){
		System.out.println();
		System.out.println("コンピューターの番です");
		Random random = new Random();
		int vertical ;
		int horizontal ;
		do{
		vertical  = random.nextInt(3);
		horizontal = random.nextInt(3);
		}while ( place[vertical][horizontal] != " " );
		place[vertical][horizontal] = mark ;
	}
	static void show_marubatsu(String mark,String place[][]){
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
			System.out.print("|"+ place[i][j]);
			}
			System.out.println("|");
		}
	}
	static boolean judge(String mark,String place[][]){
		for(int i=0;i<3;i++){
			if(place[i][0]==  mark &&place[i][1] == mark &&place[i][2] == mark ){
				System.out.println(mark+ "の勝ちです") ;
				return false;
			}
			if(place[0][i]==  mark &&place[1][i] == mark &&place[2][i] == mark ){
				System.out.println(mark+ "の勝ちです") ;
				return false;
			}
		}
		if(place[0][0]== mark &&place[1][1] == mark &&place[2][2] == mark ){
			System.out.println(mark + "の勝ちです") ;
			return false;
		}
		if(place[0][2]== mark &&place[1][1] == mark &&place[2][0] == mark ){
			System.out.println(mark + "の勝ちです") ;
			return false;
		}

		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(place[i][j] == " "){
					return true;
				}
			}
		}
		System.out.println("あいこです") ;
		return false;
	}
}
