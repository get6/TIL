public class Dog extends AbstractAnimal {
    Dog(String name) {
        super(name);
    }

    @Override
    public void cry() {
        System.out.print("왈왈\n");
    }
}
