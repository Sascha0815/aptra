package git_aptra.ResponsePDF;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Image;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.util.GregorianCalendar;

import org.apache.pdfbox.pdmodel.PDDocument;



public class Invitation {
	
	static GregorianCalendar now = new GregorianCalendar(); 
	static DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);		
    private static Font FontHeadline = new Font(Font.FontFamily.COURIER, 16, Font.BOLD);
	private static Document rejection = new Document();	
	private static String dates = df.format(now.getTime());	
	private static Chunk chunkDate = new Chunk(Invitation.dates);	            
    private static Paragraph date = new Paragraph(chunkDate);
	private static Paragraph headline = new Paragraph("R�ckmeldung bez�glich Ihrer Bewerbung bei Aptra", FontHeadline);
	private static Paragraph introduction = new Paragraph("vielen Dank f�r Ihre ansprechende Bewerbung und das damit verbundene Interesse an einer T�tigkeit in unserem Unternehmen.");
	private static Paragraph mainPart = new Paragraph("Ihre Bewerbung hat unser Interesse geweckt und wir w�rden uns gerne ein individuelles Bild von Ihnen machen. Aus diesem Grund laden wir Sie zu einem pers�nlichen Vorstellungsgespr�ch am  (Datum)  (Uhrzeit)  (Stra�e)  (Ort) ein.");
	private static Paragraph noteOfThanks = new Paragraph("Sollten Sie an diesem Tag verhindert sein, bitten wir Sie sich mit uns in Verbindung zu setzen um einen alternativen Termin zu vereinbaren.");
	private static Paragraph ending = new Paragraph("Mit freundlichen Gr��en");
	private static Paragraph signature = new Paragraph("Aptra GmbH & Co. KG");
	
	
	
	public static void invitation(String fullName, String streetNr, String PCCity, String sex, String name, int id){
			try {
				PdfWriter.getInstance(rejection, new FileOutputStream("Einladung Gespr�ch " + fullName + "(" + id + ").pdf"));			
				rejection.open();
				Image logo = Image.getInstance("SAP_APTRA/src/git_aptra/resources/Logo.png");
				logo.scaleAbsolute(90, 90);
				logo.setAbsolutePosition(490, 737);
				rejection.add(logo);
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
					Paragraph salutationMale = new Paragraph("Sehr geehrter Herr " + name);
					rejection.add(salutationMale);
				}
				else {
					Paragraph salutationFemale = new Paragraph("Sehr geehrte Frau "+ name);
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
				        doc = PDDocument.load("C:/Users/Fabi/git/aptra/Einladung Gespr�ch " + fullName + "(" + id + ").pdf");
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
		
