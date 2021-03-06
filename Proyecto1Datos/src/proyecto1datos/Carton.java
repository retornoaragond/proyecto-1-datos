/*
    Integrantes:
        Esteban Espinoza Fallas 402290345
        Alejandro Navarro Valverde 116070118
*/

package proyecto1datos;

import java.util.ArrayList;
import java.util.Collections;

public final class Carton {

    public Carton() {
        carton = new ArrayList<>();
        rellenar();
        System.out.println(toString());
    }

    public void rellenar() {
        ArrayList<Integer> nums;
        for (int i = 0; i < 5; i++) {
            ArrayList<String> columna = new ArrayList<>();
            nums = generar(i);
            for (int j = 0; j < 5; j++) {
                columna.add(Integer.toString(nums.get(j)));
            }
            carton.add(columna);
        }
    }

    public ArrayList<ArrayList<String>> getCarton() {
        return carton;
    }

    public ArrayList<Integer> generar(int fila) {
        ArrayList<Integer> num = new ArrayList<>();
        int x, y;
        switch (fila) {
            case 0:
                x = 1;
                y = 15;
                break;
            case 1:
                x = 16;
                y = 30;
                break;
            case 2:
                x = 31;
                y = 45;
                break;
            case 3:
                x = 46;
                y = 60;
                break;
            default:
                x = 61;
                y = 75;
                break;
        }
        for (int i = x; i <= y; i++) {
            num.add(i);
        }
        Collections.shuffle(num);
        return num;
    }

    public int ubicacionx(int n) {
        if (1 <= n && n <= 15) {
            return 0;
        } else if (16 <= n && n <= 30) {
            return 1;
        } else if (31 <= n && n <= 45) {
            return 2;
        } else if (46 <= n && n <= 60) {
            return 3;
        } else if (61 <= n && n <= 75) {
            return 4;
        } else {
            return -1;
        }
    }
    
    public int ubicaciony(int n,ArrayList<String> l){
         for (int i = 0; i < 5; i++) {
             if(l.get(i).equals(Integer.toString(n))){
                 return i;
             }
         }
         return -1;
    }

    public boolean isIn(int i) {
        int pos = ubicacionx(i);
        return carton.get(pos).contains(Integer.toString(i));
    }
    
    public void cambiaX(int n){
        int pox = ubicacionx(n);
        int posy = ubicaciony(n, carton.get(pox));
        carton.get(pox).set(posy,"X");
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("          B      I       N       G       O\n");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                s.append("\t[").append(carton.get(j).get(i));
                if(j==4){
                    s.append("]\n");
                }else{
                    s.append("],");
                }
            }
        }
        s.append("\n");
        return s.toString();
    }

    private final ArrayList<ArrayList<String>> carton;
}
