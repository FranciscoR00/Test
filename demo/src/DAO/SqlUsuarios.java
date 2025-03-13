
package DAO;
import DAO.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.usuarios;

/**
 *
 * @author Usuario
 */
public class SqlUsuarios extends Conexion{
    
    //Pantalla de Registro
    
    public boolean registrar(usuarios usr){
        
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql= "INSERT INTO usuarios (id_tipo, usuario, password) VALUES(?,?,?)"; 
    
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1, usr.getId_tipo());
            ps.setString(2, usr.getUsuario());
            ps.setString(3, usr.getPassword());
            ps.execute();
            return true;
                    } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
     public int ValidacionUsuario(String username){
        
        PreparedStatement ps=null;
        ResultSet rs = null;
        Connection con = getConexion();
        
        String sql= "SELECT count(id) FROM usuarios WHERE usuario = ?"; 
    
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, username);
            rs= ps.executeQuery();
            
            if(rs.next()){
                return rs.getInt(1);
                
            }
            return 1;
            
                    } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }
    }
     
    //Desde aqui empiza el codigo de la pantalla de Login
     
    public boolean login(usuarios usr){
        
        PreparedStatement ps=null;
        ResultSet rs = null;
        Connection con = getConexion();
        
        String sql= "SELECT id,id_tipo,usuario,password FROM usuarios WHERE usuario = ?"; 
    
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, usr.getUsuario());
            rs= ps.executeQuery();
            
            if(rs.next()){
                if(usr.getPassword().equals(rs.getString(4))){
                    
                    usr.setId(rs.getInt(1));
                    usr.setId_tipo(rs.getInt(2));
                    usr.setUsuario(rs.getString(3));
                    return true;
                } else{
                    return false;
                }
                
            }
            return false;
            
                    } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
