package com.fun.simplereactiveapi.service;

import com.fun.simplereactiveapi.client.Album;
import com.fun.simplereactiveapi.client.AlbumWebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class AlbumsService {
    @Autowired
    private AlbumWebClient albumWebClient;

    public Flux<Album> getAlbums() {
       return albumWebClient.getAlbums();
    }
}
