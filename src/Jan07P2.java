import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
class Jan07P2 {
	
	public static void main(String[]args) throws IOException{
		File file = new File("DATA21.txt");
		Scanner scanner = new Scanner(file);
		String line = scanner.nextLine();
		String [] dimen = line.split(" ");
		int[] dimensions = {Integer.parseInt(dimen[0]), 
				Integer.parseInt(dimen[1])};
		char [][] grid = new char[dimensions[0]][dimensions[1]];
		int [][] abcde = new int [5][3];
		for(int i = 0; i < dimensions[0]; i++){
			grid[i] = scanner.nextLine().toCharArray();
			for(int j = 0; j < dimensions[1]; j++){
				switch(grid[i][j]){
				case 'a':
					abcde[0][0] = i;
					abcde[0][1] = j;
					break;
				case 'b':
					abcde[1][0] = i;
					abcde[1][1] = j;
					break;
				case 'c':
					abcde[2][0] = i;
					abcde[2][1] = j;
					break;
				case 'd':
					abcde[3][0] = i;
					abcde[3][1] = j;
					break;
				case 'e':
					abcde[4][0] = i;
					abcde[4][1] = j;
					break;
				}
				
			}
		}
		scanner.close();
		file = new File("OUT21.txt");
			BufferedWriter write = new BufferedWriter(new FileWriter(file));
		for(int k = 0; k < 5; k++){
			//5 letters
			for(int i = 0; i < 3; i++){
				for(int j = 0; j < 3; j++){
					try{
						if(grid[abcde[k][0] + i - 1][abcde[k][1] + j - 1] == '*'){
							abcde[k][2]++;
						}
					}catch(ArrayIndexOutOfBoundsException a){
						
					}
				}
			}
			write.write(grid[abcde[k][0]][abcde[k][1]] + "-" +abcde[k][2] + "\n");
		}
		
		write.close();
		
	}
}
