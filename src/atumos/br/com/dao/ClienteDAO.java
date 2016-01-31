/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atumos.br.com.dao;

import atumos.br.com.models.Cliente;
import javax.persistence.EntityManager;

/**
 *
 * @author root
 */
public class ClienteDAO extends GenericDAO<Integer, Cliente> {
    public ClienteDAO(EntityManager entityManager) {
        super(entityManager);
    }
    
}
