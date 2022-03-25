package com.deb.qbe.service;

import java.util.List;
import com.deb.qbe.model.Customers;

public interface CustomerService {
	List<Customers> getAll();
	List<Customers> findByFirstNameEnding(String ending);
	List<Customers> findByLastNameEnding(String ending);
	List<Customers> findByFirstName(String firstName);
	List<Customers> findByWalletBalanceEquals(Long balance);
}
