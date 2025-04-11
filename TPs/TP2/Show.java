import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Show {
    
    private String showId;
    private String type;
    private String title;
    private String director;
    private String[] cast;
    private String country;
    private Date dateAdded;
    private int releaseYear;
    private String rating;
    private String duration;
    private String[] listedIn;
    
    
    
    public Show(){
        
        this.showId = "";
        this.type = "";
        this.title = "";
        this.director = "";
        this.cast = null;
        this.country = "";
        this.dateAdded = null;
        this.releaseYear = 0;
        this.rating = "";
        this.duration = "";
        this.listedIn = null;
        
        
        
    }
    
    // Construtor  (o nome do contrutor deve ser o mesmo da classe) (usados para inicializar os atributos da classe)
    public Show(String showId, String type, String title, String director, String[] cast, String country, 
                Date dateAdded, int releaseYear, String rating, String duration, String[] listedIn) {
        this.showId = showId;
        this.type = type;
        this.title = title;
        this.director = director;
        this.cast = cast;
        this.country = country;
        this.dateAdded = dateAdded;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.duration = duration;
        this.listedIn = listedIn;
    }
    
    //Os getters e setters são métodos que servem para acessar e modificar os atributos de um objeto de forma controlada.)

    // Getters Pegam valores dos atributos
    public String getShowId() {
        return this.showId;
    }
    
    public String getType() {
        return this.type;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public String getDirector() {
        return this.director;
    }
    
    public String[] getCast() {
        return this.cast;
    }
    
    public String getCountry() {
        return this.country;
    }
    
    public Date getDateAdded() {
        return this.dateAdded;
    }
    
    public int getReleaseYear() {
        return this.releaseYear;
    }
    
    public String getRating() {
        return this.rating;
    }
    
    public String getDuration() {
        return this.duration;
    }
    
    public String[] getListedIn() {
        return this.listedIn;
    }
    
    

    // Setters Alteram valores dos atributos
    public void setShowId(String showId) {
        this.showId = showId;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setCast(String[] cast) {
        this.cast = cast;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setListedIn(String[] listedIn) {
        this.listedIn = listedIn;
    }
    
    //clone
    public Show clone(){
        
        return new Show(this.showId, this.type, this.title, this.director, this.cast, this.country, this.dateAdded, this.releaseYear, this.rating, this.duration, this.listedIn);
    
    }
    
    
    public void mostrar() {

        System.out.println("=>"
            + this.getShowId() + " ## "
            + this.getType() + " ## "
            + this.getTitle() + " ## "
            + (this.getDirector() == "" ? "NaN" : this.getDirector()) + " ## "
            +"[" + (this.getCast() == null ? "NaN" : this.getCast()) + "] " + " ## "
            + (this.getCountry() == "" ? "NaN" : this.getCountry()) + " ## "
            + (this.getDateAdded() == null ? "NaN" : this.getDateAdded()) + " ## "
            + (this.getReleaseYear() == 0 ? "NaN" : this.getReleaseYear()) + " ## "
            + (this.getRating() == null ? "NaN" : this.getRating()) + " ## "
            + (this.getDuration() == "" ? "NaN" : this.getDuration()) + " ## "
            +"[" + (this.getListedIn() == null ? "NaN" : this.getListedIn()) + "] " + " ## ");
    }
    
    
    public void ler(String linha){
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM d, yyyy");
        
       try{
           
           String[] partes = linha.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1); // split para separar cada atributo mesmo com virgulas dentro de aspas
           
           this.showId = partes[0];
           this.type = partes[1];
           this.title = partes[2];
           this.director = partes[3].isEmpty() ? "NaN" : partes[3]; // if partes[3] vazia this.director = "NaN" else this.director = partes[3]
           this.cast = partes[4].isEmpty() ? new String[] { "NaN" } : partes[4].replace("\"", "").split(",");;
           this.country = partes[5].isEmpty() ? "NaN" : partes[5];
           try {
             this.dateAdded = partes[6].isEmpty() ? null : sdf.parse(partes[6]); //sdf.parse serve para converter uma string em formato de date
            } catch (Exception e) {
                this.dateAdded = null;
               }
           this.releaseYear = partes[7].isEmpty() ? 0 : Integer.parseInt(partes[7]);
           this.rating = partes[8].isEmpty() ? "NaN" : partes[8];
           this.duration = partes[9].isEmpty() ? "NaN" : partes[9];
           this.listedIn = partes[10].isEmpty() ? new String[] { "NaN" } : partes[10].replace("\"", "").split(",");;
           
       } catch(Exception e){
           
           System.out.println("Erro ao ler a linha" + linha);
           
       }
        

    }
    
    

    
}
