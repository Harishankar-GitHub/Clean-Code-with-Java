package com.b.simple.design.business.customer;

import java.math.BigDecimal;
import java.util.List;

import com.b.simple.design.business.exception.DifferentCurrenciesException;
import com.b.simple.design.model.customer.Amount;
import com.b.simple.design.model.customer.AmountImpl;
import com.b.simple.design.model.customer.Currency;
import com.b.simple.design.model.customer.Product;

public class CustomerBOImplRefactored_Rhsb implements CustomerBO {

	@Override
	public Amount getCustomerProductsSum(List<Product> products)
			throws DifferentCurrenciesException {
		
		if (products.size() == 0)
			return new AmountImpl(BigDecimal.ZERO, Currency.EURO);

		if (!doAllProductsHaveSameCurrency(products))
		{
			throw new DifferentCurrenciesException();
		}

		return calculateSumOfProducts(products);
	}

	public Amount calculateSumOfProducts(List<Product> products) {
		
		Currency firstProductCurrency = products.get(0).getAmount().getCurrency();
		
		BigDecimal sum = products.stream()
				.map(product -> product.getAmount().getValue())
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		
		return new AmountImpl(sum, firstProductCurrency);
	}

	public boolean doAllProductsHaveSameCurrency(List<Product> products) throws DifferentCurrenciesException {
		
		Currency firstProductCurrency = products.get(0).getAmount().getCurrency();
		
		return products.stream()
			.map(product -> product.getAmount().getCurrency())
			.allMatch(currency -> currency.equals(firstProductCurrency));
		
		// The above code is written using functional programming
		
//		for (Product product : products) {
//			boolean currencySameAsFirstProduct = product.getAmount()
//					.getCurrency().equals(products.get(0).getAmount()
//							.getCurrency());
//			if (!currencySameAsFirstProduct) {
//				return false;
//			}
//		}
//		return true;
	}
}