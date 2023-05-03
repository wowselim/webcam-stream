package co.selim.webcamstream

import java.awt.Dimension
import java.awt.Graphics
import java.awt.Graphics2D
import javax.swing.JComponent

class WebcamSurface : JComponent() {

    private val image by lazy { createVolatileImage(IMAGE_WIDTH, IMAGE_HEIGHT) }
    private val graphics by lazy { image.createGraphics() }

    init {
        preferredSize = Dimension(IMAGE_WIDTH, IMAGE_HEIGHT)
    }

    override fun paint(g: Graphics) {
        g.drawImage(image, 0, 0, width, height, null)
    }

    fun useGraphics(block: (Graphics2D) -> Unit) {
        block(graphics)
    }
}