package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import shared.ProtocolStrings;

public class EchoClient
{
  Socket socket;
  private int port;
  private InetAddress serverAddress;
  private Scanner input;
  private PrintWriter output;
  public boolean stopped = true;
  
  public void connect(String address, int port) throws UnknownHostException, IOException
  {
    this.port = port;
    serverAddress = InetAddress.getByName(address);
    socket = new Socket(serverAddress, port);
    input = new Scanner(socket.getInputStream());
    output = new PrintWriter(socket.getOutputStream(), true);  //Set to true, to get auto flush behaviour
    stopped = false;
  }
  
  public void send(String msg)
  {
    output.println(msg);
  }
  
  public void stop() throws IOException{
    output.println(ProtocolStrings.STOP);
    stopped = true;
  }
  
  public boolean isStopped() {
      if(stopped = true) {
          System.out.println("The server is stopped");
      } else {
          System.out.println("The server is not online");
      }
      return false;
  }
  
  public String receive()
  {
    String msg = input.nextLine();
    if(msg.equals(ProtocolStrings.STOP)){
      try {
        socket.close();
      } catch (IOException ex) {
        Logger.getLogger(EchoClient.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    return msg;
  }
  
  public static void main(String[] args)
  {   
    int port = 7777;
    String ip = "localhost";
    if(args.length == 2){
      ip = args[0];
      port = Integer.parseInt(args[1]);
    }
    try {
      EchoClient tester = new EchoClient();      
      tester.connect(ip, port);
      System.out.println("Sending 'Hello world'");
      tester.send("Hello World");
      System.out.println("Waiting for a reply");
      System.out.println("Received: " + tester.receive()); //Important Blocking call         
      tester.stop();      
      //System.in.read();      
    } catch (UnknownHostException ex) {
      Logger.getLogger(EchoClient.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(EchoClient.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}