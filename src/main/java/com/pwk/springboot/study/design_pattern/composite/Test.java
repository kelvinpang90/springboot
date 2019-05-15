package com.pwk.springboot.study.design_pattern.composite;

public class Test {
    public static void main(String[] args){
        Company root = new ConcreteCompany("中国总公司");
        Company hr = new HRDepartment("中国公司HR部门");
        Company finance = new FinanceDepartment("中国公司Finance部门");
        root.addSubCompany(hr);
        root.addSubCompany(finance);

        Company gz = new ConcreteCompany("广州分公司");
        Company gzhr = new HRDepartment("广州分公司HR部门");
        Company gzfinance = new FinanceDepartment("广州分公司Fiance部门");
        gz.addSubCompany(gzhr);
        gz.addSubCompany(gzfinance);

        Company sz = new ConcreteCompany("深圳分公司");
        Company szhr = new HRDepartment("深圳分公司HR部门");
        Company szfiance = new FinanceDepartment("深圳分公司Fiance部门");
        sz.addSubCompany(szhr);
        sz.addSubCompany(szfiance);

        root.addSubCompany(gz);
        root.addSubCompany(sz);
        root.display(0);
    }
}
