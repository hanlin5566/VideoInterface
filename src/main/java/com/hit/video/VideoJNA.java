package com.hit.video;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface VideoJNA extends Library{
//	VideoSDK INSTANTCE = (VideoJNA) Native.loadLibrary("NSDEVNET", VideoJNA.class);  
	VideoJNA INSTANTCE = (VideoJNA) Native.loadLibrary("D:\\NVRSDK20170913\\NVRSDK20170913\\NETSDK\\NSDEVNET", VideoJNA.class);  
	//此方法为链接库中的方法  
	boolean  NS_NET_Initate();  
	boolean  NS_NET_Clear();  
	Long  NS_NET_Login(String ip,int port,String userName,String password);
	void  NS_NET_Logout(Long id);
	void NS_NET_SearchFile();
	void NS_NET_SearchNextFile();
	void NS_NET_SearchFileClose();
	//获取错误
	int NS_NET_GetLastErr();
	//远程预览
	void NS_NET_VideoTranspondStart();
}
