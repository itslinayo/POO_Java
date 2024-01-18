import java.util.Scanner;

public class App {
    public static void main(String[] _args){
        Animais animal = new Animais("", "");

        while(true){
            String line = input(); 
            String[] args = line.split(" "); // declaração de uma variável string que será um array () divide a string em partes menores, o caracter separador é espaço
            write("$" + line);

            if(args[0].equals("init")){
                animal = new Animais(args[1], args[2]);
            }else if(args[0].equals("grow")){
                animal.envelhecer((int) number(args[1]));
            }else if(args[0].equals("noise")){
                write(animal.fazerBarulho());
            }else if(args[0].equals("show")){
                write(animal.toString());
            }else if(args[0].equals("end")){
                break;
            }else{
                write("fail: comando invalido");
            }
        }
    }

    static Scanner scanner = new Scanner(System.in);
    public static String input(){
        return scanner.nextLine(); // lendo entrada de texto de linha inteira do usuário, incluindo espaços, até o ENTER.
    }
    public static void write(String value){
        System.out.println(value);
    }
    public static double number(String str){
        return Double.parseDouble(str); // transforma string em double.
    }
}
