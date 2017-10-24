package my.lib.serenity.primefaces.sars.model;

/**
 * Created by michael on 29/09/2016.
 */
public class CompanyDetailModel {
    private String companyFullName;
    private String workType;
    private String listed;
    private String headOffice;
    private String customerCode;
    private String website;
    private String branches;
    private String furigana;
    private String companyName;

    public CompanyDetailModel(String companyFullName, String workType, String listed, String headOffice, String customerCode, String website, String branches, String furigana, String companyName) {
        this.companyFullName = companyFullName;
        this.workType = workType;
        this.listed = listed;
        this.headOffice = headOffice;
        this.customerCode = customerCode;
        this.website = website;
        this.branches = branches;
        this.furigana = furigana;
        this.companyName = companyName;
    }

    @Override
    public boolean equals(Object obj) {
        CompanyDetailModel company = (CompanyDetailModel) obj;
        return this.companyFullName.equalsIgnoreCase(company.getCompanyFullName()) && this.workType.equalsIgnoreCase(company.getWorkType()) && this.listed.equalsIgnoreCase(company.getListed())
                && this.headOffice.equalsIgnoreCase(company.getHeadOffice()) && this.customerCode.equalsIgnoreCase(company.getCustomerCode()) && this.website.equalsIgnoreCase(company.getWebsite())
                && this.branches.equalsIgnoreCase(company.getBranches()) && this.furigana.equalsIgnoreCase(company.getFurigana()) && this.companyName.equalsIgnoreCase(company.getCompanyName());
    }

    public String getCompanyFullName() {
        return this.companyFullName;
    }

    public void setCompanyFullName(String companyFullName) {
        this.companyFullName = companyFullName;
    }

    public String getWorkType() {
        return this.workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public String getListed() {
        return this.listed;
    }

    public void setListed(String listed) {
        this.listed = listed;
    }

    public String getHeadOffice() {
        return this.headOffice;
    }

    public void setHeadOffice(String headOffice) {
        this.headOffice = headOffice;
    }

    public String getCustomerCode() {
        return this.customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getBranches() {
        return branches;
    }

    public void setBranches(String branches) {
        this.branches = branches;
    }

    public String getFurigana() {
        return furigana;
    }

    public void setFurigana(String furigana) {
        this.furigana = furigana;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
