package controllers;

import org.junit.Test;
import play.Application;
import play.inject.guice.GuiceApplicationBuilder;
import play.mvc.Http;
import play.mvc.Result;
import play.test.WithApplication;

import static org.junit.Assert.assertEquals;
import static play.mvc.Http.Status.OK;
import static play.test.Helpers.GET;
import static play.test.Helpers.route;

/**
 * @author Varshini
 * @author Bhavitha
 * @author Vishanth
 * @author Heet
 * @author Shail
 */

public class HomeControllerTest extends WithApplication {

    @Override
    protected Application provideApplication() {
        return new GuiceApplicationBuilder().build();
    }

    @Test
    public void testIndex() {
        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(GET)
                .uri("/");

        Result result = route(app, request);
        assertEquals(OK, result.status());
        assertEquals("text/html", result.contentType().get());
        assertEquals("utf-8", result.charset().get());
    }
    @Test
    public void testSearch(){
        Http.RequestBuilder request1= new Http.RequestBuilder()
            .method(GET)
            .uri("/?query='java'");
    Result result1 = route(app, request1);
        assertEquals(OK, result1.status());
        assertEquals("text/html", result1.contentType().get());
        assertEquals("utf-8", result1.charset().get());

    }
    @Test
    public void testIssues(){
        Http.RequestBuilder request2= new Http.RequestBuilder()
            .method(GET)
            .uri("/?query='java'/?q1='java'");
    Result result2 = route(app, request2);
        assertEquals(OK, result2.status());
        assertEquals("text/html", result2.contentType().get());
        assertEquals("utf-8", result2.charset().get());
    }
    @Test
    public void testIssuesStats(){
        Http.RequestBuilder request3= new Http.RequestBuilder()
            .method(GET)
            .uri("/");
    Result result3 = route(app, request3);
        assertEquals(OK, result3.status());
        assertEquals("text/html", result3.contentType().get());
        assertEquals("utf-8", result3.charset().get());
    }
    @Test
    public void testTopic(){
        Http.RequestBuilder request4= new Http.RequestBuilder()
            .method(GET)
            .uri("/topic/query='java'");
    Result result4 = route(app, request4);
        assertEquals(OK, result4.status());
        assertEquals("text/html", result4.contentType().get());
        assertEquals("utf-8", result4.charset().get());
    }
    @Test
    public void testUser(){
        Http.RequestBuilder request5= new Http.RequestBuilder()
            .method(GET)
            .uri("/?id='patelheet99'");
    Result result5 = route(app, request5);
        assertEquals(OK, result5.status());
        assertEquals("text/html", result5.contentType().get());
        assertEquals("utf-8", result5.charset().get());
    }
    @Test
    public void testCommit(){
        Http.RequestBuilder request6= new Http.RequestBuilder()
            .method(GET)
            .uri("/?owner='patelheet99'/?repo='DS'");
    Result result6 = route(app, request6);
        assertEquals(OK, result6.status());
        assertEquals("text/html", result6.contentType().get());
        assertEquals("utf-8", result6.charset().get());
    }
    @Test
    public void testFetchUser(){
        Http.RequestBuilder request7= new Http.RequestBuilder()
            .method(GET)
            .uri("/?id='patelheet99'");
    Result result7 = route(app, request7);
        assertEquals(OK, result7.status());
        assertEquals("text/html", result7.contentType().get());
        assertEquals("utf-8", result7.charset().get());
    }
    @Test
    public void testFullCommitData(){
        Http.RequestBuilder request8= new Http.RequestBuilder()
            .method(GET)
            .uri("/?id='patelheet99'");
    Result result8 = route(app, request8);
        assertEquals(OK, result8.status());
        assertEquals("text/html", result8.contentType().get());
        assertEquals("utf-8", result8.charset().get());
    }
    @Test
    public void testName(){
        Http.RequestBuilder request9= new Http.RequestBuilder()
            .method(GET)
            .uri("/?name='patelheet99'");
    Result result9 = route(app, request9);
        assertEquals(OK, result9.status());
        assertEquals("text/html", result9.contentType().get());
        assertEquals("utf-8", result9.charset().get());
    }
    @Test
    public void testFullCommitsData(){
        Http.RequestBuilder request10= new Http.RequestBuilder()
            .method(GET)
            .uri("/?url='abcd'");
    Result result10 = route(app, request10);
        assertEquals(OK, result10.status());
        assertEquals("text/html", result10.contentType().get());
        assertEquals("utf-8", result10.charset().get());
    }

}
