package my.lib.serenity.primefaces.sars.model;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by arrow on 14/10/16.
 */
public class DailyReportModel {

    private String companyName;
    private String content;
    private String personInCharge;
    private String department;
    private String businessType;
    private String purpose;
    private String reminder;
    private String reminderFrom;
    private String reminderTo;
    private String projectFlag;
    private String openFlag;

    @Override
    public boolean equals(Object obj) {
        DailyReportModel dailyReportModel = (DailyReportModel) obj;
        return StringUtils.equals(this.getCompanyName(), dailyReportModel.getCompanyName()) && StringUtils.equals(this.getContent(), dailyReportModel.getContent()) && StringUtils.equals(this.getOpenFlag(), dailyReportModel.getOpenFlag())
                && StringUtils.equals(this.getPersonInCharge(), dailyReportModel.getPersonInCharge()) && StringUtils.equals(this.getDepartment(), dailyReportModel.getDepartment()) && StringUtils.equals(this.getBusinessType(), dailyReportModel.getBusinessType())
                && StringUtils.equals(this.getPurpose(), dailyReportModel.getPurpose()) && StringUtils.equals(this.getReminder(), dailyReportModel.getReminder()) && StringUtils.equals(this.getProjectFlag(), dailyReportModel.getProjectFlag())
                && StringUtils.equals(this.getProjectFlag(), dailyReportModel.getProjectFlag()) && StringUtils.equals(this.getOpenFlag(), dailyReportModel.getOpenFlag());
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPersonInCharge() {
        return personInCharge;
    }

    public void setPersonInCharge(String personInCharge) {
        this.personInCharge = personInCharge;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getReminder() {
        return reminder;
    }

    public void setReminder(String reminder) {
        this.reminder = reminder;
    }

    public String getReminderFrom() {
        return reminderFrom;
    }

    public void setReminderFrom(String reminderFrom) {
        this.reminderFrom = reminderFrom;
    }

    public String getReminderTo() {
        return reminderTo;
    }

    public void setReminderTo(String reminderTo) {
        this.reminderTo = reminderTo;
    }

    public String getProjectFlag() {
        return projectFlag;
    }

    public void setProjectFlag(String projectFlag) {
        this.projectFlag = projectFlag;
    }

    public String getOpenFlag() {
        return openFlag;
    }

    public void setOpenFlag(String openFlag) {
        this.openFlag = openFlag;
    }
}
