package Application32;

public class Cat extends Animal {
    private String litterPreference;

    public Cat(String name) {
        super(name); // agora chama o construtor da superclasse
    }

    public Cat() {
        super();
    }

    public String getLitterPreference() {
        return litterPreference;
    }

    public void setLitterPreference(String litterPreference) {
        try {
            this.litterPreference = litterPreference;
        } catch(Exception e){
            System.out.println("error");
        }
    }

    @Override
    public void makeSound() {
        System.out.println(name + " diz: Miau!");
    }
}
