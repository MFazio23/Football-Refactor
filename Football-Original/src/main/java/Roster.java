import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class Roster{

    private String[] qb=new String[3],wr1=new String[3],wr2=new String[3],wr3=new String[3],rb1=new String[3],rb2=new String[3],te=new String[3],k=new String[3],def=new String[2];
    
    public Roster(String filename){
    try{
        StringTokenizer token;
        BufferedReader reader=new BufferedReader(new FileReader(filename));
        String input = reader.readLine();
        token= new StringTokenizer(input,":");
        token.nextToken();
        qb[0]=token.nextToken();
        qb[1]=token.nextToken();
        qb[2]=token.nextToken();
        input = reader.readLine();
        token= new StringTokenizer(input,":");
        token.nextToken();
        wr1[0]=token.nextToken();
        wr1[1]=token.nextToken();
        wr1[2]=token.nextToken();
        input = reader.readLine();
        token= new StringTokenizer(input,":");
        token.nextToken();
        wr2[0]=token.nextToken();
        wr2[1]=token.nextToken();
        wr2[2]=token.nextToken();
        input = reader.readLine();
        token= new StringTokenizer(input,":");
        token.nextToken();
        wr3[0]=token.nextToken();
        wr3[1]=token.nextToken();
        wr3[2]=token.nextToken();
        input = reader.readLine();
        token= new StringTokenizer(input,":");
        token.nextToken();
        rb1[0]=token.nextToken();
        rb1[1]=token.nextToken();
        rb1[2]=token.nextToken();
        input = reader.readLine();
        token= new StringTokenizer(input,":");
        token.nextToken();
        rb2[0]=token.nextToken();
        rb2[1]=token.nextToken();
        rb2[2]=token.nextToken();
        input = reader.readLine();
        token= new StringTokenizer(input,":");
        token.nextToken();
        te[0]=token.nextToken();
        te[1]=token.nextToken();
        te[2]=token.nextToken();
        input = reader.readLine();
        token= new StringTokenizer(input,":");
        token.nextToken();
        k[0]=token.nextToken();
        k[1]=token.nextToken();
        k[2]=token.nextToken();
        input = reader.readLine();
        token= new StringTokenizer(input,":");
        token.nextToken();
        def[0]=token.nextToken();
        def[1]=token.nextToken();
    }
    
    catch(IOException e){
            System.out.println("Error");    }
}

    public String[] getQB(){
        return qb;
    }
    
    public String[] getWR1(){
        return wr1;
    }
    
    public String[] getWR2(){
        return wr2;
    }
    
    public String[] getWR3(){
        return wr3;
    }
    
    public String[] getRB1(){
        return rb1;
    }
    
    public String[] getRB2(){
        return rb2;
    }
    
    public String[] getTE(){
        return te;
    }
    
    public String[] getK(){
        return k;
    }
    
    public String[] getDEF(){
        return def;
    }
}