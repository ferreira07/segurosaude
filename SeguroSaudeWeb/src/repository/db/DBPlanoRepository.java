package repository.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Plano;
import factories.ConnectionFactory;
import repository.IPlanoRepository;

public class DBPlanoRepository implements IPlanoRepository {

	@Override
	public int save(Plano entity) {
		int ret = 0;
		try {
			Connection con = ConnectionFactory.getConnection();

			if (entity.getId() == 0) {
				// cria um preparedStatement
				String sql = "insert into plano (id, nome) values (null, ?)";
				PreparedStatement stmt = con.prepareStatement(sql);

				// preenche os valores
				stmt.setString(1, entity.getNome());

				// executa
				stmt.execute();
				ResultSet rs = stmt.getGeneratedKeys();
                if(rs.next())
                {
                    ret = rs.getInt(1);
                }
                
				stmt.close();
			} else {
				// cria um preparedStatement
				String sql = "update plano set nome = ? where id = ?";
				PreparedStatement stmt = con.prepareStatement(sql);

				// preenche os valores
				stmt.setString(1, entity.getNome());
				stmt.setInt(2, entity.getId());

				// executa
				stmt.execute();
				ret = entity.getId();
				stmt.close();
			}
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public void delete(int id) {
		try {
			Connection con = ConnectionFactory.getConnection();
			
			// cria um preparedStatement
	        String sql = "delete from plano where id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			
			// preenche os valores
	        stmt.setInt(1, id);
	
	        // executa
	        stmt.execute();
	        
	        stmt.close();		
	        con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Plano get(int id) {
		Plano ret = null;
		try {
			Connection con = ConnectionFactory.getConnection();
			
			// cria um preparedStatement
	        String sql = "select * from plano where id = (?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			
			// preenche os valores
	        stmt.setInt(1, id);
	
	        // executa
	        ResultSet r = stmt.executeQuery();
	        
	        r.next();
	        ret = LerPlano(r);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

	private Plano LerPlano(ResultSet r) throws SQLException {
		Plano p = new Plano("");
		p.setId(r.getInt("id"));
		p.setNome(r.getString("nome"));
		
		return p;
	}

	@Override
	public List<Plano> list() {
		ArrayList<Plano> ret = new ArrayList<Plano>();
		try {
			Connection con = ConnectionFactory.getConnection();
			
			// cria um preparedStatement
	        String sql = "select * from plano";
			PreparedStatement stmt = con.prepareStatement(sql);
				
	        // executa
	        ResultSet r = stmt.executeQuery();
	        
	        while(r.next()){
	        	ret.add(LerPlano(r));
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

}
