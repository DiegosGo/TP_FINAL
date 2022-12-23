package controller;

import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;
import java.util.function.Consumer;
import data.SeriesDAO;
import model.Series;
import java.util.List;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet({ "/servletControlador" })
public class ServletControlador extends HttpServlet
{
    protected void doGet(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
        final String accionJava = req.getParameter("accion");
        if (accionJava != null) {
            final String s = accionJava;
            switch (s) {
                case "editar": {
                    try {
                        this.editarSerie(req, res);
                    }
                    catch (ClassNotFoundException ex) {
                        ex.printStackTrace(System.out);
                    } catch (SQLException ex) {
                    Logger.getLogger(ServletControlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                    break;
                }
                default: {
                   
                try {
                    this.accionDefault(req, res);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ServletControlador.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(ServletControlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                    
                    break;
                }
                case "eliminar": {
                    try {
                        this.eliminarSerie(req, res);
                    }
                    catch (ClassNotFoundException ex) {
                        ex.printStackTrace(System.out);
                    } catch (SQLException ex) {
                    Logger.getLogger(ServletControlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                    break;
                }
            }
        }
        else {
            try {
                this.accionDefault(req, res);
            }
            catch (ClassNotFoundException ex2) {
                ex2.printStackTrace(System.out);
            } catch (SQLException ex) {
                Logger.getLogger(ServletControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    protected void doPost(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
        final String accionJava = req.getParameter("accion");
        if (accionJava != null) {
            final String s = accionJava;
            switch (s) {
                case "insertar": {
                    try {
                        this.insertarSerie(req, res);
                    }
                    catch (ClassNotFoundException ex) {
                        ex.printStackTrace(System.out);
                    } catch (SQLException ex) {
                    Logger.getLogger(ServletControlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                    break;
                }
                case "modificar": {
                    try {
                        this.modificarSerie(req, res);
                    }
                    catch (ClassNotFoundException ex) {
                        ex.printStackTrace(System.out);
                    } catch (SQLException ex) {
                    Logger.getLogger(ServletControlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                    break;
                }
                default: {
                    try {
                        this.accionDefault(req, res);
                    }
                    catch (ClassNotFoundException ex) {
                        ex.printStackTrace(System.out);
                    } catch (SQLException ex) {
                    Logger.getLogger(ServletControlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                    break;
                }
            }
        }
        else {
            try {
                this.accionDefault(req, res);
            }
            catch (ClassNotFoundException ex2) {
                ex2.printStackTrace(System.out);
            } catch (SQLException ex) {
                Logger.getLogger(ServletControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private Integer calcularTemporadas(final List<Series> seriesLista) {
        Integer cantidad = 0;
        for (int i = 0; i < seriesLista.size(); ++i) {
            cantidad += seriesLista.get(i).getTemporadas();
        }
        return cantidad;
    }
    
    private void accionDefault(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException, ClassNotFoundException, SQLException {
        final List<Series> series = new SeriesDAO().seleccionar();
        series.forEach(System.out::println);
        final HttpSession sesion = req.getSession();
        sesion.setAttribute("series", (Object)series);
        sesion.setAttribute("totalSeries", (Object)series.size());
        sesion.setAttribute("totalTemporadas", (Object)this.calcularTemporadas(series));
        res.sendRedirect("series.jsp");
    }
    
    private void insertarSerie(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException, ClassNotFoundException, SQLException {
        final String nombre = req.getParameter("nombre");
        final String lanzamientoString = req.getParameter("lanzamiento");
        int lanzamiento = 0;
        int temporadas = 0;
        if (lanzamientoString != null && !lanzamientoString.equals(" ")) {
            lanzamiento = Integer.parseInt(lanzamientoString);
        }
        final String temporadasString = req.getParameter("temporadas");
        if (temporadasString != null && !temporadasString.equals(" ")) {
            temporadas = Integer.parseInt(temporadasString);
        }
        final String plataforma = req.getParameter("plataforma");
        final Series serie = new Series(nombre, lanzamiento, temporadas, plataforma);
        final int regMod = new SeriesDAO().insertar(serie);
        System.out.println("Registros guardados: " + regMod);
        this.accionDefault(req, res);
    }
    
    private void editarSerie(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException, ClassNotFoundException, SQLException {
        final int id = Integer.parseInt(req.getParameter("id"));
        final Series serie = new SeriesDAO().seleccionarPorId(id);
        req.setAttribute("serie", (Object)serie);
        final String jspEditar = "/WEB-INF/paginas/operaciones/editarSerie.jsp";
        req.getRequestDispatcher(jspEditar).forward((ServletRequest)req, (ServletResponse)res);
    }
    
    private void modificarSerie(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException, ClassNotFoundException, SQLException {
        final int idserie = Integer.parseInt(req.getParameter("id"));
        final String nombre = req.getParameter("nombre");
        final String lanzamientoString = req.getParameter("lanzamiento");
        int lanzamiento = 0;
        int temporadas = 0;
        if (lanzamientoString != null && !lanzamientoString.equals(" ")) {
            lanzamiento = Integer.parseInt(lanzamientoString);
        }
        final String temporadasString = req.getParameter("temporadas");
        if (temporadasString != null && !temporadasString.equals(" ")) {
            temporadas = Integer.parseInt(temporadasString);
        }
        final String plataforma = req.getParameter("plataforma");
        final Series serie = new Series(idserie, nombre, lanzamiento, temporadas, plataforma);
        final int regMod = new SeriesDAO().actualizar(serie);
        System.out.println("Registros actualizados: " + regMod);
        this.accionDefault(req, res);
    }
    
    private void eliminarSerie(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException, ClassNotFoundException, SQLException {
        final int idSerie = Integer.parseInt(req.getParameter("id"));
        final int regBorrados = new SeriesDAO().eliminar(idSerie);
        System.out.println("Registros eliminados: " + regBorrados);
        this.accionDefault(req, res);
    }
}
