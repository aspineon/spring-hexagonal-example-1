package com.rdelgatte.hexagonal.infrastructure.restclient.controller;

import com.rdelgatte.hexagonal.api.CustomerService;
import com.rdelgatte.hexagonal.domain.Customer;
import io.vavr.control.Option;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CustomerController.BASE_PATH)
@AllArgsConstructor
class CustomerController {

  static final String BASE_PATH = "customers";
  private static final String RESOURCE_PATH = "{name}";
  private final CustomerService customerService;

  @PostMapping
  void signUp(@RequestBody String name) {
    customerService.signUp(name);
  }

  @GetMapping(RESOURCE_PATH)
  Option<Customer> find(@PathVariable String name) {
    return customerService.findCustomer(name);
  }

  @PatchMapping(RESOURCE_PATH)
  void addProductToCart(@PathVariable String name, @RequestBody String productCode) {
    customerService.addProductToCart(name, productCode);
  }
}
