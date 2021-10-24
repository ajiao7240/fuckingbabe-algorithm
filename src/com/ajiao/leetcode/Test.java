package com.ajiao.leetcode;

import org.omg.CORBA.ObjectHelper;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        int[] person = {4,3,2,1};  //
        int cal = cal(person);
        System.out.println(cal);
    }
    public static int cal(int[] person){
        int[] house = new int[person.length];
        int total = 0;
        house[0]=person[0]>person[1]?2:1;
        house[1]=person[1]>person[0]?2:1;
        for (int i = 1,j=2; j < person.length; i++,j++) {
            if(person[j]>person[i]){
                house[j]=house[i]+1;
            }else if(person[j]==person[i]){
                if(house[i]>=2){
                    house[j]=house[i]-1;
                }else {
                    house[j]=1;
                }
            }
            else{
                house[j]=house[i]-1;
                if(house[j]<=0){
                    for (int k = 1; j-k >=0 ; k++) {
                        house[j-k]+=1;
                    }
                    house[j]=house[i]-1;
                }
            }
        }
        for (int i = 0; i < house.length; i++) {
            total+=house[i];
        }
        return total;
    }
}
