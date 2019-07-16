package br.com.exercise.model;

import java.math.BigDecimal;

public class Salesman extends AbstractEntity{

    public static final String SALESMAN_CODE = "001";

    private BigDecimal salary;

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
