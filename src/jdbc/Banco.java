package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author Bruna C.R.
 *
 */
public class Banco {

	private Connection conexao;
	private static final String database = "bruna";
	private static final String user = "root";
	private static final String psw = "aluno";
	private boolean isConnected = false;
	private static String sql;

	public Banco() {
		conectar();
	}

	public void conectar() {
		try {
			conexao = DriverManager.getConnection("jdbc:mysql://localhost/" + database + "?serverTimezone=UTC", user,
					psw);
			isConnected = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private ResultSet executeQuery(String query, Connection conexao) {
		Statement st = null;
		try {
			st = conexao.createStatement();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
	}

	public void salvar(Pessoa pessoa) {
		if (isConnected) {
			sql = "INSERT INTO pessoa(ID, UltimoNome, PrimeiroNome, Idade, Profissao) VALUES(?,?,?,?,?)";

			PreparedStatement ps;
			try {
				ps = conexao.prepareStatement(sql);
				ps.setInt(1, pessoa.getId());
				ps.setString(2, pessoa.getUltimoNome());
				ps.setString(3, pessoa.getPrimeiroNome());
				ps.setInt(4, pessoa.getIdade());
				ps.setString(5, pessoa.getProfissao());
				ps.execute();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	public void remover(Pessoa pessoa) {
		if (isConnected) {
			sql = "DELETE FROM pessoa WHERE id=?";
			PreparedStatement ps;
			try {
				ps = conexao.prepareStatement(sql);
				ps.setInt(1, pessoa.getId());
				ps.execute();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void atualizar(Pessoa pessoa) {
		if (isConnected) {
			sql = "UPDATE pessoa SET UltimoNome=?,PrimeiroNome=?,Idade=?,Profissao=? WHERE id=?";

			PreparedStatement ps;
			try {
				ps = conexao.prepareStatement(sql);
				ps.setString(1, pessoa.getUltimoNome());
				ps.setString(2, pessoa.getPrimeiroNome());
				ps.setInt(3, pessoa.getIdade());
				ps.setString(4, pessoa.getProfissao());
				ps.setInt(5, pessoa.getId());
				ps.execute();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	public List<Pessoa> listar() {

		List<Pessoa> pessoas = null;
		if (isConnected) {

			sql = "SELECT * FROM pessoa";

			ResultSet rs = this.executeQuery(sql, conexao);
			pessoas = new ArrayList<Pessoa>();
			try {
				while (rs.next()) {
					pessoas.add(this.getPessoaInfo(rs));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return pessoas;
	}

	private Pessoa getPessoaInfo(ResultSet rs) throws SQLException {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(Integer.valueOf(rs.getString("ID")));
		pessoa.setIdade(Integer.valueOf(rs.getString("Idade")));
		pessoa.setPrimeiroNome(rs.getString("PrimeiroNome"));
		pessoa.setUltimoNome(rs.getString("UltimoNome"));
		pessoa.setProfissao(rs.getString("Profissao"));
		return pessoa;
	}

	public Pessoa findByID(int id) {
		Pessoa pessoa = null;
		if (isConnected) {
			sql = "SELECT * FROM pessoa WHERE ID=" + id;
			ResultSet rs = this.executeQuery(sql, conexao);
			try {
				while (rs.next()) {
					pessoa = new Pessoa();
					pessoa.setId(Integer.valueOf(rs.getString("ID")));
					pessoa.setIdade(Integer.valueOf(rs.getString("Idade")));
					pessoa.setPrimeiroNome(rs.getString("PrimeiroNome"));
					pessoa.setUltimoNome(rs.getString("UltimoNome"));
					pessoa.setProfissao(rs.getString("Profissao"));
				}
			} catch (NumberFormatException | SQLException e1) {
				e1.printStackTrace();
			}
		}
		return pessoa;
	}

}
