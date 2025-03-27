package tech.saintbassanaga.qrcodegenerator;


import org.springframework.stereotype.Service;


/**
 * Created by saintbassanaga {saintbassanaga}
 * In the Project QrCodeGenerator at Wed - 3/12/25
 */
@Service
public class VCardService {

    public String createVCard(String extractedText) {
        // Assume the extracted text follows a structured format
        String[] lines = extractedText.split("\n");

        String name = getValue(lines, "Name:");
        String title = getValue(lines, "Title:");
        String organization = getValue(lines, "Organization:");
        String address = getValue(lines, "Address:");
        String phone = getValue(lines, "Phone:");
        String email = getValue(lines, "Email:");
        String website = getValue(lines, "Website:");

        return "BEGIN:VCARD\n" +
                "VERSION:3.0\n" +
                "FN:" + name + "\n" +
                "TITLE:" + title + "\n" +
                "ORG:" + organization + "\n" +
                "ADR:" + address + "\n" +
                "TEL:" + phone + "\n" +
                "EMAIL:" + email + "\n" +
                "URL:" + website + "\n" +
                "END:VCARD";
    }

    private String getValue(String[] lines, String prefix) {
        for (String line : lines) {
            if (line.startsWith(prefix)) {
                return line.replace(prefix, "").trim();
            }
        }
        return "";
    }
}
