package com.ajiao.leetcode.test;

public class test2 {
    public static void main(String[] args) {
        double res = 0;
        for (int i = 3; i <=15 ; i++) {
            if(i%2==0){
                res = el2(i)>el3(i)?el3(i):el2(i);
                if(res==el2(i)){
                    System.out.println("第"+i+"层时选择2号电梯");
                }else {
                    System.out.println("第"+i+"层时选择3号电梯");
                }
            }else {
                res = el1(i)>el3(i)?el3(i):el1(i);
                if(res==el1(i)){
                    System.out.println("第"+i+"层时选择1号电梯");
                }else {
                    System.out.println("第"+i+"层时选择3号电梯");
                }
            }
        }
        System.out.println(el2(14));
        System.out.println(el3(14));
    }
    public static double el1(int floor){//1.3.5.7.9.11.13.15   2/4/6/8
        return 15+(floor-1)*0.5+(((floor-1)/2)-1)*5;
    }
    public static double el2(int floor){   //1.2.4.6.8.10.12.14  15+6.5+35
        return 15+(floor-1)*0.5+((floor/2)-1)*5;
    }
    public static double el3(int floor){ //1.2.3.4  10       10+39+6.5
        return 10+(floor-1)*3.5;
    }
}
