package com.pwk.springboot.study.design_pattern.composite;

public class FinanceDepartment extends Company {

    public FinanceDepartment(String name) {
        super(name);
    }

    @Override
    protected void addSubCompany(Company company) {
        //do something
    }

    @Override
    protected void removeSubCompany(Company company) {
        //do something
    }

    @Override
    protected void display(int depth) {
        StringBuilder sb = new StringBuilder("");
        for(int i = 0;i<depth;i++){
            sb.append("-");
        }
        System.out.println(sb.toString()+super.getName());
    }
}
