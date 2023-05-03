package co.selim.webcamstream

import java.nio.file.Files
import java.nio.file.StandardCopyOption
import kotlin.io.path.absolutePathString

object OpenCV {
    fun initWindows() {
        val dllFile = checkNotNull(OpenCV::class.java.getResourceAsStream("/opencv_java460.dll")) {
            "native library not found in classpath"
        }
        val tempFile = Files.createTempFile("webcam-stream", ".lib")
        Files.copy(dllFile, tempFile, StandardCopyOption.REPLACE_EXISTING)
        System.load(tempFile.absolutePathString())
    }
}