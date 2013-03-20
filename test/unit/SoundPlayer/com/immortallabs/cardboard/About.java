package com.immortallabs.cardboard;

/**
 * About knows the credits for this application.
 * 
 * @author J. Dalbey Version History: - 01/14/09 1.1 Updated the About class to
 *         reflect a team of 8 instead of 5 developers by adding getName6,
 *         getName7, and getName8
 */
public class About
{

    /**
     * Return the names of the authors of this application.
     * 
     * @return String names of authors
     */
    public static String getAuthors()
    {
        return getName1() + "/n" + getName2() + "/n" + getName3() + "/n"
                + getName4() + "/n" + getName5() + "/n" + getName6() + "/n"
                + getName7() + "/n" + getName8() + "/n";
    }

    /**
     * Return the name of author 8.
     * 
     * @return the eighth author
     */
    private static String getName8()
    {
        return "Ryan Lange";
    }

    /**
     * Return the name of author 6.
     * 
     * @return the sixth author
     */
    private static String getName6()
    {
        return "Thomas Dvornik";
    }

    /**
     * Return the name of author 7.
     * 
     * @return the seventh author
     */
    private static String getName7()
    {
        return "Bradley Barrows";
    }

    /**
     * Return the name of author 1.
     * 
     * @return the first author
     */
    private static String getName1()
    {
        return "Michael Brooks";
    }

    /**
     * Return the name of author 2.
     * 
     * @return the second author
     */
    private static String getName2()
    {
        return "Lamont Samuels";
    }

    /**
     * Return the name of author 3.
     * 
     * @return the third author
     */
    private static String getName3()
    {
        return "Kyle Williamson";
    }

    /**
     * Return the name of author 4.
     * 
     * @return the fourth author
     */
    private static String getName4()
    {
        return "Justin Appler";
    }

    /**
     * Return the name of author 5.
     * 
     * @return the fifth author
     */
    private static String getName5()
    {
        return "Nikhil Kowshik";
    }

}
