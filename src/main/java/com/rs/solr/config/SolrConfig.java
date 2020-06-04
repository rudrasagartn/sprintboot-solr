
package com.rs.solr.config;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableSolrRepositories(basePackages = "com.rs.solr.repository", namedQueriesLocation = "classpath:solr-named-queries.properties")
public class SolrConfig {
	@Value("${spring.data.solr.host}")
	private String solrUrl;

	@Bean
	public SolrClient solrClient() {
		return new HttpSolrClient.Builder(solrUrl).build();
	}

	@Bean
	public SolrTemplate solrTemplate(SolrClient client) {
		return new SolrTemplate(client);
	}

	@Bean
	public RestTemplate restTemplate(SolrClient client) {
		return new RestTemplate();
	}

	@Bean
	public Docket swaggerConfig() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().paths(PathSelectors.ant("/api/*"))
				.apis(RequestHandlerSelectors.basePackage("com.rs.solr")).build();

	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("SpringBoot API").description("SpringBoot Java API reference for developers")
				.termsOfServiceUrl("https://github.com/rudrasagartn").contact("Rudrasagar TN")
				.license("Java License").licenseUrl("https://github.com/rudrasagartn").version("1.0").build();
	}


}
