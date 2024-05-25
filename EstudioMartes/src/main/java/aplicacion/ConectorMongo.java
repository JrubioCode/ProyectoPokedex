package aplicacion;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import org.bson.Document;

public class ConectorMongo {

	// CONECTAR CON LA BASE DE DATOS.

	static String connectionString = "mongodb+srv://Jrubio:1234@clusteres0.kmi5s1x.mongodb.net/?retryWrites=true&w=majority&appName=Clusteres0";

	static ServerApi serverApi = ServerApi.builder().version(ServerApiVersion.V1).build();

	static MongoClientSettings settings = MongoClientSettings.builder()
			.applyConnectionString(new ConnectionString(connectionString)).serverApi(serverApi).build();

	// CONSTRUCTOR VACIO.

	public ConectorMongo() {

	}

	// METODO DE ELIMINAR POKEMON.

	public static void eliminarPokemon() {

		try (MongoClient mongoClient = MongoClients.create(settings)) {
			try {

				// ACCEDER A LA BASE DE DATOS Y A SU COLECCION.

				MongoDatabase database = mongoClient.getDatabase("Pokemon");
				MongoCollection<Document> collection = database.getCollection("Pokemons");

				// ELIMINAR POKEMON

				collection.deleteOne(Filters.eq("name", "Pikachu"));
				System.out.println("Pokemon eliminado");

			} catch (MongoException e) {
				e.printStackTrace();
			}
		}
	}

	public static void añadirPokemon() {

		// Create a new client and connect to the server
		try (MongoClient mongoClient = MongoClients.create(settings)) {
			try {

				// ACCEDER A LA BASE DE DATOS Y A SU COLECCION.

				MongoDatabase database = mongoClient.getDatabase("Pokemon");
				MongoCollection<Document> collection = database.getCollection("Pokemon");

				// CREATE POKEMON.

				Document newPokemon = new Document("name", "Pikachu").append("type", "Electrico").append("level", "26");
				collection.insertOne(newPokemon);
				System.out.println("Pokemon insertado");

			} catch (MongoException e) {
				e.printStackTrace();
			}
		}
	}

	public Document mostrarInfo(String nombrePokemon) {

		// DECLARAR FUERA DEL TRY VACIO PARA RETORNARLO.
		
		Document foundPokemon = null;
		
		try (MongoClient mongoClient = MongoClients.create(settings)) {
			try {
				
				// ACCEDER A LA BASE DE DATOS Y A SU COLECCION.
				
				MongoDatabase database = mongoClient.getDatabase("Pokemon");
				MongoCollection<Document> collection = database.getCollection("Pokemon");

				// MOSTRAR INFORMACION POKEMON.
				
				foundPokemon = collection.find(Filters.eq("name", nombrePokemon)).first();
				
				if (foundPokemon != null) {
					System.out.println("Pokemon encontrado: " + foundPokemon.getString("name"));
					System.out.println("Pokemon encontrado: " + foundPokemon.getString("type"));

				} else {
					System.out.println("Pokemon no encontrado");
				}

			} catch (MongoException e) {
				e.printStackTrace();
			}

		}
		return foundPokemon;
	}
}