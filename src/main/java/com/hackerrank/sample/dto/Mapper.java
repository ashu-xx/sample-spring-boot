package com.hackerrank.sample.dto;

import com.hackerrank.sample.controller.request.DataRecordRequest;
import com.hackerrank.sample.controller.response.DataRecordResponse;
import com.hackerrank.sample.repository.entity.DataRecordEntity;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public DataRecordEntity toEntity(final DataRecordRequest dataRecordRequest) {

        return DataRecordEntity.builder()
                               .firstName(dataRecordRequest.getFirstName())
                               .lastName(dataRecordRequest.getLastName())
                               .phoneNumber(dataRecordRequest.getPhoneNumber())
                               .build();
    }

    public DataRecordResponse toResponse(final DataRecordEntity dataRecordEntity) {

        return DataRecordResponse.builder()
                                 .id(dataRecordEntity.getId())
                                 .firstName(dataRecordEntity.getFirstName())
                                 .lastName(dataRecordEntity.getLastName())
                                 .phoneNumber(dataRecordEntity.getPhoneNumber())
                                 .build();
    }
}
