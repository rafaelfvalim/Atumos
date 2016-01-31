/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atumos.br.com.service;

import atumos.br.com.dao.ClienteDAO;
import atumos.br.com.managers.SimpleEntityManager;
import atumos.br.com.models.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author root
 */
public class ClienteService {

    private ClienteDAO dao;

    private SimpleEntityManager simpleEntityManager;
    String persistenceUnitName = "AtumosPU";

    public ClienteService() {
        simpleEntityManager = new SimpleEntityManager(persistenceUnitName);
        dao = new ClienteDAO(simpleEntityManager.getEntityManager());
    }

    public void save(Cliente cliente) {
        try {
            simpleEntityManager.beginTransaction();
            dao.save(cliente);
            simpleEntityManager.commit();
        } catch (Exception e) {
            e.printStackTrace();
            simpleEntityManager.rollBack();
        } finally {
            simpleEntityManager.close();
        }
    }

    public void delete(Integer id) {
        Cliente cliente = dao.getById(id);
        simpleEntityManager.beginTransaction();
        dao.delete(cliente);
        simpleEntityManager.commit();
    }

    public List<Cliente> findAll() {
        return dao.findAll();
    }

    public Cliente getByNome(String nome) {
        return dao.getByProperty("nome", nome);
    }

    public Cliente getByTelefone(String telefone) {
        return dao.getByProperty("telefone", telefone);
    }

    public Cliente getByRua(String rua) {
        return dao.getByProperty("rua", rua);
    }

    public Cliente getByCEP(String cep) {
        return dao.getByProperty("cep", cep);
    }

    public List<Cliente> findByCepLike(String cep) {
        return dao.findLike("cep", cep);
    }

    public List<Cliente> findByNomeLike(String nome) {
        return dao.findLike("nome", nome);
    }

    public List<Cliente> findByTelefoneLike(String telefone) {
        return dao.findLike("telefone", telefone);
    }

    public List<Cliente> findByRuaLike(String rua) {
        return dao.findLike("rua", rua);
    }

    public List<Cliente> pesquisaFonetica(String value) {

        List<Cliente> clientes = new ArrayList<>();

        List<Cliente> clientesByCep = findByCepLike(value);
        List<Cliente> clientesByNome = findByNomeLike(value);
        List<Cliente> clientesByRua = findByRuaLike(value);
        List<Cliente> clientesByTelefone = findByTelefoneLike(value);
        if (clientesByCep != null) {
            clientes.addAll(clientesByCep);
        }
        if (clientesByNome != null) {
            clientes.addAll(clientesByNome);
        }
        if (clientesByRua != null) {
            clientes.addAll(clientesByRua);
        }
        if (clientesByTelefone != null) {
            clientes.addAll(clientesByTelefone);
        }
        return clientes;
    }

}
