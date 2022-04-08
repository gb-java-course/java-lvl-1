package ru.gb.level1.lesson5;

public class Lesson5 {

    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Иванов Иван Иванович", "Директор", "ivanov@mail.ru", "8922933977", 100500L, 45);
        employees[1] = new Employee("Федоров Федор Федорович", "Администратор", "fedorov@mail.ru", "8922336947", 10050L, 40);
        employees[2] = new Employee("Степанов Степан Степанович", "Старший инженер", "stepanov@mail.ru", "8922134957", 10050L, 42);
        employees[3] = new Employee("Алексеев Алексей Алексеевич", "Инженер", "alekseyev@mail.ru", "8926943987", 1005L, 33);
        employees[4] = new Employee("Александров Александр Александрович", "Младший инженер", "alexandrov@mail.ru", "89249538997", 100L, 25);

        for (Employee employee : employees) {
            if (employee.getAge() > 40) {
                employee.printInfo();
            }
        }
    }
}
