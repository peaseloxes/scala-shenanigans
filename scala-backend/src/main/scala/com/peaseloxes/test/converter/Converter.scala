package com.peaseloxes.test.converter

/**
  * @author peaseloxes
  */
case class Converter() {

  //rates in USD
  val rates = Map("USD" -> 1.0, "EUR" -> 1.11, "GBP" -> 1.42)

  /**
    * Converts one currency to another.
    *
    * @param one the currency to convert.
    * @param typ the type to convert to.
    * @return the converted value.
    */
  def convert(one: Currency, typ: String): Double = {

    // convert to dollar
    val dollarValue = rates.get(one.currencyType) match {
      case None => -1
      case Some(value) => one.amount*value
    }

    // convert to whatever type
    rates.get(typ) match {
      case None => -1
      case Some(value) => dollarValue / value
    }
  }
}
