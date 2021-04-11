public class Person {
    private String name;
    private int age;
    private int cashAmount;
    private BankAccount account;

    public Person(String name) {
        this(name, 12, 0); // 12살을 기본 나이로 설정, 초기 현금 보유액은 0원.
    }

    public Person(String name, int age) {
        this(name, age, 0); // 초기 현금 보유액은 0원.
    }

    public Person(String name, int age, int cashAmount) {
        if (age < 0) {
            this.age = 12;
        } else {
            this.age = age;
        }

        if (cashAmount < 0) {
            this.cashAmount = 0;
        } else {
            this.cashAmount = cashAmount;
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(int cashAmount) {
        this.cashAmount = cashAmount;
    }

    public BankAccount getAccount() {
        return account;
    }

    public void setAccount(BankAccount account) {
        this.account = account;
    }


    // account와 account 간의 거래이므로, 첫째로 BankAccount 클래스의 transfer 메소드를 써야함.
    // 둘째로 Person to의 정보를 to의 account 정보로 바꾸어 호출.
    public boolean transfer(Person to, int amount) {
        return account.transfer(to.getAccount(), amount);
    }

    // account와 account 간의 거래이므로, BankAccount 클래스의 transfer 메소드를 써야함.
    public boolean transfer(BankAccount to, int amount) {
        return account.transfer(to, amount);
    }
}