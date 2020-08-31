package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @description: 员工的重要性
 * @author: wang hao
 * @create: 2020-08-28 14:01
 */
public class _690 {
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    HashMap<Integer, Employee> map = new HashMap<>();

    public int getImportance(List<Employee> employees, int id) {
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        return dfs(map.get(id));
    }

    public int dfs(Employee employee) {
        int importance = employee.importance;
        List<Integer> subordinates = employee.subordinates;
        while (!subordinates.isEmpty()) {
            Employee e = map.get(subordinates.remove(0));
            importance += dfs(e);
        }
        return importance;
    }
}
