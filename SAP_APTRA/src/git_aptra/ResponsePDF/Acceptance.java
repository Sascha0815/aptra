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



public class Acceptance {
  
  static GregorianCalendar now = new GregorianCalendar(); 
  static DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);   
  private static Font FontHeadline = new Font(Font.FontFamily.COURIER, 16, Font.BOLD);
  private static Document rejection = new Document(); 
  private static String dates = df.format(now.getTime()); 
  private static Chunk chunkDate = new Chunk(Acceptance.dates);             
  private static Paragraph date = new Paragraph(chunkDate);
  private static Paragraph headline = new Paragraph("R�ckmeldung bez�glich Ihrer Bewerbung bei Aptra", FontHeadline);
  private static Paragraph introduction = new Paragraph("wir freuen uns Ihnen mitteilen zu k�nnen, dass Sie beim Vorstellungsgespr�ch einen sehr guten Eindruck hinterlassen haben. Schlie�lich haben wir uns aus einem sehr gro�en Bewerberkreis f�r Sie entschieden. Sowohl Ihre Qualifikationen als auch Ihr bisheriger Werdegang haben uns �berzeugt.");
  private static Paragraph mainPart = new Paragraph("Aus diesem Grund m�chten wir Ihnen ein Angebot unterbreiten. In der Anlage finden Sie den entsprechenden Arbeitsvertrag. Wenn Sie mit dessen Inhalt einverstanden sind bitten wir Sie diesen m�glichst zeitnah, unterschrieben zur�ckzusenden.");
  private static Paragraph noteOfThanks = new Paragraph("Wir hoffen, dass unser Angebot Ihre Zustimmung finden wird. Sollten Sie sich f�r uns entscheiden m�chten wir Sie herzlich als k�nftigen Mitarbeiter unseres Unternehmens willkommen hei�en");
  private static Paragraph ending = new Paragraph("Mit freundlichen Gr��en");
  private static Paragraph signature = new Paragraph("Aptra GmbH & Co. KG");
  
  
  
  public static void acceptance(String fullName, String streetNr, String PCCity, String sex, String name, int id){
      try {
        PdfWriter.getInstance(rejection, new FileOutputStream("Zusage " + fullName + "(" + id + ").pdf"));      
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
                doc = PDDocument.load("C:/Users/Fabi/git/aptra/Zusage " + fullName + "(" + id + ").pdf");
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