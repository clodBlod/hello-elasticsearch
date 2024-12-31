package com.kuang.hello.controller;

import org.elasticsearch.Build;
import org.elasticsearch.Version;
import org.elasticsearch.action.main.MainResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.cluster.ClusterName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class HelloController {

    //@Autowired
    //private TransportClient client;
    //
    //@GetMapping("/hello")
    //public Object hello(){
    //
    //    Version esVersion = client.admin().cluster().prepareNodesInfo().get().getNodes().get(0).getVersion();
    //
    //    System.out.println("Elasticsearch version: " + esVersion.toString());
    //
    //    return esVersion.toString();
    //}


    @Autowired
    private RestHighLevelClient client;
    @GetMapping("/hello")
    public Object hello() throws IOException {
        MainResponse response = client.info();
        ClusterName clusterName = response.getClusterName();
        String clusterUuid = response.getClusterUuid();
        String nodeName = response.getNodeName();
        Version version = response.getVersion();
        Build build = response.getBuild();
        System.out.println(clusterName +":"+clusterUuid+":"+nodeName+":"+version);
        return version.toString();
    }

}
