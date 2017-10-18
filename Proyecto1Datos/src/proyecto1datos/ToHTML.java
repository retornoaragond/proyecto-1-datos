/*
    Integrantes:
        Esteban Espinoza Fallas 402290345
        Alejandro Navarro Valverde 116070118
*/
package proyecto1datos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ToHTML {

    public ToHTML() {
        this.gen = new StringBuilder("");
    }

    public void parametros(int us, int max, String tjuego) {
        gen.append("<html>\n");
        gen.append("<body>\n");
        gen.append("<h1>Parametros iniciales</h1>\n");
        gen.append("<ol>\n");
        gen.append("    <li>Cantidad de usuarios: ");
        gen.append(us);
        gen.append("</li>\n");
        gen.append("    <li>Cantidad  maxima de cartones por usuario: ");
        gen.append(max);
        gen.append("</li>\n");
        gen.append("    <li>Tipo de juego: ");
        gen.append(tjuego);
        gen.append("</li>\n");
        gen.append("</ol>\n");
    }

    public void ronda(int r, Tombola t, Participantes p) {
        gen.append("<h2>Ronda N&deg");
        gen.append(r);
        gen.append("</h2>\n\n");
        gen.append("<table border=4>\n");
        for (int nc : t.getPila_bolitas()) {
            gen.append("<tr>");
            gen.append("<td><center>");
            gen.append(nc);
            gen.append("</center></td>\n");
            gen.append("</tr>\n");
        }
        gen.append("<tr>\n");
        gen.append("<td>");
        gen.append("PILA");
        gen.append("</td>\n");
        gen.append("</tr>\n");
        gen.append("</table>\n\n");
        for (Jugador j : p.getPlayers()) {
            gen.append("<h3>Jugador N&deg");
            gen.append(j.getNumero());
            gen.append(" (");
            gen.append(j.getCartones().size());
            gen.append(" tableros)</h3>\n");
            for (Carton c : j.getCartones()) {
                carton(c);
            }
        }
    }

    public void carton(Carton c) {
        gen.append("<table border=10>\n");
        gen.append("<tr>");
        gen.append("<td>B</td>\n");
        gen.append("<td>I</td>\n");
        gen.append("<td>N</td>\n");
        gen.append("<td>G</td>\n");
        gen.append("<td>O</td>\n");
        gen.append("</tr>");
        
        for (ArrayList<String> l : c.getCarton()) {
            gen.append("<tr>\n");
            for (String s : l) {
                gen.append("<td>");
                gen.append(s);
                gen.append("</td>\n"); 
            }
            gen.append("</tr>\n");
        }
        
        gen.append("</table>\n\n");
    }

    public void ganador(int i) {
        gen.append("<h1><font color=\"green\">GANADOR: JUGADOR N&deg");
        gen.append(i);
        gen.append("</font></h1>\n");
    }

    public void end() {
        gen.append("</body>\n");
        gen.append("</html>\n");
    }

    public void toHTML() {
        FileWriter filewriter;
        PrintWriter printw;
        try {
            filewriter = new FileWriter("JuegoBingo.html");
            printw = new PrintWriter(filewriter);
            printw.print(gen.toString());
            printw.close();
            System.out.println("Generado exitosamente");
        } catch (IOException ex) {
            Logger.getLogger(ToHTML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getGenerado() {
        return gen.toString();
    }

    private final StringBuilder gen;
}
