package com.if1007.kscore.storage;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private final Map<String, String> storage;

    public Storage(){
        storage = new HashMap<>();
    }

    public void insert(String key, String item){
        storage.put(key,item);
    }

    public String get(String key){
        return this.storage.get(key);
    }

    public void delete(String key) {this.storage.remove(key);}
}
