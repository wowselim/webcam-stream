package co.selim.webcamstream

import javax.swing.JFrame

const val IMAGE_WIDTH = 1280
const val IMAGE_HEIGHT = 720

fun main() {
    OpenCV.initWindows()
    WebcamStreamWindow("Webcam Stream – ${IMAGE_WIDTH}x${IMAGE_HEIGHT} px").apply {
        pack()
        setLocationRelativeTo(null)
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        isVisible = true
    }
}
