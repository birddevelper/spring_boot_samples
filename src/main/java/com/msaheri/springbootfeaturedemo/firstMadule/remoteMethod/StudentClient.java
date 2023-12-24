package com.msaheri.springbootfeaturedemo.firstMadule.remoteMethod;


import com.msaheri.springbootfeaturedemo.firstMadule.model.Student;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="student-service", url="http://127.0.0.1:3000/api")
public interface StudentClient {

    @PostMapping("/student")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    Student getStudentById(@RequestParam("id") int id);
}
