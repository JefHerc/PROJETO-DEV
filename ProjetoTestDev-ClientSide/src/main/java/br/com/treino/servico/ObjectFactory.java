
package br.com.treino.servico;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.com.treino.servico package. 
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

    private final static QName _AlterarExame_QNAME = new QName("http://soap.treino.com.br/", "alterarExame");
    private final static QName _AlterarExameResponse_QNAME = new QName("http://soap.treino.com.br/", "alterarExameResponse");
    private final static QName _BuscarExames_QNAME = new QName("http://soap.treino.com.br/", "buscarExames");
    private final static QName _BuscarExamesResponse_QNAME = new QName("http://soap.treino.com.br/", "buscarExamesResponse");
    private final static QName _DeletarExame_QNAME = new QName("http://soap.treino.com.br/", "deletarExame");
    private final static QName _DeletarExameResponse_QNAME = new QName("http://soap.treino.com.br/", "deletarExameResponse");
    private final static QName _GetExames_QNAME = new QName("http://soap.treino.com.br/", "getExames");
    private final static QName _GetExamesResponse_QNAME = new QName("http://soap.treino.com.br/", "getExamesResponse");
    private final static QName _SetExame_QNAME = new QName("http://soap.treino.com.br/", "setExame");
    private final static QName _SetExameResponse_QNAME = new QName("http://soap.treino.com.br/", "setExameResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.com.treino.servico
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AlterarExame }
     * 
     */
    public AlterarExame createAlterarExame() {
        return new AlterarExame();
    }

    /**
     * Create an instance of {@link AlterarExameResponse }
     * 
     */
    public AlterarExameResponse createAlterarExameResponse() {
        return new AlterarExameResponse();
    }

    /**
     * Create an instance of {@link BuscarExames }
     * 
     */
    public BuscarExames createBuscarExames() {
        return new BuscarExames();
    }

    /**
     * Create an instance of {@link BuscarExamesResponse }
     * 
     */
    public BuscarExamesResponse createBuscarExamesResponse() {
        return new BuscarExamesResponse();
    }

    /**
     * Create an instance of {@link DeletarExame }
     * 
     */
    public DeletarExame createDeletarExame() {
        return new DeletarExame();
    }

    /**
     * Create an instance of {@link DeletarExameResponse }
     * 
     */
    public DeletarExameResponse createDeletarExameResponse() {
        return new DeletarExameResponse();
    }

    /**
     * Create an instance of {@link GetExames }
     * 
     */
    public GetExames createGetExames() {
        return new GetExames();
    }

    /**
     * Create an instance of {@link GetExamesResponse }
     * 
     */
    public GetExamesResponse createGetExamesResponse() {
        return new GetExamesResponse();
    }

    /**
     * Create an instance of {@link SetExame }
     * 
     */
    public SetExame createSetExame() {
        return new SetExame();
    }

    /**
     * Create an instance of {@link SetExameResponse }
     * 
     */
    public SetExameResponse createSetExameResponse() {
        return new SetExameResponse();
    }

    /**
     * Create an instance of {@link Exame }
     * 
     */
    public Exame createExame() {
        return new Exame();
    }

    /**
     * Create an instance of {@link LocalDate }
     * 
     */
    public LocalDate createLocalDate() {
        return new LocalDate();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AlterarExame }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AlterarExame }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.treino.com.br/", name = "alterarExame")
    public JAXBElement<AlterarExame> createAlterarExame(AlterarExame value) {
        return new JAXBElement<AlterarExame>(_AlterarExame_QNAME, AlterarExame.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AlterarExameResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AlterarExameResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.treino.com.br/", name = "alterarExameResponse")
    public JAXBElement<AlterarExameResponse> createAlterarExameResponse(AlterarExameResponse value) {
        return new JAXBElement<AlterarExameResponse>(_AlterarExameResponse_QNAME, AlterarExameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarExames }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BuscarExames }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.treino.com.br/", name = "buscarExames")
    public JAXBElement<BuscarExames> createBuscarExames(BuscarExames value) {
        return new JAXBElement<BuscarExames>(_BuscarExames_QNAME, BuscarExames.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarExamesResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BuscarExamesResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.treino.com.br/", name = "buscarExamesResponse")
    public JAXBElement<BuscarExamesResponse> createBuscarExamesResponse(BuscarExamesResponse value) {
        return new JAXBElement<BuscarExamesResponse>(_BuscarExamesResponse_QNAME, BuscarExamesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletarExame }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeletarExame }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.treino.com.br/", name = "deletarExame")
    public JAXBElement<DeletarExame> createDeletarExame(DeletarExame value) {
        return new JAXBElement<DeletarExame>(_DeletarExame_QNAME, DeletarExame.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletarExameResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeletarExameResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.treino.com.br/", name = "deletarExameResponse")
    public JAXBElement<DeletarExameResponse> createDeletarExameResponse(DeletarExameResponse value) {
        return new JAXBElement<DeletarExameResponse>(_DeletarExameResponse_QNAME, DeletarExameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetExames }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetExames }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.treino.com.br/", name = "getExames")
    public JAXBElement<GetExames> createGetExames(GetExames value) {
        return new JAXBElement<GetExames>(_GetExames_QNAME, GetExames.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetExamesResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetExamesResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.treino.com.br/", name = "getExamesResponse")
    public JAXBElement<GetExamesResponse> createGetExamesResponse(GetExamesResponse value) {
        return new JAXBElement<GetExamesResponse>(_GetExamesResponse_QNAME, GetExamesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetExame }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SetExame }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.treino.com.br/", name = "setExame")
    public JAXBElement<SetExame> createSetExame(SetExame value) {
        return new JAXBElement<SetExame>(_SetExame_QNAME, SetExame.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetExameResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SetExameResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.treino.com.br/", name = "setExameResponse")
    public JAXBElement<SetExameResponse> createSetExameResponse(SetExameResponse value) {
        return new JAXBElement<SetExameResponse>(_SetExameResponse_QNAME, SetExameResponse.class, null, value);
    }

}
