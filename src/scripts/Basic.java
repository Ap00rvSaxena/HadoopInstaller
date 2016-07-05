package scripts;

import java.io.*;
import java.net.URL;

import javax.swing.JTextArea;
import gui.Intro;

public class Basic {

	private JTextArea txtarea;
	private String user;
	
	public Basic(JTextArea area,String username)
		{
		txtarea = area;
		user = username;
		}
	
	public void create_user(String pass)
	{	
		 txtarea.append("Adding new User as hadoop.....\n");
		 txtarea.append("Creating Home Directory for USER-hadoop.....\n");
		 String cmd1 = "adduser " + user;
		 txtarea.append("#"+cmd1+"\n");
		 String cmd2 = "passwd " + user;
		 String pwd = pass+"\n";
		 txtarea.append("#"+cmd2+"\n");	
			try {
				Process p1 = Runtime.getRuntime().exec(cmd1);
				p1.waitFor();
				Process p2 = Runtime.getRuntime().exec(cmd2);
				OutputStream out = p2.getOutputStream();
				out.write(pwd.getBytes());
				txtarea.append("#"+"\n");
				out.write(pwd.getBytes());
				txtarea.append("#"+"\n");
				out.flush();
				txtarea.append("USER-hadoop successfully created...........\n");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				txtarea.append("#"+e+"\n");
				e.printStackTrace();
	    }
			txtarea.append("\n");
		
	}
	
	public void ssh_services()
	{	
		try {
			txtarea.append("Creating SSH services.....\n");
			String username = user;
			String command = "ssh-keygen -t rsa -N \"\" -f ~/.ssh/id_rsa ; cat ~/.ssh/id_rsa.pub >> ~/.ssh/authorized_keys";
			txtarea.append("#"+command+"\n");
			ProcessBuilder processBuilder = new ProcessBuilder("su", username, "-c", command);
			Process process = processBuilder.start();
			process.waitFor();
			txtarea.append("Changing Permisiions for SSH services.....\n");
			String cmd1 = "su "+ username +" -c \'chmod 0600 ~/.ssh/authorized_keys\'";
			executeCommands(cmd1,"");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			txtarea.append("#"+e+"\n");
			e.printStackTrace();
		}
		txtarea.append("SSH services created successfully.....\n");
		txtarea.append("\n");
	}
	
	public void install_hadoop(String abstarpath,String filename,String parapth)
	{
		try{
		txtarea.append("Installing "+filename+" in "+ user +" home directory.....\n");
		String cmd1 = "tar xzf "+abstarpath;
		String cmd2 = "mv "+ filename +" /home/"+user+"/hadoop";
		txtarea.append("#"+cmd1+"\n");
		txtarea.append("#"+cmd2+"\n");
		executeCommands(cmd1, cmd2);			
		}catch(Exception e){
			txtarea.append("#"+e+"\n");
			e.printStackTrace();
		}
		txtarea.append(filename +"installed successfully.....\n");
		txtarea.append("\n");
	}
	
	public void setup_env()
	{	
		//System.out.println(new File("src/files/bash.xml").getAbsolutePath());
		ClassLoader classLoader = getClass().getClassLoader();
		File fin = new File(classLoader.getResource("bash.xml").getFile());
		
		//File fin = new File("src/files/bash.xml");
		File fout = new File("/home/"+ user +"/.bashrc");
		txtarea.append("#setting Enviorment Variable for hadoop...."+"\n");
		txtarea.append("#writting in ~/.bashrc."+"\n");
		try {
			FileInputStream fis = new FileInputStream(fin);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			FileWriter fstream = new FileWriter(fout, true);
			BufferedWriter out = new BufferedWriter(fstream);
			String hadoop_home="export HADOOP_HOME=/home/"+ user +"/hadoop";
			out.write(hadoop_home);
			String aLine = null;
			while ((aLine = in.readLine()) != null) {
				out.write(aLine);
				txtarea.append(aLine+"\n");
				out.newLine();
			}
			in.close();
			out.close();			
		}
		catch (Exception e) {
			txtarea.append("#"+e+"\n");
			e.printStackTrace();
		}
		txtarea.append("\n");
	}
	
	public void content_transfer(String file)
	{
		try {
			ClassLoader classLoader = getClass().getClassLoader();
			File fin = new File(classLoader.getResource(file).getFile());
			File fout = new File("/home/"+ user +"/hadoop/etc/hadoop/" + file);
			FileInputStream fis = new FileInputStream(fin);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			
			if(!fout.exists())
				fout.createNewFile();
			
			FileWriter fstream = new FileWriter(fout);
			BufferedWriter out = new BufferedWriter(fstream);
	 
			String aLine = null;
			while ((aLine = in.readLine()) != null) {
				out.write(aLine);
				txtarea.append(aLine+ "\n");
				out.newLine();
			}
			in.close();
			out.close();
	        }
	    catch(Exception e) {
	    	txtarea.append("#"+e+"\n");
	        e.printStackTrace();
	    	}
		txtarea.append("\n");
	}
	
	public void edit_config()
	{
		txtarea.append("#Editting Configuration File-core-site.xml\n");
		content_transfer("core-site.xml");
		txtarea.append("#Editting Configuration File-hdfs-site.xml\n");
		content_transfer("hdfs-site.xml");
		txtarea.append("#Editting Configuration File-mapred-site.xml\n");
		content_transfer("mapred-site.xml");
		txtarea.append("#Editting Configuration File-yarn-site.xml\n");
		content_transfer("yarn-site.xml");
		txtarea.append("\n");
	}
	
	public void executeCommands(String cmd1,String cmd2) throws IOException {

	    File tempScript = createTempScript(cmd1,cmd2);

	    try {
	        ProcessBuilder pb = new ProcessBuilder("bash", tempScript.toString());
	        pb.inheritIO();
	        Process process = pb.start();
	        process.waitFor();
	    } catch (InterruptedException e) {
	    	txtarea.append("#"+e+"\n");
			e.printStackTrace();
		} finally {
	        tempScript.delete();
	    }
	}

	public  File createTempScript(String cmd1,String cmd2) throws IOException {
	    File tempScript = File.createTempFile("script", null);

	    Writer streamWriter = new OutputStreamWriter(new FileOutputStream(
	            tempScript));
	    PrintWriter printWriter = new PrintWriter(streamWriter);

	    printWriter.println("#!/bin/bash");
	    printWriter.println(cmd1);
	    printWriter.println(cmd2);
	    printWriter.close();

	    return tempScript;
	}
	
//	public static void main(String args[])
//	{
//		Basic b = new Basic(null);
//		b.setup_env();		
//	}
	
}
