

public class Arabic extends Number {

    private int a;
    private int b;
    private int result;
    //конструктор класса Arabic
    Arabic(int value1, int value2) {
        if (value1 <=0 || value1<10 || value2 <=0 || value2>10 ) {
            a = value1;
            b = value2;
        }else System.out.println("Ошибка !!!! (Первое и второе число длолжны быть в деопазоне от 0 до 10)");

    }
    // медод сложение из основного класса
    public void sum() {
        this.result = a + b;
    }
    // метод вычитания
    public void sub() {
        this.result = a - b;
    }
    // метод деления
    public void div() {
        try{
            this.result = a / b;
        } catch (ArithmeticException e) {
            System.out.print("Делить на ноль нельзя! ");
            return;
        }

    }
    // метод для умножения
    public void mul() {
        this.result = a * b;
    }
    // получить результат
    @Override
    public int getResult() {
        return result;
    }
    //получить результат в строчку
    @Override
    public String getStringResult() {
        return "" + result;
    }

    //получить первое число
    public int getValue1() {
        return a;
    }
//получить второе число
    public int getValue2() {
        return b;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public void setValue1(int value1) {
        a=value1;
    }

    public void setValue2(int value2) {
        b=value2;
    }
}