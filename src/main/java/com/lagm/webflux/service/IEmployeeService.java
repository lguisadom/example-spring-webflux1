package com.lagm.webflux.service;

import com.lagm.webflux.modelo.Employee;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IEmployeeService {
	Mono<Employee> save(Employee employee);

	Mono<Employee> findById(String id);

	Mono<Employee> finByDni(String dni);

	Flux<Employee> findAll();

	Mono<Employee> update(Employee employee, String id);

	Mono<Void> deleteById(String id);
}
