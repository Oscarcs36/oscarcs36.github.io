package jdbc;

import dto.ClienteDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements IClienteDAO {
    private static final String SQL_INSERT = "INSERT INTO clientes (nombre, apellidos, correo, telefono, saldo) VALUES (?,?,?,?,?);";
    private static final String SQL_UPDATE = "UPDATE clientes SET nombre = ?, apellidos = ?, correo = ?, telefono = ?, saldo = ? WHERE id_cliente = ?";
    private static final String SQL_DELETE = "DELETE FROM clientes WHERE id_cliente = ?";
    private static final String SQL_SELECT = "SELECT * FROM clientes";
    private static final String SQL_SELECT_CLIENT = "SELECT * FROM clientes WHERE id_cliente = ?";

    public ClienteDAO() {
    }

    @Override
    public void insert(ClienteDTO clienteDTO) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, clienteDTO.getNombre());
            stmt.setString(2, clienteDTO.getApellidos());
            stmt.setString(3, clienteDTO.getCorreo());
            stmt.setString(4, clienteDTO.getTelefono());
            stmt.setDouble(5, clienteDTO.getSaldo());
            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
    }

    @Override
    public void update(ClienteDTO clienteDTO) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, clienteDTO.getNombre());
            stmt.setString(2, clienteDTO.getApellidos());
            stmt.setString(3, clienteDTO.getCorreo());
            stmt.setString(4, clienteDTO.getTelefono());
            stmt.setDouble(5, clienteDTO.getSaldo());
            stmt.setInt(6, clienteDTO.getIdCliente());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
    }

    @Override
    public void delete(ClienteDTO clienteDTO) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, clienteDTO.getIdCliente());
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
    }

    @Override
    public List<ClienteDTO> select() {
        List<ClienteDTO> clienteDTOS = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        int id_cliente;
        String nombre;
        String apellidos;
        String correo;
        String telefono;
        float saldo;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                id_cliente = rs.getInt("id_cliente");
                nombre = rs.getString("nombre");
                apellidos = rs.getString("apellidos");
                correo = rs.getString("correo");
                telefono = rs.getString("telefono");
                saldo = rs.getFloat("saldo");
                clienteDTOS.add(new ClienteDTO(id_cliente, nombre, apellidos, correo, telefono, saldo));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return clienteDTOS;
    }

    @Override
    public ClienteDTO getClientInfo(ClienteDTO cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String nombre = null;
        String apellidos = null;
        String correo = null;
        String telefono = null;
        float saldo = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_CLIENT);
            stmt.setInt(1, cliente.getIdCliente());
            rs = stmt.executeQuery();

            while (rs.next()){
                nombre = rs.getString("nombre");
                apellidos = rs.getString("apellidos");
                correo = rs.getString("correo");
                telefono = rs.getString("telefono");
                saldo = rs.getFloat("saldo");
            }

            cliente.setNombre(nombre);
            cliente.setApellidos(apellidos);
            cliente.setCorreo(correo);
            cliente.setTelefono(telefono);
            cliente.setSaldo(saldo);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return cliente;
    }
}
