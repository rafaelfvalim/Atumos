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
@Table(name = "tipo_venda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoVenda.findAll", query = "SELECT t FROM TipoVenda t"),
    @NamedQuery(name = "TipoVenda.findById", query = "SELECT t FROM TipoVenda t WHERE t.id = :id"),
    @NamedQuery(name = "TipoVenda.findByDescricao", query = "SELECT t FROM TipoVenda t WHERE t.descricao = :descricao")})
public class TipoVenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(mappedBy = "tipoVendaId")
    private Collection<Pedido> pedidoCollection;
    @OneToMany(mappedBy = "tipoEntrega")
    private Collection<Pedido> pedidoCollection1;

    public TipoVenda() {
    }

    public TipoVenda(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public Collection<Pedido> getPedidoCollection() {
        return pedidoCollection;
    }

    public void setPedidoCollection(Collection<Pedido> pedidoCollection) {
        this.pedidoCollection = pedidoCollection;
    }

    @XmlTransient
    public Collection<Pedido> getPedidoCollection1() {
        return pedidoCollection1;
    }

    public void setPedidoCollection1(Collection<Pedido> pedidoCollection1) {
        this.pedidoCollection1 = pedidoCollection1;
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
        if (!(object instanceof TipoVenda)) {
            return false;
        }
        TipoVenda other = (TipoVenda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "atumos.br.com.models.TipoVenda[ id=" + id + " ]";
    }
    
}
