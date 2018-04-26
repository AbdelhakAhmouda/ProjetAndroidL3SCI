package sci.iam.learnapp;


public class Module {

    private String id;
    private String accronym;
    private String name;
    private String description;
    private String credit;


    public Module(String accronym, String name,String credit,String description) {
        this.accronym = accronym;
        this.name = name;
        this.credit=credit;
        this.description=description;
    }


    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public String getAccronym() {
        return accronym;
    }

    public void setAccronym(String accronym) {
        this.accronym = accronym;
    }

    public String getName() {
        return name;
    }

    public void setName(String id) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }



}
