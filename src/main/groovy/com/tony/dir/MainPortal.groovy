package com.tony.dir


import org.gradle.api.*;

/**
 * Created by sanyinchen on 16/3/3.
 */
class MainPortal implements Plugin<Project> {
    def void apply(Project project) {
        project.task('hello')<<{
            println 'Hello dev'
        }
    }
}
