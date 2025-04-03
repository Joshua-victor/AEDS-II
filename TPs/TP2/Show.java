import java.util.Date;

public class Show {
    
    private String showId;
    private String type;
    private String title;
    private String director;
    private String[] cast;
    private String country;
    private LocalDate dateAdded;
    private int releaseYear;
    private String rating;
    private String duration;
    private String[] listedIn;

    // Construtor  (o nome do contrutor deve ser o mesmo da classe) (usados para inicializar os atributos da classe)
    public Show(String showId, String type, String title, String director, String[] cast, String country, 
                LocalDate dateAdded, int releaseYear, String rating, String duration, String[] listedIn) {
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
    
    public LocalDate getDateAdded() {
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

    public void setDateAdded(LocalDate dateAdded) {
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
}
