import sun.font.TrueTypeFont;

import java.util.HashMap;
import java.util.Map;

public class Intepret {

    int first;
    int second;
    int operation;
    boolean isArabStyle;

    HashMap<String,Integer> rimMap = new HashMap<>();
    HashMap<String,Integer> mathMap = new HashMap<>();

    public void style(){
        //1 = I. 2 = II. 3 = III. 4 = IV. 5 = V. 6 = VI. 7 = VII. 8 = VIII. 9 = IX. 10 = X

        rimMap.put("нуль",0);
        rimMap.put("I",1);
        rimMap.put("II",2);
        rimMap.put("III",3);
        rimMap.put("IV",4);
        rimMap.put("V",5);
        rimMap.put("VI",6);
        rimMap.put("VII",7);
        rimMap.put("VIII",8);
        rimMap.put("IX",9);
        rimMap.put("X",10);
        rimMap.put("XI",11);
        rimMap.put("XII",12);
        rimMap.put("XIII",13);
        rimMap.put("XIV",14);
        rimMap.put("XV",15);
        rimMap.put("XVI",16);
        rimMap.put("XVII",17);
        rimMap.put("XVIII",18);
        rimMap.put("XIX",19);
        rimMap.put("XX",20);
        rimMap.put("XXI",21);


        mathMap.put("+",1);
        mathMap.put("-",2);
        mathMap.put("*",3);
        mathMap.put("/",4);
    }

    public void printResult(boolean isArabStyle){
        Math math = new Math();
        int result = math.Calk(first, second, operation);
        if (isArabStyle){
            System.out.println("Результат: " + result);
        } else {
            for (Map.Entry<String,Integer> entry :rimMap.entrySet()){
                if (entry.getValue().equals(result)){
                    System.out.println("Результат: " + entry.getKey());
                }
            }
        }

    }

    public void itIs(String calkString){

        String[] calkArray = calkString.split(" ");
        /*
        for (String calk : calkArray) {
            System.out.println(calk);
        }
        */
        if (itIsCalk(calkArray)){
            //System.out.println("Номер операции: " + operation);
        } else {
            throw new NumberFormatException();
            //System.out.println("Не валидная операция");
        }
        if (itIsInt(calkArray)){
            //System.out.println("Цифры");
            System.out.println("======");
        }
        else if (itIsRim(calkArray)){
            System.out.println("======");
        }
        else {
            throw new NumberFormatException();
            //System.out.println("Нет");
        }

    }

    private boolean itIsCalk(String[] calkArray){
        style();
        style();
        String math = calkArray[1];
        if (mathMap.containsKey(math)) {
            operation = mathMap.get(math);
            return true;
        }
        return false;
    }

    private boolean itIsInt(String[] calkArray){
        try{
            first = Integer.parseInt(calkArray[0]);
            second = Integer.parseInt(calkArray[2]);
        } catch (NumberFormatException e){
            return false;
        }
        isArabStyle = true;
        return true;
    }

    private boolean itIsRim(String[] calkArray){
        style();

        String firstStr = calkArray[0];
        String secondStr = calkArray[2];
        if ((rimMap.containsKey(firstStr)) & (rimMap.containsKey(secondStr))){
            //System.out.println("все римские");
            first = rimMap.get(firstStr);
            second = rimMap.get(secondStr);
            isArabStyle = false;
            return true;
        }
        return false;

    }

}
