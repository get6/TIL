public class Cat extends AbstractAnimal {
    Cat(String name) {
        super(name);
    }

    @Override
    public void cry() {
        System.out.print("야옹\n");
    }
}
