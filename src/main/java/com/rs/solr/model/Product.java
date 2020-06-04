package com.rs.solr.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SolrDocument(collection = "products")
@ApiModel(description = "Product is featched from Solr Index")
public class Product {

	@Id
	@Indexed(name = "product_id", type = "long")
	@ApiModelProperty(notes = "The unique id of product")
	private long product_id;

	@Indexed(name = "product_desc", type = "string")
	@ApiModelProperty(notes = "The description of the product")
	private String product_desc;

	@Indexed(name = "product_code", type = "string")
	@ApiModelProperty(notes = "The product code")
	private String product_code;

	public long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}

	public String getProduct_desc() {
		return product_desc;
	}

	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}

	public String getProduct_code() {
		return product_code;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

}
