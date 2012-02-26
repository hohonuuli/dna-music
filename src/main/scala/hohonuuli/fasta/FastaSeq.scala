package hohonuuli.fasta

import io.Source

/**
 * 
 * @author Hohonuuli
 * @since 2011-04-22
 */

class FastaSeq(fasta: String) {

    lazy val header: String  = {
        var source = Source.fromString(fasta)
        source.getLines.filter( p => p.startsWith(">") || p.startsWith(";") ).mkString("\n")
    }

    lazy val body: String = {
        var source = Source.fromString(fasta)
        source.getLines.filterNot( p => p.startsWith(">") || p.startsWith(";") ).mkString("\n")
    }

    lazy val asBases: String = body.filterNot { _ == '\n'}
    
}