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
import java.util.*;
public class ManchesterClient
{	public static void main(String[] args)throws IOException
	{	Socket clientSock=new Socket("localhost",1111);
		System.out.println("Client connected to server");
		BufferedReader keyRead=new BufferedReader(new InputStreamReader(System.in));
		OutputStream ostream=clientSock.getOutputStream();
		PrintWriter pwrite=new PrintWriter(ostream,true);
		InputStream istream=clientSock.getInputStream();
		BufferedReader receiveRead=new BufferedReader(new InputStreamReader(istream));
		String receiveMessage, sendMessage,sm;
		char m[]=new char[100];
		while(true)
		{	String r=new String("");
			r=keyRead.readLine();
			sendMessage=r;
			if(r.equals("disconnect"))
			{	pwrite.println(r);
				break;
			}
			char[] c=sendMessage.toCharArray();
			int j=0;
			for(int i=0;i<c.length;i++)
			{	if(c[i]=='0')
				{	m[j]='0';
					m[j+1]='1';
					j=j+2;
				}
				else
				{	m[j]='1';
					m[j+1]='0';
					j=j+2;
				}
			}
			String sendMessage1=new String(m);
			sendMessage1=String.valueOf(m);
			pwrite.println(sendMessage1);
			System.out.flush();
			if((receiveMessage=receiveRead.readLine())!=null)
			{	System.out.println(receiveMessage);
			}
			if(sendMessage.equals("disconnect"))
			{	break;
			}
		}
	}
}

