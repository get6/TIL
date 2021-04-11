public class BankAccount {
    private int balance;
    private Person owner;

    // 생성자
    public BankAccount(Person owner) {
        this(0);
        this.owner = owner;
        owner.setAccount(this);
    }

    public BankAccount(int pBalance) {
        if (pBalance < 0) {
            balance = 0;
        } else {
            balance = pBalance;
        }
    }

    public BankAccount(int pBalance, Person pOwner) {
        balance = pBalance;
        owner = pOwner;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    // 파라미터 : 입금할 액수(정수)
    // 리턴 : 성공여부(불린)
    boolean deposit(int amount) {
        // 1. write code here
        if (amount < 0 || owner.getCashAmount() < amount) {
            System.out.printf("입금 실패입니다. 잔고: %d원, 현금: %d원\nfalse\n", balance, owner.getCashAmount());
            return false;
        }
        balance += amount;
        owner.setCashAmount(owner.getCashAmount() - amount);

        System.out.printf("%d원 입금하였습니다. 잔고: %d원, 현금: %d원\ntrue\n", amount, balance, owner.getCashAmount());
        return true;
    }

    public boolean deposit(double amount, double exchangeRate) {
        return deposit((int) (amount * exchangeRate));
    }

    // 파라미터 : 출금할 액수(정수)
    // 리턴 : 성공여부(불린)
    boolean withdraw(int amount) {
        // 2. write code here
        if (amount < 0 || balance < amount) {
            System.out.printf("출금 실패입니다. 잔고: %d원, 현금: %d원\nfalse\n", balance, owner.getCashAmount());
            return false;
        }
        balance -= amount;
        owner.setCashAmount(owner.getCashAmount() + amount);

        System.out.printf("%d원 출금하였습니다. 잔고: %d원, 현금: %d원\ntrue\n", amount, balance, owner.getCashAmount());
        return true;
    }

    public boolean transfer(BankAccount to, int amount) {
        boolean success;

        if (amount < 0 || amount > balance) {
            success = false;
        } else {
            balance -= amount;
            to.balance += amount;
            success = true;
        }

        System.out.println(success + " - from: " + owner.getName()
                + ", to: " + to.owner.getName()
                + ", amount: " + amount
                + ", balance: " + balance);

        return success;
    }

    // account와 account 간의 거래이므로, Person to의 정보를 to의 account 정보로 바꾸어 호출.
    public boolean transfer(Person to, int amount) {
        return transfer(to.getAccount(), amount);
    }


}