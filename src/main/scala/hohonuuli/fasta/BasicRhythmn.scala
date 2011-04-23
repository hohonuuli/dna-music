package hohonuuli.fasta

import org.jfugue.{Rhythm, PatternInterface}

/**
 * 
 * @author Brian Schlining
 * @since 2011-04-22
 */

class BasicRhythmn(fastaSeq: FastaSeq) extends DNASong {
    lazy val pattern: PatternInterface = {
        // Bang out your beat
        val layerA: String = fastaSeq.asBases.replaceAll("[CGTU]", ".").replaceAll("A", "O")
        val layerC: String = fastaSeq.asBases.replaceAll("[AGTU]", ".").replaceAll("C", "*")
        val layerG: String = fastaSeq.asBases.replaceAll("[ACTU]", ".").replaceAll("G", "^")
        val layerT: String = fastaSeq.asBases.replaceAll("[ACGU]", ".").replaceAll("T", "o")
        val layerU: String = fastaSeq.asBases.replaceAll("[ACGT]", ".").replaceAll("U", "o")

        // Build Rythmn
        val rhythm = new Rhythm()
        rhythm.setLayer(1, layerA)
        rhythm.setLayer(2, layerC)
        rhythm.setLayer(3, layerG)
        rhythm.setLayer(4, layerT)
        rhythm.setLayer(5, layerU)

        // Associate percussion notes to the beat
        rhythm.addSubstitution('O', "[OPEN_HI_CONGA]s");
        rhythm.addSubstitution('o', "[MUTE_HI_CONGA]s");
        rhythm.addSubstitution('*', "[LOW_CONGA]s");
        rhythm.addSubstitution('^', "[LOW_BONGO]s");
        //rhythm.addSubstitution('!', "[CRASH_CYMBAL_1]s Rs");
        rhythm.addSubstitution('.', "Rs.");

        rhythm.getPattern
        
    }
}