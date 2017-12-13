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
class Bitstuff_Send
{    
    public static void main(String args[])throws Exception
    {  String z="";
        try
        {   
           Socket clientSock=new Socket("localhost",1111);
		System.out.println("Client connected to server");
                String f="F:\\dpk.txt";
                BufferedReader in1 = new BufferedReader(new FileReader(f));
                OutputStream ostream=clientSock.getOutputStream();
		PrintWriter pwrite=new PrintWriter(ostream,true);
		
            
            int i,count=0;
             String output="";
         
            String s=in1.readLine();
            
            in1.close();
           
            StringBuffer stb=new StringBuffer(s);
            
             
            for(i=0;i<stb.length();i++)
            {
             
              if(stb.charAt(i)=='1')
              {
                  count++;
                  if(count==5)
                  {
                      
                       stb.insert(i+1,'0');  
                       count=0;
                  }
                  
              }
              else{
                  count=0;  
              }
       
             }
            
               output=new String(stb);

            int p=output.length();
            
            pwrite.println(output);
            
             
        }
        catch (Exception e)  {            
              System.out.println(e);             
        }   
    }
}

