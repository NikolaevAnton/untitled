public class Math {
    // a - 1 цифра b - 2 цифра o - операция: сложение, вычитание, умножение, деление
    public int Calk(int a, int b, int c){
        switch (c){
            case 1:
                return a + b;
            case 2:
                return a - b;
            case 3:
                return a * b;
            case 4:
                return a / b;
        }

        return 0;
    }
}
