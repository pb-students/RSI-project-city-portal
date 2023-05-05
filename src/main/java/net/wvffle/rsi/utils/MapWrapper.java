package net.wvffle.rsi.utils;

import java.util.Map;

public class MapWrapper<K, V> {
    private Map<K, V> map;
    
    public MapWrapper(Map<K, V> map) {
        this.setMap(map);
    }

    public void setMap(Map<K, V> map) {
        this.map = map;
    } 

    protected Map<K, V> getMap() {
        return map;
    }
}

