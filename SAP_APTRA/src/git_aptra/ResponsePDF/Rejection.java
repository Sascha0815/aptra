package git_aptra.ResponsePDF;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Chunk;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.util.GregorianCalendar;

import org.apache.pdfbox.pdmodel.PDDocument;



public class Rejection {
  
  static GregorianCalendar now = new GregorianCalendar(); 
  static DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);   
  private static Font FontHeadline = new Font(Font.FontFamily.COURIER, 16, Font.BOLD);
  private static Document rejection = new Document(); 
  private static String dates = df.format(now.getTime()); 
  private static Chunk chunkDate = new Chunk(Rejection.dates);              
  private static Paragraph date = new Paragraph(chunkDate);
  private static Paragraph headline = new Paragraph("R�ckmeldung bez�glich Ihrer Bewerbung bei Aptra", FontHeadline);
  private static Paragraph introduction = new Paragraph("wir bedanken uns f�r Ihre Bewerbung und das damit zum Ausdruck gebrachte Interesse an einer Mitarbeit in unserem Unternehmen.");
  private static Paragraph mainPart = new Paragraph("Wir haben inzwischen unsere Vorauswahl getroffen. Leider konnten wir Ihre Bewerbung nicht in die engere Wahl ziehen � wir haben uns f�r einige Kandidatinnen und Kandidaten entschieden, deren Profil noch genauer den Anforderungen der ausgeschriebenen Position entspricht.");
  private static Paragraph noteOfThanks = new Paragraph("Wir danken Ihnen f�r Ihre M�he, die Sie sich mit der Bewerbung gemacht haben und w�nschen Ihnen alles Gute f�r Ihren weiteren Weg.");
  private static Paragraph ending = new Paragraph("Mit freundlichen Gr��en");
  private static Paragraph signature = new Paragraph("Aptra GmbH & Co. KG");
  
  
  
  public static void rejection(String fullName, String streetNr, String PCCity, String sex, String name, int id){
      try {
        PdfWriter.getInstance(rejection, new FileOutputStream("Ablehnung " + fullName + "(" + id + ").pdf"));     
        rejection.open();
        Chunk chunkFullName = new Chunk(fullName);              
        Paragraph ParagraphFullName = new Paragraph(chunkFullName);
        rejection.add(ParagraphFullName);
        Chunk chunkStreetNr = new Chunk(streetNr);              
        Paragraph ParagraphStreetNr = new Paragraph(chunkStreetNr);
        rejection.add(ParagraphStreetNr);
        Chunk chunkPCCity = new Chunk(PCCity);              
        Paragraph ParagraphPCCity = new Paragraph(chunkPCCity);
        rejection.add(ParagraphPCCity);
        rejection.add(Chunk.NEWLINE);
        rejection.add(Chunk.NEWLINE);
        rejection.add(Chunk.NEWLINE);
              date.setAlignment(Paragraph.ALIGN_RIGHT);
              date.setSpacingAfter(30);
              rejection.add(date);
        rejection.add(headline);
        rejection.add(Chunk.NEWLINE);       
        if (sex.equals("m�nnlich")) {
          Paragraph salutationMale = new Paragraph("Sehr geehrter Herr " + name +",");
          rejection.add(salutationMale);
        }
        else {
          Paragraph salutationFemale = new Paragraph("Sehr geehrte Frau "+ name +",");
          rejection.add(salutationFemale);
        }       
        rejection.add(introduction);
        rejection.add(mainPart);
        rejection.add(noteOfThanks);
        rejection.add(Chunk.NEWLINE);
        rejection.add(ending);
        rejection.add(signature);
        rejection.close();
        
        PDDocument doc=null;
            try {
                doc = PDDocument.load("C:/Users/Fabi/git/aptra/Ablehnung " + fullName + "(" + id + ").pdf");
                doc.print();
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                if (doc != null) {
                    try {
                        doc.close();
                    } catch (IOException ex1) {
                        ex1.printStackTrace();
                    }
                }
            }
        
      } catch (Exception e) {
        e.printStackTrace();    
      }
    }
}