package net.wvffle.rsi.utils;

import java.util.Map;


public class MapWrapper<K, V> {
    /**
     * map being wrapped
     */
    private Map<K, V> map;
    
    /**
     * Constructor of the class
     * @param map is the map to be wrapped
     */
    public MapWrapper(Map<K, V> map) {
        this.setMap(map);
    }

    /**
     * map setter
     * @param map is the new map to be wrapped
     */
    public void setMap(Map<K, V> map) {
        this.map = map;
    } 

    /**
     * map getter
     * @return wrapped map 
     */
    protected Map<K, V> getMap() {
        return map;
    }
}

