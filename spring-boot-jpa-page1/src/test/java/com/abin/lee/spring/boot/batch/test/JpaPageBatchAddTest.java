package com.abin.lee.spring.boot.batch.test;

import com.abin.lee.spring.boot.page.common.HttpClientUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abin on 2018/1/15 11:36.
 * spring-boot-start2
 * com.abin.lee.spring.boot.mybatis.test
 */
public class JpaPageBatchAddTest {

    private static final String httpURL = "http://localhost:8099/user/add1";

    @Test
    public void testJpaPageBatchAdd() {
        try {
            for (int i = 0; i <1000 ; i++) {
                CloseableHttpClient httpClient = HttpClientUtil.getHttpClient();
                List<NameValuePair> nvps = new ArrayList<NameValuePair>();
                String userName = "abin"+(int)(Math.random()*10);
                nvps.add(new BasicNameValuePair("userName", userName));
//            String randomString = new RandomStringGenerator.Builder().build().generate(10);
//            nvps.add(new BasicNameValuePair("question", randomString));
                nvps.add(new BasicNameValuePair("password", RandomStringUtils.randomAlphabetic(5)));
                String age = (int)(Math.random()*10) + "";
                nvps.add(new BasicNameValuePair("age", age));
                HttpPost httpPost = new HttpPost(httpURL);

                httpPost.setEntity(new UrlEncodedFormEntity(nvps, Consts.UTF_8));
                System.out.println("Executing request: " + httpPost.getRequestLine());
                HttpResponse response = httpClient.execute(httpPost);
                System.out.println("----------------------------------------");
                System.out.println(response.getStatusLine());
                System.out.println(EntityUtils.toString(response.getEntity()));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }



}
