package study;

import org.junit.Test;

import java.util.TreeSet;

/**
 * @program: Toutiao
 * @author: CNWh3t
 * @create: 2019-01-23 17:43
 * @description: 字符串的字符去重
 */

public class StringNoRepeat {

    /**
     * @author : CNWh3t
     * @DateTime : 2019/1/23 17:51
     * @Param : [s]
     * @Rerturn : java.lang.String
     * @description : 利用treeSet的无重复有序的特性,利用treeset的有序性排序
     */
    public static String noRepeatChar(String s){
        String[] chars = s.split("");
        //把数组串放入TreeSet中，根据set的不重复特性，去重
        TreeSet<String> treeSet = new TreeSet<>();
        for (String str : chars){
            treeSet.add(str);
        }
        String string = "";
        for (String str : treeSet){
            string += str;
        }
        return string;
    }


    @Test
    public void testNoRepeatChar(){
        String string = "abdsdsssdddffwerrrt";
        String string1 = "aabbbbcccdddd";
        System.out.println(noRepeatChar(string));
        System.out.println(noRepeatChar(string1));
    }
}
