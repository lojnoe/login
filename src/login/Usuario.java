package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Usuario {
	Conexion conexion = new Conexion();
	Connection cn = null;
	Statement stm = null;
	ResultSet rs = null;
	String hola = "a";

	// AGREGAR USUARIO
	public void AgregarUsuario(String usuario, String contraseña, String email) {
		try {
			cn = conexion.conectar();
			PreparedStatement stm2 = cn
					.prepareStatement("INSERT INTO usuario(Usuario,Contraseña,Email) VALUES (?,?,?)");

			stm2.setString(1, usuario);
			stm2.setString(2, contraseña);
			stm2.setString(3, email);

			stm2.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}

				if (stm != null) {
					stm.close();
				}

				if (cn != null) {
					cn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	// MODIFICAR DATOS
	public void ModificaDatos(String usuario, String contraseña, String email) {
		try {
			cn = conexion.conectar();
			PreparedStatement stm2 = cn.prepareStatement(
					"UPDATE usuario SET Usuario = ?, SET Contraseña = ?,SET Email = ? WHERE Usuario = ?");

			stm2.setString(1, usuario);
			stm2.setString(2, contraseña);
			stm2.setString(3, email);
			stm2.setString(4, usuario);

			stm2.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}

				if (stm != null) {
					stm.close();
				}

				if (cn != null) {
					cn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	// MODIFICAR SOLO CONTRASEÑA
	public void ModificaDatos(String contraseña, String usuario) {
		try {
			cn = conexion.conectar();
			PreparedStatement stm2 = cn.prepareStatement("UPDATE usuario  SET Contraseña = ? WHERE Usuario = ?");
			stm2.setString(1, contraseña);
			stm2.setString(2, usuario);

			stm2.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}

				if (stm != null) {
					stm.close();
				}

				if (cn != null) {
					cn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	// BORRAR DATOS

	public void borrarDatos(String usuario) {
		try {
			cn = conexion.conectar();
			PreparedStatement stm2 = cn.prepareStatement("DELETE FROM usuarios  WHERE Usuario = ?");
			stm2.setString(1, usuario);

			stm2.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}

				if (stm != null) {
					stm.close();
				}

				if (cn != null) {
					cn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public int comparardatos(String usuario, String contraseña) {
		int resultado = 0;
		try {
			cn = conexion.conectar();
			PreparedStatement stm = cn.prepareStatement("SELECT * FROM usuario WHERE USUARIO = ? AND CONTRASEÑA=? ");
			stm.setString(1, usuario);
			stm.setString(2, contraseña);

			rs = stm.executeQuery();
			if (rs.next()) {
				resultado = 1;
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}

				if (stm != null) {
					stm.close();
				}

				if (cn != null) {
					cn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return resultado;
	}

	/*
	 * public void mostrar(String a) { String sql = "SELECT * FROM usuario";
	 * 
	 * Conexion con = new Conexion(); Connection conexion = con.conectar();
	 * DefaultTableModel model = new DefaultTableModel(); model.addColumn("ID");
	 * model.addColumn("Nombre");
	 * 
	 * String[] dato = new String[1]; ResultSet rs = null; try { conexion =
	 * con.conectar(); PreparedStatement stm2 = conexion.prepareStatement(sql); rs =
	 * stm2.executeQuery(); while (rs.next()) { Object[] row = new Object[2]; row[0]
	 * = rs.getInt("id"); row[1] = rs.getString("nombre");
	 * 
	 * model.addRow(row); }
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); }
	 * 
	 * }
	 */
	public DefaultTableModel rellenar() {
		String filaTABLA[] = { "ID,NOMBRE" };
		DefaultTableModel modelo = new DefaultTableModel(filaTABLA, 0);
		try {
			String consulta = "SELECT id, Usuario FROM usuario;";
			cn = conexion.conectar();
			PreparedStatement stm = cn.prepareStatement(consulta);
			rs = stm.executeQuery(consulta);

			while (rs.next()) {
				int id = rs.getInt("id");
				String Usuario = rs.getString("Usuario");
				Object[] fila = { id, Usuario };
				modelo.addRow(fila);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}

				if (stm != null) {
					stm.close();
				}

				if (cn != null) {
					cn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return modelo;
	}

	public DefaultTableModel rellenarTabla() {
		String[] columnas = { "id", "Usuario", "Contraseña", "Email" };
		DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
		try {
			String consulta = "SELECT id, Usuario, Contraseña, Email FROM usuario";
			cn = conexion.conectar();
			PreparedStatement stm2 = cn.prepareStatement(consulta);
			rs = stm2.executeQuery(consulta);
			modelo.addRow(columnas);
			while (rs.next()) {
				int TAG = rs.getInt("id");
				String Usuario = rs.getString("Usuario");
				String Contraseña = rs.getString("Contraseña");
				String Email = rs.getString("Email");
				Object[] fila = { TAG, Usuario, Contraseña, Email };
				modelo.addRow(fila);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}

				if (stm != null) {
					stm.close();
				}

				if (cn != null) {
					cn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return modelo;
	}
}
