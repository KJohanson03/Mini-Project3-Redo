package mProj3;

import java.io.PrintWriter;

/**
 * A series of experiments with the text block layout classes.
 * 
 * @author Samuel A. Rebelsky
 * @version 1.3 of September 2019
 */
public class TBExpt {
  // +------+--------------------------------------------------------------
  // | Main |
  // +------+

  public static void main(String[] args) throws Exception {
    // Prepare for input and output
    PrintWriter pen = new PrintWriter(System.out, true);

    // Create a block to use
    TextBlock block = new TextLine("Farm House");
    TextBlock blockBottom = new TextLine("Hello");    

    // Print out the block
    //TBUtils.print(pen, block);

    // Test for eqv
    Truncated eqv1 = new Truncated(block,3);    

    Truncated eqv2 = new Truncated(block,10);      
    
    // Print out the block
    //System.out.println(eqv1.eqv(eqv2));

    
    // create a Truncated object 
    Truncated trunc = new Truncated(block, 10);
    
    // Print out the block
    //TBUtils.print(pen, trunc);

    
    // create a right justified object 
    RightJustified right = new RightJustified(block, 2);

    // Print out the block
    //TBUtils.print(pen, rigth);


    // creates a three layer high vertical composition and prints it out
    VComposition my = new VComposition(blockBottom, block);
    VComposition my1 = new VComposition(my, block);

    //TBUtils.print(pen,my1);
    //System.out.println("----");
  
    //flips the 3 layer high vComp and prints it out
    VerticallyFlipped my3 = new VerticallyFlipped(my1);

    //prints out block
    //TBUtils.print(pen, my3);
    
  
    
    // create a Centered object with width bigger
    Centered center = new Centered(block, 15);
    
    // Print out the block
    TBUtils.print(pen, center);

        
    // create a Centered object with width smaller
    Centered centerSmall = new Centered(block, 5);
    
    // Print out the block
    TBUtils.print(pen, centerSmall);

    // create veritcal object
    VComposition vComp = new VComposition(block, blockBottom);

    // Print out the block
    //TBUtils.print(pen, vComp);
    
    // create a VerticallyFlipped object 
    VerticallyFlipped vFlip = new VerticallyFlipped(vComp);
    
    // Print out the block
    //TBUtils.print(pen, vFlip);
    
    // creates HComposed object
    HComposition hComp = new HComposition(block, blockBottom);
    //TBUtils.print(pen, hComp);

    // create a HorizontallyFlipped object 
    HorizontallyFlipped hFlip = new HorizontallyFlipped(hComp);
    //TBUtils.print(pen, hFlip);
    // Print out the block
    //TBUtils.print(pen, hComp);    
    
    // create a HorizontallyFlipped object 
    Uppered upper = new Uppered(block);
    
    // Print out the block
    //TBUtils.print(pen, upper);    
    
    // Clean up after ourselves.
    pen.close();
  } // main(String[])

} // class TBExpt
