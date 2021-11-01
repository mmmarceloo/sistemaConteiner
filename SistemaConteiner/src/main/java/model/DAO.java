package model;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	// PARÂMETROS DE CONEXÃO
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/dbconteiner?useTimezone=true$serverTimezone=UTC";

	private String user = "root";
	private String password = "root";

	// MÈTODO DE CONEXÃO
	private Connection conectar() {

		Connection con = null;
		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	// CRUD CREATE

	public void inserirConteiner(JavaBeans conteiner) {
		System.out.println("entrou no inserir");
		String create = "insert into conteiners (cpf, numero,tipo,sttus, categoria) values (?,?,?,?,?)";

		try {
			Connection con = conectar();
			System.out.println("dentro do create" + con);
			PreparedStatement grava = con.prepareStatement(create);

			grava.setNString(1, conteiner.getCpf());
			grava.setNString(2, conteiner.getNumero());
			grava.setNString(3, conteiner.getTipo());
			grava.setNString(4, conteiner.getSttus());
			grava.setNString(5, conteiner.getCategoria());

			grava.executeUpdate(); // executa
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	public void consultaConteiner(JavaBeans consulta) { // verifica se existe o cpf

		String read2 = "SELECT * FROM conteiners WHERE numero = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, consulta.getNumero());
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				consulta.setCpf(rs.getString(1));
				consulta.setNumero(rs.getString(2)); // setar as variaveis JavaBeans
				consulta.setTipo(rs.getString(3));
				consulta.setSttus(rs.getString(4));
				consulta.setCategoria(rs.getString(5));
				

			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	public void modificarConteiner(JavaBeans consulta) {
		String create = "update conteiners set numero=?,tipo=?,sttus=?,categoria=? where cpf=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);

			pst.setString(1, consulta.getNumero());
			pst.setString(2, consulta.getTipo());
			pst.setString(3, consulta.getSttus());
			pst.setString(4, consulta.getCategoria());
			pst.setString(5, consulta.getCpf());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void inserirMovimentacao(JavaBeans movimentacao) {

		String create = "insert into movimentacoes (em,des,gin,gout,rep,pes,sca,mov, dataInicio, horaInicio, dataFim, horaFim,cpf) values (?,?,?,?,?,?,?,?,?,?,?,?,?);";

		
		String verificaCpf = "select count(*) from movimentacoes where cpf =?;";
		try {
			Connection con = conectar();
			PreparedStatement grava = con.prepareStatement(create);

			PreparedStatement consultaCpf = con.prepareStatement(verificaCpf);
			consultaCpf.setString(1, movimentacao.getCpf());

			System.out.println("ANTES DO RESULT SET");
			ResultSet rs = consultaCpf.executeQuery();
			System.out.println("antes do sysout com rs");
			System.out.println("Antes do if");
			while (rs.next()) {
				movimentacao.setNumero(rs.getString(1));
			}
			System.out.println("passou do while" + movimentacao.getNumero());
			consultaCpf.setString(1, movimentacao.getCpf());
			if (movimentacao.getNumero().equals("1")) {
				System.out.println("ja tem");

				System.out.println("O Valor dentro de TipoMov" + movimentacao.getTipoMov());

				if (movimentacao.getTipoMov().equals("em")) {

					String comCpf = "update movimentacoes set em = em + 1, mov = mov+1, dataInicio = ?,horaInicio = ?, dataFim = ?, horaFim = ?  where cpf = ?;";
					PreparedStatement mesmoCpf = con.prepareStatement(comCpf);

					mesmoCpf.setString(1, movimentacao.getDataInicio());
					mesmoCpf.setString(2, movimentacao.getHoraInicio());
					mesmoCpf.setString(3, movimentacao.getDataFim());
					mesmoCpf.setString(4, movimentacao.getHoraFim());
					mesmoCpf.setString(5, movimentacao.getCpf());
					mesmoCpf.executeUpdate();

				} else if (movimentacao.getTipoMov().equals("des")) {

					String comCpf = "update movimentacoes set des = des + 1, mov = mov+1  where cpf = ?;";
					PreparedStatement mesmoCpf = con.prepareStatement(comCpf);
					mesmoCpf.setString(1, movimentacao.getCpf());
					mesmoCpf.executeUpdate();

				} else if (movimentacao.getTipoMov().equals("gin")) {

					String comCpf = "update movimentacoes set gin = gin + 1, mov = mov+1  where cpf = ?;";
					PreparedStatement mesmoCpf = con.prepareStatement(comCpf);
					mesmoCpf.setString(1, movimentacao.getCpf());
					mesmoCpf.executeUpdate();

				} else if (movimentacao.getTipoMov().equals("gout")) {

					String comCpf = "update movimentacoes set gout = gout + 1, mov = mov+1  where cpf = ?;";
					PreparedStatement mesmoCpf = con.prepareStatement(comCpf);
					mesmoCpf.setString(1, movimentacao.getCpf());
					mesmoCpf.executeUpdate();

				} else if (movimentacao.getTipoMov().equals("rep")) {

					String comCpf = "update movimentacoes set rep = rep + 1, mov = mov+1  where cpf = ?;";
					PreparedStatement mesmoCpf = con.prepareStatement(comCpf);
					mesmoCpf.setString(1, movimentacao.getCpf());
					mesmoCpf.executeUpdate();

				} else if (movimentacao.getTipoMov().equals("pes")) {

					String comCpf = "update movimentacoes set pes = pes + 1, mov = mov+1  where cpf = ?;";
					PreparedStatement mesmoCpf = con.prepareStatement(comCpf);
					mesmoCpf.setString(1, movimentacao.getCpf());
					mesmoCpf.executeUpdate();

				} else {

					String comCpf = "update movimentacoes set sca = sca + 1, mov = mov+1  where cpf = ?;";
					PreparedStatement mesmoCpf = con.prepareStatement(comCpf);
					mesmoCpf.setString(1, movimentacao.getCpf());
					mesmoCpf.executeUpdate();

				}

				con.close();

			} else {
				System.out.println("nao tem");

				System.out.println("setando em 0");

				grava.setInt(1, 0);
				grava.setInt(2, 0);
				grava.setInt(3, 0);
				grava.setInt(4, 0);
				grava.setInt(5, 0);
				grava.setInt(6, 0);
				grava.setInt(7, 0);
				grava.setInt(8, 1);

				System.out.println("Ifs");

				if (movimentacao.getTipoMov().equals("em")) {
					grava.setInt(1, 1);
				} else if (movimentacao.getTipoMov().equals("des")) {
					grava.setInt(2, 1);

				} else if (movimentacao.getTipoMov().equals("gin")) {
					grava.setInt(3, 1);

				} else if (movimentacao.getTipoMov().equals("gout")) {
					grava.setInt(4, 1);

				} else if (movimentacao.getTipoMov().equals("rep")) {
					grava.setInt(5, 1);
				} else if (movimentacao.getTipoMov().equals("pes")) {
					grava.setInt(6, 1);

				} else {
					grava.setInt(7, 1);
				}

				// grava.setString(8, movimentacao.getMov());

				grava.setString(9, movimentacao.getDataInicio());
				grava.setString(10, movimentacao.getHoraInicio());
				grava.setString(11, movimentacao.getDataFim());
				grava.setString(12, movimentacao.getHoraFim());
				grava.setString(13, movimentacao.getCpf());

				System.out.println("Antes do execute");

				grava.executeUpdate();

				con.close();
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	public void consultaMovimentacao(JavaBeans consulta) { // verifica se existe o cpf

		String read2 = "SELECT * FROM movimentacoes WHERE cpf = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, consulta.getCpf());consulta.getCpf() ;
			System.out.println("Antes do RESULTSET o CPF:  " + consulta.getCpf() );
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				consulta.setEm(rs.getString(1));
				consulta.setDes(rs.getString(2));
				consulta.setGin(rs.getString(3));
				consulta.setGout(rs.getString(4));
				consulta.setRep(rs.getString(5));
				consulta.setPes(rs.getString(6));
				consulta.setSca(rs.getString(7));
				consulta.setMov(rs.getString(8));
				consulta.setDataInicio(rs.getString(9));
				consulta.setHoraInicio(rs.getString(10));
				consulta.setDataFim(rs.getString(11));
				consulta.setHoraFim(rs.getString(12));
				consulta.setCpf(rs.getString(13));
				

			}
			System.out.println(consulta.getCpf() + "dentro do DAO na consultaCPF");
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	public void modificarMovimentacao(JavaBeans consulta) {
		String create = "update movimentacoes set em=?,des=?,gin=?,gout=?,rep=?,pes=?,sca=?,mov=?,dataInicio=?,horaInicio=?,dataFim=?,horaFim=?	  where cpf=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);

			pst.setString(1, consulta.getEm());
			pst.setString(2, consulta.getDes());
			pst.setString(3, consulta.getGin());
			pst.setString(4, consulta.getGout());
			pst.setString(5, consulta.getRep());
			pst.setString(6, consulta.getPes());
			pst.setString(7, consulta.getSca());
			pst.setString(8, consulta.getMov());
			pst.setString(9, consulta.getDataInicio());
			pst.setString(10, consulta.getHoraInicio());
			pst.setString(11, consulta.getDataFim());
			pst.setString(12, consulta.getHoraFim());
			pst.setString(13, consulta.getCpf());
			
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	public void deleteConteiner(JavaBeans consulta) {
		String deleteConteiner = "delete from conteiners where cpf =?";
		String deleteMovimentacao = "delete from movimentacoes where cpf=?";
		try {
			Connection con = conectar();
			// tem q deletar de duas tabelas simultaneamente
			PreparedStatement pst = con.prepareStatement(deleteMovimentacao);
			PreparedStatement pst1 = con.prepareStatement(deleteConteiner);
			System.out.println("antes de setar var dentro do DAO CPF: " + consulta.getCpf());
			pst.setString(1, consulta.getCpf());
			pst.executeUpdate();

			pst1.setString(1, consulta.getCpf());
			pst1.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void deletaMovimentacao(JavaBeans consulta) {
		
		String deleteMovimentacao = "delete from movimentacoes where cpf=?";
		try {
			Connection con = conectar();
			
			PreparedStatement pst = con.prepareStatement(deleteMovimentacao);
			
			System.out.println("antes de setar var dentro do DAO CPF: " + consulta.getCpf());
			pst.setString(1, consulta.getCpf());
			pst.executeUpdate();

			
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	
	
	public  ArrayList<JavaBeans> relatorio(JavaBeans consulta) { // ArrayList cria vetor dinamico ctrl shift + o para importar esse
		// Criando um objeto para acessar a classe JavaBeans
		ArrayList<JavaBeans> relatorio = new ArrayList<>();
		
		
		String read = "select cpf,mov,em,des,gin,gout,rep,pes,sca  from movimentacoes order by cpf;";
		
		
			
		try {
		Connection con = conectar();
		PreparedStatement pst = con.prepareStatement(read);
		
		
		
		ResultSet rs = pst.executeQuery(); // ctrl shift + o para importar esse recurso armazena o resultado da
																			// consulta   ResultSet obtem os dados do bd
																		// em um objeto dessa classe
		
		
		// enquanto houver contatos
		while (rs.next()) {
		// gravar os dados recebidos em variaveis
			
		
		String cpf=rs.getString(1);
		String mov = rs.getString(2);
		String em=rs.getString(3);
		String des = rs.getString(4);
		String gin=rs.getString(5);
		String gout = rs.getString(6);
		String rep=rs.getString(7);
		String pes = rs.getString(8);
		String sca=rs.getString(9);
		
		System.out.println("O Mov dentro do while" + mov);
		// colocando tudo na ArrayList
		relatorio.add(new JavaBeans(cpf,mov,em,des,gin,gout,rep,pes,sca));
		System.out.println("O Mov dentro do while parte 2   " + relatorio.get(0).getMov() );
				}
	System.out.println(relatorio.get(0).getCpf() + "dentro do dao");
		con.close();
		return relatorio;
		

		} catch (Exception e) {
		System.out.println(e);
		return null;
		}

		}	
	public int importacao(JavaBeans importacao) {
		int resultado =0;
		String imp = " SELECT COUNT(*) FROM conteiners WHERE categoria = 'importacao';";	
		
		try {
				Connection con = conectar();
				PreparedStatement pst = con.prepareStatement(imp);

				
				
				ResultSet rs = pst.executeQuery();
				if(rs.next()) {
				resultado = rs.getInt(1);
				}
				
				
				
				
				System.out.println(resultado);
		} catch (Exception e) {
			System.out.println(e);
		}
		return resultado;
	}
	public int exportacao(JavaBeans importacao) {
		int resultado =0;
		String imp = " SELECT COUNT(*) FROM conteiners WHERE categoria = 'exportacao';";	
		
		try {
				Connection con = conectar();
				PreparedStatement pst = con.prepareStatement(imp);

				
				
				ResultSet rs = pst.executeQuery();
				if(rs.next()) {
				resultado = rs.getInt(1);
				}
				
				
				
				
				System.out.println(resultado);
		} catch (Exception e) {
			System.out.println(e);
		}
		return resultado;
	}

}	



