package com.rs.solr.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import com.rs.solr.model.Product;

@Repository
public interface SolrProductRepository extends SolrCrudRepository<Product, Long> {

	@Query("product_code:*?0*")
	public Page<Product> findByName(String searchTerms, Pageable pageable);
	
	
	@Query(name = "Product.findByNamedQuery")
	public List<Product> findByName2(String searchTerms);
	
 
}
