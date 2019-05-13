/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesAbstratas;

/**
 *
 * @author mathe
 */
public class Setor {
    private int codigo_set;
    private String Descricao_set;
    private String Campo_extra;

    public int getCodigo_set() {
        return codigo_set;
    }

    public void setCodigo_set(int codigo_set) {
        this.codigo_set = codigo_set;
    }

    public String getDescricao_set() {
        return Descricao_set;
    }

    public void setDescricao_set(String Descricao_set) {
        this.Descricao_set = Descricao_set;
    }

    public String getCampo_extra() {
        return Campo_extra;
    }

    public void setCampo_extra(String Campo_extra) {
        this.Campo_extra = Campo_extra;
    }
    
    
    public String toString(){
        return getDescricao_set();
    }
}
