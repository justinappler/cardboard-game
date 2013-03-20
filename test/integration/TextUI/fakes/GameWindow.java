package com.immortallabs.cardboard.ui;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JApplet;
import javax.swing.JFrame;

import com.immortallabs.cardboard.CardBoardResource;
import com.immortallabs.cardboard.game.Card;
import com.immortallabs.cardboard.game.CardBoardMessage;
import com.immortallabs.cardboard.game.GameState;
import com.immortallabs.cardboard.game.SetsBoard;

import edu.profdalbey.Natural;

/**
 * <p>
 * Displays the state of the CardBoard game in a single window.
 * </p>
 * <b>Operations:</b>
 * <ul>
 * <li>GameWindow displays the game state in a window.</li>
 * <li>GameWindow can return the current x,y coordinates of the open inlay
 * slot.</li>
 * <li>GameWindow can prompt the user for his or her name and return it.</li>
 * </ul>
 * 
 * @author Lamont Samuels
 * @author Immortal Labs CSC309 W09
 * @author Sky Eckstrom
 * @author Rusty Nail CSC308 F08
 * @version 1.2
 * @version 01/12/08
 * @history - 01/19/08 1.2 Updated the Psuedocode - 01/12/08 1.2 Updated Author
 *          Tags, Added the Following instance variables: - hintButton -
 *          pauseButton - threeMoreButton - explainWhyButton - - 12/04/08 1.1
 *          Added Version History & Pseudocode<br> - 11/30/08 1.0 Inital Class
 *          Skeleton<br>
 */
public class GameWindow extends javax.swing.JPanel implements CardBoardUI,
        ActionListener
{
    /**
     * INLAY represents the different open inlay positions.
     */
    public enum INLAY
    {
        /** Inlay spot one * */
        ONE,
        /** Inlay spot two * */
        TWO,
        /** Inlay spot three * */
        THREE;
    }

    /**
     * DIRECTION represents the different movement directions for the selected
     * card.
     */
    public enum DIRECTION
    {
        /** Move up * */
        UP,
        /** Move down * */
        DOWN,
        /** Move left * */
        LEFT,
   
        HINTDIR,
        /** Move right * */
        RIGHT;
    }

    /** the height of the window * */
    public final int kWindowHeight = 730;

    /** the width of the window */
    public final int kWindowWidth = 780;


    /** reference of the GameState */
    private GameState state;

    /** represents the first inlaySpot */
    private final int firstInlay = 0;

    /** represents the second inlaySpot */
    private final int secondInlay = 1;

    /** represents the third inlaySpot */
    private final int thirdInlay = 2;


    /** Represents the max number of cards in the lay */
    private final int kInlaySize = 3;


    /** Represents the x location of the inlay cards */
    private final int inlayX = 35;

    /** Represents the y locations of the inlay cards */
    private final int[] inlayY = {30, 145, 255};

    /** Represents the message the game wants to display to the user */
    private String message;

    /** Represents if a message needs to be displayed to the user */
    public boolean hasMessage;

    /** Represents the font size of pause prompt */
    private final int kPauseSize = 16;
    
    /** Represents the  x offSet for the selectedCard */
    private final int selectedCardXOffSet = 5; 
    
    /** Represents the selected card dimensions offset */ 
    private final int selectedCardDimOffSet = 10; 

    /** Represents the font size of welcome prompt */
    private final int kWelcomeSize = 15;

    /** Represents the composite shade value */
    private final float kComposite = 0.75f;

    /** Represents the x location of the buttons */
    private final int buttonsX = 25;

    /** Represents the fileName for background image */
    private final String kBackgroundFile = "background.jpg";

    /** Represents the fileName for message image */
    private final String kMessageFile = "messageBox.jpg";

    /** Represents the number of columns for the cards */
    private final int kColumns = 3;

    /** Represents the max number of rows for the cards */
    private final int kRowsMax = 7;

    /** Represents the location of the message box */
    private final Point messageLoc = new Point(250, 205);

    /** Represents the delay time for showing a message for a valid set */
    private final int delayTimeValid = 900;

    /** Represents the delay time for showing a message for a invalid set */
    private final int delayTimeInvalid = 7000;

    /** Represents the delay time for time expiration for competitive */ 
    private final int delayTimeTimeRunOut = 1500; 
    
    /** Represents the delay time for showing a message for a invalid set */
    private final int delayTimeMessage = 900;

    /** Represents the start location of message prompt */
    private final Point messagePromptLoc = new Point(260, 295);

    /** Represents the message prompt text size */
    private final int kMessageSize = 13;

    /** Represents the y locations of the buttons */
    private final int[] buttonsY = {373, 438, 503, 568};

    /** Represents the beginning card location */
    private final Point cardStartLoc = new Point(235, 30);

    /** Represents the X offset for the cards */
    private final int kCardXOffset = 20;

    /** Represents the backgrounds location */
    private final Point backgroundStartLoc = new Point(0, 0);

    /** Represents the Y offset for the cards */
    private final int kCardYOffset = 20;

    /** Represents the scaleIndex */
    private int scaleIndex;

    /** Represents the hint button Index */
    private final int kHintIndex = 0;

    /** Represents the pause button index */
    private final int kPauseIndex = 1;

    /** Represents the threeMore button index */
    private final int kThreeMoreIndex = 2;

    /** Represents the explain button index */
    private final int kExplainIndex = 3;

    /** Represents the first scalar index */
    private final int kFirstScalar = 0;

    /** Represents the two scalar index */
    private final int kSecondScalar = 1;

    /** Represents a second in milliseconds */
    private final int kSecond = 1000;

    /** Represents the third scalar index */
    private final int kThirdScalar = 2;

    /** Represents current number of rows */
    private int numberOfRows;

    /** Represents a player being buzzed in */
    private boolean isBuzzedIn = false;

    /** Represents the number of rows the game could have */
    private final int[] kCardRows = {4, 5, 6, 7};

    /** Represents the scale width sizes for the cards */
    private final int[] kCardWidth = {150, 130, 110};

    /** Represents the scale height sizes for the cards */
    private final int[] kCardHeight = {100, 80, 60};

    /** Represents the width of a button */
    private final Dimension kButtonDimesion = new Dimension(180, 50);


    /** Represents the timer's location */
    private final Point timeLoc = new Point(35, 655);

    /** Represents the explanation's resume button location */
    private final Point explainResumeButtonLoc = new Point(425, 395);

    /** Represents the ok button's location */
    private final Point okButtonLoc = new Point(340, 320);

    /** Represents the score's location */
    private final Point scoreLoc = new Point(235, 655);

    /** Represents the cards left location */
    private final Point cardsLeftLoc = new Point(650, 655);

    /** Represents if the game is paused */
    private boolean isPaused;

    /** Represents if the application just launched */
    private boolean isWelcome;

    /** Represents if the game is showing an explanation */
    private boolean isShowingExplanation;

    /** Represents the x location of the rectangle to paint over the cards */
    private final Point paintOverLoc = new Point(220, 5);

    /** Represents the paint over width for pausing */
    private final Dimension paintOverDimesion = new Dimension(551, 612);

    /** Represents the paint over message location */
    private final Point paintOverMessageLoc = new Point(235, 260);

    /** Represents the resume button location */
    private final Point resumeButtonLoc = new Point(420, 275);

    /** Represents the start button location */
    private final Point startButtonLoc = new Point(305, 305);

    /** Represents the start prompt location */
    private final Point startPromptLoc = new Point(160, 290);

    /** Represents the backgrounds width and height */
    private final Dimension background = new Dimension(780, 686);

    /** Represents the currently selected column */
    private int selectedCol = 0;

    /** Represents the currently selected row */
    private int selectedRow = 0;

    /** Allows for repaiting the timerGraphic every second */
    private javax.swing.Timer repaintTimer;

    /** Represents the applet for the game */
    private JApplet theApplet = null;

    /** Represents the application for the game */
    private JFrame theApp = null;

    /** Allows for displaying a message for an interval of time */
    private javax.swing.Timer messageTimer;

    private Graphics bufferedGraphic;

    private Image offImage;

    /**
     * Instantiates a new game window that will display the state of the game
     * held in GameState.
     * 
     * @param theApplet 
     *            the applet that the GameWindow is running in 
     * @param isNormal 
     *            Determines if the game should be in a test state 
     */
    public GameWindow(JApplet theApplet, boolean isNormal)
    {

    }
    /**
     * Instantiates a new game window that will display the state of the game
     * held in GameState.
     * 
     * @param theFrame
     *            the frame that the GameWindow is running in 
     * @param isNormal 
     *            Determines if the game should be in a test state 
     */
    public GameWindow(JFrame theFrame, boolean isNormal)
    {

    }
    /**
     * Initializes all components of the GameWindow
     * @param isNormal
     *             represents whether the game should be run in test mode. 
     */
    public void init(boolean isNormal)
    {
        
    }

    /**
     * Creates the off screen image
     */
    public void makeImageBuffer()
    {

    }

    private void highlightCard()
    {
        
    }

    /**
     * Sets the selected card to the clicked card.
     * 
     * @param card
     *            the card that was selected
     */
    public void cardClicked()
    {
        
    }

    /**
     * Moves the selected card in the specified direction
     * 
     * @param dir
     *            the direction to move
     */
    public void moveSelector(DIRECTION dir)
    {
        
    }

    /**
     * Sets the selectedCOL and selectedRow to the card currently to 
     * the left of the selected card
     */
    private void getLeftCard()
    {
        
    }
    /**
     * Sets the selectedCOL and selectedRow to the card currently above
     *  of the selected card
     */
    private void getUpCard()
    {
        
    }
    /**
     * Sets the selectedCOL and selectedRow to the card currently below
     * the selected card
     */
    private void getDownCard()
    {
        
    }
    /**
     * Sets the selectedCOL and selectedRow to the card currently to 
     * the right of the selected card
     */
    private void getRightCard()
    {
        
    }

    /**
     * The object on which the event initially occurred.
     * 
     * @param x
     *            the x location where the mouse was pressed
     * @param y
     *            the y location where the mouse was pressed
     * @return The object on which the event initially occurred.
     */
    public Object getSource(int x, int y)
    {
        return null;
    }


    /**
     * Sets the references to the window's game state
     * @param state
     *           represents the state to set GameWindow too. 
     
    public void setGameState(GameState state)
    {
        this.state = state;
        // CALL setUserInterface on GameState passing a copy of self
        state.setUserInterface(this);
        // CREATE new ActionMap
        map = new ActionMap(state, this);
    }
    */
    
    /**
     * Checks to see if the mouse clicked on one of the inlay cards
     * 
     * @param x
     *            the x location where the mouse was pressed
     * @param y
     *            the y location where the mouse was pressed
     * @return an inlay card if the x and y is within the bounds of the card,
     *         otherwise NULL
     */
    private void checkInLay(int x, int y)
    {
        
    }

    /**
     * Checks to see if the mouse clicked on a card
     * 
     * @param x
     *            the x location where the mouse was pressed
     * @param y
     *            the y location where the mouse was pressed
     * @return a card if the x and y is within the bounds of the card, otherwise
     *         NULL
     */
    private void checkCards(int x, int y)
    {
        
    }

    /**
     * Check to see if the mouse clicked on a button
     * 
     * @param x
     *            the x location where the mouse was pressed
     * @param y
     *            the y location where the mouse was pressed
     * @return a button if the x and y is within the bounds of the button,
     *         otherwise NULL
     */
    private Object checkButtons(int x, int y)
    {
        return null;
    }
    /**
     * Shows the user a message regarding an action they've taken
     * 
     * @param message
     *          The message to be shown to the user
     */
    public void showMessage(CardBoardMessage message)
    {
        
    }

    /**
     * Removes the last set displayed in the inlay.
     */
    public void clearLastSet()
    {
        // CALL paint to fresh the window with the inlays removed
        repaint();
    }

    /**
     * Retrieves the name/handle of the current player from the User Interface.
     * 
     * @return The name or handle of the player who received the high score
     */
    public String getName()
    {
        return "";
    }

    /**
     * Notifies GameWindow that the theme has changed.
     */
    public void themeChanged()
    {
        // LOAD the new background image
        // FOR each button in the display
        // NOTIFY the button of the new theme
    }

    /**
     * Displays the button of the given type in the game window.
     * 
     * @param btn
     *            the button type to display
     */
    public void showButton()
    {
        
    }
    
    /**
     * Displays the player that is currently buzzed in
     * @param player
     *     The player that is currently buzzed in
     *     null if no player is currently buzzed in
     */
    public void displayBuzzedPlayer(GameState.PLAYER player)
    {
        
    }

    /**
     * Removes the button of the given type from the game window.
     * 
     * @param btn
     *            the button type to remove
     */
    public void removeButton()
    {
        
    }

    /**
     * Updates the window by calling the paint method
     * 
     * @param g
     *            the graphics for painting to the window
     */
    public void update(Graphics g)
    {

    }

    /**
     * Paints all components to the window
     * 
     * @param g
     *            the graphics to paint the components to
     */
    public void paint(Graphics g)
    {

       
    }

    /**
     * Paints all cards currently in the inlay
     * 
     * @param g
     *            the graphics component to paint the cards to.
     */
    private void paintInLayCards(Graphics g)
    {
 
    }

    /**
     * Paints the background to the screen
     * 
     * @param g
     *            the graphics component to paint the cards to.
     */
    private void paintBackground(Graphics g)
    {
        
    }

    /**
     * Paints all the cards to the screen
     * 
     * @param g
     *            the graphics component to paint the cards to.
     */
    private void paintCards(Graphics g)
    {
        
    }

    /**
     * Paints all buttons to the screen
     * 
     * @param g
     *            the graphics component to paint the cards to.
     */
    private void paintButtons(Graphics g)
    {
    }

    /**
     * Paints over the cards and paints a resume button in the middle
     * 
     * @param g
     *            the graphics component to paint the cards to.
     */
    private void paintOver(Graphics g)
    {
        
    }

    /**
     * Paints the welcome screen to the frame
     * 
     * @param g
     *            the graphics component to paint the cards to.
     */
    private void paintWelcome(Graphics g)
    {
        
    }

    /**
     * Paints the timer graphic to the screen
     * 
     * @param g
     *            the graphics component to paint the cards to.
     */
    private void paintTimer(Graphics g)
    {
        
    }

    private void paintCardCount(Graphics g)
    {
        
    }

    /**
     * Displays the given page in a different browser page.
     * 
     * @param aPage
     *            the page to load to from the browser 
     */
    public void showPage(String aPage)
    {
        
    }
    /**
     * Paints the selector at the selected row and column 
     * @param g
     */
    private void paintSelectedCard(Graphics g)
    {
        
        
    }

    /**
     * Paints the score graphic to the screen
     * 
     * @param g
     *            the graphics component to paint the cards to.
     */
    private void paintScore(Graphics g)
    {
        
    }

    /**
     * Paints the explain why button
     * 
     * @param g
     *            the graphic to paint the explain button onto.
     */
    private void paintExplain(Graphics g)
    {
        
    }

    /**
     * Returns the currently selected card;
     * 
     * @return returns the currently selected card
     */
    public Card getSelected()
    {
        return null;
    }

    /**
     * Updates the timer graphic
     * 
     * @param e
     *            the source that fired the event
     */
    public void actionPerformed(ActionEvent e)
    {
        
    }

    /**
     * Retrieves the currently selected card
     * 
     * @return the currently selected card
     */
    public void getSelectedCardGraphic()
    {
    }

    /**
     * Redraws or refreshes the user interface after an unexposed
     * change in the GameState
     */
    public void redraw()
    {
    }
}
