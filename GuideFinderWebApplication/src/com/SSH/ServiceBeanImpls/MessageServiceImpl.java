package com.SSH.ServiceBeanImpls;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.SSH.ServiceBeans.MessageService;

public class MessageServiceImpl implements MessageService {
	
	@Override
	public void addMessage(String sender, String receiver, String content, Date sendTime,String path) {
		// TODO Auto-generated method stub	
		try {
			makeDir(path);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path, true)))){
			out.println(sender + "-" + receiver + "-" +content + "-" +sendTime);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	

	@Override
	public String readMessage(String receiver,String path) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("<Lists>");
		try {
			makeDir(path);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try{
			FileReader read = new FileReader(path);
			BufferedReader in = new BufferedReader(read);
			String message;
			String[] buf = new String[4];
			
			while((message = in.readLine())!= null){
				buf = message.split("-");
				if(buf[1].equals(receiver)){
					//System.out.println(buf[2]);
					sb.append("<sender>");
					sb.append(buf[0]);
					sb.append("</sender>");
					sb.append("<app_content>");
					sb.append(buf[2]);
					sb.append("</app_content>");
					sb.append("<sendTime>");
					sb.append(buf[3]);
					sb.append("</sendTime>");
				}
			}
			sb.append("</Lists>");
			
			in.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		 //System.out.println(sb.toString());
		return sb.toString();
	}

	@Override
	public String getMessage(String receiver, String sender, String path) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("<Lists>");
		try {
			makeDir(path);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try{
			FileReader read = new FileReader(path);
			BufferedReader in = new BufferedReader(read);
			String message;
			String[] buf = new String[4];
			
			while((message = in.readLine())!= null){
				buf = message.split("-");
				if(buf[0].equals(sender)&&buf[1].equals(receiver)){
					sb.append("<sender>");
					sb.append(buf[0]);
					sb.append("</sender>");
					sb.append("<app_content>");
					sb.append(buf[2]);
					sb.append("</app_content>");
					sb.append("<sendTime>");
					sb.append(buf[3]);
					sb.append("</sendTime>");
				}
			}
			sb.append("</Lists>");
			
			in.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	private void makeDir(String path) throws IOException{
		File file=new File(path);
		if(!file.isFile()||!file.exists()){
			FileOutputStream fileout=new FileOutputStream(file);
			fileout.write("".getBytes());
			fileout.flush();
			fileout.close();
		}
	}


	@Override
	public List<String> androidreadMessage(String receiver, String path) {
		List<String> msgls= new ArrayList<String>();
		
		try {
			makeDir(path);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try{
			FileReader read = new FileReader(path);
			BufferedReader in = new BufferedReader(read);
			String message;
			String[] buf = new String[4];
			
			while((message = in.readLine())!= null){
				StringBuffer sb = new StringBuffer();
				buf = message.split("-");
				if(buf[1].equals(receiver)){
					sb.append(buf[0]+": "+buf[2]+"   "+buf[3]);
					msgls.add(sb.toString());
				}
			}
			in.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		return msgls;
	}


	@Override
	public List<String> androidgetMessage(String receiver, String sender,
			String path) {
		List<String> msgls= new ArrayList<String>();
			
			try {
				makeDir(path);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try{
				FileReader read = new FileReader(path);
				BufferedReader in = new BufferedReader(read);
				String message;
				String[] buf = new String[4];
				
				while((message = in.readLine())!= null){
					StringBuffer sb = new StringBuffer();
					buf = message.split("-");
					if(buf[0].equals(sender)&&buf[1].equals(receiver)){
						sb.append(buf[0]+": "+buf[2]+"   "+buf[3]);
						msgls.add(sb.toString());
					}
				}
				in.close();
			}catch(IOException e){
				e.printStackTrace();
			}
			return msgls;
	}

}
