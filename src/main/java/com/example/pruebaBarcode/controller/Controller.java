package com.example.pruebaBarcode.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("")
    public ResponseEntity<String> mainPage(){
        String html = "<h1>Generador de códigos de barra</h1>" +
                "<b>Barbecue: </b>Acceder a /barcodes/barbecue/ean13/{nro}<br><br>" +
                "<b>Barcode4j: </b>" +
                "<ul> <li><b>EAN-13:</b> Acceder a /barcodes/barcode4j/ean13/{nro}<br><br></li>" +
                "<li><b>Code 128</b> Acceder a /barcodes/barcode4j/code128/{string}<br><br></li>" +
                "<li><b>PDF417:</b> Acceder a /barcodes/barcode4j/pdf417/{string}<br><br></li></ul><br>" +
                "<b>ZXing: </b>" +
                "<ul> <li><b>EAN-13:</b> Acceder a /barcodes/zxing/ean13/{nro}<br><br></li>" +
                "<li><b>Code 128</b> Acceder a /barcodes/zxing/code128/{string}<br><br></li>" +
                "<li><b>PDF417:</b> Acceder a /barcodes/zxing/pdf417/{string}<br><br></li></ul><br>";
        return ResponseEntity.ok().body(html);
    }
}
