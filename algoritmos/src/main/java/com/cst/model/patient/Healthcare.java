package com.cst.model.patient;

import com.cst.model.clinic.Visit;

/**
 * Healthcare class - Translation: "Obra Social"
 */
public class Healthcare {

    /** Discounts based on percentage for healthcare companies */
    private Long discount;

    /** Stores company name */
    private String company;

    /**
     * Healthcare class Constructor
     * @param discount percentage
     * @param company
     */
    public Healthcare(Long discount, String company) {
        this.discount = discount;
        this.company = company;
    }

    /**
     * Applies a healthcare discount to a given salary calculation
     * @param salary
     * @return
     */
    public double applyDiscount(double salary) {
        return salary - ((this.discount * salary) / 100);
    }

    /**
     * Gets the discount price set in this Healthcare object
     * @return Long
     */
    public Long getDiscount() {
        return discount;
    }

    /**
     * Sets the discount price for this Healthcare object
     * @param discount
     */
    public void setDiscount(Long discount) {
        this.discount = discount;
    }

    /**
     * Gets the company name of this Healthcare object
     * @return String
     */
    public String getCompany() {
        return company;
    }

    /**
     * Sets the company for this Healthcare object
     * @param company
     */
    public void setCompany(String company) {
        this.company = company;
    }

}
