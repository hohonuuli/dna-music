package hohonuuli.fasta

import org.jfugue.Pattern

/**
 * 
 * @author Brian Schlining
 * @since 2011-04-22
 */

class BasicSong(fastaSeq: FastaSeq, noteMap: Map[String, String] = BasicSong.noteMap) extends DNASong {
    lazy val pattern = {
        /* V38 45 52 53 55 62 84 */
        new Pattern("V0 I38 " +
                fastaSeq.asBases
                        .map( c => noteMap.getOrElse(c.toString, ""))
                        .mkString(" "))
    }


}

object BasicSong {
    val noteMap = Map("A" -> "A4s",
        "G" -> "Gs",
        "T" -> "D6s",
        "U" -> "D4s",
        "C" -> "Cs")
}