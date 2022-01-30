package com.rest.ecommerce.project.category;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.search.join.ScoreMode;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.elasticsearch.index.query.QueryBuilders.multiMatchQuery;

@Service
@Slf4j
public class ProductElasticService {
    @Autowired
    private ProductRepository productRepository;
    private RestHighLevelClient client;
    private ObjectMapper objectMapper;

    @Autowired
    public ProductElasticService(RestHighLevelClient client, ObjectMapper objectMapper) {
        this.client = client;
        this.objectMapper = objectMapper;
    }

    public Product createProduct(Product product) throws Exception {

        Map<String, Object> documentMapper = objectMapper.convertValue(product, Map.class);
                documentMapper.putAll(objectMapper.convertValue(product.getCategory_(), Map.class));
        IndexRequest indexRequest = new IndexRequest("productindex","_doc", product.getPid().toString()).source(documentMapper);
        IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);

        return product;
    }


    public Product findById(String id) throws Exception {

        GetRequest getRequest = new GetRequest(id);
        GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);
        Map<String, Object> resultMap = getResponse.getSource();

        return objectMapper
                .convertValue(resultMap, Product.class);
    }

    private List<Product> getSearchResult(SearchResponse response) {

        SearchHit[] searchHit = response.getHits().getHits();

        List<Product> productDocument = new ArrayList<>();
        if (searchHit.length > 0) {

            Arrays.stream(searchHit)
                    .forEach(hit -> productDocument
                            .add(objectMapper
                                    .convertValue(hit.getSourceAsMap(),
                                            Product.class))
                    );
        }
        return productDocument;
    }

    public List<Product> searchByProductNameAndDescription(String match) throws Exception {

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(multiMatchQuery(match,"productName","product_description", "category_.title", "category_.description").fuzziness(Fuzziness.ONE));
        SearchRequest searchRequest = new SearchRequest("productindex");
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
        SearchHits hits = searchResponse.getHits();
        SearchHit[] searchHits = hits.getHits();

               return (List<Product>) getSearchResult(searchResponse);
    }






        public List<Product> searchByCategory(String category) throws Exception {

            SearchRequest searchRequest = new SearchRequest();
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            QueryBuilder queryBuilder = QueryBuilders
                    .multiMatchQuery(category, "category_.title", "category_.description")
                    .fuzziness(Fuzziness.ONE);
            searchSourceBuilder.query(QueryBuilders
                    .nestedQuery("category_",
                            queryBuilder,
                            ScoreMode.Avg));

            searchRequest.source(searchSourceBuilder);

            SearchResponse response =
                    client.search(searchRequest, RequestOptions.DEFAULT);

            return getSearchResult(response);
        }




//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        searchSourceBuilder.query(multiMatchQuery(category,"category_.title","category_.description"));
//        SearchRequest searchRequest = new SearchRequest("productindex");
//        searchRequest.source(searchSourceBuilder);
//        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
//        SearchHits hits = searchResponse.getHits();
//        SearchHit[] searchHits = hits.getHits();
//
//        return (List<Product>) getSearchResult(searchResponse);
    }


//            SearchRequest searchRequest = new SearchRequest();
//            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
//                .withQuery(multiMatchQuery(category)
//                        .field("category_.title")
//                        .field("category_.description")
//                        .type(MultiMatchQueryBuilder.Type.BEST_FIELDS))
//                        .build();
//        searchSourceBuilder.query(QueryBuilders
//                .nestedQuery("technologies",
//                        (QueryBuilder) searchQuery,
//                        ScoreMode.Avg));
//            SearchRequest searchRequest = new SearchRequest();
//            searchRequest.source(searchSourceBuilder);
//
//            SearchResponse response =
//                    client.search(searchRequest, RequestOptions.DEFAULT);
//
//            return getSearchResult(response);





//        QueryBuilder queryBuilder = QueryBuilders
//                .boolQuery()
//                .should(QueryBuilders
//                        .matchQuery("productName", match));
//
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder().postFilter(queryBuilder);


//        MultiMatchQueryBuilder queryBuilder = QueryBuilders
//                .multiMatchQuery(match, "productName", "product_description")
//                .type(MultiMatchQueryBuilder.Type.BEST_FIELDS).operator(Operator.OR);

//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder().postFilter(queryBuilder);