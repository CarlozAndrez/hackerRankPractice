package java8;


import java8.sampleDomain.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class PredicateTest {

    @Test
    public void predicateExample() {

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(getEmployeeSample(100L, "FALCAO", "CAPTAIN"));
        employees.add(getEmployeeSample(200L, "CUADRADO", "RIGHT_WING"));
        employees.add(getEmployeeSample(300L, "IZQUIERDO", "LEFT_WING"));

        assertEquals(2, verifyEmployeeName(employees, p -> p.getRole().contains("WING")).size());

    }

    public ArrayList<Employee> verifyEmployeeName(ArrayList<Employee> employees, Predicate<Employee> predicate) {
        return (ArrayList<Employee>) employees.stream().filter(predicate).collect(Collectors.toList());
    }

    public Employee getEmployeeSample(Long id, String name, String role) {
        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(name);
        employee.setRole(role);
        return employee;
    }

    @Test
    public void lambdaTest() {
        MyLambda myLambda = () ->
                System.out.println("SOME TEXT");
        assertEquals("SOME TEXT", myLambda.toString());
    }

    interface MyLambda {
        void foo();
    }
}
