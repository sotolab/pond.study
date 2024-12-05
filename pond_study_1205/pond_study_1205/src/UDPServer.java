import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
    public static void main(String[] args){
        DatagramSocket serverSocket = null;
        try{
            serverSocket = new DatagramSocket(9999);
            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[1024];
            while(true){
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);
                String sentence = new String(receivePacket.getData());
                System.out.println("RECEIVED: " + sentence);
                InetAddress IPAddress = receivePacket.getAddress();
                int port = receivePacket.getPort();
                String capitalizedSentence = "Thank you for connecting to " + serverSocket.getLocalSocketAddress();
                sendData = capitalizedSentence.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
                serverSocket.send(sendPacket);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(serverSocket != null){
                serverSocket.close();
            }
        }
    }
}
