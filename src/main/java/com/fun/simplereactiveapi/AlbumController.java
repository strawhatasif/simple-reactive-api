package com.fun.simplereactiveapi;

import com.fun.simplereactiveapi.client.Album;
import com.fun.simplereactiveapi.service.AlbumsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class AlbumController {
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
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "whoops!")
    private String getAlbumz() {
        return "this is the not the endpoint you're looking for!";
    }
}
