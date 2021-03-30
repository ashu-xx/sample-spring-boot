package com.hackerrank.sample.service;

import com.hackerrank.sample.repository.DataRecordRepository;
import com.hackerrank.sample.repository.entity.DataRecordEntity;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.val;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class DataRecordService {

    @NonNull
    private DataRecordRepository dataRecordRepository;

    public Optional<DataRecordEntity> get(final String id) {

        return dataRecordRepository.findById(id);
    }

    public List<DataRecordEntity> get() {

        return dataRecordRepository.findAll();
    }

    public DataRecordEntity post(final DataRecordEntity dataRecordEntity) {

        return dataRecordRepository.saveAndFlush(dataRecordEntity);
    }

    public Optional<DataRecordEntity> delete(final String id) {

        val dataRecordEntityOptional = get(id);
        if (dataRecordEntityOptional.isPresent()) {
            dataRecordRepository.deleteById(id);
        }
        return dataRecordEntityOptional;
    }
}
