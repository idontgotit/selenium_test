package my.lib.serenity.primefaces.sars.model;

/**
 * Created by ngoc on 08/11/2016.
 */
public class MaintainCreditAccountTableModel {
    private String customerCode;
    private String SansanCompanyId;
    private String companyName;
    private String companyNo;
    private String companyNameInKana;
    private String clientStatus;
    private String yearStart;
    private String yearEstablish;
    private String lastExport;

    public MaintainCreditAccountTableModel() {
    }

    public String getCustomerCode() {
        return this.customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getSansanCompanyId() {
        return this.SansanCompanyId;
    }

    public void setSansanCompanyId(String sansanCompanyId) {
        this.SansanCompanyId = sansanCompanyId;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyNo() {
        return this.companyNo;
    }

    public void setCompanyNo(String companyNo) {
        this.companyNo = companyNo;
    }

    public String getCompanyNameInKana() {
        return this.companyNameInKana;
    }

    public void setCompanyNameInKana(String companyNameInKana) {
        this.companyNameInKana = companyNameInKana;
    }

    public String getClientStatus() {
        return this.clientStatus;
    }

    public void setClientStatus(String clientStatus) {
        this.clientStatus = clientStatus;
    }

    public String getYearStart() {
        return this.yearStart;
    }

    public void setYearStart(String yearStart) {
        this.yearStart = yearStart;
    }

    public String getYearEstablish() {
        return this.yearEstablish;
    }

    public void setYearEstablish(String yearEstablish) {
        this.yearEstablish = yearEstablish;
    }

    public String getLastExport() {
        return this.lastExport;
    }

    public void setLastExport(String lastExport) {
        this.lastExport = lastExport;
    }
}
