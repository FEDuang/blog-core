package org.za.blog.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.*;

public class JsonUtil {
    private ObjectMapper mapper;
    private Map mapResult;
    private String jsonResult;

    public JsonUtil(){
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapResult = new LinkedHashMap<>();

    }

    public HashMap Json2Map(String json){
        try {
            return (HashMap) mapper.readValue(json,Map.class);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("cannot convert map to json, it will return a empty HashMap!");
        }
        return null;
    }

    public HashMap[] Json2ListMap(String json){
        try {
            return (HashMap[]) mapper.readValue(json,Map[].class);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("cannot convert map to json, it will return a empty HashMap!");
        }
        return null;
    }

    public <T> T Json2Any(String json,Class<T> valueType){
        try {
            return (T) mapper.readValue(json,valueType);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("cannot convert map to json, it will return a empty HashMap!");
        }
        return null;
    }

    public static  <T> T Change(Object o,Class<T> valueType){
        return (T) o;
    }

    public String Map2Json(HashMap hashMap){
        try {
            return mapper.writeValueAsString(hashMap);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("cannot convert json to map");
        }
        return "";
    }

    public String Object2Json(Object o){
        try {
            return mapper.writeValueAsString(o);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("cannot convert Object to Json, maybe a private field which without getter cause this problem. ");
        }
        return "";
    }

    public Map getMapResult() { return mapResult; }

    private void setMapResult(String json){
        try {
            mapResult = mapper.readValue(json,Map.class);
        }catch (IOException e){
            e.printStackTrace();
            System.err.println("cannot convert json to map");
            //throw new InputException();
        }
    }


}
