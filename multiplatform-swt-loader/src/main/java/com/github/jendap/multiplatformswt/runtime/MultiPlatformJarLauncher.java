package com.github.jendap.multiplatformswt.runtime;


import org.springframework.boot.loader.launch.Archive;

import java.util.List;

public class MultiPlatformJarLauncher extends org.springframework.boot.loader.launch.JarLauncher {

    public MultiPlatformJarLauncher() throws Exception {
    }

    public static void main(String[] args) throws Exception {
        new MultiPlatformJarLauncher().launch(args);
    }
}
