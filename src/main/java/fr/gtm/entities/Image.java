package fr.gtm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "images")
public class Image {
	@Id
	@Column(name = "image")
	private String image;
	@Column(name = "fk_destination")
	private long fkDestination;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public long getFkDestination() {
		return fkDestination;
	}

	public void setFkDestination(long fkDestination) {
		this.fkDestination = fkDestination;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
