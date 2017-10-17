
package proyecto1datos;

import java.util.Scanner;

public class Proyecto1Datos {

    
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int tipojuego;
        int players;
        int maxcartones;
        
        System.out.println("Ingrese la cantidad de jugadores. ");
        players = entrada.nextInt();
        System.out.println("Ingrese la cantidad de cartones máximo por jugador. ");
        maxcartones = entrada.nextInt();
        opciones ();
        System.out.println("Ingrese el numero correspondiente a la accion que desea. ");
        tipojuego = entrada.nextInt();
        
        Juego bingo = new Juego(maxcartones, players);
        bingo.jugar(tipoJuego(tipojuego)); 
    }
    
    static void opciones (){
        StringBuilder s  = new StringBuilder();
        s.append("Tipos de juego: \n");
        s.append("(1) Linea Completa \n");
        s.append("(2) Diagonal \n");
        s.append("(3) Letra 'C' \n");
        s.append("(4) Letra 'X' \n");
        s.append("(5) Letra 'U' \n");
        s.append("(6) Letra 'O' \n");
        s.append("(7) 'BINGO'");
        System.out.println(s.toString());
    }
    static String tipoJuego(int i){
        switch (i) {
            case 1:
                return "(1)Linea Completa";
            case 2:
                return "(2)Diagonal";
            case 3:
                return "(3)'C'";
            case 4:
                return "(4)'X'";
            case 5:
                return "(5)'U'";
            case 6:
                return "(6)'O'";
            case 7:
                return "(7)BINGO";
            default:
                return "(7)BINGO";
        }
    }
    
}
