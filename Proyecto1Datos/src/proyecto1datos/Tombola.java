package proyecto1datos;

import java.util.ArrayList;
import java.util.Collections;

public  class Tombola {

    public Tombola() {
        this.pila_bolitas = new ArrayList<>();
        this.generados = genRand();
    }
    
    public final ArrayList<Integer> genRand(){
        ArrayList<Integer> nums = new ArrayList<>();
        for(int i = 1; i <76;i++){
            nums.add(i);
        }
        Collections.shuffle(nums);
        return nums;
    }

    @Override
    public String toString() {
        return "Tombola{" + "pila_bolitas=" + pila_bolitas.toString() + "}";
    }
    
    public int getbolita(){
        pila_bolitas.add(generados.remove(0));
        return pila_bolitas.get(pila_bolitas.size()-1);
    }
    
    private final ArrayList<Integer> pila_bolitas;
    private final ArrayList<Integer> generados;
}
