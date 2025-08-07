package Application32;

public class Dog extends Animal {
    int walkDistancePreference;

    public Dog(String name) {
        super(name);
    }

    public Dog() {
        super();
    }

    @Override
    public void makeSound() {
        System.out.println(name + " diz: Au au!");
    }
}
