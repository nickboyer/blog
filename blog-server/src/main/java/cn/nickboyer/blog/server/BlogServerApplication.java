package cn.nickboyer.blog.server;

import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@EnableScheduling
@RestController
public class BlogServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogServerApplication.class, args);
	}

	@Value("${server.port}")
	String port;
	@Value("${spring.data.solr.host}")
	String url;

	@RequestMapping("/hi")
	public String home(@RequestParam String name) {
		return "hi " + name + ",i am from port:" + port;
	}

	@Bean
	public SolrTemplate solrTemplate() {
		HttpSolrClient httpSolrClient = new HttpSolrClient(url);

		return new SolrTemplate(httpSolrClient, "nickboyer");
	}
}
