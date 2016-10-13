package com.example.usuario.pruebawebsservice.ws;

import android.util.Log;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

/**
 * Created by Usuario on 11/10/2016.
 */

public class SOAPClient {
    private  static String URL = "http://www.webservicex.net/convertweight.asmx";
    private  static String METHOD_NAME = "ConvertWeight";
    private  static String NAMESPACE = "http://www.webserviceX.NET/";
    private  static String SOAP_ACTION = NAMESPACE + METHOD_NAME;

    public static String convertWeight(String weight, String fromUnit,String toUnit){
        String result= null;

        SoapObject request = new SoapObject(NAMESPACE,METHOD_NAME);
        request.addProperty("Weight",weight);
        request.addProperty("FromUnit",fromUnit);
        request.addProperty("ToUnit",toUnit);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.dotNet= true;
        envelope.setOutputSoapObject(request);

        HttpTransportSE transportSE = new HttpTransportSE(URL);
        transportSE.debug = true;
        try{
            transportSE.call(SOAP_ACTION, envelope);
            SoapPrimitive soapPrimitive = (SoapPrimitive) envelope.getResponse();
            result = soapPrimitive.toString();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Log.i("XML Request",transportSE.requestDump);
        Log.i("XML Response",transportSE.responseDump);

        return result;
    }
}
