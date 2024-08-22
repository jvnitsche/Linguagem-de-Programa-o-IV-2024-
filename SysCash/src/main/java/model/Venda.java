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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "venda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venda.findAll", query = "SELECT v FROM Venda v"),
    @NamedQuery(name = "Venda.findByIdven", query = "SELECT v FROM Venda v WHERE v.idven = :idven"),
    @NamedQuery(name = "Venda.findByNomecli", query = "SELECT v FROM Venda v WHERE v.nomecli = :nomecli"),
    @NamedQuery(name = "Venda.findByCpfcli", query = "SELECT v FROM Venda v WHERE v.cpfcli = :cpfcli"),
    @NamedQuery(name = "Venda.findByQtdite", query = "SELECT v FROM Venda v WHERE v.qtdite = :qtdite"),
    @NamedQuery(name = "Venda.findByPagam", query = "SELECT v FROM Venda v WHERE v.pagam = :pagam"),
    @NamedQuery(name = "Venda.findByTotven", query = "SELECT v FROM Venda v WHERE v.totven = :totven")})
public class Venda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idven")
    private Integer idven;
    @Size(max = 60)
    @Column(name = "nomecli")
    private String nomecli;
    @Size(max = 12)
    @Column(name = "cpfcli")
    private String cpfcli;
    @Column(name = "qtdite")
    private Integer qtdite;
    @Size(max = 40)
    @Column(name = "pagam")
    private String pagam;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "totven")
    private Double totven;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpro")
    private Collection<Item> itemCollection;
    @JoinColumn(name = "idus", referencedColumnName = "idus")
    @ManyToOne(optional = false)
    private Usuario idus;

    public Venda() {
    }

    public Venda(Integer idven) {
        this.idven = idven;
    }

    public Integer getIdven() {
        return idven;
    }

    public void setIdven(Integer idven) {
        this.idven = idven;
    }

    public String getNomecli() {
        return nomecli;
    }

    public void setNomecli(String nomecli) {
        this.nomecli = nomecli;
    }

    public String getCpfcli() {
        return cpfcli;
    }

    public void setCpfcli(String cpfcli) {
        this.cpfcli = cpfcli;
    }

    public Integer getQtdite() {
        return qtdite;
    }

    public void setQtdite(Integer qtdite) {
        this.qtdite = qtdite;
    }

    public String getPagam() {
        return pagam;
    }

    public void setPagam(String pagam) {
        this.pagam = pagam;
    }

    public Double getTotven() {
        return totven;
    }

    public void setTotven(Double totven) {
        this.totven = totven;
    }

    @XmlTransient
    public Collection<Item> getItemCollection() {
        return itemCollection;
    }

    public void setItemCollection(Collection<Item> itemCollection) {
        this.itemCollection = itemCollection;
    }

    public Usuario getIdus() {
        return idus;
    }

    public void setIdus(Usuario idus) {
        this.idus = idus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idven != null ? idven.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venda)) {
            return false;
        }
        Venda other = (Venda) object;
        if ((this.idven == null && other.idven != null) || (this.idven != null && !this.idven.equals(other.idven))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Venda[ idven=" + idven + " ]";
    }
    
}
