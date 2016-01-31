/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atumos.br.com.models;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p"),
    @NamedQuery(name = "Pedido.findById", query = "SELECT p FROM Pedido p WHERE p.id = :id"),
    @NamedQuery(name = "Pedido.findByQuantidade", query = "SELECT p FROM Pedido p WHERE p.quantidade = :quantidade"),
    @NamedQuery(name = "Pedido.findByDataVenda", query = "SELECT p FROM Pedido p WHERE p.dataVenda = :dataVenda"),
    @NamedQuery(name = "Pedido.findByEntregador", query = "SELECT p FROM Pedido p WHERE p.entregador = :entregador")})
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "quantidade")
    private Integer quantidade;
    @Column(name = "data_venda")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataVenda;
    @Column(name = "entregador")
    private Integer entregador;
    @JoinColumn(name = "tipo_venda_id", referencedColumnName = "id")
    @ManyToOne
    private TipoVenda tipoVendaId;
    @JoinColumn(name = "produto_id", referencedColumnName = "id")
    @ManyToOne
    private Produto produtoId;
    @JoinColumn(name = "linha_id", referencedColumnName = "id")
    @ManyToOne
    private Linha linhaId;
    @JoinColumn(name = "tipo_entrega", referencedColumnName = "id")
    @ManyToOne
    private TipoVenda tipoEntrega;

    public Pedido() {
    }

    public Pedido(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Integer getEntregador() {
        return entregador;
    }

    public void setEntregador(Integer entregador) {
        this.entregador = entregador;
    }

    public TipoVenda getTipoVendaId() {
        return tipoVendaId;
    }

    public void setTipoVendaId(TipoVenda tipoVendaId) {
        this.tipoVendaId = tipoVendaId;
    }

    public Produto getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Produto produtoId) {
        this.produtoId = produtoId;
    }

    public Linha getLinhaId() {
        return linhaId;
    }

    public void setLinhaId(Linha linhaId) {
        this.linhaId = linhaId;
    }

    public TipoVenda getTipoEntrega() {
        return tipoEntrega;
    }

    public void setTipoEntrega(TipoVenda tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
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
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "atumos.br.com.models.Pedido[ id=" + id + " ]";
    }
    
}
