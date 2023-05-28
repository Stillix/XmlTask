package by.dorogokupets.vouchers.validator;

import by.dorogokupets.vouchers.handler.VouchersErrorHandler;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XmlValidator {
    private String language;
    private String fileName;
    private String schemaName;

    public XmlValidator(String fileName, String schemaName) {
        this.language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        this.fileName = fileName;
        this.schemaName = schemaName;
    }

    public void validateXml() {
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(schemaName);
        try {
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(fileName);
            validator.setErrorHandler(new VouchersErrorHandler());
            validator.validate(source);
        } catch (SAXException | IOException e) {
            System.err.println(fileName + " is not correct or valid");
        }
    }
}
