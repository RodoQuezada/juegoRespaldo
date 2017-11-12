/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bean;

import cl.pojos.Pregunta;
import cl.services.PreguntaFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author rodo
 */
@Named(value = "preguntaBean")
@SessionScoped
public class PreguntaBean implements Serializable {

    @EJB
    private PreguntaFacadeLocal preguntaFacade;

    private int id;
    private String preguntaCuestionario;
    private String alternativauno;
    private String alternativados;
    private String alternativatres;
    private String alternativacuatro;
    private String respuesta;
    private Pregunta preEdit;

    // cambios rodolfo 
    private ArrayList<Pregunta> ramdon = new ArrayList<>();
    private String respuestaJugador;
    
    
    
    
    
    public PreguntaBean() {
        preEdit = new Pregunta();
    //     ramdon.add(preguntaFacade.find(1));
    }

   
    
    public void crearPregunta() {
        System.out.println("entra funcion crear");
        Pregunta pre = new Pregunta();
        pre.setPreguntaCuestionario(preguntaCuestionario);
        pre.setAlternativauno(alternativauno);
        pre.setAlternativados(alternativados);
        pre.setAlternativatres(alternativatres);
        pre.setAlternativacuatro(alternativacuatro);
        // pre.setRespuesta(respuesta);
        switch (respuesta) {
            case "A":
                pre.setRespuesta(alternativauno);
                break;
            case "B":
                pre.setRespuesta(alternativados);
                break;
            case "C":
                pre.setRespuesta(alternativatres);
                break;
            case "D":
                pre.setRespuesta(alternativacuatro);
                break;
            default:
                break;
        }
        preguntaFacade.create(pre);
        System.out.println("pregunta ingresada");
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("CREADO!"));
    }

    public void eliminarPregunta(Pregunta pregunta) {
        preguntaFacade.remove(pregunta);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ELIMINADO!"));
    }

    public String actualizarPregunta() {
        System.out.println("Entra a pregunta");     
        System.out.println("numero -->"+preEdit.getId());        
        Pregunta pre = preguntaFacade.find(preEdit.getId());
        System.out.println("pre "+pre.toString());
        System.out.println(" ");
        System.out.println("preEdit"+ preEdit.toString());
        pre.setPreguntaCuestionario(preEdit.getPreguntaCuestionario());
        pre.setAlternativauno(preEdit.getAlternativauno());
        pre.setAlternativados(preEdit.getAlternativados());
        pre.setAlternativatres(preEdit.getAlternativatres());
        pre.setAlternativacuatro(preEdit.getAlternativacuatro());
        String auxResp = "";
        switch (preEdit.getRespuesta()) {
            case "A":
                auxResp = preEdit.getAlternativauno();
                break;
            case "B":
              auxResp = preEdit.getAlternativados();
                break;
            case "C":
               auxResp = preEdit.getAlternativatres();
                break;
            case "D":
               auxResp = preEdit.getAlternativacuatro();
                break;
            default:
                break;
        }
        pre.setRespuesta(auxResp);
        System.out.println("casi guarda");
        preguntaFacade.edit(pre);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ACTUALIZADO!"));
        return "preguntaMantenedor";
    }
    
    public List<Pregunta> getPreguntas() {
        return preguntaFacade.findAll();
    }
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPreguntaCuestionario() {
        return preguntaCuestionario;
    }

    public void setPreguntaCuestionario(String preguntaCuestionario) {
        this.preguntaCuestionario = preguntaCuestionario;
    }

    public String getAlternativauno() {
        return alternativauno;
    }

    public void setAlternativauno(String alternativauno) {
        this.alternativauno = alternativauno;
    }

    public String getAlternativados() {
        return alternativados;
    }

    public void setAlternativados(String alternativados) {
        this.alternativados = alternativados;
    }

    public String getAlternativatres() {
        return alternativatres;
    }

    public void setAlternativatres(String alternativatres) {
        this.alternativatres = alternativatres;
    }

    public String getAlternativacuatro() {
        return alternativacuatro;
    }

    public void setAlternativacuatro(String alternativacuatro) {
        this.alternativacuatro = alternativacuatro;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public Pregunta getPreEdit() {
        return preEdit;
    }

    public void setPreEdit(Pregunta preEdit) {
        this.preEdit = preEdit;
    }

    public ArrayList<Pregunta> getRamdon() {
        return ramdon;
    }

    public void setRamdon(ArrayList<Pregunta> ramdon) {
        this.ramdon = ramdon;
    }

    public String getRespuestaJugador() {
        return respuestaJugador;
    }

    public void setRespuestaJugador(String respuestaJugador) {
        this.respuestaJugador = respuestaJugador;
    }

    
    
    
}
