import java.util.Scanner;
import java.util.InputMismatchException;

public class Main{
    public static void main(String[] args) {

        Scanner teclado=new Scanner(System.in);// crea un objeto Scanner para la entrada desde teclado
        Scanner escaner=new Scanner(System.in);// otro objeto Scanner

        System.out.print("La cadena que deseas ingresar es: ");//Lee la entrada caracteres String
        String lectTeclado=escaner.nextLine();//lectura Scanner

        try{//la primera posicion de la cadena es 0
            char resultado=CadenaCaracter.caracterEn(lectTeclado,7);
            System.out.println("El caracter en la posicion 7 es:" + resultado);//salida de caracteres String

        } catch (Exception e) {
            System.out.println("Has intentado recuperar una posicion de la cadena de caracteres que no existe");
        }

            boolean condicion = false;
        do{ condicion = false;
            try {
                System.out.print("Introduce un valor postivo:");//Entrada caracteres int en consola
                int num = teclado.nextInt();//lee el numero entero
                teclado.nextLine();//permite la entrada de caracteres

                if (num < 0) {
                throw new NumeroNegativoException("Error no es posible introducir un numero negativo");
                }
                System.out.println("la raiz cuadrada de "+num+" es: "+Math.sqrt(num)); //calculo + salida de caracteres int
            }catch(NumeroNegativoException ex){
                System.out.println("Error no es posible ingresar valores numericos negativos");
                condicion = true;
            } catch ( InputMismatchException ex) {
                System.out.println("Error, entrada incorrecta favor de ingresar al menos un valor numerico ");
                teclado.nextLine();
                condicion = true;
            }
            break;
        }while(condicion);

        teclado.close();
        escaner.close();//cierra el obejeto Scanner

    }

}
class CadenaCaracter { //metodo auxiliar de nombre “caracterEn”
    public static char caracterEn(String cadena, int entero) throws Exception { // parámetros de cadena (String) y un entero (int);
        if (entero >= 0 && entero < cadena.length()) {
            return cadena.charAt(entero); //  devuelve el carácter en la posición correspondiente
        } else {
            throw new Exception("Fuera del rango valido, ingresa mas de 7 caracteres");
        }
    }
}
class NumeroNegativoException extends Exception { //constructor sin parámetros que invoca el constructor de la clase base Exception
    public NumeroNegativoException(String mensaje) {// constructor con un parámetro de tipo String
        super(mensaje);// Llama al constructor de la clase base Exception con mensaje
    }
}