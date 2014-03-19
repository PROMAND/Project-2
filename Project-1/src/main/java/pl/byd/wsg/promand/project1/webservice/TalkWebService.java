package pl.byd.wsg.promand.project1.webservice;


//import java.io.PrintWriter;
//import java.net.Socket;

import pl.byd.wsg.promand.project1.domain.list.TalkList;

public class TalkWebService {

    //having some variable
    private TalkList talkList = new TalkList();

    //construtor

    public TalkWebService(TalkList talkList) {
        this.talkList = talkList;
    }

   /* public void getTalk(){
    Socket socket = new Socket("beta-promand.rhcloud.com", 3000);
    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
    System.out.println("test");
    socket.close();

    }
    //get
*/

}
