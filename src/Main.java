import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
         try {
             ServerSocket server = new ServerSocket(8080);
             ArrayList<Client> clients = new ArrayList<>();

             while (true) {
                 try {
                     Socket socket = server.accept();
                     System.out.println("Connected.");
                     Client client = new Client(socket, clients);
                     clients.add(client);
                     Thread clientThread = new Thread(client);
                     clientThread.start();

                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }
         } catch (IOException e) {
             e.printStackTrace();
         }
    }
}
//import java.io.*;
//import java.net.ServerSocket;
//import java.net.Socket;
//
//
//public class Main {
//    public static void main(String[] args) {
//        String clientData = "";
//        String clientDatas = "";
//        int r=0,g=0,b=0;
//        BufferedWriter writer;
//        BufferedReader reader;
//        try{
//            ServerSocket serverSocket = new ServerSocket(8080);
//            Socket socket = serverSocket.accept();
//            System.out.println("Connected.");
//
//            OutputStreamWriter o = new OutputStreamWriter(socket.getOutputStream());
//            writer = new BufferedWriter(o);
//
//            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
//            reader = new BufferedReader(isr);
//
//            String data;
//            //StringBuilder history = new StringBuilder();
//            while ((data = reader.readLine()) != null){
//                System.out.println(data);
//                try {
//                    if (data.equals("play")) {
//                        for (int i=0;i<4;i++) {
//                            r = (int) Math.floor(Math.random() * 256);
//                            g = (int) Math.floor(Math.random() * 256);
//                            b = (int) Math.floor(Math.random() * 256);
//                            clientDatas =clientDatas + r + " " + g + " " + b + " ";
//                        }
//                        System.out.println(clientDatas);
//                        writer.write(clientDatas);
//                        writer.flush();
//                        writer.write("<eof>\n");
//                        writer.flush();
//                        clientDatas = "";
//
//
//                    }
////                    else if (data.equals("sub")) {
////                        String a = reader.readLine();
////                        String b = reader.readLine();
////
////                        double d1 = Double.parseDouble(a);
////                        double d2 = Double.parseDouble(b);
////
////                        String res = (d1 - d2) + "\n";
////
////                        //history.append(a).append(" - ").append(b).append(" = ").append(res);
////
////                        writer.write(res);
////                        writer.flush();
////                    }
////                    else if (data.equals("mult")) {
////                        String a = reader.readLine();
////                        String b = reader.readLine();
////
////                        double d1 = Double.parseDouble(a);
////                        double d2 = Double.parseDouble(b);
////
////                        String res = (d1 * d2) + "\n";
////
////                        //history.append(a).append(" * ").append(b).append(" = ").append(res);
////
////                        writer.write(res);
////                        writer.flush();
////                    }
////                    else if (data.equals("div")) {
////                        String a = reader.readLine();
////                        String b = reader.readLine();
////
////                        double d1 = Double.parseDouble(a);
////                        double d2 = Double.parseDouble(b);
////
////                        String res = (d1 / d2) + "\n";
////
////                        //history.append(a).append(" / ").append(b).append(" = ").append(res);
////
////                        writer.write(res);
////                        writer.flush();
////                    }
////                    else if (data.equals("history")) {
////                        //String curHistory = history.toString();
////                        //writer.write(curHistory + "<eof>\n");
////                        writer.flush();
////                    }
//                }
//                catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
//
//            writer.close();
//            reader.close();
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }
//    }
//}