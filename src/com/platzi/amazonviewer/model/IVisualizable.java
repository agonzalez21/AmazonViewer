package com.platzi.amazonviewer.model;
import java.util.Date;

public interface IVisualizable {
	
	/**
	 * Éste método captura el tiempo de inicio de visualización.
	 * @param dateI Es un Objeto {@code Date} con el tiempo de inicio exacto.
	 * @return Devuelve la fecha y hora capturado.
	 * */
	public Date startToSee(Date dateI);
	
	/**
	 * Éste método captura el tiempo exacto de inicio y final de visualización.
	 * @param dateI Es un objeto {@code Date} con el tiempo de inicio exacto.
	 * @param dateF Es un objeto {@code Date} con el tiempo de fin exacto.
	 * */
	void stopToSee(Date dateI, Date dateF);
}
