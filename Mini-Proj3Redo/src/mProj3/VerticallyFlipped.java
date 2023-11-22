package mProj3;

/**
 * The vertical composition of two text blocks.
 * 
 * @author Kevin Johanson
 *         Snippets of code taken From SamR Rebelsky's CSC 207 class
 */

public class VerticallyFlipped implements TextBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The composition.
   */
  TextBlock block;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new block by composing top and bottom vertically.
   * @throws Exception
   */
  public VerticallyFlipped(TextBlock block) {
    if (block == null) { // handles null case
      this.block = new TextLine("");
    } else {
      this.block = block;
    }// else 
    
  } // VerticallyFlipped

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+
  /**
   * compares instances
   */
  public boolean eqv(TextBlock cmp) {
    cmp = (VerticallyFlipped) cmp;
    return ((cmp instanceof VerticallyFlipped) && this.block.eqv((((VerticallyFlipped) cmp).block))); // checks the top path
                                                                                                  // then bottom then
                                                                                                  // calls both
                                                                                                  // recursively
        
  }

  /**
   * Get one row from the block.
   * 
   * @pre 0 <= i < this.height()
   * @exception Exception if the precondition is not met
   */
  public String row(int i) throws Exception {
    
    return this.block.row(block.height() - 1 - i);
    
  } // row(int)

  /**
   * Determine how many rows are in the block.
   */
  public int height() {
    // The height is the sum of the heights of the top and bottom
    // blocks.
    return this.block.height();
  } // height()

  /**
   * Determine how many columns are in the block.
   */
  public int width() {
    // The width is the greater of the widths of the top and bottom
    // blocks.
    return this.block.width();
  } // width()

} // class VerticallyFLipped