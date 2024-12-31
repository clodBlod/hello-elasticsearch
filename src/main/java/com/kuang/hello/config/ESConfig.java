package com.kuang.hello.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ESConfig {

    //
    //@Bean
    //public TransportClient transport() throws UnknownHostException {
    //
    //    Settings settings = Settings.builder()
    //            .put("cluster.name", "elasticsearch") // 替换为您的集群名称
    //            .build();
    //    TransportClient client = new PreBuiltTransportClient(settings)
    //            .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("192.168.182.245"), 9300)); // 替换为您的 ES 服务器地址和端口
    //    // 获取 Elasticsearch 服务端版本
    //
    //    return client;
    //}

    @Bean
    public RestHighLevelClient restHighLevelClient(){
        RestClient restClient = RestClient.builder(
                new HttpHost("192.168.182.245", 9200, "http")).build();
        RestHighLevelClient client =
                new RestHighLevelClient(restClient);

        return client;
    }
}
