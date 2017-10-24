package my.lib.serenity.primefaces.sars.model;

/**
 * Created by ngoc on 13/10/2016.
 */
public class NotificationSettingModel {
    //    private String branch;
    private String valueBranch;
    //    private String position;
    private String valuePosition;
    //    private String empName;
    private String valueEmpName;

//    public NotificationSettingModel(String branch, String valueBranch, String position, String valuePosition, String empName, String valueEmpName) {
//        this.branch = branch;
//        this.valueBranch = valueBranch;
//        this.position = position;
//        this.valuePosition = valuePosition;
//        this.empName = empName;
//        this.valueEmpName = valueEmpName;
//    }


    public NotificationSettingModel(String valueBranch, String valuePosition, String valueEmpName) {
        this.valueBranch = valueBranch;
        this.valuePosition = valuePosition;
        this.valueEmpName = valueEmpName;
    }

    public String getValueBranch() {
        return this.valueBranch;
    }

    public void setValueBranch(String valueBranch) {
        this.valueBranch = valueBranch;
    }

    public String getValuePosition() {
        return this.valuePosition;
    }

    public void setValuePosition(String valuePosition) {
        this.valuePosition = valuePosition;
    }

    public String getValueEmpName() {
        return this.valueEmpName;
    }

    public void setValueEmpName(String valueEmpName) {
        this.valueEmpName = valueEmpName;
    }
}
