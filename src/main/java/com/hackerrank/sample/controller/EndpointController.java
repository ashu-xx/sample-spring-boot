package com.hackerrank.sample.controller;

import com.hackerrank.sample.controller.request.DataRecordRequest;
import com.hackerrank.sample.controller.response.DataRecordResponse;
import com.hackerrank.sample.dto.Mapper;
import com.hackerrank.sample.repository.entity.DataRecordEntity;
import com.hackerrank.sample.service.DataRecordService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController("EndpointController")
@RequiredArgsConstructor
@RequestMapping("/endpoint")
public class EndpointController {

    @NonNull
    private Mapper mapper;
    @NonNull
    private DataRecordService dataRecordService;

    @PostMapping("/insert")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<DataRecordResponse> insert(final @RequestBody @NotNull DataRecordRequest dataRecordRequest) {

        val dataRecordEntity = dataRecordService.post(mapper.toEntity(dataRecordRequest));
        val response = mapper.toResponse(dataRecordEntity);
        return ResponseEntity.of(Optional.of(response));
    }

    @PostMapping("/delete/{id}")
    public void delete(final @PathVariable @NotNull String id, HttpServletResponse response) {

        val dataRecordEntityOptional = dataRecordService.delete(id);
        if (!dataRecordEntityOptional.isPresent()) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @GetMapping("/select/{id}")
    public ResponseEntity<DataRecordResponse> select(final @PathVariable @NotNull String id) {

        val dataRecordEntityOptional = dataRecordService.get(id);
        if (!dataRecordEntityOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        val response = mapper.toResponse(dataRecordEntityOptional.get());
        return ResponseEntity.of(Optional.of(response));
    }

    @GetMapping("/select")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<List<DataRecordResponse>> select() {

        val dataRecordEntityList = dataRecordService.get();
        val response = dataRecordEntityList.stream()
                                           .sorted(Comparator.comparing(DataRecordEntity::getId))
                                           .map(entity -> mapper.toResponse(entity))
                                           .collect(Collectors.toList());

        return ResponseEntity.of(Optional.of(response));
    }
}
