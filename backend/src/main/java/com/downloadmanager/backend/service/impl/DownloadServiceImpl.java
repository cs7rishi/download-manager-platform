package com.downloadmanager.backend.service.impl;

import com.downloadmanager.backend.service.DownloadService;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

@Service
public class DownloadServiceImpl implements DownloadService {

    public HttpURLConnection generateConnection(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("Host", "188.165.227.112");

        return connection;
    }

    @Override
    public String downloadFile(String urlString) throws IOException {
        HttpURLConnection connection = generateConnection(urlString);
        String fileName = extractFileName(urlString);

        InputStream inputStream = connection.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        byte[] buffer = new byte[1024];
        int bytesRead;

        while ((bytesRead = inputStream.read(buffer)) > 0) {
            fileOutputStream.write(buffer, 0, bytesRead);
        }

        inputStream.close();
        fileOutputStream.close();

        if(connection.getResponseCode() == HttpURLConnection.HTTP_OK){
            return "File downloaded successfully!";
        }else{
            return "File download failed!";
        }

    }

    private String extractFileName(String url) {
        return url.substring(url.lastIndexOf('/') + 1);
    }
}
