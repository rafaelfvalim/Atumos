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
public final class TableHelper {

    public static void criarLinhas(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        LinhaService linhaService = new LinhaService();
        for (Linha linha : linhaService.findAll()) {
            model.addRow(new String[]{linha.getNumero()});
        }

    }

    public static void removeTodasLinhas(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setNumRows(0);
    }
    public static void BuscaTodasLinhas(JTable table, Class clazz , Class dao) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
    }
    
}
