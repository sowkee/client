package com.credibanco.client.Consumir;

import com.credibanco.dependencia.DTO.RequestDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import static com.credibanco.dependencia.Http.HttpService.getHttpEntity;


public class HttpService {
    private static final Logger logger = LoggerFactory.getLogger(HttpService.class);
    @Autowired
    static RequestDTO requestDTO;

    public static String consumirService(){
        try {
            logger.info("-------Envia la peticion-------");

            requestDTO.setId(200);
            requestDTO.setUserName("Juan");
            requestDTO.setUserPassword("12345");

            ResponseEntity<String> response = new RestTemplate().exchange("http://localhost:8081/users/create", HttpMethod.POST, getHttpEntity(requestDTO), String.class);
            if (response.getStatusCode() == HttpStatus.OK) {
                logger.info(response.getBody());
            }
        } catch (Exception e) {
            logger.error("------Error------", e);
        }
        return null;
    }


}
