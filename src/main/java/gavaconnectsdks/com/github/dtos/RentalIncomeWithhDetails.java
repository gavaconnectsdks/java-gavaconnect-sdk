package gavaconnectsdks.com.github.dtos;

import java.time.LocalDateTime;

import gavaconnectsdks.com.github.utils.annotations.Pin;

public class RentalIncomeWithhDetails {
    private String typeOfProperty;
    @Pin
    private String landlordPin;
    private String invoiceNo;
    private LocalDateTime paymentDate;
    private float grossAmount;
    private float taxRate;
    private float taxAmount;
    private String lrNumber;
    private String building;
    private String street;
    private String town;   
}
