/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atumos.br.com.comom;

import javax.swing.JTable;

/**
 *
 * @author root
 */
public interface ITableHelper {
    public void  criarLinhas(JTable table);
    public void removeTodasLinhas(JTable table);
    public void BuscaTodasLinhas(JTable table);
}
