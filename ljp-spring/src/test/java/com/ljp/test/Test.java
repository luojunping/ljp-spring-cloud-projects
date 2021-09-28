package com.ljp.test;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author 罗俊平
 * @email 591402399@qq.com
 * @date 2021/9/27
 * @since 1.0.0
 **/
public class Test {

    /**
     * 找到数组中出现次数最多的数
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] array = {1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 3};
        Test test = new Test();
        System.out.println(test.listMaxNum(array));
    }

    public ArrayList<Integer> listMaxNum(int[] array) {
        ArrayList<Integer> rs = Lists.newArrayList();
        if (array == null || array.length == 0) {
            return rs;
        }
        int n = 0;
        HashMap<Integer, Integer> hashMap = Maps.newHashMap();
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int m = array[i];
            Integer a = hashMap.get(m);
            if (a == null) {
                a = 1;
            } else {
                a++;
            }
            hashMap.put(m, a);
            if (a > n) {
                n = a;
                rs.clear();
                rs.add(m);
            } else if (a.intValue() == n) {
                rs.add(m);
            }
        }
        return rs;
    }

}
