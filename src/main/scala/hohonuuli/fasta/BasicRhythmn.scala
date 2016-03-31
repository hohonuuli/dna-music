package hohonuuli.fasta

import org.jfugue.rhythm.Rhythm
import org.jfugue.pattern.Pattern

/**
 *
 * @author Hohonuuli
 * @since 2011-04-22
 */

class BasicRhythmn(fastaSeq: FastaSeq) extends DNASong {
  lazy val pattern: Pattern = {
    // Bang out your beat
    val layers = Seq(
      fastaSeq.asBases.replaceAll("[CGTU]", ".").replaceAll("A", "O"),
      fastaSeq.asBases.replaceAll("[AGTU]", ".").replaceAll("C", "*"),
      fastaSeq.asBases.replaceAll("[ACTU]", ".").replaceAll("G", "^"),
      fastaSeq.asBases.replaceAll("[ACGU]", ".").replaceAll("T", "o"),
      fastaSeq.asBases.replaceAll("[ACGT]", ".").replaceAll("U", "o")
    )

    // Build Rythmn
    val rhythm = new Rhythm(layers: _*)

    // Associate percussion notes to the beat
    // rhythm.addSubstitution('O', "[OPEN_HI_CONGA]s");
    // rhythm.addSubstitution('o', "[MUTE_HI_CONGA]s");
    // rhythm.addSubstitution('*', "[LOW_CONGA]s");
    // rhythm.addSubstitution('^', "[LOW_BONGO]s");
    // //rhythm.addSubstitution('!', "[CRASH_CYMBAL_1]s Rs");
    // rhythm.addSubstitution('.', "Rs.");

    rhythm.getPattern

  }
}
