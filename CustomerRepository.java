package com.gm.CustomerService.CustomerDetails.Service;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gm.CustomerService.CustomerDetails.Model.Customers;


@Repository
public interface CustomerRepository extends JpaRepository<Customers,Integer> {

}
