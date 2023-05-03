package jdbc;

import dto.ClienteDTO;

import java.util.*;

public interface IClienteDAO {
    public void insert(ClienteDTO clienteDTO);
    public void update(ClienteDTO clienteDTO);
    public void delete(ClienteDTO clienteDTO);
    public List select();
    public ClienteDTO getClientInfo(ClienteDTO cliente);
}