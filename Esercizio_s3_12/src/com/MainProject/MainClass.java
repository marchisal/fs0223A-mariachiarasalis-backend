package com.MainProject;

import java.sql.SQLException;
import java.time.LocalDate;

import com.classes.Evento;
import com.classes.EventoDAO;
import com.enums.TipoEvento;

public class MainClass {

	public static void main(String[] args) {

		Evento e1 = new Evento("Matrimonio", LocalDate.of(2000, 12, 4), "molto bello", TipoEvento.PRIVATO, 800);
		Evento e2 = new Evento("Sant'Efisio", LocalDate.of(2023, 5, 1), "molto religioso", TipoEvento.PUBBLICO, 165000);

		try {
			EventoDAO eventoDao = new EventoDAO();
			//eventoDao.salvaEvento(e1);
			//eventoDao.salvaEvento(e2);
			eventoDao.cancellaEvento(2);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
