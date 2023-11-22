// Kevin Johanson CSC207 mini-project03
// testing File for textblock


package mProj3;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

public class TextBlockTest {

    @Test
    public void HorizontallyComposeTest() throws Exception{
            

        // Create blocks to use
        TextBlock leftBlock = new TextLine("LEFT");
        TextBlock rightBlock = new TextLine("right");
        HComposition hComposed = new HComposition(leftBlock, rightBlock);

        assertEquals("LEFTright", hComposed.row(0));
    } // HorizontallyComposeTest
  

    @Test
    public void VerticallyComposeTest() throws Exception{

        // Create blocks to use
        TextBlock topBlock = new TextLine("TOP");
        TextBlock bottomBlock = new TextLine("bottom");
        VComposition vComposed = new VComposition(topBlock, bottomBlock);

        assertEquals("TOP   ", vComposed.row(0));
        assertEquals("bottom", vComposed.row(1));
    } // VerticallyComposeTest


    @Test
    public void HorizontallyFlippedTest() throws Exception{
        // Create blocks to use
        TextBlock leftBlock = new TextLine("LEFT");
        TextBlock rightBlock = new TextLine("right");
        HComposition hComposed = new HComposition(leftBlock, rightBlock);

        HorizontallyFlipped hFLip = new HorizontallyFlipped(hComposed);

        assertEquals("thgirTFEL", hFLip.row(0));

    } // HorizontallyFlippedTest



    @Test
    public void EmptyHorizontallyFlippedTest() throws Exception{


        HorizontallyFlipped hFLip = new HorizontallyFlipped(new TextLine(""));

        assertEquals("", hFLip.row(0));

    } // EmptyHorizontallyFlippedTest


    @Test
    public void VerticallyFlippedTest() throws Exception{
        // Create blocks to use
        TextBlock topBlock = new TextLine("TOP");
        TextBlock bottomBlock = new TextLine("bottom");
        VComposition vComposed = new VComposition(topBlock, bottomBlock);

        VerticallyFlipped vFlip = new VerticallyFlipped(vComposed);

        assertEquals("TOP   ", vFlip.row(1));
        assertEquals("bottom", vFlip.row(0));
    } // VerticallyFlippedTest


    @Test
    public void EmptyVerticallyFlippedTest() throws Exception{


        VerticallyFlipped vFlip = new VerticallyFlipped(new TextLine(""));

        assertEquals("", vFlip.row(0));
    } // VerticallyFlippedTest    


    @Test
    public void LargeVerticallyFlippedTest() throws Exception{
        // Create blocks to use
        TextBlock topBlock = new TextLine("TOP");
        TextBlock bottomBlock = new TextLine("bottom");
        VComposition vComposed = new VComposition(topBlock, bottomBlock);
        VComposition vComposedNew = new VComposition(vComposed, bottomBlock);

        VerticallyFlipped vFlip = new VerticallyFlipped(vComposedNew);

        assertEquals("TOP   ", vFlip.row(2));
        assertEquals("bottom", vFlip.row(1));
        assertEquals("bottom", vFlip.row(0));
    } // VerticallyFlippedTest



    @Test
    public void RightJustifiedwGreaterWidthTest() throws Exception{

        // Create blocks to use
        TextBlock leftBlock = new TextLine("LEFT");
        TextBlock rightBlock = new TextLine("right");
        HComposition hComposed = new HComposition(leftBlock, rightBlock);

        RightJustified right = new RightJustified(hComposed, 20);

        // 11 spaces to the left
        assertEquals("           LEFTright", right.row(0)); 
    } // RightJustifiedTest


    @Test
    public void RightJustifiedwLesserWidthTest() throws Exception{

        // Create blocks to use
        TextBlock leftBlock = new TextLine("LEFT");
        TextBlock rightBlock = new TextLine("right");
        HComposition hComposed = new HComposition(leftBlock, rightBlock);

        RightJustified right = new RightJustified(hComposed, 5);

        // 5 characters should exist to the right
        assertEquals("right", right.row(0)); 
    } // RightJustifiedTest



    
    @Test
    public void CenteredwGreaterWidthTest() throws Exception{
        // Create blocks to use
        TextBlock leftBlock = new TextLine("LEFT");
        TextBlock rightBlock = new TextLine("right");
        HComposition hComposed = new HComposition(leftBlock, rightBlock);

        Centered center = new Centered(hComposed, 25);

        // 8 spaces to the left and right
        assertEquals("        LEFTright        ", center.row(0)); 
    } // CenteredwGreaterWidthTest


    @Test
    public void CenteredSmallWidthTest() throws Exception{
        // Create blocks to use
        TextBlock leftBlock = new TextLine("LEFT");
        TextBlock rightBlock = new TextLine("right");
        HComposition hComposed = new HComposition(leftBlock, rightBlock);

        Centered center = new Centered(hComposed, 5);

        // 8 spaces to the left and right
        assertEquals("FTrig", center.row(0)); 
    } // CenteredwLesserWidthTest


    
    @Test
    public void TruncatedLargeWidthTest() throws Exception{
        // Create blocks to use
        TextBlock leftBlock = new TextLine("LEFT");
        TextBlock rightBlock = new TextLine("right");
        HComposition hComposed = new HComposition(leftBlock, rightBlock);

        Truncated trunc = new Truncated(hComposed, 10);

        // 1 spaces to the right
        assertEquals("LEFTright ", trunc.row(0)); 
    } // TruncatedLargeWidthTest


    @Test
    public void TruncatedSmallWidthTest() throws Exception{
        // Create blocks to use
        TextBlock leftBlock = new TextLine("LEFT");
        TextBlock rightBlock = new TextLine("right");
        HComposition hComposed = new HComposition(leftBlock, rightBlock);

        Truncated trunc = new Truncated(hComposed, 5);

        // 1 spaces to the right
        assertEquals("LEFTr", trunc.row(0)); 
    } // TruncatedSmallWidthtest


    @Test
    public void UpperedVComposeTest() throws Exception{
        // Create blocks to use
        TextBlock topBlock = new TextLine("TOP");
        TextBlock bottomBlock = new TextLine("bottom");
        VComposition vComposed = new VComposition(topBlock, bottomBlock);

        Uppered upper = new Uppered(vComposed);

        // 1 spaces to the right
        assertEquals("TOP   ", upper.row(0)); 
        assertEquals("BOTTOM", upper.row(1)); 
    } // UpperedVComposeTest


    @Test
    public void UpperedHComposeTest() throws Exception{
        // Create blocks to use
        TextBlock topBlock = new TextLine("TOP");
        TextBlock bottomBlock = new TextLine("bottom");
        HComposition hComposed = new HComposition(topBlock, bottomBlock);

        Uppered upper = new Uppered(hComposed);

        // 1 spaces to the right
        assertEquals("TOPBOTTOM", upper.row(0));  
    } // UpperedHComposeTest


    @Test
    public void VCompNullTest() throws Exception{
        // Create blocks to use
        TextBlock topBlock = new TextLine("TOP");

        VComposition vComposed = new VComposition(topBlock, null);


        
        assertEquals("TOP", vComposed.row(0));  
    } // UpperedHComposeTest    


    @Test
    public void HCompNullTest() throws Exception{
        // Create blocks to use
    

        HComposition hComposed = new HComposition(null, null);


        // 1 spaces to the right
        assertEquals("", hComposed.row(0));  
    } // UpperedHComposeTest        


    @Test
    public void CenteredNullTest() throws Exception{
        
        Centered centered = new Centered(new TextLine(null), 10);
        
        assertEquals("          ", centered.row(0));

    } // CenteredNullTest


    @Test
    public void VerticallyFlippedNullTest() throws Exception{


        VerticallyFlipped vFlip = new VerticallyFlipped(null);

        assertEquals("", vFlip.row(0));
    } // VerticallyFlippedNullTest

    @Test
    public void HorizontallyFlippedNullTest() throws Exception{


        HorizontallyFlipped hFlip = new HorizontallyFlipped(null);

        assertEquals("", hFlip.row(0));
    } // HorizontallyFlippedNullTest    

    @Test
    public void TruncatedNullTest() throws Exception{


        Truncated trunc = new Truncated(null, 10);

        assertEquals("          ", trunc.row(0));
    } // TruncatedNullTest 


    @Test
    public void UpperedNullTest() throws Exception{


        Uppered upper = new Uppered(null);

        assertEquals("", upper.row(0));
    } // UpperedNullTest     
}
