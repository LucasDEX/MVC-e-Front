package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Area;
import service.AreaService;

public class IncluirArea implements Command {
	
	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pId = request.getParameter("id");
		String pNome = request.getParameter("nome");
		
		int id = -1;
		try {
			id = Integer.parseInt(pId);
		} catch (NumberFormatException e) {

		}

		Area area = new Area();
		area.setId(id);
		area.setNome(pNome);
	
		AreaService cs = new AreaService();

		RequestDispatcher view = null;
		HttpSession session = request.getSession();

		cs.criar(area);
		ArrayList<Area> lista = new ArrayList<>();
		lista.add(area);
		session.setAttribute("area", lista);
		view = request.getRequestDispatcher("Area.jsp");

		view.forward(request, response);

	}

	public int busca(Area area, ArrayList<Area> lista) {
		Area to;
		for (int i = 0; i < lista.size(); i++) {
			to = lista.get(i);
			if (to.getId() == area.getId()) {
				return i;
			}
		}
		return -1;
	}
}
