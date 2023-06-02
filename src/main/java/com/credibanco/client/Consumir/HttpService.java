package com.credibanco.client.Consumir;

import com.credibanco.client.DTO.UserDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class HttpService {
    private static final Logger logger = LoggerFactory.getLogger(HttpService.class);
    public static String consumirService(){
        UserDto userDto = new UserDto();
        userDto.setId(2L);
        userDto.setUserName("Juan");
        userDto.setUserPassword("12345");
        ResponseEntity<String> response = new RestTemplate().exchange("http://localhost:8081/users/create", HttpMethod.POST, getHttpEntity(userDto), String.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            logger.info(response.getBody());
        }
        return null;
    }

    private static HttpEntity getHttpEntity(UserDto userDto) {
        return new HttpEntity(userDto, getHttpHeadersJson());
    }

    private static HttpHeaders  getHttpHeadersJson(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/json");
        headers.add("Accept", "application/json");
        return headers;
    }
}
