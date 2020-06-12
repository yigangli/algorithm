package day20200605;

public class Solution {
    public String intToRoman(int num) {
        if(num==4) return "IV";
        if(num==9) return "IX";
        if(num==40) return "XL";
        if(num==90) return "XC";
        if(num==400) return "CD";
        if(num/1000!=0){
            int tmp = num/1000;
            int tail = num%1000;
            StringBuffer res = new StringBuffer();
            for(int i=0;i<tmp;i++){
                res.append("M");
            }
            return res.append(intToRoman(tail)).toString();
        }
        if(num/900!=0){
            int tail = num%900;
            StringBuffer res = new StringBuffer("CM");
            return res.append(intToRoman(tail)).toString();
        }
        if(num/500!=0){
            int tail = num%500;
            StringBuffer res = new StringBuffer("D");
            return res.append(intToRoman(tail)).toString();
        }
        if(num/400!=0){
            int tail = num%400;
            StringBuffer res = new StringBuffer("CD");
            return res.append(intToRoman(tail)).toString();
        }
        if(num/100!=0){
            int tmp = num/100;
            int tail = num%100;
            StringBuffer res = new StringBuffer();
            for(int i=0;i<tmp;i++){
                res.append("C");
            }
            return res.append(intToRoman(tail)).toString();
        }
        if(num/90!=0){
            int tail = num%90;
            StringBuffer res = new StringBuffer("XC");
            return res.append(intToRoman(tail)).toString();
        }
        if(num/50!=0){
            int tail = num%50;
            StringBuffer res = new StringBuffer("L");
            return res.append(intToRoman(tail)).toString();
        }
        if(num/40!=0){
            int tail = num%40;
            StringBuffer res = new StringBuffer("XL");
            return res.append(intToRoman(tail)).toString();
        }
        if(num/10!=0){
            int tmp = num/10;
            int tail = num%10;
            StringBuffer res = new StringBuffer();
            for(int i=0;i<tmp;i++){
                res.append("X");
            }
            return res.append(intToRoman(tail)).toString();
        }
        if(num/9!=0){
            int tail = num%9;
            StringBuffer res = new StringBuffer("IX");
            return res.append(intToRoman(tail)).toString();
        }
        if(num/5!=0){
            int tail = num%5;
            StringBuffer res = new StringBuffer("V");
            return res.append(intToRoman(tail)).toString();
        }
        if(num/4!=0){
            int tail = num%4;
            StringBuffer res = new StringBuffer("IV");
            return res.append(intToRoman(tail)).toString();
        }
        if(num/1!=0){
            int tmp = num/1;
            int tail = num%1;
            StringBuffer res = new StringBuffer();
            for(int i=0;i<tmp;i++){
                res.append("I");
            }
            return res.append(intToRoman(tail)).toString();
        }
        return "";
    }
}
