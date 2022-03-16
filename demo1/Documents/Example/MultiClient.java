import java.net.Socket;
import java.util.Scanner;
import java.io.PrintStream;

class MultiClient{
	public static void main(String args[]){
		try(Socket s = new Socket("localhost",8080)){
			Scanner sc = new Scanner(s.getInputStream());
			PrintStream p = new PrintStream(s.getOutputStream());
			Scanner input = new Scanner(System.in);
			String str;
			String ClientName = "empty";
	
			do{
				if(ClientName.equals("empty")){
					System.out.println("Enter your name:");
					str = input.nextLine(); 
					ClientName = str;
					p.println("["+ClientName+" connected]");
				}
				else{
					str=input.nextLine();
					if(str.equals("exit")){
						p.println("["+ClientName+" "+str+"ed]");
						break;
					}
					p.println("["+ClientName+"] "+str);
				}	
			} while(!str.equals("exit"));
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}


