package com.arraybased;

public class InheritTest {
    public static void main(String[] args) {
        Animal animal = new Animal("Anima");
        animal.makeSound();

        Dog dog = new Dog("Dog");
        dog.makeSound();

        Animal a = new Dog("AnimaDog");
        a.makeSound();
    }
}

class Animal {

    final String name;

    Animal(String name) {
        this.name = name;
    }

    void makeSound() {
        System.out.println("Generic Sound From Animal "+name);
    }
}

class Dog extends Animal {

    final String name;

    Dog(String name) {
        super(name);
        this.name = name;
    }

    void makeSound() {
        System.out.println("Bow Bow from "+name);
    }
}
