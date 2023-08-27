package com.demo.gpapp.controller;

import com.demo.gpapp.service.InfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("info")
public class InfoController {

    private final InfoService infoService;

    @GetMapping("save")
    public ResponseEntity<?> saveText(@RequestParam String info) {
        return infoService.saveInfo(info);
    }

    @GetMapping("all")
    public ResponseEntity<?> getAll() {
        return infoService.getAll();
    }
}
