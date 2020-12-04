import sun.font.TrueTypeFont;

import java.util.HashMap;
import java.util.Map;

public class Intepret {

    RimIntepretator rimIntepretator = new RimIntepretator();

    int first;
    int second;
    int operation;
    boolean isArabStyle;

    HashMap<String,Integer> rimMap = rimIntepretator.rimMap;
    HashMap<String,Integer> mathMap = new HashMap<>();

    public void style(){
        //1 = I. 2 = II. 3 = III. 4 = IV. 5 = V. 6 = VI. 7 = VII. 8 = VIII. 9 = IX. 10 = X

        rimMap.put("нуль",0);
        
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
