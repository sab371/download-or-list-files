import java.net.DatagramPacket;
import java.net.DatagramSocket;

class UDPServer{
	public static void main(String args[]) throws Exception{
		DatagramSocket ds = new DatagramSocket(8080);
		while(true){
			byte b[] = new byte[1024];
			DatagramPacket dp = new DatagramPacket(b,b.length);
			ds.receive(dp);
			String temp = new String(dp.getData());
			if(temp == null)
				break;
			System.out.println(temp);
			
		}
		ds.close();
	}
}
