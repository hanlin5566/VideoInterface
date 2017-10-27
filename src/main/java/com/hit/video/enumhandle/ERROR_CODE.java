package com.hit.video.enumhandle;

public enum ERROR_CODE implements EnumType{
	/**
	 * 	错误代码：
	 */
	UNKNOWN(-1,"未知"),
	SUCCESS(200,"成功"),
	LOCAL_INITATE_FAILED(103,"初始化失败"),
	LOCAL_DESTROY_FAILED(104,"销毁资源失败"),
	NET_ERR_OK(1981,"正常"),
	NET_ERR_USER_PASSWD(300,"登录失败（无效的帐号或密码）"),
	NET_ERR_USER_FULL(301,"在线用户达到最大"),
	NET_ERR_ILLEGAL_USER(302,"非法的登录 ID"),
	NS_LOCAL_ERR_INIT(2112,"未初始化"),
	NS_LOCAL_ERR_INVAILDIP(2114,"无效 IP"),
	NS_LOCAL_ERR_SENDMSG(2116,"发送失败"),
	NS_LOCAL_ERR_RECVMSG(2117,"接受失败");
	private final int code;
	
    private final String text;

	@Override
	public int code() {
		return code;
	}

	@Override
	public String text() {
		return text;
	}
	
	private ERROR_CODE(int code,String text) {
		this.code=code;
		this.text=text;
	}
	
	public static ERROR_CODE codeOf(int code) {
        for (ERROR_CODE value : values()) {
            if (value.code == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid code: " + code);
	}
	
	public static ERROR_CODE textOf(String text) {
        for (ERROR_CODE value : values()) {
            if (value.text.equals(text)) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid text: " + text);
    }

}
