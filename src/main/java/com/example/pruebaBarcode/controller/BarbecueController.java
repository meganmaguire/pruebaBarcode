package com.example.pruebaBarcode.controller;

import com.example.pruebaBarcode.service.BarbecueService;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import net.sourceforge.barbecue.output.OutputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.awt.image.BufferedImage;

@RestController
@RequestMapping(value = "/barcodes", produces = MediaType.IMAGE_PNG_VALUE)
public class BarbecueController {

    @Autowired
    BarbecueService service;

    @GetMapping("/barbecue/ean13/{barcode}")
    public ResponseEntity<BufferedImage> generateEAN13BarcodeImage(@PathVariable String barcode){

        BufferedImage response = service.generateEAN13BarcodeImage(barcode);
        if(response!=null){
            return ResponseEntity.ok().body(response);
        }
        else{
            return ResponseEntity.badRequest().body(response);
        }
    }

}
