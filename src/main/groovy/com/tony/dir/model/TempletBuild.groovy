/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.tony.dir.model

/**
 * Created by sanyinchen on 16/3/14.
 */
class TempletBuild {


    static String helloGroovy = "\n" +
            "package com.hello\n" +
            "\n" +
            "import org.gradle.api.Plugin\n" +
            "import org.gradle.api.Project\n" +
            "\n" +
            "/**\n" +
            " * Created by InitStandGroovyDir plugin.\n" +
            " */\n" +
            "class MainPortal implements Plugin<Project> {\n" +
            "    @Override\n" +
            "    void apply(Project project) {\n" +
            "        project.tasks('hello') << {\n" +
            "            println 'hello groovy';\n" +
            "        }\n" +
            "    }\n" +
            "}";
    static String porperty = "implementation-class=com.hello.MainPortal";

    static String buildTeml = "apply plugin: 'groovy'\n" +
            "apply plugin: 'maven'\n" +
            "\n" +
            "dependencies {\n" +
            "    compile gradleApi()\n" +
            "    compile localGroovy()\n" +
            "}\n" +
            "repositories {\n" +
            "    mavenCentral()\n" +
            "}\n" +
            "group=\"com.tony.gradletools\"\n" +
            "version=\"0.1\"\n" +
            "uploadArchives{\n" +
            "    repositories {\n" +
            "        mavenDeployer {\n" +
            "            repository(url: uri('./repo'))\n" +
            "        }\n" +
            "    }\n" +
            "}\n" +
            ""
    static String setTing = "rootProject.name = 'helloWord'";
}
