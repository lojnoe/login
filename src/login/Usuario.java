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

	// COMPARA DATOS PARA EL MENU DE LOGIN
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

	// rellenar la tabla usuario

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

	// rellenar la tabla personajes luminosos

	public DefaultTableModel rellenarTablapersonajesl() {
		String[] columnas = { "id", "Nombre", "Planeta", "Raza", "Edad", };
		DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
		try {
			String consulta = "SELECT id, nombre, planeta_natal,raza, edad FROM personajes where luminoso = true";
			cn = conexion.conectar();
			PreparedStatement stm2 = cn.prepareStatement(consulta);
			rs = stm2.executeQuery(consulta);
			modelo.addRow(columnas);
			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String planeta = rs.getString("planeta_natal");
				String raza = rs.getString("raza");
				String edad = rs.getString("edad");
				Object[] fila = { id, nombre, planeta, raza, edad };
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

	// rellenar la tabla personajes oscuros

	public DefaultTableModel rellenarTablapersonajes() {
		String[] columnas = { "id", "Nombre", "Planeta", "Raza", "Edad", };
		DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
		try {
			String consulta = "SELECT id, nombre, planeta_natal,raza, edad FROM personajes where luminoso = false";
			cn = conexion.conectar();
			PreparedStatement stm2 = cn.prepareStatement(consulta);
			rs = stm2.executeQuery(consulta);
			modelo.addRow(columnas);
			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String planeta = rs.getString("planeta_natal");
				String raza = rs.getString("raza");
				String edad = rs.getString("edad");
				Object[] fila = { id, nombre, planeta, raza, edad };
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

	public int comparardatospersonajes(String id, String nombre) {
		int resultado = 0;
		try {
			cn = conexion.conectar();
			PreparedStatement stm = cn.prepareStatement("SELECT * FROM personajes WHERE id = ? AND nombre=? ");
			stm.setString(1, id);
			stm.setString(2, nombre);

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
	public void borrarDatosPersonajes(String id, String nombre) {
		try {
			cn = conexion.conectar();
			PreparedStatement stm2 = cn.prepareStatement("DELETE FROM personajes  WHERE id = ? AND nombre=? ");
			stm2.setString(1, id);
			stm2.setString(2, nombre);

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
}
