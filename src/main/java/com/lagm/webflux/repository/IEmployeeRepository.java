package com.lagm.webflux.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.lagm.webflux.modelo.Employee;

import reactor.core.publisher.Mono;

public interface IEmployeeRepository extends ReactiveMongoRepository<Employee, String> {
	Mono<Employee> findByDni(String dni);
}
