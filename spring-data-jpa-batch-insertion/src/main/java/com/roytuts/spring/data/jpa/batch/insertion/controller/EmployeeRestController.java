package com.roytuts.spring.data.jpa.batch.insertion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.roytuts.spring.data.jpa.batch.insertion.entity.Employee;
import com.roytuts.spring.data.jpa.batch.insertion.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Api(value = "컨트롤러", description = "")
@Slf4j
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employees/save")
    @ApiOperation(value = "벌크 삽입", notes = "벌크 삽입.")
    public ResponseEntity<Void> saveEmployees(@RequestBody List<Employee> employees) {
        employeeService.saveEmployees(employees);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PostMapping("/employees/test")
    @ApiOperation(value = "벌크 삽입 테스트 파라미터 없이", notes = "벌크 삽입.")
    public ResponseEntity<Void> test() {
        var stopWatch = new StopWatch();
        stopWatch.start();
        employeeService.test();
        stopWatch.stop();
        log.debug("@@ stopWatch : {}", stopWatch.getTotalTimeSeconds());
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}