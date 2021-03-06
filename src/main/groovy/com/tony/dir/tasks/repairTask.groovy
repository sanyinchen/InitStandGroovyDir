/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.tony.dir.tasks

import com.tony.dir.model.TempletBuild
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * Created by sanyinchen on 16/3/14.
 */
class RepairTask extends DefaultTask {
    @TaskAction
    def checkAction() {
        String[] roots = project.standconfig.roots;
        if (roots != null && roots.length != 0) {
            for (int ri = 0; ri < roots.length; ri++) {
                // check logic
                String root = roots[ri];
                List<String> dirlist = new ArrayList<>();
                dirlist.add(root + File.separator + "src" + File.separator + "main" + File.separator + "groovy" + File.separator + "com" + File.separator + "hello");
                // dirlist.add(root + File.separator + "src" + File.separator + "main" + File.separator + "groovy" + File.separator + "com" + File.separator + "hello" + File.separator + "tasks")
                dirlist.add(root + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "META-INF" + File.separator + "gradle-plugins")
                for (int j = 0; j < dirlist.size(); j++) {
                    File f = new File(dirlist.get(j));
                    if (!f.exists() && !f.isDirectory()) {
                        f.mkdirs();
                        println "creat file dir " + f.path;
                    }
                }
// generate MainPortal.groovy
                File f = new File(dirlist.get(0) + File.separator + "MainPortal.groovy");
                if (!f.exists() && !f.isFile()) {
                    f.createNewFile();
                    println "creat groovy file " + f.path;
                }
                f.write(TempletBuild.helloGroovy);
// create properties
                f = new File(dirlist.get(1) + File.separator + "com.hello.properties");
                if (!f.exists() && !f.isFile()) {
                    f.createNewFile();
                    println "creat properties file " + f.path;
                }
                f.write(TempletBuild.porperty);
// create build.gradle
                f = new File(root + File.separator + 'build.gradle');
                if (!f.exists() && !f.isFile()) {
                    f.createNewFile();
                    println("creat build.gradle");
                }
                f.write(TempletBuild.buildTeml);
// create seeings.gradle
                f = new File(root + File.separator + 'settings.gradle');
                if (!f.exists() && !f.isFile()) {
                    f.createNewFile();
                    println("creat settings.gradle");
                }
                f.write(TempletBuild.setTing);

            }
        }
    }
}
