package com.ps;

import java.util.ArrayList;

public class Zoo {
    private String name;
    private String address;
    private String phone;

    private ArrayList<Animal> animals;

    public Zoo(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.animals = new ArrayList<>();
    }

    public void cleanAllHabitats(){
        for(Animal animal: animals){
            animal.cleanHabitat();
        }
    }
    public void addAnimal(Animal animal){
        animals.add(animal);
    }

    public void removeAnimal(Animal animal){
        animals.remove(animal);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", animals=" + animals +
                '}';
    }
}