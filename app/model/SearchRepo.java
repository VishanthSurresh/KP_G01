package model;

import java.io.IOException;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class SearchRepo {
    
    public String keyTerm;
    //private List<KeyTermData> keyTermData;

    public String getKeyTerm() {
        return this.keyTerm;
    }

    public void setKeyTerm(String keyTerm) {
        this.keyTerm = keyTerm;
    }

//    public List<KeyTermData> getKeyTermData() {
//        return this.keyTermData;
//    }
//
//    public void setKeyTermData(List<KeyTermData> keyTermData) {
//        this.keyTermData = keyTermData;
//    }

    public SearchRepo(String keyTerm) {
        this.keyTerm = keyTerm;
        //this.keyTermData = keyTermData;
    }

    public static String getReposByKeyword(String key) {

        String url = "https://api.github.com/search/repositories?q="+key;
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        request.addHeader("content-type", "application/json");
        CloseableHttpResponse result = null;
		try {
			result = httpClient.execute(request);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        String json = null;
		try {
			json = EntityUtils.toString(result.getEntity(), "UTF-8");
		} catch (ParseException | IOException e) {
			e.printStackTrace();
		}    
        return json;
        }

}
