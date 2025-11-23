/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.List;


public class ProdutosDAO {
    
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
      

       public void cadastrarProduto (ProdutosDTO produto){
        
        String sql = "INSERT INTO produtos (nome, valor, status) VALUES (?, ?, ?) ";
        try{
             conectaDAO dao = new conectaDAO();
             conn = dao.connectDB();
            
        prep = conn.prepareStatement(sql);
        
        prep.setString(1, produto.getNome());
        prep.setInt(2, produto.getValor());
        prep.setString(3, produto.getStatus());
        prep.executeUpdate();
    
        }catch(SQLException a){
            a.getErrorCode();
        }
        
   }
    
    public List<ProdutosDTO> listarProdutos(){
        String sql = "SELECT * FROM produtos";
        conectaDAO dao = new conectaDAO();
        conn = dao.connectDB();
        
        try{
         prep = conn.prepareStatement(sql);
       
         resultset = prep.executeQuery();
        while(resultset.next()){
            ProdutosDTO produto = new ProdutosDTO();
            produto.setId(resultset.getInt("id"));
            produto.setNome(resultset.getString("nome"));
            produto.setValor(resultset.getInt("valor"));
            produto.setStatus(resultset.getString("status"));
            listagem.add(produto);
         }
          return listagem;
        }catch(SQLException b){
            b.getErrorCode();
            return null;
        }
    
        
        
  }
    
    public void atualizar(ProdutosDTO produto){
        String sql = "UPDATE produtos SET status = ? WHERE id = ?";
        try{
        conectaDAO conectar = new conectaDAO();
        conn = conectar.connectDB();
        prep = conn.prepareStatement(sql);
        prep.setString(1, produto.getStatus());
        prep.setInt(2, produto.getId());
        prep.executeUpdate();
        }catch(SQLException c){
        c.getErrorCode();
    }

}
    
    public int remover (int id){
        String sql = "delete from produtos WHERE id = ?";
      
        try{
            conectaDAO dao = new conectaDAO();
            conn = dao.connectDB();
            prep = conn.prepareStatement(sql);
            prep.setInt(1, id);
            int retorno = prep.executeUpdate();
            return retorno;
        }catch(SQLException d){
           return d.getErrorCode();
      
        
      }
        
    
       
        
    }
}

       


    
 
    























