/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uncc.mhealth.utils;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 *
 * @author Jai Kiran
 */
public class EmailUtil {

	public static final String MAIL_FROM_ADDRESS="smartrekmhealth@gmail.com";
	public static final String MAIL_FROM_ADDRESS_PWD="mHealth@123";
	public static final String MAIL_FROM_ADDRESS_NAME="mHealth Research Team";
	
	public static final String MAIL_TO_ADDRESS="mhealthegowan@gmail.com";
	public static final String MAIL_TO_ADDRESS_NAME="mHealth Gowan";
	
	public static final String MAIL_CC_ADDRESS="dkazemi@uncc.edu";
	public static final String MAIL_CC_ADDRESS_NAME="Donna Kazemi";
	
	public static final String subject="Six Week Survey Completed";
	
	
    public static boolean sendMessage(String studyId) {

        Properties properties = new Properties();
        properties.setProperty("mail.smtp.host", "smtp.gmail.com");
        properties.setProperty("mail.smtp.socketFactory.port", "465");
        properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.port", "465");
        
        
        
        boolean state=true;
        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties,
                new Authenticator() {

                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(MAIL_FROM_ADDRESS, MAIL_FROM_ADDRESS_PWD);
                    }
                });
        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);
            // Set From: header field of the header.
            message.setFrom(new InternetAddress(MAIL_FROM_ADDRESS,MAIL_FROM_ADDRESS_NAME));
            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(MAIL_TO_ADDRESS,MAIL_TO_ADDRESS_NAME));
            message.addRecipient(Message.RecipientType.CC,
                    new InternetAddress(MAIL_CC_ADDRESS,MAIL_CC_ADDRESS_NAME));
            // Set Subject: header field
            message.setSubject(subject);
            // Now set the actual message
            ///message.setText("This is actual message");
            message.setContent(getSurveyCompletedMsg(studyId), "text/html");
            // Send message
            Transport.send(message);
            state=true;
        } catch (MessagingException e) {
			throw new RuntimeException(e);
		}catch (UnsupportedEncodingException ex) {
            Logger.getLogger(EmailUtil.class.getName()).log(Level.SEVERE, null, ex);
            state=false;
        }
        return state;
    
    }

    private static String getSurveyCompletedMsg(String studyId) {

        
        return 
        "<!doctype html>"+
        "<html>"+
        "<head>"+
        "<meta name=\"viewport\" content=\"width=device-width\">"+
        "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">"+
        "<title>mHealth</title>"+
        "<style>"+
        "/* -------------------------------------"+
        "    GLOBAL"+
        "------------------------------------- */"+
        "* {"+
        "  font-family: \"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;"+
        "  font-size: 100%;"+
        "  line-height: 1.6em;"+
        "  margin: 0;"+
        "  padding: 0;"+
        "}"+
        "img {"+
        "  max-width: 600px;"+
        "  width: auto;"+
        "}"+
        "body {"+
        "  -webkit-font-smoothing: antialiased;"+
        "  height: 100%;"+
        "  -webkit-text-size-adjust: none;"+
        "  width: 100% !important;"+
        "}"+
        "/* -------------------------------------"+
        "    ELEMENTS"+
        "------------------------------------- */"+
        "a {"+
        "  color: #348eda;"+
        "}"+
        ".btn-primary {"+
        "  Margin-bottom: 10px;"+
        "  width: auto !important;"+
        "}"+
        ".btn-primary td {"+
        "  background-color: #348eda; "+
        "  border-radius: 25px;"+
        "  font-family: \"Helvetica Neue\", Helvetica, Arial, \"Lucida Grande\", sans-serif; "+
        "  font-size: 14px; "+
        "  text-align: center;"+
        "  vertical-align: top; "+
        "}"+
        ".btn-primary td a {"+
        "  background-color: #348eda;"+
        "  border: solid 1px #348eda;"+
        "  border-radius: 25px;"+
        "  border-width: 10px 20px;"+
        "  display: inline-block;"+
        "  color: #ffffff;"+
        "  cursor: pointer;"+
        "  font-weight: bold;"+
        "  line-height: 2;"+
        "  text-decoration: none;"+
        "}"+
        ".last {"+
        "  margin-bottom: 0;"+
        "}"+
        ".first {"+
        "  margin-top: 0;"+
        "}"+
        ".padding {"+
        "  padding: 10px 0;"+
        "}"+
        "/* -------------------------------------"+
        "    BODY"+
        "------------------------------------- */"+
        "table.body-wrap {"+
        "  padding: 20px;"+
        "  width: 100%;"+
        "}"+
        "table.body-wrap .container {"+
        "  border: 1px solid #f0f0f0;"+
        "}"+
        "/* -------------------------------------"+
        "    FOOTER"+
        "------------------------------------- */"+
        "table.footer-wrap {"+
        "  clear: both !important;"+
        "  width: 100%;  "+
        "}"+
        ".footer-wrap .container p {"+
        "  color: #666666;"+
        "  font-size: 12px;"+
        "  "+
        "}"+
        "table.footer-wrap a {"+
        "  color: #999999;"+
        "}"+
        "/* -------------------------------------"+
        "    TYPOGRAPHY"+
        "------------------------------------- */"+
        "h1, "+
        "h2, "+
        "h3 {"+
        "  color: #111111;"+
        "  font-family: \"Helvetica Neue\", Helvetica, Arial, \"Lucida Grande\", sans-serif;"+
        "  font-weight: 200;"+
        "  line-height: 1.2em;"+
        "  margin: 40px 0 10px;"+
        "}"+
        "h1 {"+
        "  font-size: 36px;"+
        "}"+
        "h2 {"+
        "  font-size: 28px;"+
        "}"+
        "h3 {"+
        "  font-size: 22px;"+
        "}"+
        "p, "+
        "ul, "+
        "ol {"+
        "  font-size: 14px;"+
        "  font-weight: normal;"+
        "  margin-bottom: 10px;"+
        "}"+
        "ul li, "+
        "ol li {"+
        "  margin-left: 5px;"+
        "  list-style-position: inside;"+
        "}"+
        "/* ---------------------------------------------------"+
        "    RESPONSIVENESS"+
        "------------------------------------------------------ */"+
        "/* Set a max-width, and make it display as block so it will automatically stretch to that width, but will also shrink down on a phone or something */"+
        ".container {"+
        "  clear: both !important;"+
        "  display: block !important;"+
        "  Margin: 0 auto !important;"+
        "  max-width: 600px !important;"+
        "}"+
        "/* Set the padding on the td rather than the div for Outlook compatibility */"+
        ".body-wrap .container {"+
        "  padding: 20px;"+
        "}"+
        "/* This should also be a block element, so that it will fill 100% of the .container */"+
        ".content {"+
        "  display: block;"+
        "  margin: 0 auto;"+
        "  max-width: 600px;"+
        "}"+
        "/* Let's make sure tables in the content area are 100% wide */"+
        ".content table {"+
        "  width: 100%;"+
        "}"+
        "</style>"+
        "</head>"+
        ""+
        "<body bgcolor=\"#f6f6f6\">"+
        ""+
        "<!-- body -->"+
        "<table class=\"body-wrap\" bgcolor=\"#f6f6f6\">"+
        "  <tr>"+
        "    <td></td>"+
        "    <td class=\"container\" bgcolor=\"#FFFFFF\">"+
        ""+
        "      <!-- content -->"+
        "      <div class=\"content\">"+
        "      <table>"+
        "        <tr>"+
        "          <td>"+
        "            <p>Dear "+MAIL_TO_ADDRESS_NAME+",</p>"+
        "            <p>The user with Study Id:: "+studyId+" has completed his/her Six Week Survey. Please proceed with further steps.</p>"+
        "            <p>Thanks & Regards</p>"+
        "            <p>mHealth Research Team</p>"+
        "          </td>"+
        "        </tr>"+
        "      </table>"+
        "      </div>"+
        "      <!-- /content -->"+
        "      "+
        "    </td>"+
        "    <td></td>"+
        "  </tr>"+
        "</table>"+
        "<!-- /body -->"+
        ""+
        "<!-- footer -->"+
        "<table class=\"footer-wrap\">"+
        "  <tr>"+
        "    <td></td>"+
        "    <td class=\"container\">"+
        "      "+
        "      <!-- content -->"+
        "      <div class=\"content\">"+
        "        <table>"+
        "          <tr>"+
        "            <td align=\"center\">"+
        "              <p>You recieved this Message from <a href=\"mailto:"+MAIL_FROM_ADDRESS+"\">"+MAIL_FROM_ADDRESS_NAME+"</a> - mHealth Research Team."+
        "              </p>"+
        "            </td>"+
        "          </tr>"+
        "        </table>"+
        "      </div>"+
        "      <!-- /content -->"+
        "      "+
        "    </td>"+
        "    <td></td>"+
        "  </tr>"+
        "</table>"+
        "<!-- /footer -->"+
        ""+
        "</body>"+
        "</html>";
   
    }
    
}
