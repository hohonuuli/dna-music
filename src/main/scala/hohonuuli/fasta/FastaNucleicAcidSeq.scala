package hohonuuli.fasta

/**
 *
 * @author Hohonuuli
 * @since 2011-04-22
 */

class FastaNucleicAcidSeq(fasta: String) extends FastaSeq(fasta) {

  override val asBases: String = super.asBases.map(c =>
    FastaNucleicAcidSeq.nucleicAcidMap.getOrElse(c.toString, "")).mkString

}

object FastaNucleicAcidSeq {
  val nucleicAcidMap = Map(
    "A" -> "A",
    "C" -> "C",
    "G" -> "G",
    "T" -> "T",
    "U" -> "U",
    "R" -> "GA", // puRine
    "Y" -> "TC", // pYrmidine
    "K" -> "GT", // Ketone
    "M" -> "AC", // aMino group
    "S" -> "GC", // Strong interaction
    "W" -> "AT", // Weak interaction
    "B" -> "GTC", // (not A) B comes after a
    "D" -> "GAT", // (not C) D comes after c
    "H" -> "ACT", // (not G) H comes after g
    "V" -> "GCA", // (not T, not U) V comes after u
    "N" -> "AGCT", // aNy
    "X" -> "", // masked
    "-" -> ""
  ) // gap of indterminate length
}