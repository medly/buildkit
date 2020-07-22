package com.medly.buildkit


import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import apifi.codegen.*

class ApifiCodegen extends DefaultTask {

    @InputFile
    File openApiSpec

    @Input
    String basePackageName

    @OutputDirectory
    File generatedSourceDir

    @TaskAction
    void generate() throws IOException {
        new CodegenIO().execute(openApiSpec, generatedSourceDir, basePackageName)
    }
}
