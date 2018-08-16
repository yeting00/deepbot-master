package com.perspicace.ai.deepbot.utils;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 
* @Description: 自定义一对多的map
* @Param:  
* @return:  
* @Author: Destiny 
* @Date: 2018/7/13 
*/
@Component
public class OToMoreMap<K,V>{
      private List<K>  mkey;
      private List<List<V>>  mvlaue;
 
      public OToMoreMap(){
          mkey = new ArrayList<K>();
          mvlaue = new ArrayList<List<V>>();
 
      }
    /*
     **添加元素
     */
      public void put(K key, V value){
          List list = new ArrayList<V>();
          list.add(value);
          if (containsKey(key)){
              mvlaue.get(mkey.indexOf(key)).add(value);
          }else {
               mkey.add(key);
               mvlaue.add(list);
          }
        }
    /*
   *通过index获取key
   */
    public K getkey(int i){
        return mkey.get(i);
    }
 
    /*
   *通过index获取values
   */
    public List<V> getvalue(int i){
        return mvlaue.get(i);
    }
 
    /*
     *通过index获取元素
     */
      public Map<K,List<V>> get(int i){
            Map<K,List<V>> map = new HashMap<>();
            map.put(mkey.get(i),mvlaue.get(i));
           return map;
      }
    /*
     *获取全部元素
     */
     public Map<K,List<V>> getAll(){
         Map<K,List<V>> map = new HashMap<>();
         for (int i = 0; i < mkey.size(); i++) {
             map.put(mkey.get(i),mvlaue.get(i));
         }
         return map;
     }
      //查看key是否重复
      public boolean containsKey(K key){
          if (mkey.contains(key)){
              return true;
          }else {
              return false;
          }
      }
    /*
     *大小
     */
    public long getSize(){
        return mkey.size();
    }
    /*
     *移除
     */
    public boolean removeAll(){
        mkey.clear();
        mvlaue.clear();
        if (mkey.isEmpty()&&mvlaue.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}

