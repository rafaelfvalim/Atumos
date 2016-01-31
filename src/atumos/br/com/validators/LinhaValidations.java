/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atumos.br.com.validators;

import atumos.br.com.models.Linha;
import atumos.br.com.service.LinhaService;
import javax.swing.JOptionPane;

/**
 *
 * @author root
 */
public final class LinhaValidations {

    public static boolean isEmpty(Linha linha) {
        if (!"".equals(linha.errorMensages())) {
            JOptionPane.showMessageDialog(null, linha.errorMensages(), "Atenção", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public static boolean alredyExists(Linha linha) {
        if (new LinhaService().getByNumero(linha.getNumero()) != null) {
            JOptionPane.showMessageDialog(null, "Esse numero já existe", "Atenção", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
