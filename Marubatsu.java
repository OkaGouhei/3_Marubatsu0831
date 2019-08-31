import java.util.Scanner;
public class Marubatsu{
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		String place[][] = new String[3][3];
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				place[i][j] =" ";
			}
		}
		int roop_number = 0;
		String mark ="";
		loop:do{
			if(roop_number%2 == 0){
				mark ="@";
			}else{
				mark ="*";
			}
			System.out.println(mark +"をどこに置きますか? ") ;
			int vertical = scan.nextInt();
			vertical--;
			int horizontal = scan.nextInt();
			horizontal--;
			while ( vertical<0 || vertical >2 || horizontal<0 || horizontal > 2 || place[vertical][horizontal] != " " ){
				System.out.println("もう一度おいてください ") ;
				vertical = scan.nextInt();
				vertical--;
				horizontal = scan.nextInt();
				horizontal--;
			}
			place[vertical][horizontal] = mark ;
    	for(int i=0;i<3;i++){
	    	for(int j=0;j<3;j++){
		    	System.out.print("|"+ place[i][j]);
	    	}
		    System.out.println("|");
			}
			roop_number++;
			for(int i=0;i<3;i++){
				if(place[i][0]==  mark &&place[i][1] == mark &&place[i][2] == mark ){
					System.out.println(mark+ "の勝ちです") ;
					break loop;
				}
				if(place[0][i]==  mark &&place[1][i] == mark &&place[2][i] == mark ){
					System.out.println(mark+ "の勝ちです") ;
					break loop;
				}
			}
			if(place[0][0]== mark &&place[1][1] == mark &&place[2][2] == mark ){
				System.out.println(mark + "の勝ちです") ;
				break ;
			}
			if(place[0][2]== mark &&place[1][1] == mark &&place[2][0] == mark ){
				System.out.println(mark + "の勝ちです") ;
				break ;
			}
			for(int i=0;i<3;i++){
				for(int j=0;j<3;j++){
					if(place[i][j] == " "){
						continue loop;
					}
				}
			}
			System.out.println("あいこです") ;
			break ;
		}while(true);
	}
}
