package br.com.github.kalilventura.openfeign.client;

import br.com.github.kalilventura.openfeign.dto.PostDTO;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.mock.HttpMethod;
import feign.mock.MockClient;
import org.junit.jupiter.api.Test;
import org.springframework.cloud.openfeign.support.SpringMvcContract;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PostFeignClientTest {

    private static String url = "https://jsonplaceholder.typicode.com";
    private static String response = "[{\n" +
            "        \"userId\": 1,\n" +
            "        \"id\": 1,\n" +
            "        \"title\": \"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\",\n" +
            "        \"body\": \"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\"\n" +
            "    }]";

    private PostFeignClient postFeignClient;

    @Test
    public void whenGetPostClientThenReturnOk() {
        this.builderFeignClient(new MockClient().ok(
                HttpMethod.GET,
                url.concat("/api/posts"),
                response
        ));

        List<PostDTO> posts = postFeignClient.getPosts();

        assertFalse(posts.isEmpty());
    }

    private void builderFeignClient(MockClient mockClient) {
        postFeignClient = Feign
                .builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .contract(new SpringMvcContract())
                .target(PostFeignClient.class, url);
    }
}