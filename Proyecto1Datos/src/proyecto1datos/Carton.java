package proyecto1datos;

import java.util.ArrayList;
import java.util.Collections;

public final class Carton {

    public Carton() {
        carton = new ArrayList<>();
        rellenar();
    }

    public void rellenar() {
        ArrayList<Integer> nums;
        ArrayList<String> columna = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            nums = generar(i);
            for (int j = 0; j < 5; j++) {
                columna.add(Integer.toString(nums.get(j)));
            }
            carton.add(columna);
        }
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

    public int ubicacion(int x) {
        if (1 <= x && x <= 15) {
            return 0;
        } else if (16 <= x && x <= 30) {
            return 1;
        } else if (31 <= x && x <= 45) {
            return 2;
        } else if (46 <= x && x <= 60) {
            return 3;
        } else if (61 <= x && x <= 75) {
            return 4;
        } else {
            return -1;
        }
    }

    public boolean isIn(int i) {
        int pos = ubicacion(i);
        return carton.get(pos).contains(Integer.toString(i));
    }
    
    public void cambiaX(int n){
        int pos = ubicacion(n);
        String x = "X";
        for(String s : carton.get(pos)){
            if(Integer.toString(n).equals(s)){
                s = x;
                break;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("[\n");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                s.append("[").append(carton.get(j).get(i));
                if(j==4){
                    s.append("]\n");
                }else{
                    s.append("],");
                }
            }
        }
        s.append("]\n");
        return s.toString();
    }

    private final ArrayList<ArrayList<String>> carton;
}
