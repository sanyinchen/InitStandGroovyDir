
package com.tony.dir

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Created by InitStandGroovyDir plugin.
 */
class hello implements Plugin<Project> {
    @Override
    void apply(Project project) {
        project.tasks << {
            println 'hello groovy';
        }
    }
}
