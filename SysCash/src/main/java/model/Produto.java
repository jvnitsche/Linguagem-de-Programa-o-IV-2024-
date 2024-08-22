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
@Table(name = "produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.findByIdpro", query = "SELECT p FROM Produto p WHERE p.idpro = :idpro"),
    @NamedQuery(name = "Produto.findByDespro", query = "SELECT p FROM Produto p WHERE p.despro = :despro"),
    @NamedQuery(name = "Produto.findByFabpro", query = "SELECT p FROM Produto p WHERE p.fabpro = :fabpro"),
    @NamedQuery(name = "Produto.findByValpro", query = "SELECT p FROM Produto p WHERE p.valpro = :valpro"),
    @NamedQuery(name = "Produto.findByEstoq", query = "SELECT p FROM Produto p WHERE p.estoq = :estoq")})
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpro")
    private Integer idpro;
    @Size(max = 200)
    @Column(name = "despro")
    private String despro;
    @Size(max = 40)
    @Column(name = "fabpro")
    private String fabpro;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valpro")
    private Double valpro;
    @Column(name = "estoq")
    private Integer estoq;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idven")
    private Collection<Item> itemCollection;

    public Produto() {
    }

    public Produto(Integer idpro) {
        this.idpro = idpro;
    }

    public Integer getIdpro() {
        return idpro;
    }

    public void setIdpro(Integer idpro) {
        this.idpro = idpro;
    }

    public String getDespro() {
        return despro;
    }

    public void setDespro(String despro) {
        this.despro = despro;
    }

    public String getFabpro() {
        return fabpro;
    }

    public void setFabpro(String fabpro) {
        this.fabpro = fabpro;
    }

    public Double getValpro() {
        return valpro;
    }

    public void setValpro(Double valpro) {
        this.valpro = valpro;
    }

    public Integer getEstoq() {
        return estoq;
    }

    public void setEstoq(Integer estoq) {
        this.estoq = estoq;
    }

    @XmlTransient
    public Collection<Item> getItemCollection() {
        return itemCollection;
    }

    public void setItemCollection(Collection<Item> itemCollection) {
        this.itemCollection = itemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpro != null ? idpro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.idpro == null && other.idpro != null) || (this.idpro != null && !this.idpro.equals(other.idpro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Produto[ idpro=" + idpro + " ]";
    }
    
}
