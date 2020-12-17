
package com.filipeo2.integracao.rest;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.datacontract.schemas._2004._07.covidwcf package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ArrayOfCovid_QNAME = new QName("http://schemas.datacontract.org/2004/07/CovidWcf", "ArrayOfCovid");
    private final static QName _Covid_QNAME = new QName("http://schemas.datacontract.org/2004/07/CovidWcf", "Covid");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.datacontract.schemas._2004._07.covidwcf
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ArrayOfCovid }
     * 
     */
    public ArrayOfCovid createArrayOfCovid() {
        return new ArrayOfCovid();
    }

    /**
     * Create an instance of {@link Covid }
     * 
     */
    public Covid createCovid() {
        return new Covid();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfCovid }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfCovid }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/CovidWcf", name = "ArrayOfCovid")
    public JAXBElement<ArrayOfCovid> createArrayOfCovid(ArrayOfCovid value) {
        return new JAXBElement<ArrayOfCovid>(_ArrayOfCovid_QNAME, ArrayOfCovid.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Covid }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Covid }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/CovidWcf", name = "Covid")
    public JAXBElement<Covid> createCovid(Covid value) {
        return new JAXBElement<Covid>(_Covid_QNAME, Covid.class, null, value);
    }

}
