package com.rs.solr.controler;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rs.solr.model.Product;
import com.rs.solr.repository.SolrProductRepository;

@RestController
public class SolrIndexControler {

	@Autowired
	private SolrProductRepository solrProductRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/findById")
	public Optional<Product> findByProductId() {
		return solrProductRepository.findById(new Long(884355));
	}

	@RequestMapping(value = "/findByName")
	public List<Product> findByName() {
		return solrProductRepository.findByName2("18188");
	}
	
	@RequestMapping(value = "/deltaImport")
	public void deltaImport() {
		HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
	      ResponseEntity<String> e = 
		restTemplate.exchange(
		         "http://localhost:8983/solr/item_product/dataimport?command=delta-import&commit=true&clean=false&debug=true", HttpMethod.GET, entity, String.class);
	     
	      System.out.println(e);
	}
}
