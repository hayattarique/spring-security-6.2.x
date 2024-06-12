package org.boot.controller;

import lombok.RequiredArgsConstructor;
import org.boot.dtos.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class AuthenticationController {

    @GetMapping
    public ResponseEntity<ResponseDto> getProduct() {
        ResponseDto dto = new ResponseDto("Hello There how are u", "200");
        return ResponseEntity.ok(dto);
    }
}
