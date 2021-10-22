package br.com.github.kalilventura.openfeign.client;

import br.com.github.kalilventura.openfeign.dto.PostDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "post", url = "https://jsonplaceholder.typicode.com")
public interface PostFeignClient {

    @GetMapping(value = "/posts")
    List<PostDTO> getPosts();
}
