package geekbang.beautyOfDesignPatterns.composite.case2.mockRepo;

import java.util.List;

/**
 * @Author lnd
 * @Description 模拟从数据库查员工信息
 * @Date 2023/1/31 0:20
 */
public class EmployeeRepo {
    /**获取员工IDs*/
    public List<Long> getDepartmentEmployeeIds(long id) {
        return null;
    }

    /**获取员工工资*/
    public double getEmployeeSalary(Long employeeId) {
        return 0;
    }
}
