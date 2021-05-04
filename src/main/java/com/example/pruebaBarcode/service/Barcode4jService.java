package com.example.pruebaBarcode.service;

import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.impl.pdf417.PDF417Bean;
import org.krysalis.barcode4j.impl.upcean.EAN13Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;

@Service
public class Barcode4jService {

    public BufferedImage generateEAN13BarcodeImage(String inputText){

        if(inputText.length() < 14) {
            String barcode = inputText;
            while(barcode.length() <12){
                barcode = "0"+barcode;
            }
            EAN13Bean barcodeGenerator = new EAN13Bean();
            BitmapCanvasProvider canvas = new BitmapCanvasProvider(160, BufferedImage.TYPE_BYTE_BINARY, false, 0);
            barcodeGenerator.generateBarcode(canvas, barcode);
            return canvas.getBufferedImage();
        }
        return null;
    }

    public BufferedImage generateCode128BarcodeImage(String inputText){

        Code128Bean barcodeGenerator = new Code128Bean();
        BitmapCanvasProvider canvas = new BitmapCanvasProvider(160, BufferedImage.TYPE_BYTE_BINARY,false, 0);
        barcodeGenerator.generateBarcode(canvas, inputText);
        return canvas.getBufferedImage();
    }

    public BufferedImage generatePdf417BarcodeImage(String inputText){

        PDF417Bean barcodeGenerator = new PDF417Bean();
        BitmapCanvasProvider canvas = new BitmapCanvasProvider(160, BufferedImage.TYPE_BYTE_BINARY,false, 0);
        barcodeGenerator.generateBarcode(canvas, inputText);
        return canvas.getBufferedImage();
    }
}
