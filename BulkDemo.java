package com.example.demo.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.ESClientFactory;

public class BulkDemo {
	/**
	 * 准备保存到搜索引擎的数据。
	 * @param path json数据文件路径
	 * @return
	 * @throws IOException
	 */
	private static List<Map<String, Object>> prepareData(String path) throws IOException{
	    FileInputStream in = new FileInputStream(path);
	    byte[] b = new byte[1024];
	    StringBuilder sb = new StringBuilder();
	    while ((in.read(b)) != -1) {
	        sb.append(new String(b));
	    }
	    in.close();
	    JSONArray array = JSONArray.parseArray(sb.toString());
	    int size = array.size();
	    List<Map<String, Object>> sourceData = new ArrayList<>();
	    for (int i = 0; i < size; i++) {
	        JSONObject object = array.getJSONObject(i);
	        Map<String, Object> content = new HashMap<>();
	        Set<String> keys = object.keySet();
	        for (String string : keys) {
	            content.put(string, object.get(string));
	        }
	        sourceData.add(content);
	    }
	    return sourceData;
	}
	

	public static void main(String[] args) throws IOException {//批量插入批量删除
	    RestHighLevelClient client = ESClientFactory.getHighLevelClient();
	    BulkRequest bulkRequest = new BulkRequest();
	    List<Map<String, Object>> sourceData = prepareData("d:/test/app.json");
	    // 将其他请求绑定到批量请求上，不止是indexRequest，其他查询，获取，删除操作均可以添加到批量请求，统一操作
	    for (Map<String, Object> map : sourceData) {
	        IndexRequest request = new IndexRequest("appstore", "app", String.valueOf(map.get("id")));
	        request.source(map, XContentType.JSON);
	        //---可以自己添加删除
	      /*  DeleteRequest request1 = new DeleteRequest(
	                "posts",    
	                "doc",     
	                "1"); 
	        bulkRequest.add(request1);*/
	        //---
	        bulkRequest.add(request);
	    }
	    try {
	        BulkResponse r = client.bulk(bulkRequest);
	        if (r.hasFailures()) {
	            System.out.println(r.buildFailureMessage());
	        }
	        System.out.println(r.toString());
	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	    ESClientFactory.close();
	}
}
