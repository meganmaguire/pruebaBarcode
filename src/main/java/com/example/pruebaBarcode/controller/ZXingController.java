package com.example.pruebaBarcode.controller;

import com.example.pruebaBarcode.service.BarbecueService;
import com.example.pruebaBarcode.service.ZXingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.BufferedImage;

@RestController
@RequestMapping(value = "/barcodes", produces = MediaType.IMAGE_PNG_VALUE)
public class ZXingController {
    @Autowired
    ZXingService service;

    @GetMapping("/zxing/ean13/{barcode}")
    public ResponseEntity<BufferedImage> generateEAN13BarcodeImage(@PathVariable String barcode){
        BufferedImage response = service.generateEAN13BarcodeImage(barcode);
        if(response!=null){
            return ResponseEntity.ok().body(response);
        }
        else{
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping("/zxing/code128/{barcode}")
    public ResponseEntity<BufferedImage> generateCode128BarcodeImage(@PathVariable String barcode){
        BufferedImage response = service.generateCode128BarcodeImage(barcode);
        if(response!=null){
            return ResponseEntity.ok().body(response);
        }
        else{
            return ResponseEntity.badRequest().body(response);
        }
    }
    @GetMapping("/zxing/pdf417/{barcode}")
    public ResponseEntity<BufferedImage> generatePdf417BarcodeImage(@PathVariable String barcode){
        BufferedImage response = service.generatePdf417BarcodeImage(barcode);
        if(response!=null){
            return ResponseEntity.ok().body(response);
        }
        else{
            return ResponseEntity.badRequest().body(response);
        }
    }
}
