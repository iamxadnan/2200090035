package com.affordmedical.backend.service;

import java.util.List;
import java.util.OptionalDouble;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.affordmedical.backend.model.NumbersResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

@Service
public class CalService {

     @Autowired
     private final RestTemplate restTemplate;

    public CalService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public double primes(){
        String accessKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJNYXBDbGFpbXMiOnsiZXhwIjoxNzQ3ODk4MDU2LCJpYXQiOjE3NDc4OTc3NTYsImlzcyI6IkFmZm9yZG1lZCIsImp0aSI6IjMyYzRjZDBjLWQ1ZjctNDEyYi1hZTRiLTM0NDE4YzVlYTlkZCIsInN1YiI6IjIyMDAwOTAwMzVjc2l0QGdtYWlsLmNvbSJ9LCJlbWFpbCI6IjIyMDAwOTAwMzVjc2l0QGdtYWlsLmNvbSIsIm5hbWUiOiJtb2hhbW1hZCBhZG5hbiBzaGFyaWZmIiwicm9sbE5vIjoiMjIwMDA5MDAzNSIsImFjY2Vzc0NvZGUiOiJiZVRKakoiLCJjbGllbnRJRCI6IjMyYzRjZDBjLWQ1ZjctNDEyYi1hZTRiLTM0NDE4YzVlYTlkZCIsImNsaWVudFNlY3JldCI6IkZidXJtSFZXZnJuQ0VmRXYifQ.-Pq1buBEGdcEUfNGfvUkjVTEQpBjogPJwud0veLLVGU";
        String url = "http://20.244.56.144/evaluation-service/primes";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessKey);
          HttpEntity<String> entity = new HttpEntity<>(headers);

        // Fetch the data from the API
        ResponseEntity<NumbersResponse> response = restTemplate.exchange(
            url,
            HttpMethod.GET,
            entity,
            NumbersResponse.class
        );

        // Extract numbers from the response body
        List<Integer> numbers = response.getBody().getNumbers();
        
       OptionalDouble average = numbers.stream()
                                        .mapToInt(Integer::intValue)
                                        .average();

        return average.orElseThrow(() -> new IllegalStateException("Could not calculate the average"));
    }

    public double even(){
        String accessKey ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJNYXBDbGFpbXMiOnsiZXhwIjoxNzQ3ODk3NTUzLCJpYXQiOjE3NDc4OTcyNTMsImlzcyI6IkFmZm9yZG1lZCIsImp0aSI6IjMyYzRjZDBjLWQ1ZjctNDEyYi1hZTRiLTM0NDE4YzVlYTlkZCIsInN1YiI6IjIyMDAwOTAwMzVjc2l0QGdtYWlsLmNvbSJ9LCJlbWFpbCI6IjIyMDAwOTAwMzVjc2l0QGdtYWlsLmNvbSIsIm5hbWUiOiJtb2hhbW1hZCBhZG5hbiBzaGFyaWZmIiwicm9sbE5vIjoiMjIwMDA5MDAzNSIsImFjY2Vzc0NvZGUiOiJiZVRKakoiLCJjbGllbnRJRCI6IjMyYzRjZDBjLWQ1ZjctNDEyYi1hZTRiLTM0NDE4YzVlYTlkZCIsImNsaWVudFNlY3JldCI6IkZidXJtSFZXZnJuQ0VmRXYifQ._AtawV8kZ7_kfmGVUOdOH-6fUZYMoVU4fxZRe1NOCiY";
        String url = "http://20.244.56.144/evaluation-service/even";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessKey);
          HttpEntity<String> entity = new HttpEntity<>(headers);

        // Fetch the data from the API
        ResponseEntity<NumbersResponse> response = restTemplate.exchange(
            url,
            HttpMethod.GET,
            entity,
            NumbersResponse.class
        );

        // Extract numbers from the response body
        List<Integer> numbers = response.getBody().getNumbers();
        
       OptionalDouble average = numbers.stream()
                                        .mapToInt(Integer::intValue)
                                        .average();

        return average.orElseThrow(() -> new IllegalStateException("Could not calculate the average"));
    }

    public double fib(){
        String accessKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJNYXBDbGFpbXMiOnsiZXhwIjoxNzQ3ODk3NTUzLCJpYXQiOjE3NDc4OTcyNTMsImlzcyI6IkFmZm9yZG1lZCIsImp0aSI6IjMyYzRjZDBjLWQ1ZjctNDEyYi1hZTRiLTM0NDE4YzVlYTlkZCIsInN1YiI6IjIyMDAwOTAwMzVjc2l0QGdtYWlsLmNvbSJ9LCJlbWFpbCI6IjIyMDAwOTAwMzVjc2l0QGdtYWlsLmNvbSIsIm5hbWUiOiJtb2hhbW1hZCBhZG5hbiBzaGFyaWZmIiwicm9sbE5vIjoiMjIwMDA5MDAzNSIsImFjY2Vzc0NvZGUiOiJiZVRKakoiLCJjbGllbnRJRCI6IjMyYzRjZDBjLWQ1ZjctNDEyYi1hZTRiLTM0NDE4YzVlYTlkZCIsImNsaWVudFNlY3JldCI6IkZidXJtSFZXZnJuQ0VmRXYifQ._AtawV8kZ7_kfmGVUOdOH-6fUZYMoVU4fxZRe1NOCiY";
        String url = "http://20.244.56.144/evaluation-service/fibo";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessKey);
          HttpEntity<String> entity = new HttpEntity<>(headers);

        // Fetch the data from the API
        ResponseEntity<NumbersResponse> response = restTemplate.exchange(
            url,
            HttpMethod.GET,
            entity,
            NumbersResponse.class
        );

        // Extract numbers from the response body
        List<Integer> numbers = response.getBody().getNumbers();
        
       OptionalDouble average = numbers.stream()
                                        .mapToInt(Integer::intValue)
                                        .average();

        return average.orElseThrow(() -> new IllegalStateException("Could not calculate the average"));
    }


    public double rand(){
        String accessKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJNYXBDbGFpbXMiOnsiZXhwIjoxNzQ3ODk4MDU2LCJpYXQiOjE3NDc4OTc3NTYsImlzcyI6IkFmZm9yZG1lZCIsImp0aSI6IjMyYzRjZDBjLWQ1ZjctNDEyYi1hZTRiLTM0NDE4YzVlYTlkZCIsInN1YiI6IjIyMDAwOTAwMzVjc2l0QGdtYWlsLmNvbSJ9LCJlbWFpbCI6IjIyMDAwOTAwMzVjc2l0QGdtYWlsLmNvbSIsIm5hbWUiOiJtb2hhbW1hZCBhZG5hbiBzaGFyaWZmIiwicm9sbE5vIjoiMjIwMDA5MDAzNSIsImFjY2Vzc0NvZGUiOiJiZVRKakoiLCJjbGllbnRJRCI6IjMyYzRjZDBjLWQ1ZjctNDEyYi1hZTRiLTM0NDE4YzVlYTlkZCIsImNsaWVudFNlY3JldCI6IkZidXJtSFZXZnJuQ0VmRXYifQ.-Pq1buBEGdcEUfNGfvUkjVTEQpBjogPJwud0veLLVGU";
        String url = "http://20.244.56.144/evaluation-service/rand";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessKey);
          HttpEntity<String> entity = new HttpEntity<>(headers);

        // Fetch the data from the API
        ResponseEntity<NumbersResponse> response = restTemplate.exchange(
            url,
            HttpMethod.GET,
            entity,
            NumbersResponse.class
        );

        // Extract numbers from the response body
        List<Integer> numbers = response.getBody().getNumbers();
        
       OptionalDouble average = numbers.stream()
                                        .mapToInt(Integer::intValue)
                                        .average();

        return average.orElseThrow(() -> new IllegalStateException("Could not calculate the average"));
    }

}
