package gavaconnectsdks.com.github.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


public class InvoiceDetail {
    private  LocalDate salesDate;
    private  LocalDateTime transmissionDate;
    private  LocalDateTime invoiceDate;
    private  Integer totalItemCount;
    private  String supplierPin;
    private  String supplierName;
    private  String deviceSerialNumber;
    private  String customerPin;//Nullable
    private  String customerName;//Nullable
    private  String controlUnitInvoiceNumber;
    private  String traderSystemInvoiceNumber;
    private  Float  totalInvoiceAmount;
    private  Float  totalTaxableAmount;
    private  String excemptionCertificateNo;
    private  Float  totalDiscountAmount;
    private  List<String> itemDetails;

    public void setControlUnitInvoiceNumber(String controlUnitInvoiceNumber) {
        this.controlUnitInvoiceNumber = controlUnitInvoiceNumber;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerPin(String customerPin) {
        this.customerPin = customerPin;
    }

    public void setDeviceSerialNumber(String deviceSerialNumber) {
        this.deviceSerialNumber = deviceSerialNumber;
    }

    public void setExcemptionCertificateNo(String excemptionCertificateNo) {
        this.excemptionCertificateNo = excemptionCertificateNo;
    }

    public void setInvoiceDate(LocalDateTime invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public void setItemDetails(List<String> itemDetails) {
        this.itemDetails = itemDetails;
    }

    public void setSalesDate(LocalDate salesDate) {
        this.salesDate = salesDate;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public void setSupplierPin(String supplierPin) {
        this.supplierPin = supplierPin;
    }

    public void setTotalDiscountAmount(Float totalDiscountAmount) {
        this.totalDiscountAmount = totalDiscountAmount;
    }

    public void setTotalInvoiceAmount(Float totalInvoiceAmount) {
        this.totalInvoiceAmount = totalInvoiceAmount;
    }

    public void setTotalItemCount(Integer totalItemCount) {
        this.totalItemCount = totalItemCount;
    }

    public void setTotalTaxableAmount(Float totalTaxableAmount) {
        this.totalTaxableAmount = totalTaxableAmount;
    }

    public void setTraderSystemInvoiceNumber(String traderSystemInvoiceNumber) {
        this.traderSystemInvoiceNumber = traderSystemInvoiceNumber;
    }

    public void setTransmissionDate(LocalDateTime transmissionDate) {
        this.transmissionDate = transmissionDate;
    }

    public String getControlUnitInvoiceNumber() {
        return this.controlUnitInvoiceNumber;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public String getCustomerPin() {
        return this.customerPin;
    }

    public String getDeviceSerialNumber() {
        return this.deviceSerialNumber;
    }

    public String getExcemptionCertificateNo() {
        return this.excemptionCertificateNo;
    }

    public LocalDateTime getInvoiceDate() {
        return this.invoiceDate;
    }

    public List<String> getItemDetails() {
        return this.itemDetails;
    }

    public LocalDate getSalesDate() {
        return this.salesDate;
    }

    public String getSupplierName() {
        return this.supplierName;
    }

    public String getSupplierPin() {
        return this.supplierPin;
    }

    public Float getTotalDiscountAmount() {
        return this.totalDiscountAmount;
    }

    public Float getTotalInvoiceAmount() {
        return this.totalInvoiceAmount;
    }

    public Integer getTotalItemCount() {
        return this.totalItemCount;
    }

    public Float getTotalTaxableAmount() {
        return this.totalTaxableAmount;
    }

    public String getTraderSystemInvoiceNumber() {
        return this.traderSystemInvoiceNumber;
    }

    public LocalDateTime getTransmissionDate() {
        return this.transmissionDate;
    }
    

}
