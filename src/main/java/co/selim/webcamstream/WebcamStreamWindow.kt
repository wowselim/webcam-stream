package co.selim.webcamstream

import io.metaloom.video4j.Videos
import io.metaloom.video4j.utils.VideoUtils
import javax.swing.JFrame

class WebcamStreamWindow(title: String) : JFrame(title) {

    private val webcamSurface = WebcamSurface()

    init {
        contentPane = webcamSurface

        stream()
    }

    private fun stream() {
        val streamTask = Runnable {
            Videos.open(0).use { stream ->
                stream.setFrameRate(24.0)
                stream.enableFormatMJPEG()
                stream.setFormat(IMAGE_WIDTH, IMAGE_HEIGHT)

                stream.streamFrames().use { frames ->
                    frames.forEach {
                        webcamSurface.useGraphics { g ->
                            g.drawImage(it.toImage(), 0, 0, null)
                        }
                        repaint()
                    }
                }
            }
        }
        Thread(streamTask)
            .apply { isDaemon = true }
            .start()
    }
}