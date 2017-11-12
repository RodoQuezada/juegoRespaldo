/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.pojos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rodo
 */
@Entity
@Table(name = "pregunta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pregunta.findAll", query = "SELECT p FROM Pregunta p"),
    @NamedQuery(name = "Pregunta.findById", query = "SELECT p FROM Pregunta p WHERE p.id = :id"),
    @NamedQuery(name = "Pregunta.findByPreguntaCuestionario", query = "SELECT p FROM Pregunta p WHERE p.preguntaCuestionario = :preguntaCuestionario"),
    @NamedQuery(name = "Pregunta.findByAlternativauno", query = "SELECT p FROM Pregunta p WHERE p.alternativauno = :alternativauno"),
    @NamedQuery(name = "Pregunta.findByAlternativados", query = "SELECT p FROM Pregunta p WHERE p.alternativados = :alternativados"),
    @NamedQuery(name = "Pregunta.findByAlternativatres", query = "SELECT p FROM Pregunta p WHERE p.alternativatres = :alternativatres"),
    @NamedQuery(name = "Pregunta.findByAlternativacuatro", query = "SELECT p FROM Pregunta p WHERE p.alternativacuatro = :alternativacuatro"),
    @NamedQuery(name = "Pregunta.findByRespuesta", query = "SELECT p FROM Pregunta p WHERE p.respuesta = :respuesta")})
public class Pregunta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "preguntaCuestionario")
    private String preguntaCuestionario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "alternativauno")
    private String alternativauno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "alternativados")
    private String alternativados;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "alternativatres")
    private String alternativatres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "alternativacuatro")
    private String alternativacuatro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "respuesta")
    private String respuesta;

    public Pregunta() {
    }

    public Pregunta(Integer id) {
        this.id = id;
    }

    public Pregunta(Integer id, String preguntaCuestionario, String alternativauno, String alternativados, String alternativatres, String alternativacuatro, String respuesta) {
        this.id = id;
        this.preguntaCuestionario = preguntaCuestionario;
        this.alternativauno = alternativauno;
        this.alternativados = alternativados;
        this.alternativatres = alternativatres;
        this.alternativacuatro = alternativacuatro;
        this.respuesta = respuesta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pregunta)) {
            return false;
        }
        Pregunta other = (Pregunta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.pojos.Pregunta[ id=" + id + " ]";
    }
    
}
