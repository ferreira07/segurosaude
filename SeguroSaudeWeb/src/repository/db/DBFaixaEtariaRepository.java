package repository.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.FaixaEtaria;
import factories.ConnectionFactory;
import repository.IFaixaEtariaRepository;

public class DBFaixaEtariaRepository implements IFaixaEtariaRepository {

	@Override
	public int save(FaixaEtaria entity) {
		int ret = 0;
		try {
			Connection con = ConnectionFactory.getConnection();

			if (entity.getId() == 0) {
				// cria um preparedStatement
				String sql = "insert into faixaetaria (id, planoId, idadeInicio, idadeFim, valor) values (null, ?, ?, ?, ?)";
				PreparedStatement stmt = con.prepareStatement(sql);

				// preenche os valores
				stmt.setInt(1, entity.getPlanoId());
				stmt.setInt(2, entity.getIdadeIni());
				stmt.setInt(3, entity.getIdadeFim());
				//por simplificação salvei o valor como inteiro
				stmt.setInt(4, (int) entity.getValor());

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
				String sql = "update faixaetaria set planoId= ?, idadeInicio = ?, idadeFim = ?, valor = ? where id = ?";
				PreparedStatement stmt = con.prepareStatement(sql);

				// preenche os valores
				stmt.setInt(1, entity.getPlanoId());
				stmt.setInt(2, entity.getIdadeIni());
				stmt.setInt(3, entity.getIdadeFim());
				//por simplificação salvei o valor como inteiro
				stmt.setInt(4, (int) entity.getValor());
				stmt.setInt(5, entity.getId());

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
	        String sql = "delete from faixaetaria where id = ?";
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
	public FaixaEtaria get(int id) {
		FaixaEtaria ret = null;
		try {
			Connection con = ConnectionFactory.getConnection();
			
			// cria um preparedStatement
	        String sql = "select * from faixaetaria where id = (?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			
			// preenche os valores
	        stmt.setInt(1, id);
	
	        // executa
	        ResultSet r = stmt.executeQuery();
	        
	        r.next();
	        ret = LerFaixaEtaria(r);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public List<FaixaEtaria> list() {
		ArrayList<FaixaEtaria> ret = new ArrayList<FaixaEtaria>();
		try {
			Connection con = ConnectionFactory.getConnection();
			
			// cria um preparedStatement
	        String sql = "select * from faixaetaria";
			PreparedStatement stmt = con.prepareStatement(sql);
				
	        // executa
	        ResultSet r = stmt.executeQuery();
	        
	        while(r.next()){
	        	ret.add(LerFaixaEtaria(r));
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public List<FaixaEtaria> listByPlano(int planoId) {
		ArrayList<FaixaEtaria> ret = new ArrayList<FaixaEtaria>();
		try {
			Connection con = ConnectionFactory.getConnection();
			
			// cria um preparedStatement
	        String sql = "select * from faixaetaria where planoId = ?";
			PreparedStatement stmt = con.prepareStatement(sql);

	        stmt.setInt(1, planoId);
	        
	        // executa
	        ResultSet r = stmt.executeQuery();
	        
	        while(r.next()){
	        	ret.add(LerFaixaEtaria(r));
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public List<FaixaEtaria> listByIdade(int idade) {
		ArrayList<FaixaEtaria> ret = new ArrayList<FaixaEtaria>();
		try {
			Connection con = ConnectionFactory.getConnection();
			
			// cria um preparedStatement
	        String sql = "select * from segurosaude.faixaetaria where idadeInicio <= ? AND idadeFim >= ?";
			PreparedStatement stmt = con.prepareStatement(sql);

	        stmt.setInt(1, idade);
	        stmt.setInt(2, idade);
	        
	        // executa
	        ResultSet r = stmt.executeQuery();
	        
	        while(r.next()){
	        	ret.add(LerFaixaEtaria(r));
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	private FaixaEtaria LerFaixaEtaria(ResultSet r) throws SQLException {
		FaixaEtaria fe = new FaixaEtaria();
		fe.setId(r.getInt("id"));
		fe.setIdadeIni(r.getInt("idadeInicio"));
		fe.setIdadeIni(r.getInt("idadeFim"));
		fe.setPlanoId(r.getInt("planoId"));
		fe.setValor(r.getInt("valor"));
		
		return fe;
	}
}
