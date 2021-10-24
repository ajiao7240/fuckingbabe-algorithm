package com.ajiao.leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class meituan {
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        String lineOne = scanner.nextLine();
        String lineTwo = scanner.nextLine();
        String[] o = lineOne.split(" ");
        int n = Integer.valueOf(o[0]);
        int m = Integer.valueOf(o[1]);
        int a = Integer.valueOf(o[2]);
        int b = Integer.valueOf(o[3]);

        String[] t = lineTwo.split(" ");
        int[] weights = new int[t.length];
        for(int i =0;i<t.length;i++){
            weights[i] = Integer.valueOf(t[i]);
        }
        System.out.println(isDone(n,m,a,b,weights));*/
        Scanner scanner = new Scanner(System.in);
        String lineThree = scanner.nextLine();
        String[] s = lineThree.split(" ");
        int[] arr = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            arr[i]= Integer.parseInt(s[i]);
        }
    }
    public static int test(int people,int num,int[] scores){
        Arrays.sort(scores);
        System.out.println(scores[0]);
        if(scores[scores.length-1]==0){
            return 0;
        }
        int index = people-num;
        int result = num;
        for (int i = index; i < scores.length; i++) {
            if (scores[i]==0){
                result--;
            }
        }
        return result;
    }

    static String isDone(int n,int m,int a,int b,int[] weights){
        if(a>b){
            int temp = b;
            b = a;
            a = temp;
        }
        Arrays.sort(weights);
        if(a>weights[0]){
            return "NO";
        }else if(b<weights[weights.length-1]){
            return "NO";
        }
        int need = 0;
        if(a<weights[0]) need++;
        if(b>weights[weights.length-1]) need++;
        return n-m>=need?"YES":"NO";
    }

    static String isDone2(int n,int m,int a,int b,int[] weights){
        if(a>b){
            int temp = a;
            a = b;
            b= temp;
        }
        Arrays.sort(weights);
        if(a>weights[0]){
            return "NO";
        }else if(b<weights[1]){
            return "NO";
        }
        int need = a-b;
        if(need<2){
            return "NO";
        }
        return "YES";
    }

    static int max(int[] arr){
        if(arr==null||arr.length<1){
            return 0;
        }
        int curMax,max,curMin,min,sum;
        curMax=max=curMin=min=sum=arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum+=arr[i];
            curMax = curMax>0?curMax+arr[i]:arr[i];
            max=curMax>max?curMax:max;
            curMin=curMin<0?curMin+arr[i]:arr[i];
            min=curMin<min?curMin:min;
        }
        if(max<0){
            return max;
        }
        return Math.max(sum-min,max);
    }
}
