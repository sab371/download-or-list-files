import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.io.PrintStream;
//import java.util.ArrayList;

class MultiServer{
	public static void main(String args[]){
		try(ServerSocket ss = new ServerSocket(8080)){
			while(true){
				Socket s = ss.accept();
				ServerThread st = new ServerThread(s);
				st.start();
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}

class ServerThread extends Thread{
	private Socket s;
	private Scanner in;
	private PrintStream p;
	public ServerThread(Socket s) throws Exception{
		this.s=s;
	}
	public void run(){
		try{
			in = new Scanner(s.getInputStream());
			p = new PrintStream(s.getOutputStream());
			while(true){	
				String str = in.nextLine();
				if(str.contains("exit")){
					System.out.println(str);
					s.close();
					break;
				}
				else{
					System.out.println(str);
				}
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
