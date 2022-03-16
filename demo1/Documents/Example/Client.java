import java.net.Socket;
import java.util.Scanner;
import java.io.PrintStream;

public class Client{
	public static void main(String args[]){
		try(Socket socket = new Socket(args[0],Integer.parseInt(args[1]));
			Scanner input = new Scanner(System.in);
			Scanner sc = new Scanner(socket.getInputStream());
			PrintStream p = new PrintStream(socket.getOutputStream())){
			String str;
			System.out.println("Enter your name:");
			String name = input.nextLine();
			p.println("["+name+" connected]");
			str=input.nextLine();
			while(str!=null){
				if(str.equals("exit")){
					p.println("["+name+" "+str+"ed]");
					break;
				}
				p.println("["+name+"] "+str);
				//str=sc.nextLine();
				//System.out.println(str);
				str=input.nextLine();
			}
			p.close();
			socket.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
