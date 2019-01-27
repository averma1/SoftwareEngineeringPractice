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
     */
    public void withdraw (double amount)  {
        balance -= amount;

    }


    /**
     * an email is valid if:
     * there is is an @ symbol present, and this @ symbol is not the last character
     * there must be a . after the @ symbol, and this . should not be the last character
     * @param email - the email address to check
     * @return True - if the email is valid
    */



    public static boolean isEmailValid(String email){
        if (email.indexOf('@') == -1) {
            return false;
        }
        else{
            return true;
        }
    }
}
