package com.peaseloxes.test.converter

/**
  * @author peaseloxes
  */
case class Currency(var amount: Double = 1.0, var currencyType: String = "EUR") {

  /**
    * Adds two currencies if they are of the same type.
    *
    * @param other the currency to add to this one.
    * @return a combination of both currencies, or null if the types do not match.
    */
  def +(other: Currency): Currency =
    if (currencyType.equals(other.currencyType)) {
      Currency(amount + other.amount)
    }
    else
      null
}
