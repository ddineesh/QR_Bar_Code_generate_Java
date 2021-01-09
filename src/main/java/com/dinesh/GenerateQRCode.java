package com.dinesh;
import java.nio.file.Paths;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;

public class GenerateQRCode {

	public static void main(String[] args) throws Exception {
		
		String dataQR = "My-QR-Data";
		String dataBarCodeData = "My-Barcode-Data";

		String path = "C:\\QR-Code\\DD.jpg";
		String barCodePath = "C:\\QR-Code\\DD_BarCode.jpg";
		
		BitMatrix matrix = new MultiFormatWriter()
				.encode(dataQR, BarcodeFormat.QR_CODE, 500, 500);
		
		System.out.println(" QR code generated..");
		
		MatrixToImageWriter.writeToPath(matrix, "jpg", Paths.get(path));

		Code128Writer code128Writer=new Code128Writer();
		BitMatrix barCodeMatrix = code128Writer
				.encode(dataBarCodeData, BarcodeFormat.CODE_128, 500, 500);		
		
		MatrixToImageWriter.writeToPath(barCodeMatrix, "jpg", Paths.get(barCodePath));
		
		System.out.println(" Bar code generated..");
		
	}

}