package ec.edu.ups.Model;

public enum Category {
	ALIMENTOS("Alimentos"),
	AUTOMOTRIZ("Automotriz"),
	BAR("Bar"),
	BELLEZA("Belleza"),
	BEBES("Bebes"),
	CELULARES("Celulares"),
	GIMNASIO("Gimnasio"),
	HOGAR("Hogar"),
	HOTELERIA("Hoteleria"),
	MASCOTAS("Mascotas"),
	MECANICA("Mecanica"),
	MUSICA("Musica"),
	OFICINA("Oficina"),
	OTROS("Otros"),
	ROPA("Ropa"),
	SALUD("Salud"),
	TECNOLOGIA("Tecnologia"),
	TIENDA("Tienda"),
	TRANSPORTE("Transporte");
	
	private String category;
	
	private Category(String category) {
		this.category = category;
	}

	public String getCategory() {
		return category;
	}
}