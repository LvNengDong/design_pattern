package geekbang.beautyOfDesignPatterns.composite.case2;

import geekbang.beautyOfDesignPatterns.composite.case2.mockRepo.DepartmentRepo;
import geekbang.beautyOfDesignPatterns.composite.case2.mockRepo.EmployeeRepo;

import java.util.List;

/**
 * @Author lnd
 * @Description
 * @Date 2023/1/31 0:18
 */
//构建组织架构的代码
public class MainDemo2 {
    private static final long ORGANIZATION_ROOT_ID = 1001;//根ID
    private DepartmentRepo departmentRepo; // 依赖注入
    private EmployeeRepo employeeRepo; // 依赖注入

    public void buildOrganization() {
        Department rootDepartment = new Department(ORGANIZATION_ROOT_ID);
        buildOrganization(rootDepartment);
    }

    /**构建公司组织架构（部门+员工）*/
    private void buildOrganization(Department department) {
        //处理部门架构
        List<Long> subDepartmentIds = departmentRepo.getSubDepartmentIds(department.getId());
        for (Long subDepartmentId : subDepartmentIds) {
            Department subDepartment = new Department(subDepartmentId);
            department.addSubNode(subDepartment);
            buildOrganization(subDepartment);
        }

        //处理员工架构
        List<Long> employeeIds = employeeRepo.getDepartmentEmployeeIds(department.getId());
        for (Long employeeId : employeeIds) {
            double salary = employeeRepo.getEmployeeSalary(employeeId);
            department.addSubNode(new Employee(employeeId, salary));
        }
    }
}
