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

    @Test
    //пополнить баланс на отрицательную сумму
    public void AddNegativeToBalance() {

        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        boolean expected = false;
        boolean actual = account.add(-1_000);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void AddZeroToBalance() {

        CreditAccount account = new CreditAccount(
                10,
                5_000,
                15
        );
        boolean expected = false;
        boolean actual = account.add(0);

        Assertions.assertEquals(expected, actual);
    }

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// Блок проверки стартового баланса
    @Test
    public void CreateCreditAccountWithInitialBalancePositive() {

        CreditAccount account = new CreditAccount(
                10,
                5_000,
                15
        );
        int expected = 10;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }


    @Test
    //создаем объект с отрицательным балансом
    public void CreateCreditAccountWithInitialBalanceNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    -10,
                    5_000,
                    0
            );
        });
    }

    @Test
    public void CreateCreditAccountWithInitialBalanceZero() {

        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        int expected = 0;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//тестируем creditLimit - неотрицательное число, максимальная сумма которую можно задолжать банку
    @Test
    public void CreateCreditAccountWithPositiveCreditLimit() {

        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        int expected = 0;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void CreateCreditAccountWithNegativeCreditLimit() {
//        CreditAccount account = new CreditAccount(
//                0,
//                -5_000,
//                15
//        );
//        int expected = 0;
//        int actual = account.getBalance();
//
//        Assertions.assertEquals(expected, actual);
        //
        //
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    1_000,
                    -5_000,
                    1);
        });
    }

    public void CreateCreditAccountWithZeroCreditLimit() {

        CreditAccount account = new CreditAccount(
                0,
                0,
                15
        );
        int expected = 0;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //тестирую rate - неотрицательное число, ставка кредитования для расчёта долга за отрицательный баланс
    @Test
    public void CreateCreditAccountWithPositiveRate() {

        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        int expected = 0;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void CreateCreditAccountWithNegativeRate() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    1_000,
                    -5_000,
                    -1);
        });

    }


    public void CreateCreditAccountWithZeroRate() {

        CreditAccount account = new CreditAccount(
                0,
                5_000,
                0
        );
        int expected = 0;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//ок, тестируем метод pay
    //покупка меньше лимита
    @Test
    public void ShouldPayIfAmountLessThanLimit() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        boolean expected = true;
        boolean actual = account.pay(3_000);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    // покупка равна лимиту
    public void ShouldPayIfAmountEqualLimit() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        boolean expected = true;
        boolean actual = account.pay(5_000);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    //больше лимита
    public void ShouldPayIfAmountMoreThanLimit() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        boolean expected = false;
        boolean actual = account.pay(6_000);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    //Покупка равна нулю
    public void ShouldPayIfAmountIsZero() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        boolean expected = false;
        boolean actual = account.pay(0);

        Assertions.assertEquals(expected, actual);
    }

    public void ShouldPayIfAmountLessThenZero() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        boolean expected = false;
        boolean actual = account.pay(0);

        Assertions.assertEquals(expected, actual);
    }

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    @Test
    //Пополнить счет на положительную сумму
    public void ShouldIncreaseByPositiveAmount() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        boolean expected = true;
        boolean actual = account.add(100);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    //Пополнить счет на отрицательную сумму
    public void ShouldIncreaseByNegativeAmount() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        boolean expected = false;
        boolean actual = account.add(-100);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    //Пополнить счет на нуль
    public void ShouldIncreaseByZeroAmount() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        boolean expected = false;
        boolean actual = account.add(0);

        Assertions.assertEquals(expected, actual);
    }

//++++++++++++++++++++++++++++++++++++++++++++++++++

    @Test
    //Расчет процентов при положительном балансе
    public void ShouldIncreaseRateIfPositiveBalance() {
        CreditAccount account = new CreditAccount(
                201,
                5_000,
                15

        );
        account.pay(200);
        int expected = 0;
        int actual = account.yearChange();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    //Расчет процентов при отрицательном балансе
    public void ShouldIncreaseRateIfNegativeBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        account.pay(200);
        int expected = -30;
        int actual = account.yearChange();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    //Расчет процентов при отрицательном балансе
    public void ShouldIncreaseRateIfZeroBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        int expected = 0;
        int actual = account.yearChange();

        Assertions.assertEquals(expected, actual);
    }




}
