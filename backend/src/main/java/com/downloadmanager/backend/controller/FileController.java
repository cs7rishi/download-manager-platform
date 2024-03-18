package com.downloadmanager.backend.controller;

import com.downloadmanager.backend.service.DownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/file")
public class FileController {


    @Autowired
    DownloadService downloadService;

    @GetMapping("/download")
    public ResponseEntity<String> downloadFile(@RequestParam("url") String downloadUrl)
        throws IOException, URISyntaxException {
        return new ResponseEntity<>(downloadService.downloadFile(downloadUrl), HttpStatus.OK);
    }
}
