package com.lagm.webflux.service;

import org.springframework.stereotype.Service;

import com.lagm.webflux.modelo.Employee;
import com.lagm.webflux.repository.IEmployeeRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements IEmployeeService {

	private final IEmployeeRepository employeeRepository;

	@Override
	public Mono<Employee> save(Employee employee) {
		return this.employeeRepository.save(employee);
	}

	@Override
	public Mono<Employee> findById(String id) {
		return this.employeeRepository.findById(id);
	}

	@Override
	public Flux<Employee> findAll() {
		return this.employeeRepository.findAll();
	}

	@Override
	public Mono<Employee> update(Employee employee, String id) {
		return this.employeeRepository.save(employee);
	}

	@Override
	public Mono<Void> deleteById(String id) {
		return this.employeeRepository.deleteById(id);
	}

	@Override
	public Mono<Employee> finByDni(String dni) {
		return this.employeeRepository.findByDni(dni);
	}

}
