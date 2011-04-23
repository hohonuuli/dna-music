package hohonuuli

import org.jfugue.elements.Instrument
import org.jfugue.{PatternInterface, Player, Pattern}

/**
 * @author ${user.name}
 */
object App {

  def main(args : Array[String]) {
    (0 to 127).foreach { i =>
        val instrument = new Instrument(i.asInstanceOf[Byte])
        println("Playing Instrument #" + i + ": " + instrument.getInstrumentName)
        val pattern: PatternInterface = new Pattern("V0 I" + i + " E5s D#5s | E5s D#5s E5s B4s D5s C5s " +
                "V1 I" + i + " Ri       | Riii                     ")
        val player = new Player()
        player.play(pattern)
        player.close()
    }

  }

}
