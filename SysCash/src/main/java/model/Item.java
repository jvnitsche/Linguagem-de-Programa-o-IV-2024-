/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TADS
 */
@Entity
@Table(name = "item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i"),
    @NamedQuery(name = "Item.findByIditem", query = "SELECT i FROM Item i WHERE i.iditem = :iditem"),
    @NamedQuery(name = "Item.findByQtdite", query = "SELECT i FROM Item i WHERE i.qtdite = :qtdite"),
    @NamedQuery(name = "Item.findBySubtot", query = "SELECT i FROM Item i WHERE i.subtot = :subtot")})
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iditem")
    private Integer iditem;
    @Column(name = "qtdite")
    private Integer qtdite;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "subtot")
    private Double subtot;
    @JoinColumn(name = "idven", referencedColumnName = "idpro")
    @ManyToOne(optional = false)
    private Produto idven;
    @JoinColumn(name = "idpro", referencedColumnName = "idven")
    @ManyToOne(optional = false)
    private Venda idpro;

    public Item() {
    }

    public Item(Integer iditem) {
        this.iditem = iditem;
    }

    public Integer getIditem() {
        return iditem;
    }

    public void setIditem(Integer iditem) {
        this.iditem = iditem;
    }

    public Integer getQtdite() {
        return qtdite;
    }

    public void setQtdite(Integer qtdite) {
        this.qtdite = qtdite;
    }

    public Double getSubtot() {
        return subtot;
    }

    public void setSubtot(Double subtot) {
        this.subtot = subtot;
    }

    public Produto getIdven() {
        return idven;
    }

    public void setIdven(Produto idven) {
        this.idven = idven;
    }

    public Venda getIdpro() {
        return idpro;
    }

    public void setIdpro(Venda idpro) {
        this.idpro = idpro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iditem != null ? iditem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.iditem == null && other.iditem != null) || (this.iditem != null && !this.iditem.equals(other.iditem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Item[ iditem=" + iditem + " ]";
    }
    
}
