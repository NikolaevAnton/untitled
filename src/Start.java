import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Start {

    public static void main(String[] args) throws IOException {

        //System.out.println("Введите операцию, например 1 + 6");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String calkString = reader.readLine();


        Intepret intepret = new Intepret();
        intepret.itIs(calkString);
        intepret.printResult(intepret.isArabStyle);

    }
}
