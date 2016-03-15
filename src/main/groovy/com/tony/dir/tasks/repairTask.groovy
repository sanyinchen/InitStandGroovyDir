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
                dirlist.add(root + File.separator + "src" + File.separator + "mian" + File.separator + "groovy" + File.separator + "com" + File.separator + "hello");
                // dirlist.add(root + File.separator + "src" + File.separator + "mian" + File.separator + "groovy" + File.separator + "com" + File.separator + "hello" + File.separator + "tasks")
                dirlist.add(root + File.separator + "src" + File.separator + "mian" + File.separator + "resources" + File.separator + "META-INF" + File.separator + "gradle-plugins")
                for (int j = 0; j < dirlist.size(); j++) {
                    File f = new File(dirlist.get(j));
                    if (!f.exists() && !f.isDirectory()) {
                        f.mkdirs();
                        println "creat file dir " + f.path;
                    }
                }
// generate MainPortal.groovy
                File f = new File(dirlist.get(j) + File.separator + "MainPortal.groovy");
                if (!f.exists() && !f.isFile()) {
                    f.createNewFile();
                    println "creat file " + f.path;
                }
                f.write(TempletBuild.helloGroovy);

// /Users/sanyinchen/IdeaProjects/InitStandGroovyDir/src/main/resources/META-INF/gradle-plugins/com.standard.dir.properties
            }
        }
    }
}
