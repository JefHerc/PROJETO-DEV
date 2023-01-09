
package br.com.treino.servico;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de exame complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="exame"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codAgendamento" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="dataExame" type="{http://soap.treino.com.br/}localDate" minOccurs="0"/&gt;
 *         &lt;element name="exame" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="observacaoResultado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="paciente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exame", propOrder = {
    "codAgendamento",
    "dataExame",
    "exame",
    "observacaoResultado",
    "paciente"
})
public class Exame {

    protected Integer codAgendamento;
    protected LocalDate dataExame;
    protected String exame;
    protected String observacaoResultado;
    protected String paciente;

    /**
     * Obtém o valor da propriedade codAgendamento.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodAgendamento() {
        return codAgendamento;
    }

    /**
     * Define o valor da propriedade codAgendamento.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodAgendamento(Integer value) {
        this.codAgendamento = value;
    }

    /**
     * Obtém o valor da propriedade dataExame.
     * 
     * @return
     *     possible object is
     *     {@link LocalDate }
     *     
     */
    public LocalDate getDataExame() {
        return dataExame;
    }

    /**
     * Define o valor da propriedade dataExame.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalDate }
     *     
     */
    public void setDataExame(LocalDate value) {
        this.dataExame = value;
    }

    /**
     * Obtém o valor da propriedade exame.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExame() {
        return exame;
    }

    /**
     * Define o valor da propriedade exame.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExame(String value) {
        this.exame = value;
    }

    /**
     * Obtém o valor da propriedade observacaoResultado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObservacaoResultado() {
        return observacaoResultado;
    }

    /**
     * Define o valor da propriedade observacaoResultado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObservacaoResultado(String value) {
        this.observacaoResultado = value;
    }

    /**
     * Obtém o valor da propriedade paciente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaciente() {
        return paciente;
    }

    /**
     * Define o valor da propriedade paciente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaciente(String value) {
        this.paciente = value;
    }

}
