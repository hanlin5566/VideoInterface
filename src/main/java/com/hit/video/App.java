package com.hit.video;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Hello world!
 *
 */
public class App 
{	
	private static final Logger logger = LoggerFactory.getLogger(App.class);
    public static void main( String[] args )
    {	
    	try {
    		boolean init = VideoJNA.INSTANTCE.NS_NET_Initate();
    		if(init){
    			logger.info("初始化成功");
    		}else{
    			logger.info("初始化失败");
    		}
    		//退出需要调用释放资源
    		boolean clear = VideoJNA.INSTANTCE.NS_NET_Clear();
    		if(clear){
    			logger.info("释放资源成功");
    		}else{
    			logger.info("释放资源失败");
    		}
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
		}
    }
}
