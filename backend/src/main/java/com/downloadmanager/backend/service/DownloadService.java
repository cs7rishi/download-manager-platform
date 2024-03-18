package com.downloadmanager.backend.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

public interface DownloadService {
    public String downloadFile(String fileUrl) throws IOException, URISyntaxException;
}
