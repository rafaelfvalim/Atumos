/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atumos.br.com.comom;

import atumos.br.com.models.Linha;
import atumos.br.com.service.LinhaService;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author root
 */
public class LinhaTableHelper implements ITableHelper {
    
    public Linha linha;
    
    public LinhaTableHelper() {
        linha = new Linha();
    }
    
    @Override
    public void criarLinhas(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        LinhaService linhaService = new LinhaService();
        for (Linha linha : linhaService.findAll()) {
            model.addRow(new String[]{linha.getNumero()});
        }
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
    
}
