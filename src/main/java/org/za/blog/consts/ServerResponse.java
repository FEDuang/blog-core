package org.za.blog.consts;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServerResponse implements Serializable {
    private String code;
    private String message;
    private Object data;

    private ServerResponse(String code, Object data){
        this.code = code;
        if(data instanceof String){
            Map<String,String> hashMap = new HashMap<>(1);
            hashMap.put("message", (String)data);
            this.data = hashMap;
        }else {
            this.data = data;
        }
    }
    private ServerResponse(String code, String message, Object data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static  ServerResponse Create(boolean isOk){
        return new ServerResponse((isOk?ResponseCode.success.getCode():ResponseCode.e555.getCode()),null);
    }
    public static  ServerResponse Create(boolean isOk, String msg){
        return new ServerResponse((isOk?ResponseCode.success.getCode():ResponseCode.e555.getCode()),msg);
    }
    public static  ServerResponse Create(boolean isOk, String msg, Object data){
        return new ServerResponse((isOk?ResponseCode.success.getCode():ResponseCode.e555.getCode()),msg,data);
    }

    /**
     * 成功
     * @return 返回200
     */
    public static  ServerResponse Success(){
        return new ServerResponse(ResponseCode.success.getCode(),null);
    }

    /**
     * 成功，并返回数据
     * @param data 要返回的数据
     * @return json
     */
    public static  ServerResponse Success(Object data){
        return new ServerResponse(ResponseCode.success.getCode(), data);
    }

    public static  ServerResponse Success(String msg, Object data){
        return new ServerResponse(ResponseCode.success.getCode(), msg, data);
    }

    /**
     * 失败
     * @return 一个常见的失败
     */
    public static  ServerResponse Error(){
        return new ServerResponse(ResponseCode.e555.getCode(),null);
    }

    /**
     * 返回一个特定的失败
     * @param error 失败代码
     * @return json
     */
    public static  ServerResponse Error(ResponseCode error){
        return ServerResponse.Error(error,error.getMsg());
    }

    /**
     * 返回失败的错误信息
     * @param errorMsg 错误的信息
     * @return json
     */
    public static  ServerResponse Error(String errorMsg){
        return new ServerResponse(ResponseCode.e555.getCode(),errorMsg,null);
    }

    /**
     * 返回特定的错误
     * @param error 错误代码
     * @param errorMsg 错误信息
     * @return json
     */
    public static  ServerResponse Error(ResponseCode error,String errorMsg){
        return new ServerResponse(error.getCode(),errorMsg);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ServerResponse{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
