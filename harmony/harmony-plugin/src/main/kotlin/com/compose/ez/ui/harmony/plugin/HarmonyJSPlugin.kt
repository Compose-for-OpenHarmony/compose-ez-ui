package com.compose.ez.ui.harmony.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * author: wulinpeng
 * date: 2024/3/20
 * desc:
 */
class HarmonyJSPlugin: Plugin<Project> {
  companion object {
    const val TASK_NAME = "compileDevelopmentExecutableHarmonyKotlinJs"
    const val DEPENDS_TASK = "compileDevelopmentExecutableKotlinJs"
  }

  override fun apply(target: Project) {
    if (runCatching { target.tasks.getByName(TASK_NAME) }.isFailure) {
      target.tasks.register(TASK_NAME, HarmonyJSTask::class.java)
    }
    target.tasks.getByName(TASK_NAME).dependsOn(DEPENDS_TASK)
  }
}
