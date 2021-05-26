import java.util.Random;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

class MyRandom{
	static int numOfChars;

	MyRandom(int x){
		numOfChars = x;
	}

	public static int getRandomNumber(){
		Random rand = new Random();
		return rand.nextInt(100);
	}

	public static char getRandomChar(){
		Random rand = new Random();
		return (char) (rand.nextInt(26) + 65);
	}

	public static void writeToFile(){
		try{
			FileWriter fw = new FileWriter(new File("output.txt"));
			for(int i = 0; i < numOfChars; i++){
				int temp = getRandomNumber();
				if(temp < 20 && temp >= 0){
					fw.write("\n");
				}else if(temp >= 20 && temp < 50){
					fw.write(" ");
				} else{
					fw.write(getRandomChar());
				}
			}
			fw.close();
		}catch(IOException e){
			System.out.println(e);
		}

	}
	public static void main(String[] args){
		MyRandom a = new MyRandom(Integer.parseInt(args[0]));
		a.writeToFile();
	}
}