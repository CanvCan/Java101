package algoProject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Movie{               
	
	public final int releaseDate;
	public final String movieName;
	public final Genres genre;
	public final String directorName;
	
	public ArrayList<Actor> actorList = new ArrayList<>();
	
	public Movie(int releaseDate, String movieName, Genres genre, String directorName, ArrayList<Actor> actorList) {
		super();
		this.releaseDate = releaseDate;
		this.movieName = movieName;
		this.genre = genre;
		this.directorName = directorName;
		this.actorList = actorList;
	}

	public Movie() {
		
		this.releaseDate = 2000;
		this.movieName = null;
		this.genre = Genres.AKSIYON;
		this.directorName = null;
		this.actorList = null;
		
	}
	
	public Movie(Movie movie) {       //copy constructor
        this(movie.getReleaseDate(), movie.getMovieName(), movie.getGenre(), movie.getDirectorName(), movie.getActorList());      

    }

	public ArrayList<Actor> getActorList() {
		return actorList;
	}

	public void setActorList(ArrayList<Actor> actorList) {
		this.actorList = actorList;
	}

	public int getReleaseDate() {       // no setter method  as it is the last variable
		return releaseDate;
	}

	public String getMovieName() {       // no setter method  as it is the last variable
		return movieName;
	}

	public Genres getGenre() {         // no setter method  as it is the last variable
		return genre;
	}

	public String getDirectorName() {        // no setter method  as it is the last variable
		return directorName;
	}

	public static String matchGenre(String genre) {    // formalizes the input for the enum
		
		switch(genre) {
		
		case "Romantik": genre = "ROMANTIK"; break;
		case "Komedi": genre = "KOMEDI"; break;
		case "Fantastik": genre = "FANTASTIK"; break;
		case "Bilim Kurgu": genre = "BILIM_KURGU"; break;
		case "Aksiyon": genre = "AKSIYON"; break;
		case "Korku": genre = "KORKU"; break;
		default: return genre;
		
		}	
	
		return genre;
	}

	@Override
	public String toString() {
		return "Release Date: " + releaseDate + " |" + " Movie's Name: " + movieName + " |" + " Genre: " + genre + " |" + " Director's Name: " + directorName
				+ " |" + " Actors ---> " + actorList;
	}

	
	// reading from file, then adding doubly linked list.
	public static ArrayList<Movie> readFromFile() throws FileNotFoundException, IOException {
  
		BufferedReader bReader = new BufferedReader(new FileReader("bilgiler.txt")); 
        String lineText;											
        															
        ArrayList<Movie> movieList = new ArrayList<>();
        
        while ((lineText = bReader.readLine()) != null) {
        	
        	 String[] tokens = lineText.split("[{]");
             String[] tokens2 = tokens[0].split(",");
             
             int releaseDate = Integer.parseInt(tokens2[0]);
             String movieName = tokens2[1].trim();
             String genre = tokens2[2].trim();
             String directorName = tokens2[3].trim();

             ArrayList<Actor> actorList = new ArrayList<>();
             String[] actorTokens = tokens[1].substring(1, tokens[1].length()).split("\\)\\(");
             actorTokens[1] = actorTokens[1].substring(0, actorTokens[1].length() - 2);       
             
             for (String actorToken : actorTokens) {

                 String[] actorInfo = actorToken.split(",");
              
                 String actorName = actorInfo[0].trim();
                 String gender = actorInfo[1].trim();
                 String nationality = actorInfo[2].trim();
     
                 Actor actor = new Actor(actorName, gender, nationality);
                 actorList.add(actor);
             }
                          
             Movie movie = new Movie(releaseDate, movieName, Genres.valueOf(matchGenre(genre)), directorName, actorList);
             movieList.add(movie);
               
        }

        bReader.close();
        System.out.println("Data loaded from file: bilgiler.txt");  
        return movieList;
     }


	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		final NodeList<Movie> movies = new NodeList<>(Comparator.comparing(Movie::getReleaseDate).thenComparing(Movie::getMovieName));
		
		
		for (Movie movie : readFromFile()) {  // reading from file, then adding doubly linked list.s
			movies.insert(movie);
		}
		
		Scanner scanner = new Scanner(System.in);
  
        int choice = 0;
        while (choice != 8) {
        	
            System.out.println();
            System.out.println("MENU");
            System.out.println("1. Add a movie");
            System.out.println("2. Search a movie");
            System.out.println("3. Delete a movie");
            System.out.println("4. Print all movies (from head)");
            System.out.println("5. Print all movies (from tail)");
            System.out.println("6. Print movies before a certain year");
            System.out.println("7. Save data to file");
            System.out.println("8. Exit");
            System.out.println();
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();
            scanner.nextLine(); // cleaning buffer

            switch (choice) {
                case 1:
                	
                    System.out.println("Enter movie details:");
                    
                    System.out.print("Release Year: ");
                    int releaseDate = scanner.nextInt();
                    scanner.nextLine();
                    
                    System.out.print("Movie Name: ");
                    String movieName = scanner.nextLine();
                    
                    System.out.print("Genre: ");
                    String genreString = scanner.nextLine();
                    Genres genre = Genres.valueOf(matchGenre(genreString));
                    
                    System.out.print("Director's Name: ");
                    String directorName = scanner.nextLine();
                    
                    System.out.print("Number of actors: ");
                    int numActors = scanner.nextInt();
                    scanner.nextLine();
                    
                    ArrayList<Actor> actorList = new ArrayList<>();
                    
                    for (int i = 0; i < numActors; i++) {
                    	
                        System.out.println("Enter details for Actor " + (i + 1));
                        
                        System.out.print("Name: ");
                        String actorName = scanner.nextLine();
                        
                        System.out.print("Gender: ");
                        String gender = scanner.nextLine();
                        
                        System.out.print("Nationality: ");
                        String nationality = scanner.nextLine();

                        actorList.add(new Actor(actorName, gender, nationality));
                    }

                    Movie movie = new Movie(releaseDate, movieName, genre, directorName, actorList);
                    movies.insert(movie);
                    System.out.println("Movie added successfully.");
                    break;
                    
                case 2:
                	
                    System.out.print("Enter movie's name: ");
                    String searchTitle = scanner.nextLine();
                    boolean flag = true;
                    
                    for (Movie movie2 : movies) {
                    	
                    	if(movie2.movieName.equals(searchTitle)) {
                    		
                    		movies.printResearchedMovie(movie2);
                    		flag = false;
                    		break;
                    		
                    	}
					}
                    
                    if(flag)
                    	System.out.println("The movie you are looking for is not in the dll !!!");
                    
                    break;
                    
                case 3:
                	
                    System.out.print("Enter movie's name: ");
                    String deleteTitle = scanner.nextLine();
                    boolean flag2 = true;
                    
                    for (Movie movie3 : movies) {

                    	if(movie3.movieName.equals(deleteTitle)) {
                    		
                    		System.out.println(movie3.movieName + " is deleted.");
                    		
                    		movies.removeResearchedMovie(movie3);
                    		flag2 = false;
                    		break;
                    		
                    	}
					}
                    
                    if(flag2)
                    	System.out.println("The movie you want to remove is not in the dll !!!");
                    
                    break;
                    
                case 4:
                	
                    movies.printFromHead();
                    break;
                    
                case 5:
                	
                    movies.printFromTail();
                    break;
                    
                case 6:
                	
                    System.out.print("Enter a year: ");
                    int searchYear = scanner.nextInt();
                    scanner.nextLine();
                    movies.printMoviesBeforeYear(searchYear);
                    break;
                    
                case 7:
                	
                    movies.saveToFile("bilgiler.txt");
                    break;
                    
                case 8:
                	
                    movies.saveToFile("bilgiler.txt");
                    System.out.println("Exiting the program.");
                    break;
                    
                default:
                	
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();  
		
	}

}
