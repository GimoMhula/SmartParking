package dev.visum.smartpark.model;

public class Reservation {
    private String id;
    private String number_of_cars;
    private String entry_date;
    private String departure_date;
    private String client_name;
    private String client_number;
    private String value_to_pay;
    private String total_stay_time;
    private String payment_status;
    private String payment_type;

    public Reservation(){}

    public Reservation(String id, String number_of_cars, String entry_date, String departure_date, String client_name, String client_number, String value_to_pay, String total_stay_time, String payment_status, String payment_type) {
        this.id = id;
        this.number_of_cars = number_of_cars;
        this.entry_date = entry_date;
        this.departure_date = departure_date;
        this.client_name = client_name;
        this.client_number = client_number;
        this.value_to_pay = value_to_pay;
        this.total_stay_time = total_stay_time;
        this.payment_status = payment_status;
        this.payment_type = payment_type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber_of_cars() {
        return number_of_cars;
    }

    public void setNumber_of_cars(String number_of_cars) {
        this.number_of_cars = number_of_cars;
    }

    public String getEntry_date() {
        return entry_date;
    }

    public void setEntry_date(String entry_date) {
        this.entry_date = entry_date;
    }

    public String getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(String departure_date) {
        this.departure_date = departure_date;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getClient_number() {
        return client_number;
    }

    public void setClient_number(String client_number) {
        this.client_number = client_number;
    }

    public String getValue_to_pay() {
        return value_to_pay;
    }

    public void setValue_to_pay(String value_to_pay) {
        this.value_to_pay = value_to_pay;
    }

    public String getTotal_stay_time() {
        return total_stay_time;
    }

    public void setTotal_stay_time(String total_stay_time) {
        this.total_stay_time = total_stay_time;
    }

    public String getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(String payment_status) {
        this.payment_status = payment_status;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id='" + id + '\'' +
                ", number_of_cars='" + number_of_cars + '\'' +
                ", entry_date='" + entry_date + '\'' +
                ", departure_date='" + departure_date + '\'' +
                ", client_name='" + client_name + '\'' +
                ", client_number='" + client_number + '\'' +
                ", value_to_pay='" + value_to_pay + '\'' +
                ", total_stay_time='" + total_stay_time + '\'' +
                ", payment_status='" + payment_status + '\'' +
                ", payment_type='" + payment_type + '\'' +
                '}';
    }
}
