import java.util.Scanner;

public class Point10 {

    public int multiWithSums(int numb, int numb2){
        int multi = 0;
        for(int i=1; i<=numb2; i++){
            multi += numb;
        }
        return multi;
    }

    public int pow(int base, int exponent) {
        int result = base;
        for(int i=1; i<exponent;i++){
            result = multiWithSums(result, base);
        }
        if(exponent != 0){
            return result;
        }else{
            return 0;
        }
    }

    public static void main(String[] args){
        Point10 func = new Point10();
        System.out.println(func.pow(3,2));
        System.out.println(func.pow(3,3));
        System.out.println(func.pow(5,3));
        System.out.println(func.pow(5,0));
        Scanner scn = new Scanner(System.in);

        int base = 0;
        while (base >=0){
            //Initiate data manually
            base = scn.nextInt();
            if (base<0){
                System.out.println("The program cannot support negative values as a base");
            }else{
                int expo = scn.nextInt();
                System.out.println(func.pow(base, expo));
            }

        }
    }
}
