package scripts;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

import javax.swing.JTextArea;

public class Advance {

	private JTextArea txtarea;
	private String tarpath;
	private String uname;
	private String upass;
	private String mastip;
	private String slvtip;
	
	public Advance(JTextArea area,String path,String user,String pass,String mip,String sip)
		{
		txtarea = area;
		tarpath = path;
		uname = user;
		upass = pass;
		mastip = mip;
		slvtip = sip;
		}
	
	public void setting_hosts()
		{
		String cmd1 = mastip + " master-node";
		String cmd2 = slvtip + " slave-node-1";
		try {
			File f = new File("/etc/hosts");
			txtarea.append("Configuring Hostname name and IP address in" + f.getAbsolutePath());
			FileOutputStream fout = new FileOutputStream(f,true);
			fout.write(System.getProperty("line.separator").getBytes());
			fout.write(cmd1.getBytes());
			txtarea.append(cmd1);
			fout.write(System.getProperty("line.separator").getBytes());
			fout.write(cmd1.getBytes());
			txtarea.append(cmd2);
			txtarea.append("Saving and Exiting....");
			fout.close();
			
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	public void create_user()
	{
		String cmd1 = "adduser " + uname;
		String cmd2 = "passwd " + uname;
		String pass = upass + "\n";
		try {
			Process p1 = Runtime.getRuntime().exec(cmd1);
			p1.waitFor();
			Process p2 = Runtime.getRuntime().exec(cmd2);
			OutputStream out = p2.getOutputStream();
			out.write(pass.getBytes());
			out.write(pass.getBytes());
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void ssh_services()
	{
		String cmd1 = "ssh-keygen -t rsa";
		String cmd2 = "su - " + uname;
		String cmd3 = cmd2 + " -c " + "ssh-copy-id -i ~/.ssh/id_rsa.pub " + uname + "@master-node";
		String cmd4 = cmd2 + " -c " + "ssh-copy-id -i ~/.ssh/id_rsa.pub " + uname + "@slave-node-1";
		String cmd5 = cmd2 + " -c " + "chmod 0600 ~/.ssh/authorized_key";
		try {
			Process p1 = Runtime.getRuntime().exec(cmd1);
			OutputStream out = p1.getOutputStream();
			out.write("\n".getBytes());
			out.write("\n".getBytes());
			out.write("\n".getBytes());
			out.flush();
			p1.waitFor();
			Process p2 = Runtime.getRuntime().exec(cmd3);
			Process p3 = Runtime.getRuntime().exec(cmd4);
			Process p4 = Runtime.getRuntime().exec(cmd5);
//			OutputStream out1 = p2.getOutputStream();
//			out1.write(cmd3.getBytes());
//			out1.write(cmd4.getBytes());
//			out1.write(cmd5.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public void conf_hadoop()
	{
		String cmd1 = "cd /opt";
		String cmd2 = "tar -zxvf " + tarpath;
		String cmd3 = "mv hadoop-2.6.0 hadoop";
		String cmd4 = "scp -r hadoop slave-node-1:/opt/";
		//Process p = Runtime.getRuntime().exec();
		ProcessBuilder pb= new ProcessBuilder("cd","/opt");
	//	Process pr =pb.start();
		//pb.directory(System.getProperty("user.dir"));
	}
	
	public void setup_env()
	{
		File fin = new File(getClass().getClassLoader().getResource("/files/bash.xml").getFile());
		File fout = new File("~/.bashrc");
		try {
			FileInputStream fis = new FileInputStream(fin);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			FileWriter fstream = new FileWriter(fout, true);
			BufferedWriter out = new BufferedWriter(fstream);
	 
			String aLine = null;
			while ((aLine = in.readLine()) != null) {
				out.write(aLine);
				out.newLine();
			}
			in.close();
			out.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void content_transfer(String file)
	{
		try {
 
			File fin = new File("/files/" + file);
			File fout = new File("/home/hadoop/hadoop/etc/hadoop/" + file);
			FileInputStream fis = new FileInputStream(fin);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			
			if(!fout.exists())
				fout.createNewFile();
			
			FileWriter fstream = new FileWriter(fout);
			BufferedWriter out = new BufferedWriter(fstream);
	 
			String aLine = null;
			while ((aLine = in.readLine()) != null) {
				out.write(aLine);
				out.newLine();
			}
			in.close();
			out.close();
	        }
	    catch(Exception e) {
	        e.printStackTrace();
	    	}
	}
	
	public void edit_config()
	{
		content_transfer("core-site.xml");
		content_transfer("hdfs-site.xml");
		content_transfer("mapred-site.xml");
		content_transfer("yarn-site.xml");
	}
}