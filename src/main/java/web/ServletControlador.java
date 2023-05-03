package web;

import dto.ClienteDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jdbc.ClienteDAO;

import java.io.IOException;
import java.util.*;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "editarCliente":
                    this.editarCliente(request, response);
                    break;
                case "eliminarCliente":
                    this.eliminarCliente(request, response);
                    break;
                default:
                    this.cargarDatos(request, response);
            }
        } else {
            this.cargarDatos(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "agregarCliente":
                    this.agregarCliente(request, response);
                    break;
                case "modificarCliente":
                    this.modificarCliente(request, response);
                    break;
                default:
                    this.cargarDatos(request, response);
            }
        } else {
            this.cargarDatos(request, response);
        }
    }

    private void cargarDatos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<ClienteDTO> clientes = new ClienteDAO().select();

        HttpSession session = request.getSession();

        session.setAttribute("clientes", clientes);
        session.setAttribute("saldoTotal", this.calcularSaldo(clientes));
        session.setAttribute("totalClientes", clientes.size());

        response.sendRedirect("clientes.jsp");
    }

    private void agregarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClienteDAO clienteDAO = new ClienteDAO();

        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String correo = request.getParameter("correo");
        String telefono = request.getParameter("telefono");
        String saldo = request.getParameter("saldo");

        ClienteDTO cliente = new ClienteDTO(nombre, apellidos, correo, telefono, Double.parseDouble(saldo));
        clienteDAO.insert(cliente);

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private void editarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        ClienteDTO cliente = new ClienteDAO().getClientInfo(new ClienteDTO(idCliente));

        request.setAttribute("cliente", cliente);

        String pathPage = "/WEB-INF/paginas/clientes/editarCliente.jsp";
        request.getRequestDispatcher(pathPage).forward(request, response);
    }

    private void modificarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClienteDAO clienteDAO = new ClienteDAO();

        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String correo = request.getParameter("correo");
        String telefono = request.getParameter("telefono");
        double saldo = Double.parseDouble(request.getParameter("saldo"));

        ClienteDTO cliente = new ClienteDTO(idCliente, nombre, apellidos, correo, telefono, saldo);

        clienteDAO.update(cliente);

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private void eliminarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClienteDAO clienteDAO = new ClienteDAO();

        int idCliente = Integer.parseInt(request.getParameter("idCliente"));

        ClienteDTO cliente = new ClienteDTO(idCliente);
        clienteDAO.delete(cliente);

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private double calcularSaldo(List<ClienteDTO> clientes) {
        double saldoTotal = 0f;

        for (ClienteDTO clienteDTO : clientes) {
            saldoTotal += clienteDTO.getSaldo();
        }

        return saldoTotal;
    }
}
