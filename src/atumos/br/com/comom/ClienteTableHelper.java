/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atumos.br.com.comom;

import atumos.br.com.models.Cliente;
import atumos.br.com.models.Linha;
import atumos.br.com.service.ClienteService;
import atumos.br.com.service.LinhaService;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author root
 */
public class ClienteTableHelper implements ITableHelper {
    
    public Cliente cliente;
    
    public ClienteTableHelper() {
    }
    
    @Override
    public void criarLinhas(JTable table) {
    }
    
    @Override
    public void removeTodasLinhas(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setNumRows(0);
    }
    
    @Override
    public void BuscaTodasLinhas(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        List<Linha> linhas = new LinhaService().findAll();
        removeTodasLinhas(table);
        for (Linha linha : linhas) {
          model.addRow(new String[]{linha.getId().toString(), linha.getNumero(), linha.getDescricao()});
        }
    }
      public void BuscaLinhasResult(JTable table, String value) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        List<Cliente> clientes = new ClienteService().pesquisaFonetica(value);
        removeTodasLinhas(table);
        for (Cliente cliente : clientes) {
         // model.addRow(new String[]{linha.getId().toString(), linha.getNumero(), linha.getDescricao()});
        }
    }
    
      public void addRow( DefaultTableModel model, Cliente cliente ){
                
          
                  
                

      }
}
