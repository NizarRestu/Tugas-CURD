package com.toko.online.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHelper {
    public static <T> ResponseEntity<commonResponse<T>> ok(T data) {
        commonResponse<T> response = new commonResponse<T>();
        response.setMessage("Success");
        response.setStatus("200");
        response.setData(data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public static <T> ResponseEntity<commonResponse<T>> error(String eror, HttpStatus httpStatus) {
        commonResponse<T> response = new commonResponse<>();
        response.setStatus(String.valueOf(httpStatus.value()));
        response.setMessage(httpStatus.name());
        response.setData((T) eror);
        return new ResponseEntity<>(response, httpStatus);
    }

}
