package org.za.blog.utils;


import org.za.blog.consts.ResponseCode;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class RedirectUtil {
    public static void setFailAndOutput(HttpServletResponse httpServletResponse, String msg) throws Exception{
        httpServletResponse.setStatus(200);
        httpServletResponse.setContentType("application/json;charset=utf-8");
        PrintWriter out = httpServletResponse.getWriter();
        String json ="{\n" +
                "    \"code\": \""+ ResponseCode.e555.getCode()+"\",\n" +
                "    \"message\": \""+msg+"\",\n" +
                "    \"data\": {\n" +
                "    }\n" +
                "}";
        out.println(json);
        out.flush();
        out.close();
    }

    public static void setFailAndOutput(HttpServletResponse httpServletResponse, ResponseCode code) throws Exception{
        httpServletResponse.setStatus(200);
        httpServletResponse.setContentType("application/json;charset=utf-8");
        PrintWriter out = httpServletResponse.getWriter();
        String json ="{\n" +
                "    \"code\": \""+ code.getCode()+"\",\n" +
                "    \"message\": \""+code.getMsg()+"\",\n" +
                "    \"data\": {\n" +
                "    }\n" +
                "}";
        out.println(json);
        out.flush();
        out.close();
    }

    public static void setSuccessAndOutput(HttpServletResponse httpServletResponse, String msg) throws Exception{
        httpServletResponse.setStatus(200);
        httpServletResponse.setContentType("application/json;charset=utf-8");
        PrintWriter out = httpServletResponse.getWriter();
        String json ="{\n" +
                "    \"code\": \""+ ResponseCode.success.getCode() +"\",\n" +
                "    \"message\": \""+msg+"\",\n" +
                "    \"data\": {\n" +
                "    }\n" +
                "}";
        out.println(json);
        out.flush();
        out.close();
    }

    public static void setSuccessAndOutput(HttpServletResponse httpServletResponse) throws Exception{
        httpServletResponse.setStatus(200);
        httpServletResponse.setContentType("application/json;charset=utf-8");
        PrintWriter out = httpServletResponse.getWriter();
        String json ="{\n" +
                "    \"code\": \""+ ResponseCode.success.getCode() +"\"" +
                "}";
        out.println(json);
        out.flush();
        out.close();
    }
}
