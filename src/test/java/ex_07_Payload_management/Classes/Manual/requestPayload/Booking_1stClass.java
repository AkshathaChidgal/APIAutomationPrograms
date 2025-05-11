package ex_07_Payload_management.Classes.Manual.requestPayload;

public class Booking_1stClass {

    private String firstname;
    private String lastname;
    private Integer totalprice;
    private Boolean depositpaid;
    private String additionalneeds;
    private BookingDates_2ndClass boookingdates;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Integer totalprice) {
        this.totalprice = totalprice;
    }

    public Boolean getDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(Boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    public BookingDates_2ndClass getBoookingdates() {
        return boookingdates;
    }

    public void setBoookingdates(BookingDates_2ndClass boookingdates) {
        this.boookingdates = boookingdates;
    }
}
