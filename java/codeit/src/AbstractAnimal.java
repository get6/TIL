public abstract class AbstractAnimal {
    public final String name;

    AbstractAnimal(String name) {
        this.name = name;
    }

    public abstract void cry();
}