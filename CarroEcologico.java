import java.util.*;

class Car{
    public int pass;
    public int passMax;
    public int gas;
    public int gasMax;
    public int km;
    
    public Car(){
        pass = 0;
        gas = 0;
        km = 0;
        passMax = 2;
        gasMax = 100;
    }
    
    public void enter(){
        if(pass < passMax){
            pass += 1;
        }else{
            System.out.println("fail: limite de pessoas atingido");
        }
    }
    
    public void leave(){
        if(pass > 0){
            pass -= 1;
        }else{
            System.out.println("fail: nao ha ninguem no carro");
        }
    }
    
    public void drive(int value){
       if(pass >= 1){
           if(gas > 0){
               if(gas - value >= 0){
                   gas -= value;
                   km += value;
               }else{
                   km += gas;
                   System.out.println("fail: tanque vazio apos andar " + gas + " km");
                   gas = 0;
               }
           }else{
               System.out.println("fail: tanque vazio");
           }
       }else{
           System.out.println("fail: nao ha ninguem no carro"); 
       }
    }
    
    public void fuel(int value){
        if(gas + value < gasMax){
            gas += value;
        }else{
            gas = gasMax;
        }
    }
    
    public String toString(){
        return "pass: " + pass + ", gas: " + gas + ", km: " + km;
    }
}


public class Solver {
    public static void main(String[] a) {
        Car car = new Car();
        
        while (true) {
            var line = input();
            write("$" + line);
            var args = line.split(" ");

            if      (args[0].equals("show"))  { System.out.println(car);              }
            else if (args[0].equals("enter")) { car.enter();                          }
            else if (args[0].equals("leave")) { car.leave();                          }
            else if (args[0].equals("drive")) { car.drive((int) number(args[1]));     }
            //--
            else if (args[0].equals("fuel"))  { car.fuel((int) number(args[1]));      }
            else if (args[0].equals("end"))   { break;                                }
            else                              { write("fail: comando invalido");}
        }
    }

    private static Scanner scanner = new Scanner(System.in);
    private static String  input()              { return scanner.nextLine(); }
    private static double  number(String value) { return Double.parseDouble(value); }
    private static void    write(String value)  { System.out.println(value); }
}
