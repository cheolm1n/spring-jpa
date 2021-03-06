package com.roytuts.spring.data.jpa.batch.insertion.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roytuts.spring.data.jpa.batch.insertion.entity.Employee;
import com.roytuts.spring.data.jpa.batch.insertion.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public void saveEmployees(List<Employee> employees) {
        int size = employees.size();
        int counter = 0;

        List<Employee> temp = new ArrayList<>();

        for (Employee emp : employees) {
            temp.add(emp);

            if ((counter + 1) % 10 == 0 || (counter + 1) == size) {
                employeeRepository.saveAll(temp);
                temp.clear();
            }

            counter++;
        }
    }

    @Transactional
    public void test() {
        List<Employee> temp = new ArrayList<>();

        AtomicLong count = new AtomicLong();
        while (count.get() < 10000L) {
            temp.add(Employee.builder().id(count.get()).name(UUID.randomUUID().toString().substring(0, 10)).build());
//            employeeRepository.save(Employee.builder().id(count.get()).name(UUID.randomUUID().toString().substring(0, 10)).build());
            count.incrementAndGet();
        }

        var result = employeeRepository.saveAll(temp);
//        log.debug("@@ result : {}", result.size());
    }
}