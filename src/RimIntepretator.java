import java.util.HashMap;

public class RimIntepretator {


    public HashMap<String,Integer> rimMap = new HashMap<>();

    public RimIntepretator(){
        for (int y = 1; y < 101; y++){
            rimMap.put(getNumber(y),y);
        }
    }

    public String getNumber(int i){
        int tenNumber = i / 10;
        int inTen = i % 10;
        String rim = "";
        if (i == 100){
            rim = "C";
        } else {
            rim = tenConstruktor(tenNumber) + analizNumber(inTen);
        }
        //System.out.println("номер десятка: " + tenNumber);
        /*
        if (inTen == 0){
            System.out.println("правило нового десятка");
        }
        */
        //System.out.println("Результат: " + rim);
        return rim;
    }

    private String tenConstruktor(int ten){
        StringBuffer result = new StringBuffer();
        if (ten>0 && ten<4){
            for (int y = 1; y < 4; y++){
                result.append("X");
                if (ten == y) break;
            }
        }
        if (ten>5 && ten<9){
            result.append("L");
            for (int y = 1; y < 4; y++){
                result.append("X");
                if (ten - 5 == y) break;
            }
        }
        if (ten == 5) {
            return "L";
        }
        if (ten == 4){
            return "XL";
        }
        if (ten == 9) {
            return "XC";
        }
        return result.toString();
    }

    private String analizNumber(int x){
        StringBuffer result = new StringBuffer();
        if (x>0 && x<4){
            for (int y = 1; y < 4; y++){
                result.append("I");
                if (x == y) break;
            }
        }
        if (x>5 && x<9){
            result.append("V");
            for (int y = 1; y < 4; y++){
                result.append("I");
                if (x - 5 == y) break;
            }
        }
        if (x == 5) {
            return "V";
        }
        if (x == 4){
            return "IV";
        }
        if (x == 9) {
            return "IX";
        }
        return result.toString();
    }
}
