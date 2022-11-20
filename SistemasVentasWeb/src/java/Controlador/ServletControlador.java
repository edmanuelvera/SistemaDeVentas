package Controlador;

import Config.GenerarSerie;
import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Venta;
import Modelo.VentaDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletControlador extends HttpServlet {

    // Variables para los metodos de empleado
    Empleado em = new Empleado();
    EmpleadoDAO edao = new EmpleadoDAO();
    int idE;
    //Variables para los metodos de cliente
    Cliente cl = new Cliente();
    ClienteDAO cdao = new ClienteDAO();
    int idC;
    //Variables para los metodos de producto
    Producto pt = new Producto();
    ProductoDAO pdao = new ProductoDAO();
    int idP;
    //Variables para metodos de registrar venta
    Venta v = new Venta();
    
    List<Venta> lista = new ArrayList<>();
    int item;
    int cod;
    String dProducto;
    double precio;
    int cant;
    double total;
    double totalPagar;
    VentaDAO vdao = new VentaDAO();
    
    //Variables para metodos de generar número de serie
    String numeroserie;
   

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        if (menu.equals("Empleado")) {
            switch (accion) {
                case "Listar":
                    List lista = edao.listar();
                    request.setAttribute("empleados", lista);
                    break;
                case "Agregar":
                    String dni = request.getParameter("txtDni");
                    String nom = request.getParameter("txtNombres");
                    String tel = request.getParameter("txtTelefono");
                    String est = request.getParameter("txtEstado");
                    String usr = request.getParameter("txtUsuario");
                    em.setDni(dni);
                    em.setNombres(nom);
                    em.setTelefono(tel);
                    em.setEstado(est);
                    em.setUser(usr);
                    edao.agregar(em);
                    request.getRequestDispatcher("ServletControlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idE = Integer.parseInt(request.getParameter("id"));
                    Empleado e = edao.listarId(idE);
                    request.setAttribute("empleado", e);
                    request.getRequestDispatcher("ServletControlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String dniA = request.getParameter("txtDni");
                    String nomA = request.getParameter("txtNombres");
                    String telA = request.getParameter("txtTelefono");
                    String estA = request.getParameter("txtEstado");
                    String usrA = request.getParameter("txtUsuario");
                    em.setDni(dniA);
                    em.setNombres(nomA);
                    em.setTelefono(telA);
                    em.setEstado(estA);
                    em.setUser(usrA);
                    em.setId(idE);
                    edao.actualizar(em);
                    request.getRequestDispatcher("ServletControlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    idE = Integer.parseInt(request.getParameter("id"));
                    edao.delete(idE);
                    request.getRequestDispatcher("ServletControlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        }

        if (menu.equals("Clientes")) {
            switch (accion) {
                case "Listar":
                    List lista = cdao.listar();
                    request.setAttribute("clientes", lista);
                    break;
                case "Agregar":
                    String dni = request.getParameter("txtDniC");
                    String nom = request.getParameter("txtNombresC");
                    String drc = request.getParameter("txtDireccionC");
                    String est = request.getParameter("txtEstadoC");
                    cl.setDni(dni);
                    cl.setNombres(nom);
                    cl.setDireccion(drc);
                    cl.setEstado(est);
                    cdao.agregar(cl);
                    request.getRequestDispatcher("ServletControlador?menu=Clientes&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String dniC = request.getParameter("txtDniC");
                    String nomC = request.getParameter("txtNombresC");
                    String drcC = request.getParameter("txtDireccionC");
                    String estC = request.getParameter("txtEstadoC");
                    cl.setDni(dniC);
                    cl.setNombres(nomC);
                    cl.setDireccion(drcC);
                    cl.setEstado(estC);
                    cl.setId(idC);
                    cdao.actualizar(cl);
                    request.getRequestDispatcher("ServletControlador?menu=Clientes&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idC = Integer.parseInt(request.getParameter("id"));
                    Cliente c = cdao.listarId(idC);
                    request.setAttribute("cliente", c);
                    request.getRequestDispatcher("ServletControlador?menu=Clientes&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    idC = Integer.parseInt(request.getParameter("id"));
                    cdao.delete(idC);
                    request.getRequestDispatcher("ServletControlador?menu=Clientes&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();

            }
            request.getRequestDispatcher("Clientes.jsp").forward(request, response);
        }

        if (menu.equals("Producto")) {
            switch (accion) {
                case "Listar":
                    List lista = pdao.listar();
                    request.setAttribute("productos", lista);
                    break;
                case "Agregar":
                    String nom = request.getParameter("txtNombres");
                    String prc = request.getParameter("txtPrecio");
                    String stk = request.getParameter("txtStock");
                    String est = request.getParameter("txtEstado");
                    pt.setNombre(nom);
                    pt.setPrecio(Double.parseDouble(prc));
                    pt.setStock(Integer.parseInt(stk));
                    pt.setEstado(est);
                    pdao.agregar(pt);
                    request.getRequestDispatcher("ServletControlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String nomP = request.getParameter("txtNombres");
                    String prcP = request.getParameter("txtPrecio");
                    String stkP = request.getParameter("txtStock");
                    String estP = request.getParameter("txtEstado");
                    pt.setNombre(nomP);
                    pt.setPrecio(Double.parseDouble(prcP));
                    pt.setStock(Integer.parseInt(stkP));
                    pt.setEstado(estP);
                    pt.setId(idP);
                    pdao.actualizar(pt);
                    request.getRequestDispatcher("ServletControlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idP = Integer.parseInt(request.getParameter("id"));
                    Producto p = pdao.listarId(idP);
                    request.setAttribute("producto", p);
                    String jspEditarProducto = "/WEB-INF/vistas/producto/editProducto.jsp";
                    request.getRequestDispatcher(jspEditarProducto).forward(request, response);
                    break;
                case "Eliminar":
                    idP = Integer.parseInt(request.getParameter("id"));
                    pdao.delete(idP);
                    request.getRequestDispatcher("ServletControlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }

        if (menu.equals("RegistrarVenta")) {
            switch (accion) {
                case "BuscarCliente":
                    String dni = request.getParameter("codigoCliente");
                    cl.setDni(dni);
                    cl = cdao.buscar(dni);
                    request.setAttribute("lista", lista);
                    request.setAttribute("c", cl);
                    request.setAttribute("nserie", numeroserie);
                break;
                case "BuscarProducto":
                    int id = Integer.parseInt(request.getParameter("codigoProducto"));
                    pt = pdao.listarId(id);
                    request.setAttribute("c", cl);
                    request.setAttribute("lista", lista);
                    request.setAttribute("producto", pt);
                    request.setAttribute("totalpagar", totalPagar);
                    request.setAttribute("nserie", numeroserie);
                break;
                case "Agregar":
                    totalPagar = 0.0;
                    item = item+1;
                    cod=pt.getId();
                    dProducto = request.getParameter("nombresProducto");
                    precio = Double.parseDouble(request.getParameter("precio"));
                    cant = Integer.parseInt(request.getParameter("cantidad"));
                    total = precio * cant;
                    v = new Venta();
                    v.setItem(item);
                    v.setId_producto(cod);
                    v.setdProducto(dProducto);
                    v.setPrecio(precio);
                    v.setCantidad(cant);
                    v.setTotal(total);
                    lista.add(v);
                    for(int i = 0; i < lista.size(); i++){
                        totalPagar = totalPagar + lista.get(i).getTotal();
                    }
                    request.setAttribute("nserie", numeroserie);
                    request.setAttribute("totalpagar", totalPagar);
                    request.setAttribute("lista", lista);
                    request.setAttribute("c", cl);
                break;
                case "GenerarVenta":
                    v.setId_cliente(cl.getId());
                    v.setId_empleado(12);
                    v.setFecha("2020-12-12");
                    v.setMonto(totalPagar);
                    v.setEstado("1");
                    
                    vdao.guardarVenta(v);
//                    //Guardar detalle de la venta
//                    int idv = Integer.parseInt(vdao.idVentas());
//                    for (int i = 0; i < lista.size(); i++) {
//                        v = new Venta();
//                        v.setId(idv);
//                        v.setId(lista.get(i).getId_producto());
//                        v.setCantidad(lista.get(i).getCantidad());
//                        v.setPrecio(lista.get(i).getPrecio());
//                        vdao.guardarDetalleVenta(v);
//                    }
                break;
                default:
                    numeroserie = vdao.generarSerie();
                    if(numeroserie.isEmpty()){
                        numeroserie = "00000001";
                        request.setAttribute("nserie", numeroserie);
                    }else{
                        int incrementar = Integer.parseInt(numeroserie);
                        GenerarSerie gs = new GenerarSerie();
                        numeroserie = gs.NumeroSerie(incrementar);
                        request.setAttribute("nserie", numeroserie);
                    }
                request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
            }
            request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
