package sda.Workers;

import sda.Workers.AbstractEmployee;
import sda.Workers.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static jdk.nashorn.internal.objects.NativeArray.forEach;

public class Application {
    public static void main(String[] args) {
        List<AbstractEmployee> employeeList = new ArrayList<>();
        employeeList.add(new AbstractEmployee("Szymon", "Nowak", 2000, "JAVA"));
        employeeList.add(new AbstractEmployee("Jan", "Kowalski", 3600, "PHP"));
        employeeList.add(new AbstractEmployee("George", "Washington", 5000, "presidency"));
        employeeList.add(new AbstractEmployee("Halabala", "Werner", 31578, "JAVA"));
        employeeList.add(new AbstractEmployee("Lucjusz", "Malfoj", 2000, "HR"));
        employeeList.add(new AbstractEmployee("Szymon", "Nowak", 7000, "Director"));

        employeeList.stream()
                .filter(e -> e.getFirstName().equals("Szymon"))
//                .filter(e -> e.getDepartment().equals("JAVA"))
//                .filter(e -> e.getLastName().startsWith("N"))
//                .filter(e -> e.getDepartment().endsWith("y"))
//                .filter(e -> e.getSalary() >= 3000)
                .forEach(e -> System.out.println(e));

        System.out.println();

        List<AbstractEmployee> javaEmployees = employeeList.stream()
                .filter(e -> e.getDepartment().equals("JAVA"))

                .collect(Collectors.toList());
        System.out.println(javaEmployees);
        System.out.println();


        Map<String, AbstractEmployee> map = employeeList.stream()
                .collect(Collectors.toMap((e -> e.getFirstName()), e -> e));
        map.forEach((k, v) -> System.out.println((k + ":" + v)));

        employeeList.sort((e1, e2) -> e1.getSalary() > e2.getSalary() ? 1 : -1);
        System.out.println(employeeList.get(0));

        System.out.println();

        AbstractEmployee richestEmployee = employeeList.stream()
                .max((e1,e2) -> e1.getSalary() > e2.getSalary() ? 1 : -1)
                .get();

        System.out.println(richestEmployee);

        AbstractEmployee poorestEmployee = employeeList.stream()
                .min((e1,e2) -> e1.getSalary() > e2.getSalary() ? 1 : -1)
                .get();

        System.out.println(poorestEmployee);

        Map<String, List<AbstractEmployee>> stringListMap = listToMap(employeeList);
        List<AbstractEmployee> tmpList = new ArrayList<>();
            stringListMap.entrySet().stream()
                    .forEach(e -> {
                        List<AbstractEmployee> value = e.getValue();
                        value.stream()
                                .filter(e1 -> e1.getSalary() > 3000);
                    });


    }

    public static Map<String, List<AbstractEmployee>> listToMap(List<AbstractEmployee>employees){

        Map<String, List<AbstractEmployee>> map  = new HashMap<>();
        for (AbstractEmployee employee : employees) {
            if (map.containsKey(employee.getDepartment())){
                List<AbstractEmployee> listOfEmployees = map.get(employee.getDepartment());
                listOfEmployees.add(employee);
            }else{
                ArrayList<AbstractEmployee> listOfEmployees = new ArrayList<>();
                listOfEmployees.add(employee);
                map.put(employee.getDepartment(),listOfEmployees);
            }

        }
        return map;
    }

}

