package tech.saintbassanaga.qrcodegenerator;

import com.google.zxing.WriterException;

import java.io.IOException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {QRCodeService.class})
@ExtendWith(SpringExtension.class)
class QRCodeServiceDiffblueTest {
    @Autowired
    private QRCodeService qRCodeService;

    /**
     * Test {@link QRCodeService#generateQRCode(String, int, int)}.
     * <p>
     * Method under test: {@link QRCodeService#generateQRCode(String, int, int)}
     */
    @Test
    @DisplayName("Test generateQRCode(String, int, int)")
    @Tag("MaintainedByDiffblue")
    void testGenerateQRCode() throws WriterException, IOException {
        // Arrange
        // TODO: Populate arranged inputs
        String vCardData = "";
        int width = 0;
        int height = 0;

        // Act
        byte[] actualGenerateQRCodeResult = this.qRCodeService.generateQRCode(vCardData, width, height);

        // Assert
        // TODO: Add assertions on result
    }
}
