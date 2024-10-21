import java.util.Scanner;  // Importa a classe Scanner
import java.util.List;          // Importa a interface List
import java.util.ArrayList;     // Importa a  ArrayList
import java.util.Date;          // para a data
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.util.Collections;   // Import para usar Collections.sort
import java.util.Comparator;    // Import para usar o Comparator


class Pokemon {
	// Atributos da classe
	private int id;
	private int generation;
	private String name;
	private String description;
	private List<String> types;
	private List<String> abilities;
	private double weight;
	private double height;
	private int captureRate;
	private boolean isLegendary;
	private Date captureDate;  // Atributo para armazenar a data


	public Pokemon() {

		this.id = 0;
		this.generation = 0;
		this.name = "";
		this.description = "";
		this.types = new ArrayList<String>();
		this.abilities = new ArrayList<String>();
		this.weight = 0.0;
		this.height = 0.0;
		this.captureRate = 0;
		this.isLegendary = false;
		this.captureDate = new Date();

	}

	public Pokemon(String[] auxiliariliar) throws Exception
	{
		
		for (int i = 0; i < auxiliariliar.length; i++){
		    if (auxiliariliar[i].isEmpty()) auxiliariliar[i] = "0";
		}
		
		this.id = Integer.parseInt(auxiliariliar[0]);
		
		this.generation = Integer.parseInt(auxiliariliar[1]);

		this.name = auxiliariliar[2];
		
		this.description = auxiliariliar[3];

		this.types = new ArrayList<>();
		auxiliariliar[4] = "'" + auxiliariliar[4] + "'";
		this.types.add(auxiliariliar[4]);
		if (auxiliariliar[5] != "0") {
			auxiliariliar[5] = "'" + auxiliariliar[5].trim() + "'";
			this.types.add(auxiliariliar[5]);
		}
		
		auxiliariliar[6] = auxiliariliar[6].replace("\"", "");
		auxiliariliar[6] = auxiliariliar[6].replace("[", "");
		auxiliariliar[6] = auxiliariliar[6].replace("]", "");
		String[] tmp = auxiliariliar[6].split(",");
		this.abilities = new ArrayList<>();
		for (String s : tmp) abilities.add(s.trim());

		this.weight = Double.parseDouble(auxiliariliar[7]);
		
		this.height = Double.parseDouble(auxiliariliar[8]);

		this.captureRate = Integer.parseInt(auxiliariliar[9]);

		this.isLegendary = (auxiliariliar[10].equals("1") ? true : false);

		if (auxiliariliar[11].isEmpty())
		{
			this.captureDate = null;
		} else
		{
			SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
			this.captureDate = inputDateFormat.parse(auxiliariliar[11]);
		}
	}

	// Construtor da classe
	public Pokemon(int id, int generation, String name, String description, List<String> types, List<String> abilities, double weight, double height, int captureRate, boolean isLegendary, Date captureDate ) {
		this.id = id;
		this.generation = generation;
		this.name = name;
		this.description = description;
		this.types = types;
		this.abilities = abilities;
		this.weight = weight;
		this.height = height;
		this.captureRate = captureRate;
		this.isLegendary = isLegendary;
		this.captureDate = captureDate;
	}

	
	//getters
public int getId() {
		return id;
	}
	public int getGeneration() {
		return generation;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public List<String> getTypes() {
		return types;
	}
	public List<String> getAbilities() {
		return abilities;
	}
	public double getWeight() {
		return weight;
	}
	public double getHeight() {
		return height;
	}
	public int getcCaptureRate() {
		return captureRate;
	}
	public boolean getIsLegendary() {
		return isLegendary;
	}
	public Date getCaptureDate() {
		return captureDate;
	}



	// setters
	public void setId(int id) {
		this.id = id;
	}
	public void setGeneration(int generation) {
		this.generation = generation;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setTypes(List<String> types) {
		this.types = types;
	}
	public void setAbilities(List<String> abilities) {
		this.abilities = abilities;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public void setCaptureRate(int captureRate) {
		this.captureRate = captureRate;
	}
	public void setIsLegendary(boolean isLegendary) {
		this.isLegendary = isLegendary;
	}
	public void setCaptureDate(Date captureDate) {
		this.captureDate = captureDate;
	}

	public Pokemon clone() {
		return new Pokemon(this.id, this.generation, this.name, this.description, this.types, this.abilities, this.weight, this.height, this.captureRate, this.isLegendary, this.captureDate);
	}




	public String toString()
	{
		SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String formattedDate = (captureDate != null) ? outputDateFormat.format(captureDate) : "erro";

		return "[#" + id + " -> " + name + ": " + description +
		       " - " + types + " - " + abilities +
		       " - " + weight + "kg - " + height + "m - " +
		       captureRate + "% - " + isLegendary +
		       " - " + generation + " gen] - " + formattedDate;
	}


}

class PokemonSearch {

	public static Pokemon searchPokemonId(List<Pokemon> pokemons, int id)
	{
		for (Pokemon pokemon : pokemons)
		{
			if (pokemon.getId() == id)
			{
				return pokemon;
			}
		}
		return null;
	}
}


class ReadCsv {
	public static List<Pokemon> readAllFile(final String fileToRead)
	{
		List<Pokemon> ListaPokemons = new ArrayList<>();

		try
		{
			BufferedReader br = new BufferedReader(new FileReader(fileToRead));

			
			br.readLine(); // pular primeira linha

			// Ler linha por linha
			String csvLine = new String();
			while((csvLine = br.readLine()) != null)
			{
				
				csvLine = lineFormat(csvLine);
				Pokemon pessoa = new Pokemon(csvLine.split(";"));
				ListaPokemons.add(pessoa);
			}

			br.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			ListaPokemons = null;
		}

		
		return ListaPokemons;
	}


	private static String lineFormat(String line)
	{
		char[] array_auxiliar = line.toCharArray();
		boolean in_list = false;
		for (int i = 0; i < array_auxiliar.length; i++)
		{
			if (!in_list && array_auxiliar[i] == ',') array_auxiliar[i] = ';'; // substiui , para ; menos dos []
			else if (array_auxiliar[i] == '"') in_list = !in_list;
		}

		return new String(array_auxiliar);
	}

}


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String input_string;
        int input_int;

        // Lista com todos os Pokémons carregados do arquivo CSV
        List<Pokemon> pokemons = ReadCsv.readAllFile("/tmp/pokemon.csv"); 

        // Lista que armazenará os Pokémons encontrados
        List<Pokemon> usados = new ArrayList<>(); 

        // Lê IDs até que o usuário digite "FIM"
        while (!(input_string = scanner.nextLine()).equals("FIM")) {  
            input_int = Integer.parseInt(input_string);
            Pokemon encontrado = PokemonSearch.searchPokemonId(pokemons, input_int);
            if (encontrado != null) {
                usados.add(encontrado);  
            }
        }

  
        Collections.sort(usados, new Comparator<Pokemon>() {
            @Override
            public int compare(Pokemon p1, Pokemon p2) {
                return p1.getName().compareTo(p2.getName());
            }
        });

        for (int i = 0; i < 10 && i < usados.size(); i++) {
    System.out.println(usados.get(i));
}
    }
}
