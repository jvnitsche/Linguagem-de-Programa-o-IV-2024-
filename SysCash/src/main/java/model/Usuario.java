/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TADS
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdus", query = "SELECT u FROM Usuario u WHERE u.idus = :idus"),
    @NamedQuery(name = "Usuario.findByNomeus", query = "SELECT u FROM Usuario u WHERE u.nomeus = :nomeus"),
    @NamedQuery(name = "Usuario.findByCpfus", query = "SELECT u FROM Usuario u WHERE u.cpfus = :cpfus"),
    @NamedQuery(name = "Usuario.findByTelus", query = "SELECT u FROM Usuario u WHERE u.telus = :telus"),
    @NamedQuery(name = "Usuario.findByEmailus", query = "SELECT u FROM Usuario u WHERE u.emailus = :emailus"),
    @NamedQuery(name = "Usuario.findByLoginus", query = "SELECT u FROM Usuario u WHERE u.loginus = :loginus"),
    @NamedQuery(name = "Usuario.findBySenhaus", query = "SELECT u FROM Usuario u WHERE u.senhaus = :senhaus")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idus")
    private Integer idus;
    @Size(max = 60)
    @Column(name = " nomeus")
    private String nomeus;
    @Size(max = 12)
    @Column(name = "cpfus")
    private String cpfus;
    @Size(max = 13)
    @Column(name = "telus")
    private String telus;
    @Size(max = 60)
    @Column(name = "emailus")
    private String emailus;
    @Size(max = 8)
    @Column(name = "loginus")
    private String loginus;
    @Size(max = 8)
    @Column(name = "senhaus")
    private String senhaus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idus")
    private Collection<Venda> vendaCollection;

    public Usuario() {
    }

    public Usuario(Integer idus) {
        this.idus = idus;
    }

    public Integer getIdus() {
        return idus;
    }

    public void setIdus(Integer idus) {
        this.idus = idus;
    }

    public String getNomeus() {
        return nomeus;
    }

    public void setNomeus(String nomeus) {
        this.nomeus = nomeus;
    }

    public String getCpfus() {
        return cpfus;
    }

    public void setCpfus(String cpfus) {
        this.cpfus = cpfus;
    }

    public String getTelus() {
        return telus;
    }

    public void setTelus(String telus) {
        this.telus = telus;
    }

    public String getEmailus() {
        return emailus;
    }

    public void setEmailus(String emailus) {
        this.emailus = emailus;
    }

    public String getLoginus() {
        return loginus;
    }

    public void setLoginus(String loginus) {
        this.loginus = loginus;
    }

    public String getSenhaus() {
        return senhaus;
    }

    public void setSenhaus(String senhaus) {
        this.senhaus = senhaus;
    }

    @XmlTransient
    public Collection<Venda> getVendaCollection() {
        return vendaCollection;
    }

    public void setVendaCollection(Collection<Venda> vendaCollection) {
        this.vendaCollection = vendaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idus != null ? idus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idus == null && other.idus != null) || (this.idus != null && !this.idus.equals(other.idus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Usuario[ idus=" + idus + " ]";
    }
    
}
