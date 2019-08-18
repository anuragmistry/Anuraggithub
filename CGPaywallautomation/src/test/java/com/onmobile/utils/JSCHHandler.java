package com.onmobile.utils;

import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;


import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class JSCHHandler{

	public static String executecommand(String hostname,String user,String password,String cmd) throws JSchException, IOException
	{
		Session session=SessionConnect(hostname, user, password);
		Channel c = session.openChannel("exec");
		ChannelExec ce = (ChannelExec) c;
		ce.setCommand(cmd);
		ce.setErrStream(System.err);
		System.out.println("Executing command: "+cmd);	
		try {
			ce.connect();
		} catch (JSchException e) {
			e.printStackTrace();
		}
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(ce.getInputStream()));
		String line;
		String output=null;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
			output+=line;
		}
		
		String campaigndata=output.substring(output.indexOf("CAMPAIGN_ID")+12,output.indexOf(",referrer"));
	    System.out.println(campaigndata);
	    
		ce.disconnect();
		c.disconnect();
		session.disconnect();
		return campaigndata;
	}


	public static Session SessionConnect(String hostname,String user,String password)
	{
		JSch jsch = new JSch();
		Session session=null;

		try
		{
			session = jsch.getSession(user, hostname, 22);
			session.setPassword(password);
			java.util.Properties config = new java.util.Properties(); 
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			session.connect();
		}catch(Exception e)
		{
			e.printStackTrace();
			session.disconnect();
		}
		return session;
	}
}