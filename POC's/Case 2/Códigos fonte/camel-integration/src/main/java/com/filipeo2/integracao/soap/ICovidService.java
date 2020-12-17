package com.filipeo2.integracao.soap;

import com.filipeo2.integracao.rest.ArrayOfCovid;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.7.fuse-770017-redhat-00001
 * 2020-12-01T20:29:38.700-03:00
 * Generated source version: 3.2.7.fuse-770017-redhat-00001
 *
 */
@WebService(targetNamespace = "http://tempuri.org/", name = "ICovidService")
@XmlSeeAlso({com.filipeo2.integracao.soapfactory.ObjectFactory.class, ObjectFactory.class, com.filipeo2.integracao.rest.ObjectFactory.class})
public interface ICovidService {

    @WebMethod(operationName = "GetCovidByDate", action = "http://tempuri.org/ICovidService/GetCovidByDate")
    @Action(input = "http://tempuri.org/ICovidService/GetCovidByDate", output = "http://tempuri.org/ICovidService/GetCovidByDateResponse")
    @RequestWrapper(localName = "GetCovidByDate", targetNamespace = "http://tempuri.org/", className = "GetCovidByDate")
    @ResponseWrapper(localName = "GetCovidByDateResponse", targetNamespace = "http://tempuri.org/", className = "GetCovidByDateResponse")
    @WebResult(name = "GetCovidByDateResult", targetNamespace = "http://tempuri.org/")
    public ArrayOfCovid getCovidByDate(
        @WebParam(name = "from", targetNamespace = "http://tempuri.org/")
        java.lang.String from
    );
}
