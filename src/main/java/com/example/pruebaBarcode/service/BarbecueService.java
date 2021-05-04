package com.example.pruebaBarcode.service;

import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import net.sourceforge.barbecue.output.OutputException;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;

@Service
public class BarbecueService {

    public BufferedImage generateEAN13BarcodeImage(String inputText){
        try {
            String barcodeText = inputText;
            while(barcodeText.length() <12){
                barcodeText = "0"+barcodeText;
            }
            Barcode barcode = BarcodeFactory.createEAN13(barcodeText);
            return BarcodeImageHandler.getImage(barcode);
        } catch (BarcodeException | OutputException e) {
            e.printStackTrace();
            return null;
        }
    }
}
