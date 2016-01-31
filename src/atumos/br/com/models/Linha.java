/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atumos.br.com.models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "linha")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Linha.findAll", query = "SELECT l FROM Linha l"),
    @NamedQuery(name = "Linha.findById", query = "SELECT l FROM Linha l WHERE l.id = :id"),
    @NamedQuery(name = "Linha.findByNumero", query = "SELECT l FROM Linha l WHERE l.numero = :numero"),
    @NamedQuery(name = "Linha.findByDescricao", query = "SELECT l FROM Linha l WHERE l.descricao = :descricao")})
public class Linha implements Serializable {

    @OneToMany(mappedBy = "linhaId")
    private Collection<Pedido> pedidoCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "numero")
    private String numero;
    @Column(name = "descricao")
    private String descricao;

    public Linha() {
    }

    public Linha(Integer id) {
        this.id = id;
    }

    public Linha(String numero, String descricao) {
        this.numero = numero;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
        if (!(object instanceof Linha)) {
            return false;
        }
        Linha other = (Linha) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "atumos.br.com.models.Linha[ id=" + id + " ]";
    }
    
    
    public boolean linhaValidations(){
        return "".equals(this.descricao) || "".equals(this.descricao);
    }
    
    
    public String errorMensages(){
        if ("".equals(this.numero))
            return "Numero não pode ser nulo";
        if ("".equals(this.descricao))
            return "Descrição não pode ser nula";
        return "";
    }

    @XmlTransient
    public Collection<Pedido> getPedidoCollection() {
        return pedidoCollection;
    }

    public void setPedidoCollection(Collection<Pedido> pedidoCollection) {
        this.pedidoCollection = pedidoCollection;
    }
}
