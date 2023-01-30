## 需求
假设我们在开发一个 OA 系统（办公自动化系统）。**公司的组织结构包含部门和员工两种数据类型。其中，部门又可以包含子部门和员工**。在数据库中的表结构如下所示：
![](https://secure2.wostatic.cn/static/aq5JVX2HVBD65sbCTNi5Zu/aq5JVX2HVBD65sbCTNi5Zu.jpeg?auth_key=1675091989-d5PtHhhiY1pQUxaKck4nWh-0-1daabe5a916cd6103503102cb99a71ba)
我们希望在内存中构建整个公司的人员架构图（部门、子部门、员工的隶属关系），并且提供接口计算出部门的薪资成本（隶属于这个部门的所有员工的薪资和）。

部门包含子部门和员工，这是一种嵌套结构，可以表示成树这种数据结构。计算每个部门的薪资开支这样一个需求，也可以通过在树上的遍历算法来实现。所以，从这个角度来看，这个应用场景可以使用组合模式来设计和实现。

这个例子的代码结构跟上一个例子的很相似，代码实现我直接贴在了下面，你可以对比着看一下。其中，HumanResource 是部门类（Department）和员工类（Employee）抽象出来的父类，为的是能统一薪资的处理逻辑。Demo 中的代码负责从数据库中读取数据并在内存中构建组织架构图。