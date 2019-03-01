package com.example.a222;

import java.util.ArrayList;

public class ListOfGamers {
    ArrayList<String> names;

    public ListOfGamers(){
        names = new ArrayList<>();
    }

    public void add(String name){
        names.add(name);
    }

    public ArrayList<String> getNames() {
        return names;
    }

    public void setNames(ArrayList<String> names) {
        this.names = names;
    }

    public int size(){
        return names.size();
    }

    public void remove(int position){
        names.remove(position);
    }

    public String getNames(int position) {
        return names.get(position-1);
    }
}
