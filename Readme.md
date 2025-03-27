# QrCodeGenerator

QrCodeGenerator is a Spring Boot application designed to generate QR codes from PDF files. The application extracts text from uploaded PDF files, converts the extracted text into vCard format, and then generates a QR code image from the vCard data. The generated QR code is returned as a downloadable PNG image.

## Technologies Used
- Java
- Spring Boot
- Gradle
- Apache PDFBox (for PDF text extraction)
- ZXing (for QR code generation)

## Key Features
1. **PDF Text Extraction:** Utilizes Apache PDFBox to extract text content from uploaded PDF files.
2. **vCard Generation:** Converts the extracted text into vCard format.
3. **QR Code Generation:** Generates a QR code image from the vCard data using ZXing.
4. **File Upload Handling:** Supports file uploads with configurable size limits.
5. **Cross-Origin Resource Sharing (CORS):** Allows cross-origin requests to the API.

## Endpoints
- **POST /api/qrcode/generate-from-pdf:** Accepts a PDF file upload, processes the file to generate a QR code, and returns the QR code image as a downloadable PNG file.

## Configuration
- `application.properties`:
    - `spring.application.name=QrCodeGenerator`
    - `spring.servlet.multipart.max-file-size=10MB`
    - `spring.servlet.multipart.max-request-size=15MB`

## Usage
1. Start the application using the main class `QrCodeGeneratorApplication`.
2. Send a POST request to `/api/qrcode/generate-from-pdf` with a PDF file to generate a QR code.

## Example Request
```bash
curl -F "file=@path/to/your/file.pdf" http://localhost:8080/api/qrcode/generate-from-pdf -o qrcode.png