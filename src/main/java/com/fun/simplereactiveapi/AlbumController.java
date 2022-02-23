package com.fun.simplereactiveapi;

import com.fun.simplereactiveapi.client.Album;
import com.fun.simplereactiveapi.service.AlbumsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class AlbumController {
    int count = 0;

    @Autowired
    private final AlbumsService albumsService;

    public AlbumController(AlbumsService albumsService) {
        this.albumsService = albumsService;
    }

    @GetMapping("/albums")
    private Flux<Album> getAllAlbums() {
        return albumsService.getAlbums();
    }

    @GetMapping("/albumz")
    private ResponseEntity<String> getAlbumz() {
        //simulate a state where the endpoint is healthy after a couple of retries.
        if (count > 1) {
            return ResponseEntity.ok().body("SUCCESS!!!");
        }
        else {
            //artificially increment global sentinel var.
            count++;
            return ResponseEntity
                    .internalServerError()
                    .body("this is the not the endpoint you're looking for!");
        }
    }
}
