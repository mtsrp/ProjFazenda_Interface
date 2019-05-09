/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PacoteFazenda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author mathe
 * Links para ajuda: 
 * https://www.devmedia.com.br/criando-uma-conexao-java-mysql-server/16753
 * https://www.youtube.com/watch?v=JQjhLxU4Fi4
 */

public class conecta_bd {
    String nomeServidor = "localhost";
    String banco = "bd_fazenda";
    String url = "jdbc:mysql://" + nomeServidor + "/" + banco;
    String usuario = "root";
    String senha = "";
    Connection conexao;
    
    conecta_bd() throws SQLException{
        conexao = DriverManager.getConnection(url, usuario, senha);
    }
   
}

/*
 SELECT E INSERT BASICOS (SÓ EXEMPLO)

try {
            conecta_bd con = new conecta_bd();
            Statement st = con.conexao.createStatement();
            
           
            //Insert
            st.executeUpdate("INSERT INTO setor(`nome_setor`, `ativo_sn`) VALUES ('Celeiro', 'S')");
            
            
            //Consulta MYSQL
            st.executeQuery("SELECT * FROM setor");
            
            ResultSet rs = st.getResultSet();
            
            while(rs.next()){
                System.out.println(rs.getString("nome_setor")+","+rs.getString("ativo_sn"));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(TelaCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
*/