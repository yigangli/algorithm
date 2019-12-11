package day20191211;

import java.util.HashMap;
import java.util.Map;

public class Method {
    public static void main(String[] args) {
        //11223322444
        //System.out.println(huiwen("2112"));
        System.out.println(maxSubStringLenAndVal("1122332233344422"));
    }
    //判断一个字符串是否是回文数，递归方式
    public static boolean huiwen(String str){
        int len=str.length();
        if(len<=1){
            return true;
        }else if(len>1&&str.charAt(0)!=str.charAt(len-1)){
            return false;
        }else
            return huiwen(str.substring(1,len-1));
    }

    public static Map<Character,Integer> maxSubStringLenAndVal(String str){
        Map<Character,Integer> m = new HashMap<Character, Integer>();
        int len = str.length();
        int maxlen=0;
        char c,k;
        for (int i=0;i<len;i++){
            k=str.charAt(i);
            if(i==0){
                m.put(k,1);
            }
            if(i>1) {
                c=str.charAt(i - 1);
                if(c==k){
                    m.put(k,m.get(k)+1);
                    if(maxlen<m.get(k)){
                        maxlen=m.get(k);
                    }
                }else{
                    if(m.get(c)<maxlen){
                        m.remove(c);
                    }
                    if(!m.containsKey(k)){
                        m.put(k,1);
                    }else{

                    }

                }
            }


        }
        return m;
    }
}
