package tech.saintbassanaga.qrcodegenerator;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import com.google.zxing.WriterException;

import org.springframework.http.HttpHeaders;

@RestController
@RequestMapping("/api/qrcode")
@CrossOrigin(origins = "*")
public class QRCodeController {

    private final PDFService pdfService;
    private final VCardService vCardService;
    private final QRCodeService qrCodeService;

    public QRCodeController(PDFService pdfService, VCardService vCardService, QRCodeService qrCodeService) {
        this.pdfService = pdfService;
        this.vCardService = vCardService;
        this.qrCodeService = qrCodeService;
    }

    @PostMapping(value = "/generate-from-pdf", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> generateQRCodeFromPDF(@RequestParam("file") MultipartFile file) {
        try {
            // Step 1: Extract text from PDF
            String extractedText = pdfService.extractTextFromPDF(file);

            // Step 2: Convert to vCard
            String vCardData = vCardService.createVCard(extractedText);
            System.out.println("Generated vCard:\n" + vCardData); // Debugging

            // Step 3: Generate QR Code
            byte[] qrCodeImage = qrCodeService.generateQRCode(vCardData, 300, 300);

            // Return the QR code image as a downloadable file
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_PNG)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"qrcode.png\"")
                    .body(qrCodeImage);

        } catch (IOException | WriterException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }
}
