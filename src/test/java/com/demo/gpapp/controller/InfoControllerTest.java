package com.demo.gpapp.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.demo.gpapp.entity.InfoEntity;
import com.demo.gpapp.service.InfoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class InfoControllerTest {

    @InjectMocks
    InfoController controller;

    @Mock
    InfoService service;


    @Test
    public void testSaveText() {
        String info = "Some test info";
        InfoEntity infoEntity = InfoEntity.builder().info(info).build();
        when(service.saveInfo(info)).thenReturn(ResponseEntity.ok(infoEntity));
        ResponseEntity<?> response = controller.saveText(info);
        verify(service).saveInfo(info);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(infoEntity, response.getBody());
    }
}
