
package com.filipeo2.integracao.rest;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de ArrayOfCovid complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfCovid"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Covid" type="{http://schemas.datacontract.org/2004/07/CovidWcf}Covid" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfCovid", propOrder = {
    "covid"
})
public class ArrayOfCovid {

    @XmlElement(name = "Covid", nillable = true)
    protected List<Covid> covid;

    /**
     * Gets the value of the covid property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the covid property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCovid().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Covid }
     * 
     * 
     */
    public List<Covid> getCovid() {
        if (covid == null) {
            covid = new ArrayList<Covid>();
        }
        return this.covid;
    }

}
