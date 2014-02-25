package com.core;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/** 
* @ClassName: AbstPost 
* @Description:
* @author:
* @date 2013年12月31日 下午2:33:33  
*/ 
public abstract class AbstPost {
	
	private final static int BUFFER_SIZE = 1024;
	
	/** 
	* @Description: 读取信息
	* @author:
	* @param url 连接字符串
	* @return
	* @throws Exception 
	* @date 2013年12月31日 下午2:33:41 
	*/ 
	public String read(String url) throws Exception{
		HttpURLConnection conn = getConn(url);
		InputStream is = conn.getInputStream();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int len = 0 ;
		byte[] data = new byte[BUFFER_SIZE];
		while((len = is.read(data,0,BUFFER_SIZE)) > -1){
			baos.write(data, 0, len);
		}
		String result = new String(baos.toByteArray() , "UTF-8");
		baos.close();
		is.close();
		return result ;
	}
	
	/** 
	* @Description: 获取连接
	* @author:
	* @param url 连接字符串
	* @return
	* @throws Exception 
	* @date 2013年12月31日 下午1:22:57 
	*/ 
	private HttpURLConnection getConn(String url) throws Exception{
		URL u = new URL(url);
		HttpURLConnection conn = (HttpURLConnection)u.openConnection();
		conn.setRequestMethod("POST");
		conn.setUseCaches(false);
		conn.setDefaultUseCaches(false);
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setRequestProperty("Content-Type", "application/octet-stream");
		return conn;
	}
	
	/*private String formateUrl(String url){
		Map<String,Object> param = this.initParam();
		for(String key : param.keySet()){
			
		}
	}*/
	public abstract Map<String,Object> initParam();
}
