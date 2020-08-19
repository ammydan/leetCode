package dataStructure;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFU {
    HashMap<Integer, Integer> keyToVal;
    HashMap<Integer,Integer> keyToFreq;
    HashMap<Integer, LinkedHashSet> freToKeys;

    int minFreq;
    int cap;

    public LFU(int capacity){
        this.keyToVal = new HashMap<>();
        this.keyToFreq = new HashMap<>();
        this.freToKeys = new HashMap<>();
        this.cap = capacity;
        this.minFreq = 0;
    }
    public int get(int key){
        if(!keyToVal.containsKey(key))return -1;
        increaseFreq(key);
        return keyToVal.get(key);
    }
    public void put(int key, int val){
        if(this.cap<=0)return;
        if(keyToVal.containsKey(key)){
            keyToVal.put(key,val);
            increaseFreq(key);
            return;
        }
        if(this.cap<=keyToVal.size()){
            removeMinFreqKey();
        }
        keyToVal.put(key,val);
        keyToFreq.put(key,1);
        freToKeys.putIfAbsent(1,new LinkedHashSet<>());
        freToKeys.get(1).add(key);
        this.minFreq = 1;
    }
    private void increaseFreq(int key){
        int freq = keyToFreq.get(key);
        keyToFreq.put(key,freq+1);
        freToKeys.get(freq).remove(key);
        freToKeys.putIfAbsent(freq+1,new LinkedHashSet());
        freToKeys.get(freq+1).add(key);
        if(freToKeys.get(freq).isEmpty()){
            freToKeys.remove(freq);
            if(freq==this.minFreq)this.minFreq++;
        }

    }
    private void removeMinFreqKey(){
        LinkedHashSet<Integer> keyList = freToKeys.get(minFreq);
        int deletedKey = keyList.iterator().next();
        keyList.remove(deletedKey);
        if(keyList.isEmpty())freToKeys.remove(this.minFreq);
        keyToVal.remove(deletedKey);
        keyToFreq.remove(deletedKey);
    }
}
