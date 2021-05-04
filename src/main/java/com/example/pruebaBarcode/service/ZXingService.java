package com.example.pruebaBarcode.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.oned.EAN13Writer;
import com.google.zxing.pdf417.PDF417Writer;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;

@Service
public class ZXingService {

    public BufferedImage generateEAN13BarcodeImage(String inputText){
        EAN13Writer barcodeWriter = new EAN13Writer();
        BitMatrix bitMatrix = null;
        String barcode = inputText;
        while(barcode.length() <12){
            barcode = "0"+barcode;
        }
        int digitoControl = digitoControlCalculator(barcode);
        barcode = barcode + digitoControl;
        try {
            // Se necesita generar el bit de chequeo para generar el código
            bitMatrix = barcodeWriter.encode(barcode, BarcodeFormat.EAN_13,400,150);

            return MatrixToImageWriter.toBufferedImage(bitMatrix);
        } catch (WriterException e) {
            e.printStackTrace();
            return null;
        }
    }

    public BufferedImage generateCode128BarcodeImage(String inputText){
        Code128Writer barcodeWriter = new Code128Writer();
        BitMatrix bitMatrix = null;
        try {
            // Se necesita generar el bit de chequeo para generar el código
            bitMatrix = barcodeWriter.encode(inputText, BarcodeFormat.CODE_128,400,150);

            return MatrixToImageWriter.toBufferedImage(bitMatrix);
        } catch (WriterException e) {
            e.printStackTrace();
            return null;
        }
    }

    public BufferedImage generatePdf417BarcodeImage(String inputText){
        PDF417Writer barcodeWriter = new PDF417Writer();
        BitMatrix bitMatrix = null;
        try {
            // Se necesita generar el bit de chequeo para generar el código
            bitMatrix = barcodeWriter.encode(inputText, BarcodeFormat.PDF_417,400,150);

            return MatrixToImageWriter.toBufferedImage(bitMatrix);
        } catch (WriterException e) {
            e.printStackTrace();
            return null;
        }
    }

    private int digitoControlCalculator(String input) {
        char[] charDigits = input.toCharArray();
        int[] ean13 = {1, 3};
        int sum = 0;
        for(int i = 0; i < charDigits.length; i++) {
            sum += Character.getNumericValue(charDigits[i]) * ean13[i % 2];
        }
        int checksum = 10 - sum % 10;
        if(checksum == 10)
            checksum = 0;
        return checksum;
    }
}
