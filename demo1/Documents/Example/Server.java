import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.io.PrintStream;

public class Server{
	public static void main(String args[]){
		try(ServerSocket ss = new ServerSocket(8080);
			Socket s = ss.accept();
			Scanner sc = new Scanner(s.getInputStream());
			PrintStream p = new PrintStream(s.getOutputStream())){
			
			String name = sc.nextLine();
			
			String str = sc.nextLine();
			if(str.equalsIgnoreCase("hii")){
				p.println("hii, "+name);
			}
			str = sc.nextLine();
			while(str!=null){
				p.println("("+name+") "+"message received");
				System.out.println(str);
				str = sc.nextLine();
			}
			//s.close();
			//ss.close();
			System.out.println("connection closed");	
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
