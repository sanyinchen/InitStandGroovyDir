package com.tony.dir

import com.tony.dir.model.CheckDir
import com.tony.dir.tasks.RepairTask
import org.gradle.api.*;

/**
 * Created by sanyinchen on 16/3/3.
 */
class MainPortal implements Plugin<Project> {
    def void apply(Project project) {
        //  add property
        project.extensions.create("standconfig", CheckDir);

        // tasks
        project.task("hellotemplet",type:RepairTask);

        project.task('hello')<<{
            println 'Hello dev'
        }

    }
}
