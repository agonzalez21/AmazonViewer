package com.platzi.amazonviewer.model;
import java.util.Date;

public interface IVisualizable {
	public Date startToSee(Date dateI);
	void stopToSee(Date dateI, Date dateF);
}
