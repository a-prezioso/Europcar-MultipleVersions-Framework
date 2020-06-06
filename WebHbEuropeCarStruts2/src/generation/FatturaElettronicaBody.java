//
// Questo file � stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andr� persa durante la ricompilazione dello schema di origine. 
// Generato il: 2019.10.17 alle 12:02:28 PM CEST 
//

package generation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Classe Java per anonymous complex type.
 * 
 * <p>
 * Il seguente frammento di schema specifica il contenuto previsto contenuto in
 * questa classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DatiGenerali">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="DatiGeneraliDocumento">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="TipoDocumento" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="Divisa" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="Data" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                             &lt;element name="Numero" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *                             &lt;element name="ImportoTotaleDocumento" type="{http://www.w3.org/2001/XMLSchema}float"/>
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
 *         &lt;element name="DatiBeniServizi">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="DettaglioLinee">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="NumeroLinea" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *                             &lt;element name="Descrizione" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="Quantita" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *                             &lt;element name="PrezzoUnitario" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *                             &lt;element name="PrezzoTotale" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *                             &lt;element name="AliquotaIVA" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="DatiRiepilogo">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="AliquotaIVA" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *                             &lt;element name="ImponibileImporto" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *                             &lt;element name="Imposta" type="{http://www.w3.org/2001/XMLSchema}float"/>
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
 *         &lt;element name="DatiPagamento">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="CondizioniPagamento" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="DettaglioPagamento">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="ModalitaPagamento" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="DataScadenzaPagamento" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                             &lt;element name="ImportoPagamento" type="{http://www.w3.org/2001/XMLSchema}float"/>
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
@XmlType(name = "", propOrder = { "datiGenerali", "datiBeniServizi", "datiPagamento" })
@XmlRootElement(name = "FatturaElettronicaBody")
public class FatturaElettronicaBody {

	@XmlElement(name = "DatiGenerali", required = true)
	protected FatturaElettronicaBody.DatiGenerali datiGenerali;
	@XmlElement(name = "DatiBeniServizi", required = true)
	protected FatturaElettronicaBody.DatiBeniServizi datiBeniServizi;
	@XmlElement(name = "DatiPagamento", required = true)
	protected FatturaElettronicaBody.DatiPagamento datiPagamento;

	/**
	 * Recupera il valore della propriet� datiGenerali.
	 * 
	 * @return possible object is {@link FatturaElettronicaBody.DatiGenerali }
	 * 
	 */
	public FatturaElettronicaBody.DatiGenerali getDatiGenerali() {
		return datiGenerali;
	}

	/**
	 * Imposta il valore della propriet� datiGenerali.
	 * 
	 * @param value allowed object is {@link FatturaElettronicaBody.DatiGenerali }
	 * 
	 */
	public void setDatiGenerali(FatturaElettronicaBody.DatiGenerali value) {
		this.datiGenerali = value;
	}

	/**
	 * Recupera il valore della propriet� datiBeniServizi.
	 * 
	 * @return possible object is {@link FatturaElettronicaBody.DatiBeniServizi }
	 * 
	 */
	public FatturaElettronicaBody.DatiBeniServizi getDatiBeniServizi() {
		return datiBeniServizi;
	}

	/**
	 * Imposta il valore della propriet� datiBeniServizi.
	 * 
	 * @param value allowed object is
	 *              {@link FatturaElettronicaBody.DatiBeniServizi }
	 * 
	 */
	public void setDatiBeniServizi(FatturaElettronicaBody.DatiBeniServizi value) {
		this.datiBeniServizi = value;
	}

	/**
	 * Recupera il valore della propriet� datiPagamento.
	 * 
	 * @return possible object is {@link FatturaElettronicaBody.DatiPagamento }
	 * 
	 */
	public FatturaElettronicaBody.DatiPagamento getDatiPagamento() {
		return datiPagamento;
	}

	/**
	 * Imposta il valore della propriet� datiPagamento.
	 * 
	 * @param value allowed object is {@link FatturaElettronicaBody.DatiPagamento }
	 * 
	 */
	public void setDatiPagamento(FatturaElettronicaBody.DatiPagamento value) {
		this.datiPagamento = value;
	}

	/**
	 * <p>
	 * Classe Java per anonymous complex type.
	 * 
	 * <p>
	 * Il seguente frammento di schema specifica il contenuto previsto contenuto in
	 * questa classe.
	 * 
	 * <pre>
	 * &lt;complexType>
	 *   &lt;complexContent>
	 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *       &lt;sequence>
	 *         &lt;element name="DettaglioLinee">
	 *           &lt;complexType>
	 *             &lt;complexContent>
	 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *                 &lt;sequence>
	 *                   &lt;element name="NumeroLinea" type="{http://www.w3.org/2001/XMLSchema}byte"/>
	 *                   &lt;element name="Descrizione" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *                   &lt;element name="Quantita" type="{http://www.w3.org/2001/XMLSchema}float"/>
	 *                   &lt;element name="PrezzoUnitario" type="{http://www.w3.org/2001/XMLSchema}float"/>
	 *                   &lt;element name="PrezzoTotale" type="{http://www.w3.org/2001/XMLSchema}float"/>
	 *                   &lt;element name="AliquotaIVA" type="{http://www.w3.org/2001/XMLSchema}float"/>
	 *                 &lt;/sequence>
	 *               &lt;/restriction>
	 *             &lt;/complexContent>
	 *           &lt;/complexType>
	 *         &lt;/element>
	 *         &lt;element name="DatiRiepilogo">
	 *           &lt;complexType>
	 *             &lt;complexContent>
	 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *                 &lt;sequence>
	 *                   &lt;element name="AliquotaIVA" type="{http://www.w3.org/2001/XMLSchema}float"/>
	 *                   &lt;element name="ImponibileImporto" type="{http://www.w3.org/2001/XMLSchema}float"/>
	 *                   &lt;element name="Imposta" type="{http://www.w3.org/2001/XMLSchema}float"/>
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
	@XmlType(name = "", propOrder = { "dettaglioLinee", "datiRiepilogo" })
	public static class DatiBeniServizi {

		@XmlElement(name = "DettaglioLinee", required = true)
		protected FatturaElettronicaBody.DatiBeniServizi.DettaglioLinee dettaglioLinee;
		@XmlElement(name = "DatiRiepilogo", required = true)
		protected FatturaElettronicaBody.DatiBeniServizi.DatiRiepilogo datiRiepilogo;

		/**
		 * Recupera il valore della propriet� dettaglioLinee.
		 * 
		 * @return possible object is
		 *         {@link FatturaElettronicaBody.DatiBeniServizi.DettaglioLinee }
		 * 
		 */
		public FatturaElettronicaBody.DatiBeniServizi.DettaglioLinee getDettaglioLinee() {
			return dettaglioLinee;
		}

		/**
		 * Imposta il valore della propriet� dettaglioLinee.
		 * 
		 * @param value allowed object is
		 *              {@link FatturaElettronicaBody.DatiBeniServizi.DettaglioLinee }
		 * 
		 */
		public void setDettaglioLinee(FatturaElettronicaBody.DatiBeniServizi.DettaglioLinee value) {
			this.dettaglioLinee = value;
		}

		/**
		 * Recupera il valore della propriet� datiRiepilogo.
		 * 
		 * @return possible object is
		 *         {@link FatturaElettronicaBody.DatiBeniServizi.DatiRiepilogo }
		 * 
		 */
		public FatturaElettronicaBody.DatiBeniServizi.DatiRiepilogo getDatiRiepilogo() {
			return datiRiepilogo;
		}

		/**
		 * Imposta il valore della propriet� datiRiepilogo.
		 * 
		 * @param value allowed object is
		 *              {@link FatturaElettronicaBody.DatiBeniServizi.DatiRiepilogo }
		 * 
		 */
		public void setDatiRiepilogo(FatturaElettronicaBody.DatiBeniServizi.DatiRiepilogo value) {
			this.datiRiepilogo = value;
		}

		/**
		 * <p>
		 * Classe Java per anonymous complex type.
		 * 
		 * <p>
		 * Il seguente frammento di schema specifica il contenuto previsto contenuto in
		 * questa classe.
		 * 
		 * <pre>
		 * &lt;complexType>
		 *   &lt;complexContent>
		 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
		 *       &lt;sequence>
		 *         &lt;element name="AliquotaIVA" type="{http://www.w3.org/2001/XMLSchema}float"/>
		 *         &lt;element name="ImponibileImporto" type="{http://www.w3.org/2001/XMLSchema}float"/>
		 *         &lt;element name="Imposta" type="{http://www.w3.org/2001/XMLSchema}float"/>
		 *       &lt;/sequence>
		 *     &lt;/restriction>
		 *   &lt;/complexContent>
		 * &lt;/complexType>
		 * </pre>
		 * 
		 * 
		 */
		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "", propOrder = { "aliquotaIVA", "imponibileImporto", "imposta" })
		public static class DatiRiepilogo {

			@XmlElement(name = "AliquotaIVA")
			protected float aliquotaIVA;
			@XmlElement(name = "ImponibileImporto")
			protected float imponibileImporto;
			@XmlElement(name = "Imposta")
			protected float imposta;

			/**
			 * Recupera il valore della propriet� aliquotaIVA.
			 * 
			 */
			public float getAliquotaIVA() {
				return aliquotaIVA;
			}

			/**
			 * Imposta il valore della propriet� aliquotaIVA.
			 * 
			 */
			public void setAliquotaIVA(float value) {
				this.aliquotaIVA = value;
			}

			/**
			 * Recupera il valore della propriet� imponibileImporto.
			 * 
			 */
			public float getImponibileImporto() {
				return imponibileImporto;
			}

			/**
			 * Imposta il valore della propriet� imponibileImporto.
			 * 
			 */
			public void setImponibileImporto(float value) {
				this.imponibileImporto = value;
			}

			/**
			 * Recupera il valore della propriet� imposta.
			 * 
			 */
			public float getImposta() {
				return imposta;
			}

			/**
			 * Imposta il valore della propriet� imposta.
			 * 
			 */
			public void setImposta(float value) {
				this.imposta = value;
			}

		}

		/**
		 * <p>
		 * Classe Java per anonymous complex type.
		 * 
		 * <p>
		 * Il seguente frammento di schema specifica il contenuto previsto contenuto in
		 * questa classe.
		 * 
		 * <pre>
		 * &lt;complexType>
		 *   &lt;complexContent>
		 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
		 *       &lt;sequence>
		 *         &lt;element name="NumeroLinea" type="{http://www.w3.org/2001/XMLSchema}byte"/>
		 *         &lt;element name="Descrizione" type="{http://www.w3.org/2001/XMLSchema}string"/>
		 *         &lt;element name="Quantita" type="{http://www.w3.org/2001/XMLSchema}float"/>
		 *         &lt;element name="PrezzoUnitario" type="{http://www.w3.org/2001/XMLSchema}float"/>
		 *         &lt;element name="PrezzoTotale" type="{http://www.w3.org/2001/XMLSchema}float"/>
		 *         &lt;element name="AliquotaIVA" type="{http://www.w3.org/2001/XMLSchema}float"/>
		 *       &lt;/sequence>
		 *     &lt;/restriction>
		 *   &lt;/complexContent>
		 * &lt;/complexType>
		 * </pre>
		 * 
		 * 
		 */
		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "", propOrder = { "numeroLinea", "descrizione", "quantita", "prezzoUnitario", "prezzoTotale",
				"aliquotaIVA" })
		public static class DettaglioLinee {

			@XmlElement(name = "NumeroLinea")
			protected byte numeroLinea;
			@XmlElement(name = "Descrizione", required = true)
			protected String descrizione;
			@XmlElement(name = "Quantita")
			protected float quantita;
			@XmlElement(name = "PrezzoUnitario")
			protected float prezzoUnitario;
			@XmlElement(name = "PrezzoTotale")
			protected float prezzoTotale;
			@XmlElement(name = "AliquotaIVA")
			protected float aliquotaIVA;

			/**
			 * Recupera il valore della propriet� numeroLinea.
			 * 
			 */
			public byte getNumeroLinea() {
				return numeroLinea;
			}

			/**
			 * Imposta il valore della propriet� numeroLinea.
			 * 
			 */
			public void setNumeroLinea(byte value) {
				this.numeroLinea = value;
			}

			/**
			 * Recupera il valore della propriet� descrizione.
			 * 
			 * @return possible object is {@link String }
			 * 
			 */
			public String getDescrizione() {
				return descrizione;
			}

			/**
			 * Imposta il valore della propriet� descrizione.
			 * 
			 * @param value allowed object is {@link String }
			 * 
			 */
			public void setDescrizione(String value) {
				this.descrizione = value;
			}

			/**
			 * Recupera il valore della propriet� quantita.
			 * 
			 */
			public float getQuantita() {
				return quantita;
			}

			/**
			 * Imposta il valore della propriet� quantita.
			 * 
			 */
			public void setQuantita(float value) {
				this.quantita = value;
			}

			/**
			 * Recupera il valore della propriet� prezzoUnitario.
			 * 
			 */
			public float getPrezzoUnitario() {
				return prezzoUnitario;
			}

			/**
			 * Imposta il valore della propriet� prezzoUnitario.
			 * 
			 */
			public void setPrezzoUnitario(float value) {
				this.prezzoUnitario = value;
			}

			/**
			 * Recupera il valore della propriet� prezzoTotale.
			 * 
			 */
			public float getPrezzoTotale() {
				return prezzoTotale;
			}

			/**
			 * Imposta il valore della propriet� prezzoTotale.
			 * 
			 */
			public void setPrezzoTotale(float value) {
				this.prezzoTotale = value;
			}

			/**
			 * Recupera il valore della propriet� aliquotaIVA.
			 * 
			 */
			public float getAliquotaIVA() {
				return aliquotaIVA;
			}

			/**
			 * Imposta il valore della propriet� aliquotaIVA.
			 * 
			 */
			public void setAliquotaIVA(float value) {
				this.aliquotaIVA = value;
			}

		}

	}

	/**
	 * <p>
	 * Classe Java per anonymous complex type.
	 * 
	 * <p>
	 * Il seguente frammento di schema specifica il contenuto previsto contenuto in
	 * questa classe.
	 * 
	 * <pre>
	 * &lt;complexType>
	 *   &lt;complexContent>
	 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *       &lt;sequence>
	 *         &lt;element name="DatiGeneraliDocumento">
	 *           &lt;complexType>
	 *             &lt;complexContent>
	 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *                 &lt;sequence>
	 *                   &lt;element name="TipoDocumento" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *                   &lt;element name="Divisa" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *                   &lt;element name="Data" type="{http://www.w3.org/2001/XMLSchema}date"/>
	 *                   &lt;element name="Numero" type="{http://www.w3.org/2001/XMLSchema}byte"/>
	 *                   &lt;element name="ImportoTotaleDocumento" type="{http://www.w3.org/2001/XMLSchema}float"/>
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
	@XmlType(name = "", propOrder = { "datiGeneraliDocumento" })
	public static class DatiGenerali {

		@XmlElement(name = "DatiGeneraliDocumento", required = true)
		protected FatturaElettronicaBody.DatiGenerali.DatiGeneraliDocumento datiGeneraliDocumento;

		/**
		 * Recupera il valore della propriet� datiGeneraliDocumento.
		 * 
		 * @return possible object is
		 *         {@link FatturaElettronicaBody.DatiGenerali.DatiGeneraliDocumento }
		 * 
		 */
		public FatturaElettronicaBody.DatiGenerali.DatiGeneraliDocumento getDatiGeneraliDocumento() {
			return datiGeneraliDocumento;
		}

		/**
		 * Imposta il valore della propriet� datiGeneraliDocumento.
		 * 
		 * @param value allowed object is
		 *              {@link FatturaElettronicaBody.DatiGenerali.DatiGeneraliDocumento }
		 * 
		 */
		public void setDatiGeneraliDocumento(FatturaElettronicaBody.DatiGenerali.DatiGeneraliDocumento value) {
			this.datiGeneraliDocumento = value;
		}

		/**
		 * <p>
		 * Classe Java per anonymous complex type.
		 * 
		 * <p>
		 * Il seguente frammento di schema specifica il contenuto previsto contenuto in
		 * questa classe.
		 * 
		 * <pre>
		 * &lt;complexType>
		 *   &lt;complexContent>
		 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
		 *       &lt;sequence>
		 *         &lt;element name="TipoDocumento" type="{http://www.w3.org/2001/XMLSchema}string"/>
		 *         &lt;element name="Divisa" type="{http://www.w3.org/2001/XMLSchema}string"/>
		 *         &lt;element name="Data" type="{http://www.w3.org/2001/XMLSchema}date"/>
		 *         &lt;element name="Numero" type="{http://www.w3.org/2001/XMLSchema}byte"/>
		 *         &lt;element name="ImportoTotaleDocumento" type="{http://www.w3.org/2001/XMLSchema}float"/>
		 *       &lt;/sequence>
		 *     &lt;/restriction>
		 *   &lt;/complexContent>
		 * &lt;/complexType>
		 * </pre>
		 * 
		 * 
		 */
		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "", propOrder = { "tipoDocumento", "divisa", "data", "numero", "importoTotaleDocumento" })
		public static class DatiGeneraliDocumento {

			@XmlElement(name = "TipoDocumento", required = true)
			protected String tipoDocumento;
			@XmlElement(name = "Divisa", required = true)
			protected String divisa;
			@XmlElement(name = "Data", required = true)
			@XmlSchemaType(name = "date")
			protected XMLGregorianCalendar data;
			@XmlElement(name = "Numero")
			protected byte numero;
			@XmlElement(name = "ImportoTotaleDocumento")
			protected float importoTotaleDocumento;

			/**
			 * Recupera il valore della propriet� tipoDocumento.
			 * 
			 * @return possible object is {@link String }
			 * 
			 */
			public String getTipoDocumento() {
				return tipoDocumento;
			}

			/**
			 * Imposta il valore della propriet� tipoDocumento.
			 * 
			 * @param value allowed object is {@link String }
			 * 
			 */
			public void setTipoDocumento(String value) {
				this.tipoDocumento = value;
			}

			/**
			 * Recupera il valore della propriet� divisa.
			 * 
			 * @return possible object is {@link String }
			 * 
			 */
			public String getDivisa() {
				return divisa;
			}

			/**
			 * Imposta il valore della propriet� divisa.
			 * 
			 * @param value allowed object is {@link String }
			 * 
			 */
			public void setDivisa(String value) {
				this.divisa = value;
			}

			/**
			 * Recupera il valore della propriet� data.
			 * 
			 * @return possible object is {@link XMLGregorianCalendar }
			 * 
			 */
			public XMLGregorianCalendar getData() {
				return data;
			}

			/**
			 * Imposta il valore della propriet� data.
			 * 
			 * @param value allowed object is {@link XMLGregorianCalendar }
			 * 
			 */
			public void setData(XMLGregorianCalendar value) {
				this.data = value;
			}

			/**
			 * Recupera il valore della propriet� numero.
			 * 
			 */
			public byte getNumero() {
				return numero;
			}

			/**
			 * Imposta il valore della propriet� numero.
			 * 
			 */
			public void setNumero(byte value) {
				this.numero = value;
			}

			/**
			 * Recupera il valore della propriet� importoTotaleDocumento.
			 * 
			 */
			public float getImportoTotaleDocumento() {
				return importoTotaleDocumento;
			}

			/**
			 * Imposta il valore della propriet� importoTotaleDocumento.
			 * 
			 */
			public void setImportoTotaleDocumento(float value) {
				this.importoTotaleDocumento = value;
			}

		}

	}

	/**
	 * <p>
	 * Classe Java per anonymous complex type.
	 * 
	 * <p>
	 * Il seguente frammento di schema specifica il contenuto previsto contenuto in
	 * questa classe.
	 * 
	 * <pre>
	 * &lt;complexType>
	 *   &lt;complexContent>
	 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *       &lt;sequence>
	 *         &lt;element name="CondizioniPagamento" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *         &lt;element name="DettaglioPagamento">
	 *           &lt;complexType>
	 *             &lt;complexContent>
	 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *                 &lt;sequence>
	 *                   &lt;element name="ModalitaPagamento" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *                   &lt;element name="DataScadenzaPagamento" type="{http://www.w3.org/2001/XMLSchema}date"/>
	 *                   &lt;element name="ImportoPagamento" type="{http://www.w3.org/2001/XMLSchema}float"/>
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
	@XmlType(name = "", propOrder = { "condizioniPagamento", "dettaglioPagamento" })
	public static class DatiPagamento {

		@XmlElement(name = "CondizioniPagamento", required = true)
		protected String condizioniPagamento;
		@XmlElement(name = "DettaglioPagamento", required = true)
		protected FatturaElettronicaBody.DatiPagamento.DettaglioPagamento dettaglioPagamento;

		/**
		 * Recupera il valore della propriet� condizioniPagamento.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getCondizioniPagamento() {
			return condizioniPagamento;
		}

		/**
		 * Imposta il valore della propriet� condizioniPagamento.
		 * 
		 * @param value allowed object is {@link String }
		 * 
		 */
		public void setCondizioniPagamento(String value) {
			this.condizioniPagamento = value;
		}

		/**
		 * Recupera il valore della propriet� dettaglioPagamento.
		 * 
		 * @return possible object is
		 *         {@link FatturaElettronicaBody.DatiPagamento.DettaglioPagamento }
		 * 
		 */
		public FatturaElettronicaBody.DatiPagamento.DettaglioPagamento getDettaglioPagamento() {
			return dettaglioPagamento;
		}

		/**
		 * Imposta il valore della propriet� dettaglioPagamento.
		 * 
		 * @param value allowed object is
		 *              {@link FatturaElettronicaBody.DatiPagamento.DettaglioPagamento }
		 * 
		 */
		public void setDettaglioPagamento(FatturaElettronicaBody.DatiPagamento.DettaglioPagamento value) {
			this.dettaglioPagamento = value;
		}

		/**
		 * <p>
		 * Classe Java per anonymous complex type.
		 * 
		 * <p>
		 * Il seguente frammento di schema specifica il contenuto previsto contenuto in
		 * questa classe.
		 * 
		 * <pre>
		 * &lt;complexType>
		 *   &lt;complexContent>
		 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
		 *       &lt;sequence>
		 *         &lt;element name="ModalitaPagamento" type="{http://www.w3.org/2001/XMLSchema}string"/>
		 *         &lt;element name="DataScadenzaPagamento" type="{http://www.w3.org/2001/XMLSchema}date"/>
		 *         &lt;element name="ImportoPagamento" type="{http://www.w3.org/2001/XMLSchema}float"/>
		 *       &lt;/sequence>
		 *     &lt;/restriction>
		 *   &lt;/complexContent>
		 * &lt;/complexType>
		 * </pre>
		 * 
		 * 
		 */
		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "", propOrder = { "modalitaPagamento", "dataScadenzaPagamento", "importoPagamento" })
		public static class DettaglioPagamento {

			@XmlElement(name = "ModalitaPagamento", required = true)
			protected String modalitaPagamento;
			@XmlElement(name = "DataScadenzaPagamento", required = true)
			@XmlSchemaType(name = "date")
			protected XMLGregorianCalendar dataScadenzaPagamento;
			@XmlElement(name = "ImportoPagamento")
			protected float importoPagamento;

			/**
			 * Recupera il valore della propriet� modalitaPagamento.
			 * 
			 * @return possible object is {@link String }
			 * 
			 */
			public String getModalitaPagamento() {
				return modalitaPagamento;
			}

			/**
			 * Imposta il valore della propriet� modalitaPagamento.
			 * 
			 * @param value allowed object is {@link String }
			 * 
			 */
			public void setModalitaPagamento(String value) {
				this.modalitaPagamento = value;
			}

			/**
			 * Recupera il valore della propriet� dataScadenzaPagamento.
			 * 
			 * @return possible object is {@link XMLGregorianCalendar }
			 * 
			 */
			public XMLGregorianCalendar getDataScadenzaPagamento() {
				return dataScadenzaPagamento;
			}

			/**
			 * Imposta il valore della propriet� dataScadenzaPagamento.
			 * 
			 * @param value allowed object is {@link XMLGregorianCalendar }
			 * 
			 */
			public void setDataScadenzaPagamento(XMLGregorianCalendar value) {
				this.dataScadenzaPagamento = value;
			}

			/**
			 * Recupera il valore della propriet� importoPagamento.
			 * 
			 */
			public float getImportoPagamento() {
				return importoPagamento;
			}

			/**
			 * Imposta il valore della propriet� importoPagamento.
			 * 
			 */
			public void setImportoPagamento(float value) {
				this.importoPagamento = value;
			}

		}

	}

}
