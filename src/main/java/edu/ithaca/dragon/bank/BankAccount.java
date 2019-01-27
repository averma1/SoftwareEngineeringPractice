package edu.ithaca.dragon.bank;

public class BankAccount {

    private String email;
    private double balance;

    /**
     * @throws IllegalArgumentException if email is invalid
     */
    public BankAccount(String email, double startingBalance){
        if (isEmailValid(email)){
            this.email = email;
            this.balance = startingBalance;
        }
        else {
            throw new IllegalArgumentException("Email address: " + email + " is invalid, cannot create account");
        }
    }

    public double getBalance(){
        return balance;
    }

    public String getEmail(){
        return email;
    }


    /**
     * @post reduces the balance by amount if amount is non-negative and smaller than balance
     * if the amount to be withdrawn is greater than the balance or negative, nothing should happen
     * @param amount - the amount to be withdrawn
     */

    public void withdraw (double amount)  {

        if(balance >= amount && amount > 0){
            balance -= amount;
        }

    }

    /**
     * @param amount - the amount must be positive and have two decimal points or less
     * @return True - if the above is true
     */

    public static boolean isAmountValid(double amount){

        return false;

    }



    /**
     * an email is valid if:
     * there is is an @ symbol present, and this @ symbol is not the last character
     * there must be a . after the @ symbol, and this . should not be the last character
     * @param email - the email address to check
     * @return True - if the email is valid
    */



    public static boolean isEmailValid(String email){
        if (email.indexOf('@') == -1 || email.indexOf('@') == 0 || email.indexOf('@') == email.length()-1){
            return false;
        }
        if(email.indexOf('.') == 0 || email.indexOf('.') == -1 || email.indexOf('.') == email.length()-1) {
            return false;
        }
        if(email.indexOf('.') < email.indexOf('@')){
            return false;
        }
        else {
            return true;
        }
    }
}
