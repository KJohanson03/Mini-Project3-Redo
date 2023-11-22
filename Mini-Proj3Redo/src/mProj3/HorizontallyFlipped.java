package mProj3;

/**
 * The horizontal composition of two text blocks.
 * 
 * @author Kevin Johanson
 * Code snippets taken from SamR CSC 207
 * @version 1.3 of February 2019
 */
public class HorizontallyFlipped implements TextBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  TextBlock block;
  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * flips the textblock horizontally
   */
  public HorizontallyFlipped(TextBlock block) {
    if (block == null) { // handles null case
      this.block = new TextLine("");
    } else {
      this.block = block;
    }// else 
    
  } // HorizontallyFlipped

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * compares instances 
   */	
 public boolean eqv(TextBlock cmp) {
	  cmp = (HorizontallyFlipped) cmp;
	  return ((cmp instanceof RightJustified) && this.block.eqv((((HorizontallyFlipped) cmp).block))); // checks the left path then right then calls both recursively
			
 }


  /**
   * Get one row from the block.
   * 
   * @pre 0 <= i < this.height()
   * @exception Exception if the precondition is not met
   */
  public String row(int i) throws Exception {
    int height = this.block.height();

    if ((i< 0) || (i>= height)) {
      throw new Exception("Invalid");
    }// if 
   
    String result = "";
    for (int j = (this.block.width() - 1); j >= 0; j--) {
      result = result.concat(Character.toString(this.block.row(i).charAt(j)));
    }
   return result;
  } // row(int)


  //Determine how many rows are in the block.
  public int height() {
    return this.block.height();
  } // height()

  /**
   * Determine how many columns are in the block.
   */
  public int width() {
    return this.block.width();
  } // width()

} // class HorizontallyFlipped
