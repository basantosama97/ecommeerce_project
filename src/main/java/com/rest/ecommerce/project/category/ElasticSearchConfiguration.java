package com.rest.ecommerce.project.category;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

@Configuration
public class ElasticSearchConfiguration {

    @Value("${elasticsearchHost}")
    private String elasticsearchHost;

    @Bean(destroyMethod = "close")
    public RestHighLevelClient client() {

        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder((HttpHost.create("http://127.0.0.1:9200"))));

        return client;

    }
        public ElasticsearchOperations elasticsearchTemplates(){
        return new ElasticsearchRestTemplate(client());
    }



//    @Bean
//    public RestHighLevelClient client(){
//        ClientConfiguration clientConfiguration = ClientConfiguration.builder()
//                .connectedTo("localhost:9200")
//                .withConnectTimeout(10000)
//                .build();
//        return RestClients.create(clientConfiguration).rest();
//    }
//
//    public ElasticsearchOperations elasticsearchTemplates(){
//        return new ElasticsearchRestTemplate(client());
//    }

//
//    @Value("${elasticsearch.ip}")
//    String ipPort;
//
//    @Bean
//    public RestClientBuilder restClientBuilder() {
//
//        return RestClient.builder(makeHttpHost(ipPort));
//    }




//    @Value("${elasticsearch.host}")
//    private String elasticsearchHost;
//
//    @Bean(destroyMethod = "close")
//    public RestHighLevelClient client() {
//
//        RestHighLevelClient client = new RestHighLevelClient(
//                RestClient.builder(new HttpHost(elasticsearchHost)));
//
//        return client;
//
//    }


//
//
//    @Bean(name = "highLevelClient")
//    public RestHighLevelClient highLevelClient(@Autowired RestClientBuilder restClientBuilder) {
//        restClientBuilder.setMaxRetryTimeoutMillis(60000);
//        return new RestHighLevelClient(restClientBuilder);
//    }
//
//
//    private HttpHost makeHttpHost(String s) {
//        String[] address = s.split(":");
//        String ip = address[0];
//        int port = Integer.parseInt(address[1]);
//
//        return new HttpHost(ip, port, "http");
//    }
//}

}


