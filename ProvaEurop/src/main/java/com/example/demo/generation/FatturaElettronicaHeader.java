//
// Questo file � stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andr� persa durante la ricompilazione dello schema di origine. 
// Generato il: 2019.10.17 alle 12:02:28 PM CEST 
//


package com.example.demo.generation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per anonymous complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DatiTrasmissione">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="IdTrasmittente">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="IdPaese" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="IdCodice" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="ProgressivoInvio" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="FormatoTrasmissione" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="CodiceDestinatario" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="ContattiTrasmittente">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Telefono" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CedentePrestatore">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="DatiAnagrafici">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="IdFiscaleIVA">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="IdPaese" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="IdCodice" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="CodiceFiscale" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *                             &lt;element name="Anagrafica">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="Denominazione" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="RegimeFiscale" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Sede">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Indirizzo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="CAP" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *                             &lt;element name="Comune" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="Provincia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="Nazione" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CessionarioCommittente">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="DatiAnagrafici">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="IdFiscaleIVA">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="IdPaese" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="IdCodice" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="CodiceFiscale" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                             &lt;element name="Anagrafica">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="Denominazione" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Sede">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Indirizzo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="CAP" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                             &lt;element name="Comune" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="Provincia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="Nazione" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="TerzoIntermediarioOSoggettoEmittente">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="DatiAnagrafici">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="IdFiscaleIVA">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="IdPaese" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="IdCodice" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="CodiceFiscale" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                             &lt;element name="Anagrafica">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="Denominazione" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="SoggettoEmittente" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "datiTrasmissione",
    "cedentePrestatore",
    "cessionarioCommittente",
    "terzoIntermediarioOSoggettoEmittente",
    "soggettoEmittente"
})
@XmlRootElement(name = "FatturaElettronicaHeader")
public class FatturaElettronicaHeader {

    @XmlElement(name = "DatiTrasmissione", required = true)
    protected FatturaElettronicaHeader.DatiTrasmissione datiTrasmissione;
    @XmlElement(name = "CedentePrestatore", required = true)
    protected FatturaElettronicaHeader.CedentePrestatore cedentePrestatore;
    @XmlElement(name = "CessionarioCommittente", required = true)
    protected FatturaElettronicaHeader.CessionarioCommittente cessionarioCommittente;
    @XmlElement(name = "TerzoIntermediarioOSoggettoEmittente", required = true)
    protected FatturaElettronicaHeader.TerzoIntermediarioOSoggettoEmittente terzoIntermediarioOSoggettoEmittente;
    @XmlElement(name = "SoggettoEmittente", required = true)
    protected String soggettoEmittente;

    /**
     * Recupera il valore della propriet� datiTrasmissione.
     * 
     * @return
     *     possible object is
     *     {@link FatturaElettronicaHeader.DatiTrasmissione }
     *     
     */
    public FatturaElettronicaHeader.DatiTrasmissione getDatiTrasmissione() {
        return datiTrasmissione;
    }

    /**
     * Imposta il valore della propriet� datiTrasmissione.
     * 
     * @param value
     *     allowed object is
     *     {@link FatturaElettronicaHeader.DatiTrasmissione }
     *     
     */
    public void setDatiTrasmissione(FatturaElettronicaHeader.DatiTrasmissione value) {
        this.datiTrasmissione = value;
    }

    /**
     * Recupera il valore della propriet� cedentePrestatore.
     * 
     * @return
     *     possible object is
     *     {@link FatturaElettronicaHeader.CedentePrestatore }
     *     
     */
    public FatturaElettronicaHeader.CedentePrestatore getCedentePrestatore() {
        return cedentePrestatore;
    }

    /**
     * Imposta il valore della propriet� cedentePrestatore.
     * 
     * @param value
     *     allowed object is
     *     {@link FatturaElettronicaHeader.CedentePrestatore }
     *     
     */
    public void setCedentePrestatore(FatturaElettronicaHeader.CedentePrestatore value) {
        this.cedentePrestatore = value;
    }

    /**
     * Recupera il valore della propriet� cessionarioCommittente.
     * 
     * @return
     *     possible object is
     *     {@link FatturaElettronicaHeader.CessionarioCommittente }
     *     
     */
    public FatturaElettronicaHeader.CessionarioCommittente getCessionarioCommittente() {
        return cessionarioCommittente;
    }

    /**
     * Imposta il valore della propriet� cessionarioCommittente.
     * 
     * @param value
     *     allowed object is
     *     {@link FatturaElettronicaHeader.CessionarioCommittente }
     *     
     */
    public void setCessionarioCommittente(FatturaElettronicaHeader.CessionarioCommittente value) {
        this.cessionarioCommittente = value;
    }

    /**
     * Recupera il valore della propriet� terzoIntermediarioOSoggettoEmittente.
     * 
     * @return
     *     possible object is
     *     {@link FatturaElettronicaHeader.TerzoIntermediarioOSoggettoEmittente }
     *     
     */
    public FatturaElettronicaHeader.TerzoIntermediarioOSoggettoEmittente getTerzoIntermediarioOSoggettoEmittente() {
        return terzoIntermediarioOSoggettoEmittente;
    }

    /**
     * Imposta il valore della propriet� terzoIntermediarioOSoggettoEmittente.
     * 
     * @param value
     *     allowed object is
     *     {@link FatturaElettronicaHeader.TerzoIntermediarioOSoggettoEmittente }
     *     
     */
    public void setTerzoIntermediarioOSoggettoEmittente(FatturaElettronicaHeader.TerzoIntermediarioOSoggettoEmittente value) {
        this.terzoIntermediarioOSoggettoEmittente = value;
    }

    /**
     * Recupera il valore della propriet� soggettoEmittente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSoggettoEmittente() {
        return soggettoEmittente;
    }

    /**
     * Imposta il valore della propriet� soggettoEmittente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSoggettoEmittente(String value) {
        this.soggettoEmittente = value;
    }


    /**
     * <p>Classe Java per anonymous complex type.
     * 
     * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="DatiAnagrafici">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="IdFiscaleIVA">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="IdPaese" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="IdCodice" type="{http://www.w3.org/2001/XMLSchema}long"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="CodiceFiscale" type="{http://www.w3.org/2001/XMLSchema}long"/>
     *                   &lt;element name="Anagrafica">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="Denominazione" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="RegimeFiscale" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Sede">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Indirizzo" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="CAP" type="{http://www.w3.org/2001/XMLSchema}short"/>
     *                   &lt;element name="Comune" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="Provincia" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="Nazione" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "datiAnagrafici",
        "sede"
    })
    public static class CedentePrestatore {

        @XmlElement(name = "DatiAnagrafici", required = true)
        protected FatturaElettronicaHeader.CedentePrestatore.DatiAnagrafici datiAnagrafici;
        @XmlElement(name = "Sede", required = true)
        protected FatturaElettronicaHeader.CedentePrestatore.Sede sede;

        /**
         * Recupera il valore della propriet� datiAnagrafici.
         * 
         * @return
         *     possible object is
         *     {@link FatturaElettronicaHeader.CedentePrestatore.DatiAnagrafici }
         *     
         */
        public FatturaElettronicaHeader.CedentePrestatore.DatiAnagrafici getDatiAnagrafici() {
            return datiAnagrafici;
        }

        /**
         * Imposta il valore della propriet� datiAnagrafici.
         * 
         * @param value
         *     allowed object is
         *     {@link FatturaElettronicaHeader.CedentePrestatore.DatiAnagrafici }
         *     
         */
        public void setDatiAnagrafici(FatturaElettronicaHeader.CedentePrestatore.DatiAnagrafici value) {
            this.datiAnagrafici = value;
        }

        /**
         * Recupera il valore della propriet� sede.
         * 
         * @return
         *     possible object is
         *     {@link FatturaElettronicaHeader.CedentePrestatore.Sede }
         *     
         */
        public FatturaElettronicaHeader.CedentePrestatore.Sede getSede() {
            return sede;
        }

        /**
         * Imposta il valore della propriet� sede.
         * 
         * @param value
         *     allowed object is
         *     {@link FatturaElettronicaHeader.CedentePrestatore.Sede }
         *     
         */
        public void setSede(FatturaElettronicaHeader.CedentePrestatore.Sede value) {
            this.sede = value;
        }


        /**
         * <p>Classe Java per anonymous complex type.
         * 
         * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="IdFiscaleIVA">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="IdPaese" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="IdCodice" type="{http://www.w3.org/2001/XMLSchema}long"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="CodiceFiscale" type="{http://www.w3.org/2001/XMLSchema}long"/>
         *         &lt;element name="Anagrafica">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="Denominazione" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="RegimeFiscale" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "idFiscaleIVA",
            "codiceFiscale",
            "anagrafica",
            "regimeFiscale"
        })
        public static class DatiAnagrafici {

            @XmlElement(name = "IdFiscaleIVA", required = true)
            protected FatturaElettronicaHeader.CedentePrestatore.DatiAnagrafici.IdFiscaleIVA idFiscaleIVA;
            @XmlElement(name = "CodiceFiscale")
            protected long codiceFiscale;
            @XmlElement(name = "Anagrafica", required = true)
            protected FatturaElettronicaHeader.CedentePrestatore.DatiAnagrafici.Anagrafica anagrafica;
            @XmlElement(name = "RegimeFiscale", required = true)
            protected String regimeFiscale;

            /**
             * Recupera il valore della propriet� idFiscaleIVA.
             * 
             * @return
             *     possible object is
             *     {@link FatturaElettronicaHeader.CedentePrestatore.DatiAnagrafici.IdFiscaleIVA }
             *     
             */
            public FatturaElettronicaHeader.CedentePrestatore.DatiAnagrafici.IdFiscaleIVA getIdFiscaleIVA() {
                return idFiscaleIVA;
            }

            /**
             * Imposta il valore della propriet� idFiscaleIVA.
             * 
             * @param value
             *     allowed object is
             *     {@link FatturaElettronicaHeader.CedentePrestatore.DatiAnagrafici.IdFiscaleIVA }
             *     
             */
            public void setIdFiscaleIVA(FatturaElettronicaHeader.CedentePrestatore.DatiAnagrafici.IdFiscaleIVA value) {
                this.idFiscaleIVA = value;
            }

            /**
             * Recupera il valore della propriet� codiceFiscale.
             * 
             */
            public long getCodiceFiscale() {
                return codiceFiscale;
            }

            /**
             * Imposta il valore della propriet� codiceFiscale.
             * 
             */
            public void setCodiceFiscale(long value) {
                this.codiceFiscale = value;
            }

            /**
             * Recupera il valore della propriet� anagrafica.
             * 
             * @return
             *     possible object is
             *     {@link FatturaElettronicaHeader.CedentePrestatore.DatiAnagrafici.Anagrafica }
             *     
             */
            public FatturaElettronicaHeader.CedentePrestatore.DatiAnagrafici.Anagrafica getAnagrafica() {
                return anagrafica;
            }

            /**
             * Imposta il valore della propriet� anagrafica.
             * 
             * @param value
             *     allowed object is
             *     {@link FatturaElettronicaHeader.CedentePrestatore.DatiAnagrafici.Anagrafica }
             *     
             */
            public void setAnagrafica(FatturaElettronicaHeader.CedentePrestatore.DatiAnagrafici.Anagrafica value) {
                this.anagrafica = value;
            }

            /**
             * Recupera il valore della propriet� regimeFiscale.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRegimeFiscale() {
                return regimeFiscale;
            }

            /**
             * Imposta il valore della propriet� regimeFiscale.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRegimeFiscale(String value) {
                this.regimeFiscale = value;
            }


            /**
             * <p>Classe Java per anonymous complex type.
             * 
             * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="Denominazione" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "denominazione"
            })
            public static class Anagrafica {

                @XmlElement(name = "Denominazione", required = true)
                protected String denominazione;

                /**
                 * Recupera il valore della propriet� denominazione.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getDenominazione() {
                    return denominazione;
                }

                /**
                 * Imposta il valore della propriet� denominazione.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setDenominazione(String value) {
                    this.denominazione = value;
                }

            }


            /**
             * <p>Classe Java per anonymous complex type.
             * 
             * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="IdPaese" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="IdCodice" type="{http://www.w3.org/2001/XMLSchema}long"/>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "idPaese",
                "idCodice"
            })
            public static class IdFiscaleIVA {

                @XmlElement(name = "IdPaese", required = true)
                protected String idPaese;
                @XmlElement(name = "IdCodice")
                protected long idCodice;

                /**
                 * Recupera il valore della propriet� idPaese.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getIdPaese() {
                    return idPaese;
                }

                /**
                 * Imposta il valore della propriet� idPaese.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setIdPaese(String value) {
                    this.idPaese = value;
                }

                /**
                 * Recupera il valore della propriet� idCodice.
                 * 
                 */
                public long getIdCodice() {
                    return idCodice;
                }

                /**
                 * Imposta il valore della propriet� idCodice.
                 * 
                 */
                public void setIdCodice(long value) {
                    this.idCodice = value;
                }

            }

        }


        /**
         * <p>Classe Java per anonymous complex type.
         * 
         * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="Indirizzo" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="CAP" type="{http://www.w3.org/2001/XMLSchema}short"/>
         *         &lt;element name="Comune" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="Provincia" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="Nazione" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "indirizzo",
            "cap",
            "comune",
            "provincia",
            "nazione"
        })
        public static class Sede {

            @XmlElement(name = "Indirizzo", required = true)
            protected String indirizzo;
            @XmlElement(name = "CAP")
            protected short cap;
            @XmlElement(name = "Comune", required = true)
            protected String comune;
            @XmlElement(name = "Provincia", required = true)
            protected String provincia;
            @XmlElement(name = "Nazione", required = true)
            protected String nazione;

            /**
             * Recupera il valore della propriet� indirizzo.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getIndirizzo() {
                return indirizzo;
            }

            /**
             * Imposta il valore della propriet� indirizzo.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setIndirizzo(String value) {
                this.indirizzo = value;
            }

            /**
             * Recupera il valore della propriet� cap.
             * 
             */
            public short getCAP() {
                return cap;
            }

            /**
             * Imposta il valore della propriet� cap.
             * 
             */
            public void setCAP(short value) {
                this.cap = value;
            }

            /**
             * Recupera il valore della propriet� comune.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getComune() {
                return comune;
            }

            /**
             * Imposta il valore della propriet� comune.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setComune(String value) {
                this.comune = value;
            }

            /**
             * Recupera il valore della propriet� provincia.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getProvincia() {
                return provincia;
            }

            /**
             * Imposta il valore della propriet� provincia.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setProvincia(String value) {
                this.provincia = value;
            }

            /**
             * Recupera il valore della propriet� nazione.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNazione() {
                return nazione;
            }

            /**
             * Imposta il valore della propriet� nazione.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNazione(String value) {
                this.nazione = value;
            }

        }

    }


    /**
     * <p>Classe Java per anonymous complex type.
     * 
     * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="DatiAnagrafici">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="IdFiscaleIVA">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="IdPaese" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="IdCodice" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="CodiceFiscale" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                   &lt;element name="Anagrafica">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="Denominazione" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Sede">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Indirizzo" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="CAP" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                   &lt;element name="Comune" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="Provincia" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="Nazione" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "datiAnagrafici",
        "sede"
    })
    public static class CessionarioCommittente {

        @XmlElement(name = "DatiAnagrafici", required = true)
        protected FatturaElettronicaHeader.CessionarioCommittente.DatiAnagrafici datiAnagrafici;
        @XmlElement(name = "Sede", required = true)
        protected FatturaElettronicaHeader.CessionarioCommittente.Sede sede;

        /**
         * Recupera il valore della propriet� datiAnagrafici.
         * 
         * @return
         *     possible object is
         *     {@link FatturaElettronicaHeader.CessionarioCommittente.DatiAnagrafici }
         *     
         */
        public FatturaElettronicaHeader.CessionarioCommittente.DatiAnagrafici getDatiAnagrafici() {
            return datiAnagrafici;
        }

        /**
         * Imposta il valore della propriet� datiAnagrafici.
         * 
         * @param value
         *     allowed object is
         *     {@link FatturaElettronicaHeader.CessionarioCommittente.DatiAnagrafici }
         *     
         */
        public void setDatiAnagrafici(FatturaElettronicaHeader.CessionarioCommittente.DatiAnagrafici value) {
            this.datiAnagrafici = value;
        }

        /**
         * Recupera il valore della propriet� sede.
         * 
         * @return
         *     possible object is
         *     {@link FatturaElettronicaHeader.CessionarioCommittente.Sede }
         *     
         */
        public FatturaElettronicaHeader.CessionarioCommittente.Sede getSede() {
            return sede;
        }

        /**
         * Imposta il valore della propriet� sede.
         * 
         * @param value
         *     allowed object is
         *     {@link FatturaElettronicaHeader.CessionarioCommittente.Sede }
         *     
         */
        public void setSede(FatturaElettronicaHeader.CessionarioCommittente.Sede value) {
            this.sede = value;
        }


        /**
         * <p>Classe Java per anonymous complex type.
         * 
         * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="IdFiscaleIVA">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="IdPaese" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="IdCodice" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="CodiceFiscale" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *         &lt;element name="Anagrafica">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="Denominazione" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "idFiscaleIVA",
            "codiceFiscale",
            "anagrafica"
        })
        public static class DatiAnagrafici {

            @XmlElement(name = "IdFiscaleIVA", required = true)
            protected FatturaElettronicaHeader.CessionarioCommittente.DatiAnagrafici.IdFiscaleIVA idFiscaleIVA;
            @XmlElement(name = "CodiceFiscale")
            protected int codiceFiscale;
            @XmlElement(name = "Anagrafica", required = true)
            protected FatturaElettronicaHeader.CessionarioCommittente.DatiAnagrafici.Anagrafica anagrafica;

            /**
             * Recupera il valore della propriet� idFiscaleIVA.
             * 
             * @return
             *     possible object is
             *     {@link FatturaElettronicaHeader.CessionarioCommittente.DatiAnagrafici.IdFiscaleIVA }
             *     
             */
            public FatturaElettronicaHeader.CessionarioCommittente.DatiAnagrafici.IdFiscaleIVA getIdFiscaleIVA() {
                return idFiscaleIVA;
            }

            /**
             * Imposta il valore della propriet� idFiscaleIVA.
             * 
             * @param value
             *     allowed object is
             *     {@link FatturaElettronicaHeader.CessionarioCommittente.DatiAnagrafici.IdFiscaleIVA }
             *     
             */
            public void setIdFiscaleIVA(FatturaElettronicaHeader.CessionarioCommittente.DatiAnagrafici.IdFiscaleIVA value) {
                this.idFiscaleIVA = value;
            }

            /**
             * Recupera il valore della propriet� codiceFiscale.
             * 
             */
            public int getCodiceFiscale() {
                return codiceFiscale;
            }

            /**
             * Imposta il valore della propriet� codiceFiscale.
             * 
             */
            public void setCodiceFiscale(int value) {
                this.codiceFiscale = value;
            }

            /**
             * Recupera il valore della propriet� anagrafica.
             * 
             * @return
             *     possible object is
             *     {@link FatturaElettronicaHeader.CessionarioCommittente.DatiAnagrafici.Anagrafica }
             *     
             */
            public FatturaElettronicaHeader.CessionarioCommittente.DatiAnagrafici.Anagrafica getAnagrafica() {
                return anagrafica;
            }

            /**
             * Imposta il valore della propriet� anagrafica.
             * 
             * @param value
             *     allowed object is
             *     {@link FatturaElettronicaHeader.CessionarioCommittente.DatiAnagrafici.Anagrafica }
             *     
             */
            public void setAnagrafica(FatturaElettronicaHeader.CessionarioCommittente.DatiAnagrafici.Anagrafica value) {
                this.anagrafica = value;
            }


            /**
             * <p>Classe Java per anonymous complex type.
             * 
             * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="Denominazione" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "denominazione"
            })
            public static class Anagrafica {

                @XmlElement(name = "Denominazione", required = true)
                protected String denominazione;

                /**
                 * Recupera il valore della propriet� denominazione.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getDenominazione() {
                    return denominazione;
                }

                /**
                 * Imposta il valore della propriet� denominazione.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setDenominazione(String value) {
                    this.denominazione = value;
                }

            }


            /**
             * <p>Classe Java per anonymous complex type.
             * 
             * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="IdPaese" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="IdCodice" type="{http://www.w3.org/2001/XMLSchema}int"/>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "idPaese",
                "idCodice"
            })
            public static class IdFiscaleIVA {

                @XmlElement(name = "IdPaese", required = true)
                protected String idPaese;
                @XmlElement(name = "IdCodice")
                protected int idCodice;

                /**
                 * Recupera il valore della propriet� idPaese.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getIdPaese() {
                    return idPaese;
                }

                /**
                 * Imposta il valore della propriet� idPaese.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setIdPaese(String value) {
                    this.idPaese = value;
                }

                /**
                 * Recupera il valore della propriet� idCodice.
                 * 
                 */
                public int getIdCodice() {
                    return idCodice;
                }

                /**
                 * Imposta il valore della propriet� idCodice.
                 * 
                 */
                public void setIdCodice(int value) {
                    this.idCodice = value;
                }

            }

        }


        /**
         * <p>Classe Java per anonymous complex type.
         * 
         * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="Indirizzo" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="CAP" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *         &lt;element name="Comune" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="Provincia" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="Nazione" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "indirizzo",
            "cap",
            "comune",
            "provincia",
            "nazione"
        })
        public static class Sede {

            @XmlElement(name = "Indirizzo", required = true)
            protected String indirizzo;
            @XmlElement(name = "CAP")
            protected int cap;
            @XmlElement(name = "Comune", required = true)
            protected String comune;
            @XmlElement(name = "Provincia", required = true)
            protected String provincia;
            @XmlElement(name = "Nazione", required = true)
            protected String nazione;

            /**
             * Recupera il valore della propriet� indirizzo.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getIndirizzo() {
                return indirizzo;
            }

            /**
             * Imposta il valore della propriet� indirizzo.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setIndirizzo(String value) {
                this.indirizzo = value;
            }

            /**
             * Recupera il valore della propriet� cap.
             * 
             */
            public int getCAP() {
                return cap;
            }

            /**
             * Imposta il valore della propriet� cap.
             * 
             */
            public void setCAP(int value) {
                this.cap = value;
            }

            /**
             * Recupera il valore della propriet� comune.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getComune() {
                return comune;
            }

            /**
             * Imposta il valore della propriet� comune.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setComune(String value) {
                this.comune = value;
            }

            /**
             * Recupera il valore della propriet� provincia.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getProvincia() {
                return provincia;
            }

            /**
             * Imposta il valore della propriet� provincia.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setProvincia(String value) {
                this.provincia = value;
            }

            /**
             * Recupera il valore della propriet� nazione.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNazione() {
                return nazione;
            }

            /**
             * Imposta il valore della propriet� nazione.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNazione(String value) {
                this.nazione = value;
            }

        }

    }


    /**
     * <p>Classe Java per anonymous complex type.
     * 
     * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="IdTrasmittente">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="IdPaese" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="IdCodice" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="ProgressivoInvio" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="FormatoTrasmissione" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="CodiceDestinatario" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="ContattiTrasmittente">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Telefono" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "idTrasmittente",
        "progressivoInvio",
        "formatoTrasmissione",
        "codiceDestinatario",
        "contattiTrasmittente"
    })
    public static class DatiTrasmissione {

        @XmlElement(name = "IdTrasmittente", required = true)
        protected FatturaElettronicaHeader.DatiTrasmissione.IdTrasmittente idTrasmittente;
        @XmlElement(name = "ProgressivoInvio", required = true)
        protected String progressivoInvio;
        @XmlElement(name = "FormatoTrasmissione", required = true)
        protected String formatoTrasmissione;
        @XmlElement(name = "CodiceDestinatario", required = true)
        protected String codiceDestinatario;
        @XmlElement(name = "ContattiTrasmittente", required = true)
        protected FatturaElettronicaHeader.DatiTrasmissione.ContattiTrasmittente contattiTrasmittente;

        /**
         * Recupera il valore della propriet� idTrasmittente.
         * 
         * @return
         *     possible object is
         *     {@link FatturaElettronicaHeader.DatiTrasmissione.IdTrasmittente }
         *     
         */
        public FatturaElettronicaHeader.DatiTrasmissione.IdTrasmittente getIdTrasmittente() {
            return idTrasmittente;
        }

        /**
         * Imposta il valore della propriet� idTrasmittente.
         * 
         * @param value
         *     allowed object is
         *     {@link FatturaElettronicaHeader.DatiTrasmissione.IdTrasmittente }
         *     
         */
        public void setIdTrasmittente(FatturaElettronicaHeader.DatiTrasmissione.IdTrasmittente value) {
            this.idTrasmittente = value;
        }

        /**
         * Recupera il valore della propriet� progressivoInvio.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getProgressivoInvio() {
            return progressivoInvio;
        }

        /**
         * Imposta il valore della propriet� progressivoInvio.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setProgressivoInvio(String value) {
            this.progressivoInvio = value;
        }

        /**
         * Recupera il valore della propriet� formatoTrasmissione.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFormatoTrasmissione() {
            return formatoTrasmissione;
        }

        /**
         * Imposta il valore della propriet� formatoTrasmissione.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFormatoTrasmissione(String value) {
            this.formatoTrasmissione = value;
        }

        /**
         * Recupera il valore della propriet� codiceDestinatario.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCodiceDestinatario() {
            return codiceDestinatario;
        }

        /**
         * Imposta il valore della propriet� codiceDestinatario.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCodiceDestinatario(String value) {
            this.codiceDestinatario = value;
        }

        /**
         * Recupera il valore della propriet� contattiTrasmittente.
         * 
         * @return
         *     possible object is
         *     {@link FatturaElettronicaHeader.DatiTrasmissione.ContattiTrasmittente }
         *     
         */
        public FatturaElettronicaHeader.DatiTrasmissione.ContattiTrasmittente getContattiTrasmittente() {
            return contattiTrasmittente;
        }

        /**
         * Imposta il valore della propriet� contattiTrasmittente.
         * 
         * @param value
         *     allowed object is
         *     {@link FatturaElettronicaHeader.DatiTrasmissione.ContattiTrasmittente }
         *     
         */
        public void setContattiTrasmittente(FatturaElettronicaHeader.DatiTrasmissione.ContattiTrasmittente value) {
            this.contattiTrasmittente = value;
        }


        /**
         * <p>Classe Java per anonymous complex type.
         * 
         * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="Telefono" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "telefono"
        })
        public static class ContattiTrasmittente {

            @XmlElement(name = "Telefono", required = true)
            protected String telefono;

            /**
             * Recupera il valore della propriet� telefono.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTelefono() {
                return telefono;
            }

            /**
             * Imposta il valore della propriet� telefono.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTelefono(String value) {
                this.telefono = value;
            }

        }


        /**
         * <p>Classe Java per anonymous complex type.
         * 
         * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="IdPaese" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="IdCodice" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "idPaese",
            "idCodice"
        })
        public static class IdTrasmittente {

            @XmlElement(name = "IdPaese", required = true)
            protected String idPaese;
            @XmlElement(name = "IdCodice")
            protected int idCodice;

            /**
             * Recupera il valore della propriet� idPaese.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getIdPaese() {
                return idPaese;
            }

            /**
             * Imposta il valore della propriet� idPaese.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setIdPaese(String value) {
                this.idPaese = value;
            }

            /**
             * Recupera il valore della propriet� idCodice.
             * 
             */
            public int getIdCodice() {
                return idCodice;
            }

            /**
             * Imposta il valore della propriet� idCodice.
             * 
             */
            public void setIdCodice(int value) {
                this.idCodice = value;
            }

        }

    }


    /**
     * <p>Classe Java per anonymous complex type.
     * 
     * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="DatiAnagrafici">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="IdFiscaleIVA">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="IdPaese" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="IdCodice" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="CodiceFiscale" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                   &lt;element name="Anagrafica">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="Denominazione" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "datiAnagrafici"
    })
    public static class TerzoIntermediarioOSoggettoEmittente {

        @XmlElement(name = "DatiAnagrafici", required = true)
        protected FatturaElettronicaHeader.TerzoIntermediarioOSoggettoEmittente.DatiAnagrafici datiAnagrafici;

        /**
         * Recupera il valore della propriet� datiAnagrafici.
         * 
         * @return
         *     possible object is
         *     {@link FatturaElettronicaHeader.TerzoIntermediarioOSoggettoEmittente.DatiAnagrafici }
         *     
         */
        public FatturaElettronicaHeader.TerzoIntermediarioOSoggettoEmittente.DatiAnagrafici getDatiAnagrafici() {
            return datiAnagrafici;
        }

        /**
         * Imposta il valore della propriet� datiAnagrafici.
         * 
         * @param value
         *     allowed object is
         *     {@link FatturaElettronicaHeader.TerzoIntermediarioOSoggettoEmittente.DatiAnagrafici }
         *     
         */
        public void setDatiAnagrafici(FatturaElettronicaHeader.TerzoIntermediarioOSoggettoEmittente.DatiAnagrafici value) {
            this.datiAnagrafici = value;
        }


        /**
         * <p>Classe Java per anonymous complex type.
         * 
         * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="IdFiscaleIVA">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="IdPaese" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="IdCodice" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="CodiceFiscale" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *         &lt;element name="Anagrafica">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="Denominazione" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "idFiscaleIVA",
            "codiceFiscale",
            "anagrafica"
        })
        public static class DatiAnagrafici {

            @XmlElement(name = "IdFiscaleIVA", required = true)
            protected FatturaElettronicaHeader.TerzoIntermediarioOSoggettoEmittente.DatiAnagrafici.IdFiscaleIVA idFiscaleIVA;
            @XmlElement(name = "CodiceFiscale")
            protected int codiceFiscale;
            @XmlElement(name = "Anagrafica", required = true)
            protected FatturaElettronicaHeader.TerzoIntermediarioOSoggettoEmittente.DatiAnagrafici.Anagrafica anagrafica;

            /**
             * Recupera il valore della propriet� idFiscaleIVA.
             * 
             * @return
             *     possible object is
             *     {@link FatturaElettronicaHeader.TerzoIntermediarioOSoggettoEmittente.DatiAnagrafici.IdFiscaleIVA }
             *     
             */
            public FatturaElettronicaHeader.TerzoIntermediarioOSoggettoEmittente.DatiAnagrafici.IdFiscaleIVA getIdFiscaleIVA() {
                return idFiscaleIVA;
            }

            /**
             * Imposta il valore della propriet� idFiscaleIVA.
             * 
             * @param value
             *     allowed object is
             *     {@link FatturaElettronicaHeader.TerzoIntermediarioOSoggettoEmittente.DatiAnagrafici.IdFiscaleIVA }
             *     
             */
            public void setIdFiscaleIVA(FatturaElettronicaHeader.TerzoIntermediarioOSoggettoEmittente.DatiAnagrafici.IdFiscaleIVA value) {
                this.idFiscaleIVA = value;
            }

            /**
             * Recupera il valore della propriet� codiceFiscale.
             * 
             */
            public int getCodiceFiscale() {
                return codiceFiscale;
            }

            /**
             * Imposta il valore della propriet� codiceFiscale.
             * 
             */
            public void setCodiceFiscale(int value) {
                this.codiceFiscale = value;
            }

            /**
             * Recupera il valore della propriet� anagrafica.
             * 
             * @return
             *     possible object is
             *     {@link FatturaElettronicaHeader.TerzoIntermediarioOSoggettoEmittente.DatiAnagrafici.Anagrafica }
             *     
             */
            public FatturaElettronicaHeader.TerzoIntermediarioOSoggettoEmittente.DatiAnagrafici.Anagrafica getAnagrafica() {
                return anagrafica;
            }

            /**
             * Imposta il valore della propriet� anagrafica.
             * 
             * @param value
             *     allowed object is
             *     {@link FatturaElettronicaHeader.TerzoIntermediarioOSoggettoEmittente.DatiAnagrafici.Anagrafica }
             *     
             */
            public void setAnagrafica(FatturaElettronicaHeader.TerzoIntermediarioOSoggettoEmittente.DatiAnagrafici.Anagrafica value) {
                this.anagrafica = value;
            }


            /**
             * <p>Classe Java per anonymous complex type.
             * 
             * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="Denominazione" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "denominazione"
            })
            public static class Anagrafica {

                @XmlElement(name = "Denominazione", required = true)
                protected String denominazione;

                /**
                 * Recupera il valore della propriet� denominazione.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getDenominazione() {
                    return denominazione;
                }

                /**
                 * Imposta il valore della propriet� denominazione.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setDenominazione(String value) {
                    this.denominazione = value;
                }

            }


            /**
             * <p>Classe Java per anonymous complex type.
             * 
             * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="IdPaese" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="IdCodice" type="{http://www.w3.org/2001/XMLSchema}int"/>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "idPaese",
                "idCodice"
            })
            public static class IdFiscaleIVA {

                @XmlElement(name = "IdPaese", required = true)
                protected String idPaese;
                @XmlElement(name = "IdCodice")
                protected int idCodice;

                /**
                 * Recupera il valore della propriet� idPaese.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getIdPaese() {
                    return idPaese;
                }

                /**
                 * Imposta il valore della propriet� idPaese.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setIdPaese(String value) {
                    this.idPaese = value;
                }

                /**
                 * Recupera il valore della propriet� idCodice.
                 * 
                 */
                public int getIdCodice() {
                    return idCodice;
                }

                /**
                 * Imposta il valore della propriet� idCodice.
                 * 
                 */
                public void setIdCodice(int value) {
                    this.idCodice = value;
                }

            }

        }

    }

}
