package data.utils;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class PDFUtils {

    public static BufferedImage renderPage(PDDocument pdfDocument, int pageNumber) {
        PDFRenderer renderer = new PDFRenderer(pdfDocument);
        try {
            return renderer.renderImage(pageNumber);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

}
