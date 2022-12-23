package model;

public class Series
{
    private int id;
    private String Nombre;
    private int Lanzamiento;
    private int Temporadas;
    private String Plataforma;
    
    public Series(final int id, final String Nombre, final int Lanzamiento, final int Temporadas, final String Plataforma) {
        this.id = id;
        this.Nombre = Nombre;
        this.Lanzamiento = Lanzamiento;
        this.Temporadas = Temporadas;
        this.Plataforma = Plataforma;
    }
    
    public Series(final String Nombre, final int Lanzamiento, final int Temporadas, final String Plataforma) {
        this.Nombre = Nombre;
        this.Lanzamiento = Lanzamiento;
        this.Temporadas = Temporadas;
        this.Plataforma = Plataforma;
    }
    
    public Series() {
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(final int id) {
        this.id = id;
    }
    
    public String getNombre() {
        return this.Nombre;
    }
    
    public void setNombre(final String Nombre) {
        this.Nombre = Nombre;
    }
    
    public int getLanzamiento() {
        return this.Lanzamiento;
    }
    
    public void setLanzamiento(final int Lanzamiento) {
        this.Lanzamiento = Lanzamiento;
    }
    
    public int getTemporadas() {
        return this.Temporadas;
    }
    
    public void setTemporadas(final int Temporadas) {
        this.Temporadas = Temporadas;
    }
    
    public String getPlataforma() {
        return this.Plataforma;
    }
    
    public void setPlataforma(final String Plataforma) {
        this.Plataforma = Plataforma;
    }
    
    @Override
    public String toString() {
        return "Series{id=" + this.id + ", Nombre=" + this.Nombre + ", Lanzamiento=" + this.Lanzamiento + ", Temporada=" + this.Temporadas + ", Plataforma=" + this.Plataforma + '}';
    }
}