package com.programs;

import java.util.HashMap;
import java.util.Map;

/* WRONG SOLUTION
Example:
Input 	Output
5	    E
27	    AA
52	    AZ
56	    BD
712 	AAJ

 */
public class ExcelColumMarker {

    private static Map<Integer, String> columnMap = new HashMap<>();

    static{
        columnMap.put(1,"A");        columnMap.put(2,"B");        columnMap.put(3,"C");        columnMap.put(4,"D");        columnMap.put(5,"E");
        columnMap.put(6,"F");        columnMap.put(7,"G");        columnMap.put(8,"H");        columnMap.put(9,"I");        columnMap.put(10,"J");
        columnMap.put(11,"K");        columnMap.put(12,"L");        columnMap.put(13,"M");        columnMap.put(14,"N");        columnMap.put(15,"O");
        columnMap.put(16,"P");        columnMap.put(17,"Q");        columnMap.put(18,"R");        columnMap.put(19,"S");        columnMap.put(20,"T");
        columnMap.put(21,"U");        columnMap.put(22,"V");        columnMap.put(23,"W");        columnMap.put(24,"X");        columnMap.put(25,"Y");
        columnMap.put(26,"Z");
    }

    public static void main(String args[]){
        System.out.println("Column no is equivalent to = " + getColumnMark(701));

    }

    private static String getColumnMark(int columnNo) {
        StringBuilder columnMark  = new StringBuilder();
        int remainder = 0, quotient = 0;
        while(columnNo > 0){
            remainder  = columnNo % 26;
            if(columnMap.get(remainder)!=null){
                columnMark.append(columnMap.get(remainder));
            }
            columnNo = columnNo / 26;  //26 alphabets

        }



        return columnMark.reverse().toString();

    }



}
