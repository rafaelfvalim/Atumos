/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atumos.br.com.service;

import atumos.br.com.dao.LinhaDAO;
import atumos.br.com.managers.SimpleEntityManager;
import atumos.br.com.models.Linha;
import java.util.List;

/**
 *
 * @author root
 */
public class LinhaService {

    private LinhaDAO dao;

    private SimpleEntityManager simpleEntityManager;
    String persistenceUnitName = "AtumosPU";

    public LinhaService() {
        simpleEntityManager = new SimpleEntityManager(persistenceUnitName);
        dao = new LinhaDAO(simpleEntityManager.getEntityManager());
    }

    public void save(Linha linha) {
        try {
            simpleEntityManager.beginTransaction();
//            linha.validate();
            dao.save(linha);
            simpleEntityManager.commit();
        } catch (Exception e) {
            e.printStackTrace();
            simpleEntityManager.rollBack();
        } finally {
            simpleEntityManager.close();
        }
    }
    
    public void delete(Integer id){
        Linha linha = dao.getById(id);
        simpleEntityManager.beginTransaction();
        dao.delete(linha);
        simpleEntityManager.commit();
    }
    

    public List<Linha> findAll() {
        return dao.findAll();
    }
    
     public Linha getByDescricao(String value){
        return dao.getByProperty("descricao", value);
    }
    
    public Linha getByNumero(String value){
        return dao.getByProperty("numero", value);
    }
}
