/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kpsomani2
 */
import java.io.*;
import java.net.*;
import java.lang.*;
class ManchesterServer
{	public static void main(String[] args) throws IOException
	{	ServerSocket serverSock=new ServerSocket(1111);
		while(true)
		{	System.out.println("waiting for client.....................");
			Socket socket=serverSock.accept();
			System.out.println("client connected....");
			BufferedReader keyRead=new BufferedReader(new InputStreamReader(System.in));
			OutputStream ostream=socket.getOutputStream();
			PrintWriter pw=new PrintWriter(ostream,true);
			InputStream istream=socket.getInputStream();
			BufferedReader receiveRead=new BufferedReader(new InputStreamReader(istream));
			String receiveMessage,sendMessage,receiveMessage1,rm;
			char[] m=new char[100];
			while (true)
			{	if((receiveMessage=receiveRead.readLine())!=null)
				{	rm=receiveMessage;
					if(receiveMessage.equals("bye"))
					{	System.out.println("client>"+receiveMessage);
						break;
					}
					System.out.println("coded message>"+receiveMessage);
					char []c=receiveMessage.toCharArray();
					int j=0;
					for(int i=0;i<c.length;i=i+2)
					{	if(c[i]=='0'&&c[i+1]=='1')
						{	m[j++]='0';
						}
						else if(c[i]=='1'&&c[i+1]=='0')
						{	m[j++]='1';
						}
					}
				}
				receiveMessage1=new String(m);
				receiveMessage1=String.valueOf(m);
				System.out.println("actual Message:>"+receiveMessage1);
				sendMessage=keyRead.readLine();
				pw.println(sendMessage);
				System.out.flush();
				if(sendMessage.equals("disconnect"))
				{	break;
				}
			}
		}
	}
}

