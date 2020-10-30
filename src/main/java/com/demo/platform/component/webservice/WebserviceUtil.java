package com.demo.platform.component.webservice;

import org.apache.commons.lang3.StringUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebserviceUtil {

    public static void main(String[] args) {
        String paramXml11 = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "  <soap:Body>\n" +
                "    <getSupportCity xmlns=\"http://WebXml.com.cn/\">\n" +
                "      <byProvinceName>辽宁</byProvinceName>\n" +
                "    </getSupportCity>\n" +
                "  </soap:Body>\n" +
                "</soap:Envelope>";
        String soapAction = "http://WebXml.com.cn/getSupportCity";

        String result = sendXmlSoap11("http://www.webxml.com.cn/WebServices/WeatherWebService.asmx",
                paramXml11, soapAction);
        System.out.println("============================================");
        System.out.println(result);
        System.out.println("============================================");


        String paramXml12 = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <getWeatherbyCityName xmlns=\"http://WebXml.com.cn/\">\n" +
                "      <theCityName>沈阳</theCityName>\n" +
                "    </getWeatherbyCityName>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        result = sendXmlSoap12("http://www.webxml.com.cn/WebServices/WeatherWebService.asmx",
                paramXml12);
        System.out.println("============================================");
        System.out.println(result);
        System.out.println("============================================");
    }

    public static String sendXmlSoap11(String asmxUrl, String paramXml, String soapAction) {
        return sendXml(asmxUrl, paramXml, soapAction);
    }

    public static String sendXmlSoap12(String asmxUrl, String paramXml) {
        return sendXml(asmxUrl, paramXml, null);
    }

    private static String sendXml(String asmxUrl, String paraXml, String soapAction) {
        OutputStream out = null;
        String respData = null;
        try {
            URL url = new URL(asmxUrl);

            HttpURLConnection con;
            con = (HttpURLConnection) url.openConnection();
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("POST");
            con.setUseCaches(false);
            if (StringUtils.isEmpty(soapAction)) {
                // soap 1.2
                con.setRequestProperty("Content-type", "application/soap+xml;charset=utf-8");
            } else {
                // soap 1.1
                con.setRequestProperty("Content-type", "text/xml; charset=UTF-8");
                con.setRequestProperty("SOAPAction", soapAction);
            }

            con.setRequestProperty("Encoding", "UTF-8");
            out = con.getOutputStream();
            con.getOutputStream().write(paraXml.getBytes());
            out.flush();
            out.close();
            int code = con.getResponseCode();
            String tempString = null;
            StringBuffer sb1 = new StringBuffer();
            if (code == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
                while ((tempString = reader.readLine()) != null) {
                    sb1.append(tempString);
                }
                if (null != reader) {
                    reader.close();
                }
            } else {
                BufferedReader reader = new BufferedReader(new InputStreamReader(con.getErrorStream(), "UTF-8"));
                // 一次读入一行，直到读入null为文件结束
                while ((tempString = reader.readLine()) != null) {
                    sb1.append(tempString);
                }
                if (null != reader) {
                    reader.close();
                }
            }
            //响应报文
            respData = sb1.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respData;
    }


}
