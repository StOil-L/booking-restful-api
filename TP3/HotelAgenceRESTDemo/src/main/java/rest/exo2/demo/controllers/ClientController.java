package rest.exo2.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import rest.exo2.demo.exceptions.ClientException;
import rest.exo2.demo.models.Client;
import rest.exo2.demo.models.Reservation;
import rest.exo2.demo.repositories.ClientRepository;

@RestController
public class ClientController {

	@Autowired
	private ClientRepository rep;
	private static final String uri = "agenceservice/api";
	
	@GetMapping(uri+"/clients")
	public List<Client> getClients() {
		return rep.findAll();
	}
	
	@GetMapping(uri+"/clients/{id}")
	public Client getClientById(@PathVariable long id) throws ClientException {
		return rep.findById(id)
				.orElseThrow(() -> new ClientException(
						"Could not find Chambre of ID: " + id));
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(uri+"/clients")
	public Client createClient(@RequestBody Client client) {
		return rep.save(client);
	}
	
	@PutMapping(uri+"clients/{id}")
	public Client updateClient(@RequestBody Client newClient, @PathVariable long id) {
		return rep.findById(id)
				.map(client -> {
					client.setNom(newClient.getNom());
					client.setPrenom(newClient.getPrenom());
					client.setNumerocarte(newClient.getNumerocarte());
					client.setMoisexpiration(newClient.getMoisexpiration());
					client.setCodesecurite(newClient.getCodesecurite());
					client.setReservations((ArrayList<Reservation>)newClient.getReservations());
					return rep.save(client);
				})
				.orElseGet(() -> rep.save(newClient));
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(uri+"/clients/{id}")
	public void deleteClient(long id) throws ClientException {
		Client client = rep.findById(id)
				.orElseThrow(() -> new ClientException(
						"Erreur: Client " + id + " introuvable"));
		rep.delete(client);
	}
}
