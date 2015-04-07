package git_aptra.ResponsePDF;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.Image;

import java.io.FileOutputStream;

public class Rejecion {
	private static Font FontHeadline = new Font(Font.FontFamily.COURIER, 16, Font.BOLD);
	private static Document rejection = new Document();
	private static Paragraph headline = new Paragraph("Rückmeldung bezüglich Ihrer Bewerbung bei Aptra", FontHeadline);
	private static Paragraph salutationFemale = new Paragraph("Sehr geehrte Frau [Empfänger]");
	private static Paragraph salutationMale = new Paragraph("Sehr geehrter Herr [Empfänger]");
	private static Paragraph introduction = new Paragraph("wir bedanken uns für Ihre Bewerbung und das damit zum Ausdruck gebrachte Interesse an einer Mitarbeit in unserem Unternehmen.");
	private static Paragraph mainPart = new Paragraph("Wir haben inzwischen unsere Vorauswahl getroffen. Leider konnten wir Ihre Bewerbung nicht in die engere Wahl ziehen – wir haben uns für einige Kandidatinnen und Kandidaten entschieden, deren Profil noch genauer den Anforderungen der ausgeschriebenen Position entspricht.");
	private static Paragraph noteOfThanks = new Paragraph("Wir danken Ihnen für Ihre Mühe, die Sie sich mit der Bewerbung gemacht haben und wünschen Ihnen alles Gute für Ihren weiteren Weg.");
	private static Paragraph ending = new Paragraph("Mit freundlichen Grüßen");
	private static Paragraph signature = new Paragraph("Aptra GmbH & Co. KG");
	
	
	//public static void rejection(String firstName, String name, String streetHouseNR, String postalCode, String city){
	public static void rejection(){
		try {
			PdfWriter.getInstance(rejection, new FileOutputStream("Ablehnung.pdf"));			
			rejection.open();
			Image logo = Image.getInstance("SAP_APTRA/src/git_aptra/resources/Logo.png");
			logo.scaleAbsolute(90, 90);
			logo.setAbsolutePosition(500, 747);
			rejection.add(logo);
			
		
			rejection.add(headline);
			rejection.add(Chunk.NEWLINE);
			rejection.add(salutationMale);
			//rejection.add(Chunk.NEWLINE);
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
