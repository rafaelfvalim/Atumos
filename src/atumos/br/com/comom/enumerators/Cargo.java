/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atumos.br.com.comom.enumerators;

/**
 *
 * @author root
 */
public enum Cargo {
    ENTREGADOR("Entregador"),
    PIZZAIOLO("Pizzaiolo"),
    BALCONISTA("Balconista"),
    CAIXA("Caixa"),
    MOTOQUEIRO("Motoqueiro"),
    OFFICEBOY("Officeboy"),
    COZINHEIRO("Cozinheiro"),
    CHEFE_COZINHA("Chefe Cozinha"),
    GARCON("Garçon");
    private String cargo;

    private Cargo(String cargo) {
        this.cargo = cargo;
    }

}
