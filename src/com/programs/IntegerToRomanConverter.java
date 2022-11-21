package com.programs;



/*
Another mapping
Map<Character, Integer> values = new LinkedHashMap<>();
	values.put('I', 1);
	values.put('V', 5);
	values.put('X', 10);
	values.put('L', 50);
	values.put('C', 100);
	values.put('D', 500);
	values.put('M', 1000);
 */
public class IntegerToRomanConverter {

    public static void main(String[] args){

        System.out.println("Integer equivalent for str:" +convertIntToRoman(125));
    }

    public static String convertIntToRoman(int num)  {
        if(num == 0 )
            System.out.println("Not a valid Number");
        else if(num<0)
            System.out.println("Validation for Negative Integer failed");


        int[] intArr = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romanArr = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder sbf = new StringBuilder();
        while(num>0){
            for(int i=0;i<intArr.length;i++){
                if(num>=intArr[i]){
                    sbf.append(romanArr[i]);
                    num -= intArr[i];
                    break;
                }
            }
        }
        return sbf.toString();
    }
}
