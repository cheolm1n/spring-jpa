package com.roytuts.spring.data.jpa.batch.insertion.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.roytuts.spring.data.jpa.batch.insertion.Application;
import com.roytuts.spring.data.jpa.batch.insertion.entity.Employee;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Application.class })
@Transactional
@NoArgsConstructor
@Slf4j
public class insertTest {

    @Autowired
    EmployeeService service;

    @Test
    public void bulkSaveTest() {
        List<Employee> temp = new ArrayList<>();

        AtomicLong count = new AtomicLong();
        while (count.get() < 1000L) {
            temp.add(Employee.builder().id(count.get()).name(UUID.randomUUID().toString().substring(0, 10)).build());

            count.incrementAndGet();
        }

        service.saveEmployees(temp);

    }
}
