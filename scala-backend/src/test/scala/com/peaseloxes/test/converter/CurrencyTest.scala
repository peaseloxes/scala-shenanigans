package com.peaseloxes.test.converter

import org.junit.Assert._
import org.junit.Test

/**
  * @author peaseloxes
  */
class CurrencyTest {
  @Test
  def testCurrencyDefault() = {
    val currency = new Currency()
    assertEquals(1.0, currency.amount, 0.001)
    assertEquals("EUR", currency.currencyType)
  }

  @Test
  def testCurrencyAddition() = {
    val currencyOne = new Currency(5, "EUR")
    val currencyTwo = new Currency(10, "EUR")
    val currencyThree = new Currency(5, "USD")
    assertEquals(15, (currencyOne + currencyTwo).amount, 0.001)
    assertEquals(currencyOne + currencyThree, null)
  }

  @Test
  def testCurrencyConversion() = {
    val converter = new Converter
    assertEquals(1.0, converter.convert(Currency(1, "USD"), "USD"), 0.1)
    assertEquals(1.11, converter.convert(Currency(1, "EUR"), "USD"), 0.1)
    assertEquals(1.42, converter.convert(Currency(1, "GBP"), "USD"), 0.1)
    assertEquals(0.70, converter.convert(Currency(1, "USD"), "GBP"), 0.1)
    assertEquals(0.90, converter.convert(Currency(1, "USD"), "EUR"), 0.1)
    assertEquals(-1, converter.convert(Currency(5, "YEN"), "USD"), 0.1)
    assertEquals(-1, converter.convert(Currency(5, "USD"), "YEN"), 0.1)
    assertEquals(-1, converter.convert(Currency(5, "CAD"), "YEN"), 0.1)
  }
}
