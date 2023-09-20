package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SavingAccountTest {

    @Test
    public void shouldAddLessMaxBalance() {
        SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, 5);

        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }

    @Test
    public void shouldAddMoreMaxBalance() {
        SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, 5);

        account.add(50_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }
    @Test
    public void shouldAddAmountZero() {
        SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, 5);

        account.add(0);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldAddAmountLessThanZero() {
        SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, 5);

        account.add(-100);

        Assertions.assertEquals(2_000, account.getBalance());
    }


    @Test
    public void shouldPayLessMinBalance() {
        SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, 5);
        account.pay(500);

        Assertions.assertEquals(1_500, account.getBalance());
    }

    @Test
    public void shouldPayMoreThenMinBalance() {
        SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, 5);
        account.pay(5_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldPayWhenAmountLessZero() {
        SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, 5);
        account.pay(-5_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldPayWhenAmountZero() {
        SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, 5);
        account.pay(0);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldPayTrueOrFalse() {
        SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, 5);
        Assertions.assertFalse(account.pay(-5_000));
        Assertions.assertTrue(account.pay(500));
        Assertions.assertFalse(account.pay(5_000));
    }

    @Test
    public void shouldYearChange() {
        SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, 5);
        int actual = account.yearChange();
        int expected = 2_000 / 100 * 5;
        Assertions.assertEquals(expected, actual);
    }
 
}
