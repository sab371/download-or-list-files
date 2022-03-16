import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.util.Scanner;
import java.net.InetAddress;

class UDPClient{
	public static void main(String args[]) throws Exception{
		DatagramSocket ds = new DatagramSocket();
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		InetAddress ia=InetAddress.getLocalHost();
		while(str!=null){
			byte[] b= (str).getBytes();
			DatagramPacket dp = new DatagramPacket(b,b.length,ia,8080);
			ds.send(dp);
			str = in.nextLine();
		}
		ds.close();
	}
}
