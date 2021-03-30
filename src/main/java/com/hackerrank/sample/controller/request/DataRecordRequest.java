package com.hackerrank.sample.controller.request;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class DataRecordRequest {

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private Integer phoneNumber;
}
