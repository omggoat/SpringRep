package cn.shil.util;

import java.util.HashMap;
import java.util.Map;

public class FileDB {

    private static Map<String,Object> filedb;

    public static final Map<String,Object> getFiledb(){
        if(null == filedb){
            filedb = new HashMap<String,Object>();
        }
        return filedb;
    }
}
