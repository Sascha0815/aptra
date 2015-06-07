package git_aptra.ResponsePDF;

import com.ibm.icu.util.Calendar;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Chunk;

import git_aptra.EditVacancyManagement.DialogEditVacancyManagementResponse;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
	private static Paragraph headline = new Paragraph("Rückmeldung bezüglich Ihrer Bewerbung bei Aptra", FontHeadline);
	private static Paragraph introduction = new Paragraph("vielen Dank für Ihre ansprechende Bewerbung und das damit verbundene Interesse an einer Tätigkeit in unserem Unternehmen.");
	private static Paragraph mainPart = new Paragraph("Ihre Bewerbung hat unser Interesse geweckt und wir würden uns gerne ein individuelles Bild von Ihnen machen. Aus diesem Grund laden wir Sie zu einem persönlichen Vorstellungsgespräch ein. Dieses findet am "+ DialogEditVacancyManagementResponse.getCal() + " um " + DialogEditVacancyManagementResponse.getTime() + " Uhr im Raum " +  DialogEditVacancyManagementResponse.getLocation() + " statt.");
	private static Paragraph noteOfThanks = new Paragraph("Sollten Sie an diesem Tag verhindert sein, bitten wir Sie sich mit uns in Verbindung zu setzen um einen alternativen Termin zu vereinbaren.");
	private static Paragraph ending = new Paragraph("Mit freundlichen Grüßen");
	private static Paragraph signature = new Paragraph("Aptra GmbH & Co. KG");
	
	
	
	public static void invitation(String fullName, String streetNr, String PCCity, String sex, String name, int id){
		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH.mm.ss");
		  Calendar cal = Calendar.getInstance();
		try {
				PdfWriter.getInstance(rejection, new FileOutputStream("Einladung Gespräch " + fullName + "(" + id + ", " + dateFormat.format(cal.getTime()) +").pdf"));		
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
				if (sex.equals("männlich")) {
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
				        doc = PDDocument.load("Einladung Gespräch " + fullName + "(" + id + ", " +dateFormat.format(cal.getTime())+").pdf");		
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
		
