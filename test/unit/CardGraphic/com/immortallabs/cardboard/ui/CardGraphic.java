package com.immortallabs.cardboard.ui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

import com.immortallabs.cardboard.CardBoardResource;
import com.immortallabs.cardboard.game.Card;
import com.immortallabs.cardboard.game.SetsBoard;

import edu.profdalbey.Natural;

/**
 * The CardGraphic class is used to draw the Cardboard game cards in the
 * GameWindow. It does this by extending Component and overwriting the paint
 * method. This class also contains methods to animate and scale the cards
 * appropriately. <br />
 * <br />
 * <b>Operations:</b>
 * <ul>
 * <li>The CardGraphic class can create a card for the game board.
 * <li>The CardGraphic class can animate itself card.
 * <li>The CardGraphic class can scale the size of itself to fit on the game
 * board.
 * </ul>
 * 
 * @author Brad Barrows
 * @version 1.3
 * @version Jan. 3rd, 2008
 * @history - 1/13/09 1.3 Updated packages and tags <br> - 12/04/08 1.2 More
 *          Pseudocoding<br> - 12/02/08 1.1 Added Version History & Pseudocode<br>
 */

public class CardGraphic extends JComponent 
{

    /**
     * Contains the card that this graphic represents
     */
    private Card card;
    /**
     * Contains the Image of the card graphic
     */
    private BufferedImage cardGraphic;
    /**
     * A reference to the instance of the ActionMap
     */
    private ActionMap actionMapInst;
    /**
     * The point that the card graphic is being drawn at
     */
    private Point drawLocation;
    /**
     * The row this card is in
     */
    private Natural row;
    /**
     * The column this card is in
     */
    private Natural column;
    /**
     * A reference to the instance of the GameWindow
     */
    private GameWindow gamewindow;
    /**
     * The number of rows of cards on the game board
     */
    private SetsBoard.ROWS numRows;
    /**
     * The width of the cards at each scale size
     */
    private static final int[] kCardWidth = {150, 150, 130, 110};

    /**
     * The height of the cards at each scale size
     */
    private static final int[] kCardHeight = {100, 100, 80, 60};



    /**
     * Creates a CardGraphic to represent a card at the position row, column in
     * the game board.
     * 
     * @param card
     *            the card to represent
     * @param actionmap
     *            the ActionMap instance to use
     * @param row
     *            the row of the gameboard to place the card
     * @param column
     *            the column of the gameboard to place the card
     * @param gamewindow
     *            the GameWindow instance to use
     * @param drawLocation
     *            the location to draw the card at            
     * @see Card
     * @see ActionMap
     * @see GameWindow
     * @see Natural
     */
    public CardGraphic(Card card, ActionMap actionmap, Natural row,
            Natural column, GameWindow gamewindow, Point drawLocation)
    {
        // SET this card
        this.card = card;
        // SET this ActionMap instance
        this.actionMapInst = actionmap;
        // SET this row
        this.row = row;
        // SET this column
        this.column = column;
        // SET this GameWindow instance
        this.gamewindow = gamewindow;
        // SET the number of rows to 4
        this.numRows = SetsBoard.ROWS.FOUR;

        // SET drawLocation to the point of the board where this card will be
        // drawn 
        this.drawLocation = drawLocation;

        // LOAD the current theme into theme

        // LOAD the card graphic into cardGraphic
        String fileName =
            "" + card.getShape().ordinal() + card.getColor().ordinal()
                    + card.getFill().ordinal()
                    + card.getNumber().ordinal() + ".jpg";

        cardGraphic = CardBoardResource.getImage(this, fileName);
    }
    
    /**
     * Returns the point at which this card is to be drawn.
     * @return the Point to draw this card at
     */
    public Point getDrawLocation()
    {
        return drawLocation;
    }


    /**
     * Scales the size of this CardGraphic to fit on the gameboard with 4,5,6 or
     * 7 rows. This method is called when the number of rows of cards on the
     * gameboard increases. It is used to scale the size of the cards to all fit
     * in the GameWindow.
     * 
     * @param rows
     *            the number of rows of cards on the gameboard
     * @see GameWindow
     */
    public void scaleTo(SetsBoard.ROWS rows)
    {
        // SCALE cardGraphic to the appropriate WIDTH and HEIGHT for the number
        // of rows on the game board
        int width = kCardWidth[rows.ordinal()];
        int height = kCardHeight[rows.ordinal()];
        BufferedImage scaledImage =
                new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // Paint scaled version of image to new image
        Graphics2D graphics2D = scaledImage.createGraphics();
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.drawImage(cardGraphic, 0, 0, width, height, null);
        // clean up
        graphics2D.dispose();

        cardGraphic = scaledImage;

    }

    /**
     * Returns the card.
     * 
     * @return The card
     */
    public Card getCard()
    {
        // RETURN card
        return card;
    }

    @Override
    public void paint(Graphics g)
    {
        // PAINT cardGraphic to g at drawLocation
        g.drawImage(cardGraphic, drawLocation.x,
            drawLocation.y, this);
    }

}