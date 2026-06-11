package com.karim.builder;

import java.math.BigDecimal;


/*this piece of code solves challenge 1 of the builder pattern*/
public class FinancialTransaction {

    /*putting all the fields as private and final to ensure immutability once the object is created*/
    private final String transactionId;
    private final String sourceAccountId ;
    private final String destinationAccountId ;
    private final BigDecimal amount ;
    private final String currency ;
    private final String unstructuredNotes ;
    private final Boolean isCrossBorder  ;

    /*passing the builder to the private constructor, to make sure the only way to build
    an object is through our builder pattern
     */
    private FinancialTransaction(FinancialTransactionBuilder financialTransactionBuilder){
        this.transactionId=financialTransactionBuilder.transactionId;
        this.sourceAccountId=financialTransactionBuilder.sourceAccountId;
        this.destinationAccountId=financialTransactionBuilder.destinationAccountId;
        this.amount=financialTransactionBuilder.amount;
        this.currency=financialTransactionBuilder.currency;
        this.unstructuredNotes=financialTransactionBuilder.unstructuredNotes;
        this.isCrossBorder=financialTransactionBuilder.isCrossBorder;


    }

    /*making our builder a static class inside the target class because this is the only way
    * to create a transaction in our case we don't need a builder interface and multiple implementations
    * of how to create a transaction*/
    public static class FinancialTransactionBuilder{
        private  String transactionId;
        private  String sourceAccountId ;
        private  String destinationAccountId ;
        private  BigDecimal amount ;
        private  String currency ="EGP";
        private  String unstructuredNotes ="N/A";
        private  Boolean isCrossBorder =false ;

        /*applying method chaining for building the object sequentially*/
        public FinancialTransactionBuilder withTransactionId(String transactionId){
            this.transactionId=transactionId;
            return this;
        }

        public FinancialTransactionBuilder withSourceAccountId(String sourceAccountId){
            this.sourceAccountId=sourceAccountId;
            return this;
        }

        public FinancialTransactionBuilder withDestinationAccountId(String destinationAccountId){
            this.destinationAccountId=destinationAccountId;
            return this;
        }

        public FinancialTransactionBuilder withAmount(BigDecimal amount){
            this.amount=amount;
            return this;
        }

        public FinancialTransactionBuilder withCurrency(String currency){
            this.currency=currency;
            return this;
        }

        public FinancialTransactionBuilder withUnstructuredNotes(String unstructuredNotes){
            this.unstructuredNotes=unstructuredNotes;
            return this;
        }

        public FinancialTransactionBuilder isCrossBorder(Boolean isCrossBorder){
            this.isCrossBorder=isCrossBorder;
            return this;
        }

        /*this is the build method, we apply our validations here, to make sure the object doesn't break
        * the rules of creation*/
        public FinancialTransaction build(){
            if(isInvalidString(transactionId)){
                throw new IllegalStateException("transactionId can't be empty");
            }
            if(isInvalidString(sourceAccountId)){
                throw new IllegalStateException("sourceAccountId can't be empty");
            }
            if(isInvalidString(destinationAccountId)){
                throw new IllegalStateException("destinationAccountId can't be empty");
            }
           if(amount==null || amount.compareTo(BigDecimal.ZERO)<=0){
               throw new IllegalArgumentException("amount can't be 0 or less");
           }
           if(isCrossBorder && "EGP".equalsIgnoreCase(currency)){
               throw new IllegalStateException("crossborder transactions don't use local currency");
           }

           return new FinancialTransaction(this);
        }

        /*helper method*/
        private boolean isInvalidString(String str) {
            return str == null || str.trim().isEmpty();
        }

    }

    /* this will be the entry point for the builder*/
    public static FinancialTransactionBuilder builder() {
        return new FinancialTransactionBuilder();
    }



    /*getters for the built object*/
    public String getTransactionId() {
        return transactionId;
    }

    public String getSourceAccountId() {
        return sourceAccountId;
    }

    public String getDestinationAccountId() {
        return destinationAccountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getUnstructuredNotes() {
        return unstructuredNotes;
    }

    public Boolean getCrossBorder() {
        return isCrossBorder;
    }



    @Override
    public String toString() {
        return "FinancialTransaction{" +
                "transactionId='" + transactionId + '\'' +
                ", sourceAccountId='" + sourceAccountId + '\'' +
                ", destinationAccountId='" + destinationAccountId + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", unstructuredNotes='" + unstructuredNotes + '\'' +
                ", isCrossBorder=" + isCrossBorder +
                '}';
    }
}
