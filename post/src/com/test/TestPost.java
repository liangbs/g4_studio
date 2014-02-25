package com.test;

import java.util.Map;

import org.junit.Test;

import com.core.AbstPost;

public class TestPost extends AbstPost{
	
	@Test
	public void action(){
		try{
//			String url = "http://localhost:8081/ssports-website/LotteryTicket.action?partId=290&row=12";
//			String url = "http://223.203.189.218/api/get.php?url=http://223.203.189.218:8980/ssports-website/NewsListOfLotteryTicket.action?partId=290&pageNow=1&pageSize=11";
//			String url = "http://localhost:8081/ssports-website/NewsListOfLotteryTicket.action?partId=290&pageNow=1&pageSize=11";
			String url = "http://localhost:8081/ssports-website/NewsListOfLotteryTicket.action?partId=290&pageNow=1&pageSize=3";
			String result = read(url);
			System.out.println(result);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	

	@Override
	public Map<String,Object> initParam() {
		return null;
	}
}
