package Structural;

/*

********* PROPERTIES ***********
- structural design pattern
- used when we need to create a large number of similar objects
- to reduce memory usage we share Objects that are similar in some way
  rather than creating new ones
- Intrinsic state: which are same for object
- Extrinsic state: which are different for object


********* IMPLEMENTATION ***********
- Interface: which contains common method: Employee
- Object: individual class: developer, tester
- intrinsic property:
   color, developer: fix the issue, tester: test the issue
- extrinsic property: size, skills
= we use Factory to return Object: EmployeeFactory

 */

import java.util.HashMap;
import java.util.Random;

interface Employee {
    void assignSkill(String skill);
    void task();
}

class Developer implements Employee {
    private String JOB;
    private String skill;

    public Developer() {
        JOB = "Fix the issue";
    }

    @Override
    public void assignSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public void task() {
        System.out.println("Developer with skill: " + skill + " with Job: " + JOB);
    }
}

class Tester implements Employee {
    private String JOB;
    private String skill;

    public Tester() {
        JOB = "Test the issue";
    }

    @Override
    public void assignSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public void task() {
        System.out.println("Tester with skill: " + skill + " with Job: " + JOB);
    }
}


// This factory only creates a new Employee if the
// type of employee is not previously present

class EmployeeFactory {

    // The HashMap uses the type as the key for every employee

    private static HashMap<String, Employee> mp = new HashMap<>();

    public static Employee getEmployee(String type) {
        Employee emp = null;

        // Checks if the employee with a specific
        // type is present. If not it creates a
        // new one, otherwise it returns one present already

        if(mp.get(type) != null) {
            emp = mp.get(type);
        }
        else {
            switch (type) {
                case "Developer":
                    System.out.println("Developer Created");
                    emp = new Developer();
                    break;
                case "Tester":
                    System.out.println("Tester Created");
                    emp = new Tester();
                    break;
                default:
                    System.out.println("No such employee");
            }
            mp.put(type, emp);
        }
        return emp;
    }
}


public class Flyweight {

    private static String employeeType[] = {"Developer", "Tester"};
    private static String skills[] = {"Java", "C++", ".Net", "Python"};

    public static void main(String[] args) {
        for(int i = 0; i < 10; i++) {
            Employee e = EmployeeFactory.getEmployee(getRandEmployee());

            e.assignSkill(getRandSkill());

            e.task();
        }
    }

    public static String getRandEmployee() {
        Random r = new Random();
        int randInt = r.nextInt(employeeType.length);

        return employeeType[randInt];
    }

    public static String getRandSkill() {
        Random r = new Random();
        int randInt = r.nextInt(skills.length);

        return skills[randInt];
    }
}
