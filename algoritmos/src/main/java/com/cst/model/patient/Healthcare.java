package com.cst.model.patient;

/**
 * Healthcare class - Translation: "Obra Social"
 * @package com.cst.model
 */
public class Healthcare {

    /** Discounts based on percentage for healthcare companies */
    private Long discount;

    /** Stores company name */
    private String company;

    /**
     * Healthcare class Constructor
     * @param discount
     * @param company
     */
    public Healthcare(Long discount, String company) {
        this.discount = discount;
        this.company = company;
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
