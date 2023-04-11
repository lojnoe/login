package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Usuario {
	Conexion conexion = new Conexion();
	Connection cn = null;
	Statement stm = null;
	ResultSet rs = null;

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
			if(rs.next()) {
				resultado =1;
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

}
