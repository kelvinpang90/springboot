package com.pwk.springboot.study.design_pattern.composite;

import java.util.ArrayList;
import java.util.List;

public class ConcreteCompany extends Company {

    private List<Company> companies = new ArrayList<>();

    public ConcreteCompany(String name) {
        super(name);
    }

    @Override
    protected void addSubCompany(Company company) {
        companies.add(company);
    }

    @Override
    protected void removeSubCompany(Company company) {
        companies.remove(company);
    }

    @Override
    protected void display(int depth) {
        StringBuilder sb = new StringBuilder("");
        for(int i = 0;i<depth;i++){
            sb.append("-");
        }
        System.out.println(sb.toString()+this.getName());
        for (Company company:companies){
            company.display(depth+1);
        }
    }
}
