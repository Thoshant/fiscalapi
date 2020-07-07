package com.code.fiscalapi.service;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@Component
public class ReadPDFService {

    public String getCodeFromPDF(String placeOfBirth, String fileName, boolean codePositionFirst) {

        Resource resource = new ClassPathResource(fileName);
        try (PDDocument document = PDDocument.load(resource.getFile())) {
            document.getClass();
            if (!document.isEncrypted()) {

                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition(true);

                PDFTextStripper tStripper = new PDFTextStripper();

                String pdfFileInText = tStripper.getText(document);

                String lines[] = pdfFileInText.split("\\r?\\n");
                Optional<String> first = Arrays.stream(lines)
                        .filter(s -> s.contains(placeOfBirth.toUpperCase()))
                        .findFirst();
                if (first.isPresent() && !first.get().isEmpty()) {
                    String[] s = first.get().split(" ");
                    if (codePositionFirst) {
                        return s[0];
                    } else {
                        return s[s.length - 1];
                    }
                }
            }
        } catch (InvalidPasswordException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
