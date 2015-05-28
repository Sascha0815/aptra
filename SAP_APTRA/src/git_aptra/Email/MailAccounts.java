package git_aptra.Email;

public enum MailAccounts{
	
	// Hier bitte die ensprechenden Attribute jeweils anpassen
	WEB("smtp.web.de", 25, "aptra@web.de", "bermudadreieck", "Aptra"),
	GMX("mail.gmx.net", 25, "aptra@gmx.de", "bermudadreieck", "Aptra"),
	// Hier können weitere E-Mail Accounts als ENUM angelegt werden
	;
	
	private String smtpHost;
	private int port;
	private String username;
	private String password;
	private String email;
	
	/**
	 * Setzt die notwendigen Attribute des MailAccounts
	 * @param smtpHost - SMTP Host
	 * @param port - Port
	 * @param username - Benutzername
	 * @param password - Passwort
	 * @param email - Absender E-Mail
	 */
	private MailAccounts(String smtpHost, int port, String username, String password, String email)
	{
		this.smtpHost = smtpHost;
		this.port = port;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	public int getPort()
	{
		return port;
	}
	
	public String getSmtpHost()
	{
		return smtpHost;
	}
	
	public MailAuthenticator getPasswordAuthentication()
	{
		return new MailAuthenticator(username, password);
	}
	
	public String getEmail()
	{
		return email;
	}
}
