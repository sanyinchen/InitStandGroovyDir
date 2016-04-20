
package com.hello

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Created by InitStandGroovyDir plugin.
 */
class MainPortal implements Plugin<Project> {
    @Override
    void apply(Project project) {
        project.tasks('hello') << {
            println 'hello groovy';
        }
    }
}