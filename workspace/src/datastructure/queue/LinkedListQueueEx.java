/**
 * 개와 고양이만 분양하는 분양소가 있다.
 * 분양받는 사람은 동물의 종류만 고를 수 있고 (고르지 않을 수도 있다.),
 * 분양소에서 가장 오래 있은 순서로 자동으로 분양될 동물이 정해지는 클래스를 구현하시오.
 * (단, Java에서 제공하는 LinkedList로 구현하시오.)
 */

package datastructure.queue;

import java.util.LinkedList;

enum AnimalType {
    DOG, CAT
}

abstract class Animal {
    AnimalType type;
    String name;
    int order;

    public Animal(AnimalType type, String name) {
        this.type = type;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s. [%s]%s", order, type.name(), name);
    }
}

class Dog extends Animal {

    public Dog(String name) {
        super(AnimalType.DOG, name);
    }
}

class Cat extends Animal {

    public Cat(String name) {
        super(AnimalType.CAT, name);
    }
}

class AnimalShelter<T extends Animal> {
    LinkedList<Dog> dogList;
    LinkedList<Cat> catList;
    int order;

    public AnimalShelter() {
        dogList = new LinkedList<>();
        catList = new LinkedList<>();
        order = 1;
    }

    public void come(Animal animal) {
        animal.order = order++;

        if (animal.type == AnimalType.DOG) {
            dogList.addLast((Dog) animal);
        } else {
            catList.addLast((Cat) animal);
        }
    }

    public Animal out() {
        if (dogList.size() == 0 && catList.size() == 0) {
            return null;
        } else if (dogList.size() == 0) {
            return catList.pollFirst();
        } else if (catList.size() == 0) {
            return dogList.pollFirst();
        }

        Dog dog = dogList.peekFirst();
        Cat cat = catList.peekFirst();

        if (dog.order > cat.order) {
            return catList.pollFirst();
        } else {
            return dogList.pollFirst();
        }
    }

    public Animal out(AnimalType animal) {
        if (animal == AnimalType.DOG) {
            return dogList.pollFirst();
        } else {
            return catList.pollFirst();
        }
    }
}

public class LinkedListQueueEx {
    public static void main(String[] args) {
        AnimalShelter<Animal> shelter = new AnimalShelter<>();
        shelter.come(new Cat("cat1"));
        shelter.come(new Dog("dog1"));
        shelter.come(new Cat("cat2"));
        shelter.come(new Cat("cat3"));
        shelter.come(new Dog("dog2"));
        shelter.come(new Dog("dog3"));
        shelter.come(new Cat("cat4"));
        shelter.come(new Cat("cat5"));
        shelter.come(new Dog("dog4"));
        System.out.println(shelter.out(AnimalType.CAT));
        System.out.println(shelter.out(AnimalType.CAT));
        System.out.println(shelter.out(AnimalType.CAT));
        System.out.println(shelter.out(AnimalType.DOG));
        System.out.println(shelter.out(AnimalType.DOG));
        System.out.println(shelter.out());
        System.out.println(shelter.out());
        System.out.println(shelter.out());
    }
}
