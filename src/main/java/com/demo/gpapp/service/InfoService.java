package com.demo.gpapp.service;

import com.demo.gpapp.entity.InfoEntity;
import com.demo.gpapp.repository.InfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InfoService {

    private final InfoRepository infoRepository;

    public ResponseEntity<InfoEntity> saveInfo(String info) {
        InfoEntity infoEntity = InfoEntity.builder().info(info).build();
        return ResponseEntity.ok(infoRepository.save(infoEntity));
    }

    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(infoRepository.findAll());
    }
}
