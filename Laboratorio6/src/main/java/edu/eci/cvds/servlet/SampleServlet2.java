package edu.eci.cvds.servlet.model;

import edu.eci.cvds.servlet.Service;
import edu.eci.cvds.servlet.model.Todo;

import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.nio.charset.MalformedInputException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        urlPatterns = "/newServlet"
)
public class SampleServlet2 extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Writer responseWriter = resp.getWriter();
        Optional<String> optName = Optional.ofNullable(req.getParameter("id"));
        String id = optName.isPresent() && !optName.get().isEmpty() ? optName.get() : "";

        try {
            Todo item = Service.getTodo(Integer.parseInt(id));
            List<Todo> listasDeCosas = new ArrayList<Todo>();
            listasDeCosas.add(item);
            resp.setStatus(HttpServletResponse.SC_OK);
            responseWriter.write(Service.todosToHTMLTable(listasDeCosas));
            responseWriter.flush();

        }catch (NoSuchElementException e){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }catch (MalformedURLException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }catch (NumberFormatException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Writer responseWriter = resp.getWriter();

        try {
            Todo item = Service.getTodo(Integer.parseInt("id"));
            List<Todo> listasDeCosas = new ArrayList<Todo>();
            listasDeCosas.add(item);
            resp.setStatus(HttpServletResponse.SC_OK);
            responseWriter.write(Service.todosToHTMLTable(listasDeCosas));
            responseWriter.flush();

        }catch (NoSuchElementException e){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }catch (MalformedURLException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }catch (NumberFormatException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}