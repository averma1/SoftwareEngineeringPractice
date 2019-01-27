package edu.ithaca.dragon.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void getBalanceTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    void withdrawTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);
        bankAccount.withdraw(100);
        assertEquals(100, bankAccount.getBalance());

        bankAccount.withdraw(-50);
        assertEquals(100, bankAccount.getBalance());

        bankAccount.withdraw(-100);
        assertEquals(100, bankAccount.getBalance());

        bankAccount.withdraw(200);
        assertEquals(100, bankAccount.getBalance());

        bankAccount.withdraw(50.123456);
        assertEquals(100, bankAccount.getBalance());

        bankAccount.withdraw(1.082);
        assertEquals(100, bankAccount.getBalance());

        bankAccount.withdraw(100);
        assertEquals(0, bankAccount.getBalance());

    }

    @Test
    void isEmailValidTest(){

        assertTrue(BankAccount.isEmailValid( "a@b.com"));
        assertTrue(BankAccount.isEmailValid( "ithaca@ithaca.edu"));
        assertTrue(BankAccount.isEmailValid( "1@123.1"));
        assertTrue(BankAccount.isEmailValid( "test@test.test"));

        assertFalse( BankAccount.isEmailValid("hello@"));
        assertFalse( BankAccount.isEmailValid("testing@test."));
        assertFalse( BankAccount.isEmailValid("test."));
        assertFalse( BankAccount.isEmailValid("mytest.@edu"));

    }


    @Test
    void isAmountValidTest(){

        assertTrue(BankAccount.isAmountValid(10));
        assertTrue(BankAccount.isAmountValid(1.20));
        assertTrue(BankAccount.isAmountValid(50.2));

        assertFalse(BankAccount.isAmountValid(-300));
        assertFalse(BankAccount.isAmountValid(9.0123));
        assertFalse(BankAccount.isAmountValid(67.126));

    }


    @Test
    void constructorTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals("a@b.com", bankAccount.getEmail());
        assertEquals(200, bankAccount.getBalance());

        //check for exception thrown correctly
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("", 100));
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("test@test.com", -500));
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("test@test.com", 500.1234));
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("test.", 100));
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("testing.@com", 100));


    }

}