package com.pwk.springboot.study.design_pattern.composite;

public abstract class Company {
    private String name;

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    protected abstract void addSubCompany(Company company);

    protected abstract void removeSubCompany(Company company);

    protected abstract void display(int depth);
}
