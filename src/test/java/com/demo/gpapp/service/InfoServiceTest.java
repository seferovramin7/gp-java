package com.demo.gpapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.demo.gpapp.entity.InfoEntity;
import com.demo.gpapp.repository.InfoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class InfoServiceTest {

    @InjectMocks
    InfoService service;

    @Mock
    InfoRepository repository;


    @Test
    public void testSaveInfo() {
        String info = "Some info";
        InfoEntity savedInfoEntity = new InfoEntity();
        when(repository.save(any(InfoEntity.class))).thenReturn(savedInfoEntity);

        ResponseEntity<InfoEntity> response = service.saveInfo(info);
        verify(repository, times(1)).save(any(InfoEntity.class));
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(savedInfoEntity, response.getBody());
    }
}
