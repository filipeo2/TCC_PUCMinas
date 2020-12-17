
package com.filipeo2.integracao.soap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.filipeo2.integracao.rest.ArrayOfCovid;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteudo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GetCovidByDateResult" type="{http://schemas.datacontract.org/2004/07/CovidWcf}ArrayOfCovid" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getCovidByDateResult"
})
@XmlRootElement(name = "GetCovidByDateResponse")
public class GetCovidByDateResponse {

    @XmlElementRef(name = "GetCovidByDateResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfCovid> getCovidByDateResult;

    /**
     * Obtem o valor da propriedade getCovidByDateResult.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfCovid }{@code >}
     *     
     */
    public JAXBElement<ArrayOfCovid> getGetCovidByDateResult() {
        return getCovidByDateResult;
    }

    /**
     * Define o valor da propriedade getCovidByDateResult.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfCovid }{@code >}
     *     
     */
    public void setGetCovidByDateResult(JAXBElement<ArrayOfCovid> value) {
        this.getCovidByDateResult = value;
    }

}
