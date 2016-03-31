package hohonuuli.fasta

import org.jfugue.player.Player
import java.io.File

/**
 *
 * @author Hohonuuli
 * @since 2011-04-22
 */

object DNAPlayer {

  def play(song: DNASong) {
    val player = new Player()
    player.play(song.pattern)
  }

  def save(song: DNASong, target: File) {
    val player = new Player()
    //player.saveMidi(song.pattern, target)
  }

}
