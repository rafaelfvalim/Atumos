/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atumos.br.com.dao;

import atumos.br.com.models.Linha;
import javax.persistence.EntityManager;

/**
 *
 * @author root
 */
public class LinhaDAO extends GenericDAO<Integer, Linha> {
    public LinhaDAO(EntityManager entityManager) {
        super(entityManager);
    }
    
}
