package com.example.ziying_assignment1_1551960.ui.bookings;

public class BookingsRVItem {
    private String serviceName;
    private String serviceCategory;
    private String startDate;
    private String startTime;
    private String paid;

    public BookingsRVItem(String serviceName, String serviceCategory, String startDate, String startTime, String paid) {
        this.serviceName = serviceName;
        this.serviceCategory = serviceCategory;
        this.startDate = startDate;
        this.startTime = startTime;
        this.paid = paid;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getServiceCategory() {
        return serviceCategory;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getPaid() {
        return paid;
    }
}
