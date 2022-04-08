package ru.gb.level1.lesson5;

public class Employee {

    /**
     * ФИО
     */
    private String fullName;

    /**
     * Должность
     */
    private String position;

    /**
     * Email
     */
    private String email;

    /**
     * Телефон
     */
    private String phone;

    /**
     * Зарплата
     */
    private long salary;

    /**
     * Возраст
     */
    private int age;

    public Employee(
            String fullName,
            String position,
            String email,
            String phone,
            long salary,
            int age
    ) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.format("{\n" +
                        "  fullName=\"%s\",\n" +
                        "  position=\"%s\",\n" +
                        "  email=\"%s\",\n" +
                        "  phone=\"%s\",\n" +
                        "  salary=%d,\n" +
                        "  age=%d\n" +
                        "}",
                fullName, position, email, phone, salary, age);
    }

    public String getFullName() {
        return fullName;
    }

    public String setFullName(String fullName) {
        return this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
