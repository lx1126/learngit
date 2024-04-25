package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test {
    public static void main (String[] args){
//        String str = "1+2*3+4/2-3";
        Scanner s =new Scanner(System.in);
        if(s.hasNext()){
            double result = mathResult(s.nextLine());
            System.out.print(result);
        }

    }

    private static double mathResult(String str){
        char[] arr = str.toCharArray();
        List<Double> list = new ArrayList<>();
        List<Character> listMath = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]=='*'){
                 list.remove(list.size()-1);
                 list.add((arr[i-1]-'0') * (arr[i+1]-'0')+0.0);
                 i++;
            }else if( arr[i]=='/'){
                 list.remove(list.size()-1);
                 list.add((arr[i-1]-'0' +0.0) / (arr[i+1]-'0'+0.0));
                 i++;
            }else if( arr[i]=='+' || arr[i]=='-'){
                 listMath.add(arr[i]);
            }else{
                 list.add(arr[i]-'0'+0.0);
            }

        }
        double result = list.get(0);
        int x=0;
        for(int j=1;j<list.size();j++){
            if((listMath.get(x)).charValue()=='+'){
                result+=list.get(j);
                x++;
            }else if(( listMath.get(x)).charValue()=='-'){
                result-=list.get(j);
                x++;
            }
        }
        return result;
    }

}
