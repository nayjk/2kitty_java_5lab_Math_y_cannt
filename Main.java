import java.util.Scanner;
// x+y/y+1, при y+1=0 или y = -1
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите x");
        int x = in.nextInt();
        System.out.println("Введите y");
        int y = in.nextInt();
        try{
            double result = Result.getResult(x,y);
            System.out.printf("x+y/y+1 = %f", result);
        }
        catch (formulaException ex){
            System.out.println(ex.getMessage());
            System.out.println(ex.getY());
        }
    }
}
class formulaException extends Exception{
    private final double y;
    public double getY(){
        return y;
    }
    public formulaException(String massage, double y){
        super(massage);
        this.y = y;
    }
}
class Result {
    public static double getResult(double x, double y) throws formulaException {
        double result;
        if(y == -1) throw new formulaException("y = -1, деление на ноль", y);
        double a = x + y;
        double b = y + 1;
        result = a/b;
        return result;
    }
}