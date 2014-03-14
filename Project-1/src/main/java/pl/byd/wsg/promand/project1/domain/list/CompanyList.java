package pl.byd.wsg.promand.project1.domain.list;

import java.util.ArrayList;
import java.util.List;

import pl.byd.wsg.promand.project1.domain.entity.Company;

public class CompanyList {

    private List<Company> companyList = new ArrayList<Company>();

    public void add(Company company){
        companyList.add(company);
    }

    public List<Company> getCompanyList() {
        return companyList;
    }
}
