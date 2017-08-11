package com.kinslau.Test;

/**
 * Created by 刘 辉 on 2017/8/4.
 */
public class Zoo {
    private Animal animal;
    public Animal getAnimal(){
        return animal;
    }

    public void setAnimal(Animal animal){
        this.animal = animal;
    }

    @Override
    public String toString() {
        if (animal == null){
            return null;
        }
        return animal.toString();
    }
}
