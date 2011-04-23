package hohonuuli.fasta

import org.jfugue.Player

/**
 * 
 * @author Brian Schlining
 * @since 2011-04-22
 */

object DNAPlayer {

    def play(song: DNASong) {
        val player = new Player()
        player.play(song.pattern)
        player.close
    }

}