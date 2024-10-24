import java.time.*;
import java.util.*;
import java.io.*;
import java.text.*;

class TP {
    private long startTime, endTime;

    public void startTime() {
        startTime = System.nanoTime();
    }

    public void endTime() {
        endTime = System.nanoTime();
    }

    public double Time() {
        return (endTime - startTime) / 1000000;
    }

    private int comp = 0, mov = 0;

    public void addMov(int i) {
        this.mov += i;
    }

    public void addComp(int i) {
        this.comp += i;
    }

    public void pesquisaFile(String name) {
        try {
            PrintWriter write = new PrintWriter(new FileWriter(name));

            write.printf("Matrícula: 789339\t");
            write.printf("Tempo de execução: " + Time() + "ms" + "\t");
            write.printf("Comparações: " + comp);

            write.close();
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void ordenacaoFile(String name) {
        try {
            PrintWriter write = new PrintWriter(new FileWriter(name));

            write.printf("Matrícula: 789339\t");
            write.printf("Tempo de execução: " + Time() + "ms" + "\t");
            write.printf("Comparações: " + comp + "\t");
            write.printf("Movimentações: " + mov);

            write.close();
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

class Pokemon {

    private int id;
    private int generation;
    private String name;
    private String description;
    private ArrayList<String> types;
    private ArrayList<String> abilities;
    private Double weight;
    private Double height;
    private int captureRate;
    private boolean legendary;
    private Date captureDate;

    public Pokemon() {
        this.id = 0;
        this.generation = 0;
        this.name = "";
        this.description = "";
        this.types = new ArrayList<>();
        this.abilities = new ArrayList<>();
        this.weight = 0.0;
        this.height = 0.0;
        this.captureRate = 0;
        this.legendary = false;
        this.captureDate = new Date();
    }

    public Pokemon(int id, int generation, String name, String description, ArrayList<String> types,
            ArrayList<String> abilities,
            Double weight,
            Double height, int captureRate, boolean legendary, Date captureDate) {
        this.id = id;
        this.generation = generation;
        this.name = name;
        this.description = description;
        this.types = types;
        this.abilities = abilities;
        this.weight = weight;
        this.height = height;
        this.captureRate = captureRate;
        this.legendary = legendary;
        this.captureDate = captureDate;
    }

    public void setAbilities(ArrayList<String> abilities) {
        this.abilities = abilities;
    }

    public ArrayList<String> getAbilities() {
        return abilities;
    }

    public void setCaptureDate(Date captureDate) {
        this.captureDate = captureDate;
    }

    public Date getCaptureDate() {
        return captureDate;
    }

    public void setCaptureRate(int captureRate) {
        this.captureRate = captureRate;
    }

    public int getCaptureRate() {
        return captureRate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public int getGeneration() {
        return generation;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getHeight() {
        return height;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setLegendary(boolean legendary) {
        this.legendary = legendary;
    }

    public boolean isLegendary() {
        return legendary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTypes(ArrayList<String> types) {
        this.types = types;
    }

    public ArrayList<String> getTypes() {
        return types;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getWeight() {
        return weight;
    }
 

    public Pokemon myClone() {
        Pokemon clonado = new Pokemon(id, generation, name, description, types, abilities,
                weight,
                height, captureRate, legendary, captureDate);

        return clonado;
    }

    private ArrayList<String> formatTypes(String type1, String type2) {
        ArrayList<String> types = new ArrayList<>();
        if (type1 != "") {
            String type1Fixed = "\'" + type1 + "\'";
            types.add(type1Fixed.trim());
        }
        if (type2 != "") {
            String type2Fixed = "\'" + type2 + "\'";
            types.add(type2Fixed.trim());
        }
        return types;
    }

    private ArrayList<String> formatAbilitieList(String listAbilities) {
        ArrayList<String> abilities = new ArrayList<>();

        String splitted[] = listAbilities.split(",");
        for (int i = 0; i < splitted.length; i++) {
            abilities.add(splitted[i].trim());
        }

        return abilities;
    }

    public void ler(String line) {
        String newLine = "";
        boolean insideQuotes = false;
        int tam = line.length();

        for (int i = 0; i < tam; i++) {
            char currentChar = line.charAt(i);

            if (currentChar == '"') {
                insideQuotes = !insideQuotes;
            }

            if (!insideQuotes) {

                if (currentChar == ',') {
                    newLine += ';';
                } else if (currentChar != '\"') {
                    newLine += currentChar;
                }
            } else {

                if (currentChar != '"' && currentChar != '[' && currentChar != ']') {
                    newLine += currentChar;
                }
            }
        }

        line = newLine;

        String splitted[] = line.split(";");

        try {
            setId(Integer.parseInt(splitted[0]));
            setGeneration(Integer.parseInt(splitted[1]));
            setName(splitted[2]);
            setDescription(splitted[3]);

            setTypes(formatTypes(splitted[4], splitted[5]));

            setAbilities(formatAbilitieList(splitted[6]));

            if (!splitted[7].isEmpty()) {
                setWeight(Double.parseDouble(splitted[7]));
            }

            if (!splitted[8].isEmpty()) {
                setHeight(Double.parseDouble(splitted[8]));
            }

            setCaptureRate(Integer.parseInt(splitted[9]));

            setLegendary(splitted[10].equals("1"));

            SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
            setCaptureDate(formater.parse(splitted[11]));

        } catch (NumberFormatException e) {
            System.err.println("Erro ao converter número: " + e.getMessage());
        } catch (ParseException e) {
            System.err.println("Erro ao formatar data: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Erro: dados insuficientes. Verifique o número de campos.");
        } catch (NullPointerException e) {
            System.err.println("Erro: dado nulo encontrado.");
        } catch (Exception e) {
            System.err.println("Erro inesperado: " + e.getMessage());
        }

    }

    public static Pokemon[] readDb() {

        Pokemon pokemons[] = new Pokemon[801];
        Scanner reader = null;

        try {
            reader = new Scanner(new FileReader("/tmp/pokemon.csv"));

            reader.nextLine();

            for (int i = 0; reader.hasNextLine(); i++) {
                String line = reader.nextLine();
                Pokemon pokemon = new Pokemon();

                try {
                    pokemon.ler(line);
                    pokemons[i] = pokemon;
                } catch (Exception e) {
                    System.err.println("Erro ao processar linha " + (i + 1) + ": " + e.getMessage());
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erro inesperado: " + e.getMessage());
        } finally {
            if (reader != null) {
                reader.close();
            }
        }

        return pokemons;
    }

    public void mostrar() {
        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("[#" + this.id + " -> " + this.name + ": " + this.description + " - " + types + " - "
                + abilities + " - " + this.weight + "kg - " + this.height + "m - " + this.captureRate + "% - "
                + this.legendary + " - " + this.generation + " gen" + "] - " + formater.format(captureDate));
    }

}

public class Main {

    public static Pokemon[] fullDB = new Pokemon[801];
    public static Pokemon[] array;
    public static TP tp = new TP();

    public static void swap(int i, int j) {
        Pokemon tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;

        tp.addMov(3);
    }

    public static int compare(int a, Pokemon b)
    {
        int resp = 0;

        if(array[a].getGeneration() - b.getGeneration() != 0)
        {
            resp = -1;
        }

        if(resp == 0)
        {
            resp = array[a].getName().compareTo(b.getName());
        }

        return resp;
    }

    public static void insertionSort(int len)
    {
        for(int i = 1; i < len; i++)
        {
            Pokemon tmp = array[i].myClone();
            tp.addMov(1);
            int j = i - 1;

            while((j >= 0) && compare(j, tmp) > 0)
            {
                array[j+1] = array[j];
                j--;
            }

            array[j+1] = tmp;
            tp.addMov(1);
        }
    }

    public static void quicksort(int esq, int dir) {
        int i = esq;
        int j = dir;
        int pivo = array[(esq + dir) / 2].getGeneration();

        while (i <= j) {
            while (array[i].getGeneration() < pivo) {
                i++;
                tp.addComp(1);;
            }

            while (array[j].getGeneration() > pivo) {
                tp.addComp(1);
                j--;
            }

            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }

        if (esq < j) {
            quicksort(esq, j);
        }
        if (i < dir) {
            quicksort(i, dir);
        }
    }

    public static void main(String args[]) {
        fullDB = Pokemon.readDb();

        Scanner scanf = new Scanner(System.in);

        int numeros[] = new int[100];
        int len = 0;

        for (String input = scanf.nextLine(); !input.equals("FIM"); input = scanf.nextLine()) {
            numeros[len] = Integer.parseInt(input);
            len++;
        }

        array = new Pokemon[len];

        for (int i = 0; i < len; i++) {
            array[i] = fullDB[numeros[i] - 1].myClone();
        }

        tp.startTime();
        quicksort(0, len - 1);
        insertionSort(len);
        tp.endTime();

        for (int i = 0; i < 10; i++) {
            array[i].mostrar();
        }

     

        scanf.close();

    }
}