package tech.saintbassanaga.qrcodegenerator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {VCardService.class})
@ExtendWith(SpringExtension.class)
class VCardServiceDiffblueTest {
    @Autowired
    private VCardService vCardService;

    /**
     * Test {@link VCardService#createVCard(String)}.
     * <p>
     * Method under test: {@link VCardService#createVCard(String)}
     */
    @Test
    @DisplayName("Test createVCard(String)")
    @Tag("MaintainedByDiffblue")
    void testCreateVCard() {
        // Arrange
        // TODO: Populate arranged inputs
        String extractedText = "";

        // Act
        String actualCreateVCardResult = this.vCardService.createVCard(extractedText);

        // Assert
        // TODO: Add assertions on result
    }
}
