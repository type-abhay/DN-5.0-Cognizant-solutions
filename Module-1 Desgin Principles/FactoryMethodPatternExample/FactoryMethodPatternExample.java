// Interface & Document Types
interface Document {
    void open();
    void save();
    void close();
}

class WordDocument implements Document {
    public void open() { System.out.println("Opening Word Document (.docx)..."); }
    public void save() { System.out.println("Saving Word Document..."); }
    public void close() { System.out.println("Closing Word Document."); }
}

class PdfDocument implements Document {
    public void open() { System.out.println("Opening PDF Document (.pdf)..."); }
    public void save() { System.out.println("Saving PDF Document..."); }
    public void close() { System.out.println("Closing PDF Document."); }
}

class ExcelDocument implements Document {
    public void open() { System.out.println("Opening Excel Spreadsheet (.xlsx)..."); }
    public void save() { System.out.println("Saving Excel Spreadsheet..."); }
    public void close() { System.out.println("Closing Excel Spreadsheet."); }
}

// Abstract Factory & Concrete Factories
abstract class DocumentFactory {
    public abstract Document createDocument();

    public void processDocument() {
        Document doc = createDocument();
        doc.open();
        doc.save();
        doc.close();
    }
}

class WordDocumentFactory extends DocumentFactory {
    public Document createDocument() { return new WordDocument(); }
}

class PdfDocumentFactory extends DocumentFactory {
    public Document createDocument() { return new PdfDocument(); }
}

class ExcelDocumentFactory extends DocumentFactory {
    public Document createDocument() { return new ExcelDocument(); }
}

// Main class matching the file name
public class FactoryMethodPatternExample {
    public static void main(String[] args) {
        System.out.println("--- Testing Factory Method Pattern ---\n");

        System.out.println(">>> Word Document Factory:");
        DocumentFactory wordFactory = new WordDocumentFactory();
        wordFactory.processDocument();

        System.out.println("\n>>> PDF Document Factory:");
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        pdfFactory.processDocument();

        System.out.println("\n>>> Excel Document Factory:");
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        excelFactory.processDocument();
    }
}