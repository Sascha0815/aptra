package git_aptra.ResponsePDF;

import java.io.FileOutputStream;
import java.text.DateFormat;
import java.util.GregorianCalendar;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class Acceptance {
	static GregorianCalendar now = new GregorianCalendar(); 
	static DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);	
	
    private static Font FontHeadline = new Font(Font.FontFamily.COURIER, 16, Font.BOLD);
    private static Font FontText = new Font(Font.FontFamily.COURIER, 12, Font.NORMAL);
	private static Document rejection = new Document();
	private static Paragraph name  = new Paragraph("Fabian Gierer");
	private static Paragraph streetHNR = new Paragraph("Steinenbach 15");
	private static Paragraph PLZCity  = new Paragraph("88069 Tettnang");	
	static String dates = df.format(now.getTime());	
	static Chunk chunkDate = new Chunk(Rejection.dates);	            
    static Paragraph date = new Paragraph(chunkDate);
	private static Paragraph headline = new Paragraph("R�ckmeldung bez�glich Ihrer Bewerbung bei Aptra", FontHeadline);
	private static Paragraph salutationFemale = new Paragraph("Sehr geehrte Frau [Empf�nger]");
	private static Paragraph salutationMale = new Paragraph("Sehr geehrter Herr [Empf�nger]");
	private static Paragraph introduction = new Paragraph("wir bedanken uns f�r Ihre Bewerbung und das damit zum Ausdruck gebrachte Interesse an einer Mitarbeit in unserem Unternehmen.");
	private static Paragraph mainPart = new Paragraph("Wir haben inzwischen unsere Vorauswahl getroffen. Leider konnten wir Ihre Bewerbung nicht in die engere Wahl ziehen � wir haben uns f�r einige Kandidatinnen und Kandidaten entschieden, deren Profil noch genauer den Anforderungen der ausgeschriebenen Position entspricht.");
	private static Paragraph noteOfThanks = new Paragraph("Wir danken Ihnen f�r Ihre M�he, die Sie sich mit der Bewerbung gemacht haben und w�nschen Ihnen alles Gute f�r Ihren weiteren Weg.");
	private static Paragraph ending = new Paragraph("Mit freundlichen Gr��en");
	private static Paragraph signature = new Paragraph("Aptra GmbH & Co. KG");
	
	
	//public static void rejection(String firstName, String name, String streetHouseNR, String postalCode, String city){
	public static void acceptance(){
			try {
				PdfWriter.getInstance(rejection, new FileOutputStream("Ablehnung.pdf"));			
				rejection.open();
				Image logo = Image.getInstance("SAP_APTRA/src/git_aptra/resources/Logo.png");
				logo.scaleAbsolute(90, 90);
				logo.setAbsolutePosition(500, 747);
				rejection.add(logo);
				rejection.add(name);
				rejection.add(streetHNR);
				rejection.add(PLZCity);
				rejection.add(Chunk.NEWLINE);
				rejection.add(Chunk.NEWLINE);
				rejection.add(Chunk.NEWLINE);
	            date.setAlignment(Paragraph.ALIGN_RIGHT);
	            date.setSpacingAfter(30);
	            rejection.add(date);
				rejection.add(headline);
				rejection.add(Chunk.NEWLINE);
				rejection.add(salutationMale);
				rejection.add(introduction);
				rejection.add(mainPart);
				rejection.add(noteOfThanks);
				rejection.add(Chunk.NEWLINE);
				rejection.add(ending);
				rejection.add(signature);
				rejection.close();
				
			} catch (Exception e) {
				e.printStackTrace();		
			}
		}
}
