package model.objects;

public class PaddockService {

    private String ownerName;
    private String horseName;
    private String dateOfTheService;
    private String note;
    private double salary;
    private double tip;
    private boolean payedStatus;
    private boolean inlcludingJJK;
    private int horseId;

    public PaddockService(String ownerName, String horseName, String dateOfTheService, String note,
                          double salary, double tip, boolean payedStatus, boolean inlcludingJJK, int horseId) {

        this.ownerName = ownerName;
        this.horseName = horseName;
        this.dateOfTheService = dateOfTheService;
        this.note = note;
        this.salary = salary;
        this.tip = tip;
        this.payedStatus = payedStatus;
        this.inlcludingJJK = inlcludingJJK;
        this.horseId = horseId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getHorseName() {
        return horseName;
    }

    public void setHorseName(String horseName) {
        this.horseName = horseName;
    }

    public String getDateOfTheService() {
        return dateOfTheService;
    }

    public void setDateOfTheService(String dateOfTheService) {
        this.dateOfTheService = dateOfTheService;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getTip() {
        return tip;
    }

    public void setTip(double tip) {
        this.tip = tip;
    }

    public boolean isPayedStatus() {
        return payedStatus;
    }

    public void setPayedStatus(boolean payedStatus) {
        this.payedStatus = payedStatus;
    }

    public boolean isInlcludingJJK() {
        return inlcludingJJK;
    }

    public void setInlcludingJJK(boolean inlcludingJJK) {
        this.inlcludingJJK = inlcludingJJK;
    }

    public int getHorseId() {
        return horseId;
    }

    public void setHorseId(int horseId) {
        this.horseId = horseId;
    }
}
