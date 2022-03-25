package com.deb.qbe.service.impl;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.stereotype.Service;

import com.deb.qbe.model.Customers;
import com.deb.qbe.repository.CustomerRepository;
import com.deb.qbe.service.CustomerService;

import lombok.extern.log4j.Log4j2;


@Service
@Log4j2
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customers> getAll() {
		return customerRepository.findAll();
	}

	@Override
	public List<Customers> findByFirstNameEnding(String ending) {
		var customerFilter = Customers.builder().firstName(ending).build();
		var matcherFilter = ExampleMatcher.matching()
				.withIgnoreNullValues()
				.withMatcher("firstName", match -> match.endsWith().ignoreCase(true));

		var filter = Example.of(customerFilter, matcherFilter);
		return customerRepository.findAll(filter);
	}

	@Override
	public List<Customers> findByLastNameEnding(String ending) {
		var customerFilter = Customers.builder().lastName(ending).build();
		var matcherFilter = ExampleMatcher.matching()
				.withMatcher("lastName", match -> match.endsWith().ignoreCase());

		var filter = Example.of(customerFilter, matcherFilter);
		return customerRepository.findAll(filter);
	}

	@Override
	public List<Customers> findByFirstName(String firstName) {
		var customerFilter = Customers.builder().firstName(firstName).build();
		var matcherFilter = ExampleMatcher.matching()
				.withMatcher("firstName", exact().ignoreCase());

		var filter = Example.of(customerFilter, matcherFilter);
		return customerRepository.findAll(filter);
	}

	@Override
	public List<Customers> findByWalletBalanceEquals(Long balance) {
		var customerFilter = Customers.builder().walletBalance(balance).build();
		var matcherFilter = ExampleMatcher.matching()
				.withMatcher("walletBalance", exact());

		var filter = Example.of(customerFilter, matcherFilter);
		return customerRepository.findAll(filter);
	}
	
}
