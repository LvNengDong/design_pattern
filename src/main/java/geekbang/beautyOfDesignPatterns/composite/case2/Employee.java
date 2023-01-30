package geekbang.beautyOfDesignPatterns.composite.case2;

/**
 * @Author lnd
 * @Description
 * @Date 2023/1/31 0:16
 */
public class Employee extends HumanResource {

    public Employee(long id, double salary) {
        super(id);
        this.salary = salary;
    }

    @Override
    public double calculateSalary() {
        return salary;
    }
}
