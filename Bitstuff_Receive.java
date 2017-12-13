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
import java.util.*;
import  java.lang.*;  
import java.net.*;
class Bitstuff_Receive
{       
 public static void main(String args[]) 
   {         
          int count=0,i=0; 
  try
  {   ServerSocket serverSock=new ServerSocket(1111);
  System.out.println("waiting for client.....................");
			Socket socket=serverSock.accept();
			System.out.println("client connected....");
            PrintStream pw= new PrintStream(socket.getOutputStream()); 
            InputStream istream=socket.getInputStream();
            BufferedReader receiveRead=new BufferedReader(new InputStreamReader(istream));
            
            String s1=receiveRead.readLine();
            StringBuffer stb1=new StringBuffer(s1);
            System.out.println("stuffed bits" +s1);
            int len=stb1.length();
            while(i<len-1)
            {
                               
               if(stb1.charAt(i)=='1')
              {
                  count++;
                  if(count==5)
                  {
                       stb1.deleteCharAt(i+1);
                       count=0;
                  }
                  
              }
              else
                  count=0;
       
                i++; 
             }
            System.out.println("unstuffed bits" +stb1);
                
  }     
  catch (Exception e) 
        {
            System.out.println(e);
  }
}
}

