package geekbang.beautyOfDesignPatterns.composite.case2;

/**
 * @Author lnd
 * @Description
 * @Date 2023/1/31 0:14
 */
public abstract class HumanResource {
    protected long id;
    protected double salary;

    public HumanResource(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public abstract double calculateSalary();
}
