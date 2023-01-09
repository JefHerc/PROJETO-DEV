
package br.com.treino.servico;

import java.util.List;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.ws.Action;
import jakarta.xml.ws.RequestWrapper;
import jakarta.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 3.0.0
 * Generated source version: 3.0
 * 
 */
@WebService(name = "ExameService", targetNamespace = "http://soap.treino.com.br/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ExameService {


    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "alterarExame", targetNamespace = "http://soap.treino.com.br/", className = "br.com.treino.servico.AlterarExame")
    @ResponseWrapper(localName = "alterarExameResponse", targetNamespace = "http://soap.treino.com.br/", className = "br.com.treino.servico.AlterarExameResponse")
    @Action(input = "http://soap.treino.com.br/ExameService/alterarExameRequest", output = "http://soap.treino.com.br/ExameService/alterarExameResponse")
    public boolean alterarExame(
        @WebParam(name = "arg0", targetNamespace = "")
        Exame arg0);

    /**
     * 
     * @return
     *     returns java.util.List<br.com.treino.servico.Exame>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getExames", targetNamespace = "http://soap.treino.com.br/", className = "br.com.treino.servico.GetExames")
    @ResponseWrapper(localName = "getExamesResponse", targetNamespace = "http://soap.treino.com.br/", className = "br.com.treino.servico.GetExamesResponse")
    @Action(input = "http://soap.treino.com.br/ExameService/getExamesRequest", output = "http://soap.treino.com.br/ExameService/getExamesResponse")
    public List<Exame> getExames();

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "setExame", targetNamespace = "http://soap.treino.com.br/", className = "br.com.treino.servico.SetExame")
    @ResponseWrapper(localName = "setExameResponse", targetNamespace = "http://soap.treino.com.br/", className = "br.com.treino.servico.SetExameResponse")
    @Action(input = "http://soap.treino.com.br/ExameService/setExameRequest", output = "http://soap.treino.com.br/ExameService/setExameResponse")
    public boolean setExame(
        @WebParam(name = "arg0", targetNamespace = "")
        Exame arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<br.com.treino.servico.Exame>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "buscarExames", targetNamespace = "http://soap.treino.com.br/", className = "br.com.treino.servico.BuscarExames")
    @ResponseWrapper(localName = "buscarExamesResponse", targetNamespace = "http://soap.treino.com.br/", className = "br.com.treino.servico.BuscarExamesResponse")
    @Action(input = "http://soap.treino.com.br/ExameService/buscarExamesRequest", output = "http://soap.treino.com.br/ExameService/buscarExamesResponse")
    public List<Exame> buscarExames(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deletarExame", targetNamespace = "http://soap.treino.com.br/", className = "br.com.treino.servico.DeletarExame")
    @ResponseWrapper(localName = "deletarExameResponse", targetNamespace = "http://soap.treino.com.br/", className = "br.com.treino.servico.DeletarExameResponse")
    @Action(input = "http://soap.treino.com.br/ExameService/deletarExameRequest", output = "http://soap.treino.com.br/ExameService/deletarExameResponse")
    public boolean deletarExame(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

}
