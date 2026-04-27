package gavaconnectsdks.com.github.dtos;

import java.time.LocalDateTime;

import gavaconnectsdks.com.github.exceptions.ValidationException;
import gavaconnectsdks.com.github.utils.annotations.Pin;

public class RentalIncomeWithhDetails {
    private String typeOfProperty;
    @Pin
    private String landlordPin;
    private String invoiceNo;
    private LocalDateTime paymentDate;
    private LocalDateTime invoiceDate;
    private float grossAmount;
    private float taxRate;
    private float taxAmount;
    private String lrNumber;
    private String building;
    private String street;
    private String town;  
    
    
    private RentalIncomeWithhDetails(Builder builder){
        this.typeOfProperty=builder.typeOfProperty;
        this.landlordPin=builder.landlordPin;
        this.invoiceNo=builder.invoiceNo;
        this.paymentDate=builder.paymentDate;
        this.invoiceDate=builder.invoiceDate;
        this.grossAmount=builder.grossAmount;
        this.taxRate=builder.taxRate;
        this.taxAmount=builder.taxAmount;
        this.lrNumber=builder.lrNumber;
        this.building=builder.building;
        this.street=builder.street;
        this.town=builder.town;  
        
    }

    private static class Builder{
        private String typeOfProperty;
        private String landlordPin;
        private String invoiceNo;
        private LocalDateTime paymentDate;
        private LocalDateTime invoiceDate;
        private Float grossAmount;
        private Float taxRate;
        private Float taxAmount;
        private String lrNumber;
        private String building;
        private String street;
        private String town; 

        public Builder building(String building) {
            this.building = building;
            return this;
        }

        public Builder setGrossAmount(float grossAmount) {
            this.grossAmount = grossAmount;
            return this;
        }

        public Builder invoiceDate(LocalDateTime invoiceDate) {
            this.invoiceDate = invoiceDate;
            return this;
        }

        public Builder invoiceNo(String invoiceNo) {
            this.invoiceNo = invoiceNo;
            return this;
        }

        public Builder landlordPin(String landlordPin) {
            this.landlordPin = landlordPin;
            return this;
        }

        public Builder lrNumber(String lrNumber) {
            this.lrNumber = lrNumber;
            return this;
        }

        public Builder paymentDate(LocalDateTime paymentDate) {
            this.paymentDate = paymentDate;
            return this;
        }

        public Builder street(String street) {
            this.street = street;
            return this;
        }

        public Builder taxAmount(float taxAmount) {
            this.taxAmount = taxAmount;
            return this;
        }

        public Builder taxRate(float taxRate) {
            this.taxRate = taxRate;
            return this;
        }

        public Builder town(String town) {
            this.town = town;
            return this;
        }

        public Builder typeOfProperty(String typeOfProperty) {
            this.typeOfProperty = typeOfProperty;
            return this;
        }

        public RentalIncomeWithhDetails build(){
            if (this.typeOfProperty==null) {
                throw new ValidationException("typeOfproperty in RentalIncomeWithhDetails is required");
            }
            if (this.landlordPin==null) {
                throw  new ValidationException("landlordPin in ReantalIncomeWithhDetails is required");
            }
            if (this.invoiceNo==null) {
                throw new ValidationException("invoiceNo in RentalIncomeWithhDetails is required.");
            }
            if (this.invoiceDate==null) {
                throw new ValidationException("invoiceDate in ReantalIncomeWithhDetails is required");
            }
            if (this.paymentDate==null) {
                throw  new ValidationException("paymentDate in RentalIncomeWithhDetails is required.");
            }
            if (this.grossAmount==null) {
                throw new ValidationException("grossAmount in RentalIncomeWithhDetails is required.");
            }

            if (this.taxRate==null) {
                throw  new ValidationException("taxRate in RentalIncomeWithhDetails is required.");
            }

            if (this.taxAmount==null) {
                throw new ValidationException("taxAmount in RetalIncomeWithhDetails is required.");
            }

            if (this.lrNumber==null) {
                throw new ValidationException("lrNumber in ReantalIncomeWithhDetails is required.");
            }
            if (this.building==null) {
                throw  new ValidationException("building in RentalIncomeWithhDetails is required.");
            }
            if (this.street==null) {
                throw new ValidationException("street in RentalIncomeWithhDetails is required.");
            }
            if (this.town==null) {
                throw new ValidationException("town in ReantalIncomeWithhDetails is required.");
            }
            return  new RentalIncomeWithhDetails(this);
        }

    }



    public String getBuilding() {
        return this.building;
    }

    public float getGrossAmount() {
        return this.grossAmount;
    }


    public LocalDateTime getInvoiceDate() {
        return this.invoiceDate;
    }

    public String getInvoiceNo() {
        return this.invoiceNo;
    }

    public String getLandlordPin() {
        return this.landlordPin;
    }

    public String getLrNumber() {
        return this.lrNumber;
    }

    public LocalDateTime getPaymentDate() {
        return this.paymentDate;
    }

    public String getStreet() {
        return this.street;
    }

    public float getTaxAmount() {
        return this.taxAmount;
    }

    public float getTaxRate() {
        return this.taxRate;
    }

    public String getTown() {
        return this.town;
    }
    public String getTypeOfProperty() {
        return this.typeOfProperty;
    }

    public static Builder build(){
        return new Builder();
    } 
}
