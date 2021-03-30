package com.hackerrank.sample.controller.response;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class DataRecordResponse {

    @NotNull
    private Long id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private Integer phoneNumber;
}
