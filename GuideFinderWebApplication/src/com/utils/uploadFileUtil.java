package com.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class uploadFileUtil {
	public static void  upload(File file,String filename,String root,String subroot) throws IOException{
		
		mkdir(root,subroot);
		InputStream is=new FileInputStream(file);
		File desfile=new File(root+subroot+"/",filename);
		
		OutputStream os=new FileOutputStream(desfile);
		byte[] buffer=new byte[400];
		int length=0;
		while((length=is.read(buffer))>0){
			os.write(buffer, 0, length);
			
		}
		is.close();
		os.close();
		
	}
public static void  upload(File file,String filename,String root,String subroot,String subsubroot) throws IOException{
		
		mkdir(root,subroot,subsubroot);
		InputStream is=new FileInputStream(file);
		File desfile=new File(root+subroot+"/"+subsubroot+"/"+filename);
		
		OutputStream os=new FileOutputStream(desfile);
		byte[] buffer=new byte[400];
		int length=0;
		while((length=is.read(buffer))>0){
			os.write(buffer, 0, length);
			
		}
		is.close();
		os.close();
		
	}
	public static void upload(String content, String filename, String root,String subroot) throws IOException{
		mkdir(root,subroot);
		File file=new File(root+subroot+"//"+filename+".txt");
		FileOutputStream fos=new FileOutputStream(file);
		fos.write(content.getBytes());
		fos.flush();
		fos.close();
	}
	
	private static void mkdir(String root,String subroot){
		File dir=new File(root);
		File subdir=new File(root+subroot+"//");
		if(!dir.isDirectory()){
			dir.mkdir();
			subdir.mkdir();
		}else{
			subdir.mkdir();
		}
	}
	private static void mkdir(String root,String subroot,String subsubroot){
		File dir=new File(root);
		File subdir=new File(root+subroot+"//");
		File subsubdir=new File(root+subroot+"/"+subsubroot+"//");
		if(!dir.isDirectory()){
			dir.mkdir();
			subdir.mkdir();
			subsubdir.mkdir();
		}else{
			subdir.mkdir();
			subsubdir.mkdir();
		}
	}
	public static String readFromTXT(String filename, String root, String subroot) throws IOException{
		String content="";
		File file=new File(root+subroot+"//"+filename+".txt");
		if(file.isFile()&&file.exists()){
			InputStreamReader input=new InputStreamReader(new FileInputStream(file));
			BufferedReader BR=new BufferedReader(input);
			String linetxt=null;
			
			while((linetxt=BR.readLine())!=null){
				content=content+linetxt;
			}
			BR.close();
			input.close();
		}
		return content;
	}
	public static List<String> getAllFileName(String root,String dir){
		List<String> filenameList=new ArrayList<String>();
		File folder=new File(root);
		if(folder.isDirectory()&&folder.exists()){
			File[] filelist=folder.listFiles();
			for(File f:filelist){
				
				filenameList.add(dir+f.getName());
				//System.out.println(f.getName());
				
			}
		}else{
			return null;
		}
		return filenameList;
	}

}
