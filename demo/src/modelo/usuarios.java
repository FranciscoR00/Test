
package modelo;

/**
 *
 * @author Usuario
 */
public class usuarios {
    
    private int id;
    private int id_tipo;
    private String usuario;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private static class KeySelector3 implements KeySelector<tuple3<integer, long,="" string="">, Tuple2<integer, long="">> {
    private static final long serialVersionUID = 1L;

    @Override
    public Tuple2<integer, long=""> getKey(Tuple3<integer, long,="" string=""> t) {
      return new Tuple2<>(t.f0, t.f1);
    }
  }</integer,></integer,></integer,></tuple3<integer,>
    
}
