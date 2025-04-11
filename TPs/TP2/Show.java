import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Arrays;





 class Show {
    
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
        SimpleDateFormat formater = new SimpleDateFormat("MMM dd, yyyy"); // formato para alinhar a data igual o csv

         System.out.println("=> "
        + this.getShowId() + " ## "
        + this.getTitle() + " ## "
        + this.getType() + " ## "
        + this.getDirector() + " ## "
        + Arrays.toString(this.getCast()) + " ## "
        + this.getCountry() + " ## "
        + formater.format(this.getDateAdded()) + " ## "
        + this.getReleaseYear() + " ## "
        + this.getRating() + " ## "
        + this.getDuration() + " ## "
        + Arrays.toString(this.getListedIn()) + " ## ");
    }
    
    
    public void ler(String linha){
       SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy");
       // System.out.print("ENTREI");
        
       try{
           
           String[] partes = linha.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1); // split para separar cada atributo mesmo com virgulas dentro de aspas

           this.showId = partes[0]; // alocando em showId a posição 0 de partes
           this.type = partes[1]; // alocando em type a posição 1 de partes
           this.title = partes[2].replaceAll("^\"|\"$", "").replaceAll("\"\"", ""); // alocando em title a posição 2 de partes
           this.director = partes[3].isEmpty() ? "NaN" : partes[3]; // if partes[3] vazia this.director = "NaN" else this.director = partes[3]
           this.cast = partes[4].isEmpty() ? new String[] { "NaN" } : partes[4].replace("\"", "").split(",");;
           this.country = partes[5].isEmpty() ? "NaN" : partes[5]; // alocando em country a posição 5 de partes
           try {
             this.dateAdded = partes[6].isEmpty() ? null : sdf.parse(partes[6].replaceAll("^\"|\"$", "").replaceAll("\"\"", "")); //sdf.parse serve para converter uma string em formato de date
            } catch (Exception e) {
                this.dateAdded = null;
               }
           this.releaseYear = partes[7].isEmpty() ? 0 : Integer.parseInt(partes[7]); //Integer.parseInt usado para trasnformar uma string em Int
           this.rating = partes[8].isEmpty() ? "NaN" : partes[8];// alocando em rating a posição 8 de partes
           this.duration = partes[9].isEmpty() ? "NaN" : partes[9];// alocando em duration a posição 9 de partes
           this.listedIn = partes[10].isEmpty() ? new String[] { "NaN" } : partes[10].replace("\"","").split(",");
           
       } catch(Exception e){
           
           System.out.println("Erro ao ler a linha" + linha);
       }
    }
}



public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> lista = new ArrayList<>();

        // Lê todos os IDs digitados
        while (true) {
            String linha = scanner.nextLine();
            if (linha.equalsIgnoreCase("FIM")) break;
            lista.add(linha);
        }

       
       BufferedReader br = new BufferedReader(new FileReader("disneyplus.csv")); // leitura do arquivo 
       String CSV;
       br.readLine(); //pula a primeira linha do cabeçalho do CSV
       
       while((CSV = br.readLine()) != null){
           
           Show show = new Show();
           show.ler(CSV);
           
           if (lista.contains(show.getShowId())) {
                show.mostrar();
           }
           
   
       }
       
       br.close();
}
}


