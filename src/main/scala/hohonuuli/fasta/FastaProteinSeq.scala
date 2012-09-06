package hohonuuli.fasta

import io.Source

/**
 * 
 * @author Brian Schlining
 * @since 2011-04-22
 */

class FastaProteinSeq(val fasta: String) extends FastaSeq(fasta) {

    override val asBases: String = super.asBases.map( c =>
        FastaProteinSeq.aminoAcidMap.getOrElse(c.toString, "")
    ).mkString
    
}

object FastaProteinSeq {
    
    val aminoAcidMap = Map("A" -> "GCUGCCGCAGCG", // Alanine
            "B" -> "GAUGAC",             // Aspartic acid or Asparagine (AAUAAC)
            "C" -> "UGUUGC",             // Cysteine
            "D" -> "GAUGAC",             // Aspartic Acid
            "E" -> "GAAGAG",             // Glutamic Acid
            "F" -> "UUUUUC",             // Phenylalanine
            "G" -> "GGUGGCGGAGGG",       // Glycine
            "H" -> "CAUCAC",             // Histidine
            "I" -> "AUUAUCAUA",          // Isoleucine
            "K" -> "AAAAAG",             // Lysine
            "L" -> "UUAUUGCUUCUCCUACUG", // Leucine
            "M" -> "AUG",                // Methionine
            "N" -> "AAUAAC",             // Asparagine
            "O" -> "UAG",                // Pyrrolysine
            "P" -> "CCUCCCCCACCG",       // Proline
            "Q" -> "CAACAG",             // Glutamine
            "R" -> "CGUCGCCGACGGAGAAGG", // Arginine
            "S" -> "UCUUCCUCAUCGAGU",    // Serine
            "T" -> "ACUACAACCACG",       // Threonine
            "U" -> "UGA",                // Selenocysteine
            "V" -> "GUUGUCGUAGUG",       // Valine
            "W" -> "UGG",                // Tryptophan
            "Y" -> "UACUAU",             // Tyrosine
            "Z" -> "GAAGAG",             // Glutamic acid or glutamine (CAACAG)
            "X" -> "",                   // any
            "*" -> "",                   // translation stop
            "-" -> "")                   // gap of indeterminate length
}