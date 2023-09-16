package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {
//
//    @Test
//    public void shouldAddToPositiveBalance() {
//        CreditAccount account = new CreditAccount(
//                0,
//                5_000,
//                15
//        );
//
//        account.add(3_000);
//
//        Assertions.assertEquals(3_000, account.getBalance());
//    }

    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    @Test
    //пополнить баланс на положительную сумму
    public void AddPositiveToBalance() {

        CreditAccount account = new CreditAccount(
                100,
                5_000,
                15
        );
        account.add(1_000);
        int expected = 1100;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }


}
