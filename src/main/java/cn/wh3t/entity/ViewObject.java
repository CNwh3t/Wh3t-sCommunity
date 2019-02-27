package cn.wh3t.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: Toutiao
 * @author: CNWh3t
 * @create: 2019-01-18 22:37
 * @description:
 */

public class ViewObject {

    private Map<String,Object> objs = new HashMap<>();

    public void setObjs(String key,Object value){
        objs.put(key,objs);
    }
    public Object get(String key){
        return objs.get(key);
    }

}
