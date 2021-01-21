import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class Client implements Runnable{
    private BufferedWriter writer;
    private BufferedReader reader;
    ArrayList <Client> clients;
    String clientData;

    Client(Socket socket, ArrayList<Client> clients){
        try {
            OutputStreamWriter o = new OutputStreamWriter(socket.getOutputStream());
            writer = new BufferedWriter(o);

            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            reader = new BufferedReader(isr);

            this.clients = clients;
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
                while ((clientData = reader.readLine()) != null){
                    System.out.println(clientData);
                    try{
                            for(Client client: clients){
                                synchronized (client.writer) {
                                        client.writer.write(clientData + "\n");
                                        client.writer.flush();
                                }
                            }
                            clientData = reader.readLine();

                    }catch (IOException e){

                    }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

}
