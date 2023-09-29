import java.util.Scanner;
import java.text.*;

class Calculator {
    public int batteryMax;
    public int battery;
    public float display;

    public Calculator(int batteryMax) {
        this.batteryMax = batteryMax;
        this.battery = 0;
        this.display = 0.0f;
    }

    public void chargeBattery(int value) {
        battery = Math.min(battery + value, batteryMax);
    }

    public boolean useBattery() {
        if (battery > 0) {
            battery--;
            return true;
        }
        return false;
    }

    public void sum(int a, int b) {
        if (useBattery()) {
            display = a + b;
        } else {
            System.out.println("fail: bateria insuficiente"); // Corrigido
        }
    }

    public void division(int num, int den) {
    if (den != 0 && useBattery()) {
        display = (float) num / den;
    } else {
        System.out.println("fail: divisao por zero");
    }
}


    public String toString() {
        DecimalFormat form = new DecimalFormat("0.00");
        return "display = " + form.format(this.display).replace(",", ".") + ", battery = " + this.battery;
    }
}

class Solver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calc = new Calculator(0);
        while (true) {
            String line = scanner.nextLine();
            System.out.println("$" + line);
            String ui[] = line.split(" ");
            if (line.equals("end")) {
                break;
            } else if (ui[0].equals("init")) {
                calc = new Calculator(Integer.parseInt(ui[1]));
            } else if (ui[0].equals("show")) {
                System.out.println(calc);
            } else if (ui[0].equals("charge")) {
                calc.chargeBattery(Integer.parseInt(ui[1]));
            } else if (ui[0].equals("sum")) {
                calc.sum(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]));
            } else if (ui[0].equals("div")) {
                calc.division(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]));
            } else {
                System.out.println("fail: comando invalido"); // Corrigido
            }
        }
        scanner.close();
    }
}
