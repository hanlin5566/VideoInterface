package com.hit.video;

import com.hit.video.enumhandle.ERROR_CODE;
import com.hit.video.util.LoggerUtil;
import com.sun.jna.Native;

public class VideoAPI {
	private static VideoAPI api = null;
	VideoJNA INSTANTCE = (VideoJNA) Native.loadLibrary("NSDEVNET", VideoJNA.class);
	private VideoAPI() {
		super();
		boolean init = VideoJNA.INSTANTCE.NS_NET_Initate();
		if(!init){
			LoggerUtil.error(LoggerUtil.getMethodName(), ERROR_CODE.LOCAL_INITATE_FAILED.code(), this.getClass());
		}
	}
	
	public static VideoAPI getInstance(){
		if(api==null){
			api = new VideoAPI();
		}
		return api;
	}
	
	public boolean destroy(){
		boolean destroy = VideoJNA.INSTANTCE.NS_NET_Clear();
		if(!destroy){
			LoggerUtil.error(LoggerUtil.getMethodName(), ERROR_CODE.LOCAL_DESTROY_FAILED.code(), this.getClass());
		}
		return destroy;
	}
	/**
	 * 
	 * @param ip
	 * @param port
	 * @param userName
	 * @param password
	 * @return
	 */
	public Long login(String ip,int port,String userName,String password){
		Long uid = VideoJNA.INSTANTCE.NS_NET_Login(ip,port,userName,password);
		if(0 == uid){
			int errorCode = VideoJNA.INSTANTCE.NS_NET_GetLastErr();
			LoggerUtil.error(LoggerUtil.getMethodName(), errorCode, this.getClass());
		}
		return uid;
		
	}
}
