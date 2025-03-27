package tech.saintbassanaga.qrcodegenerator;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by saintbassanaga {saintbassanaga}
 * In the Project QrCodeGenerator at Wed - 3/12/25
 */


@Service
public class PDFService {
        public String extractTextFromPDF(MultipartFile file) throws IOException {
            try (PDDocument document = PDDocument.load(file.getInputStream())) {
                PDFTextStripper pdfStripper = new PDFTextStripper();
                String extractedText = pdfStripper.getText(document).trim();

                System.out.println("Extracted PDF Text:\n" + extractedText); // Debug log

                return extractedText;
            }
        }

}
