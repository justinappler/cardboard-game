package com.immortallabs.cardboard.ui;
//package edu.profdalbey;

/*
 * @(#)Natural.java	
 * 
 */

/**
 * A natural number is a non-negative integer.  All operations behave 
 * like Java's primitive integer types.  Natural provides analogues to most of 
 * Java's primitive integer operators, and most relevant methods from java.lang.Math.
 * Additionally, Natural provides operations for modular arithmetic.
 * <p>
 * Semantics of arithmetic operations exactly mimic those of Java's integer
 * arithmetic operators, as defined in <i>The Java Language Specification</i>.
 * For example, division by zero throws an <tt>ArithmeticException</tt>, and
 * division of a negative by a positive yields a negative (or zero) remainder.
 * <p>
 * Comparison operations perform signed integer comparisons, analogous to
 * those performed by Java's relational and equality operators.
 * <p>
 * For the sake of brevity and clarity, pseudo-code is used throughout the
 * descriptions of Natural methods.  The pseudo-code expression
 * <tt>(i + j)</tt> is shorthand for "a Natural whose value is
 * that of the Natural <tt>i</tt> plus that of the Natural <tt>j</tt>."
 * The pseudo-code expression <tt>(i == j)</tt> is shorthand for
 * "<tt>true</tt> if and only if the Natural <tt>i</tt> represents the same
 * value as the the Natural <tt>j</tt>."  Other pseudo-code expressions are
 * interpreted similarly.
 *
 * @author  John Dalbey, edited by Sean Dinsmore, Thomas Bouldin
 * @version 1.5  3/20/2006
 * Enhanced to include a maxvalue.
 * 3/9/05 modified equals() to not consider maxvalue.
 * 3/12/05 removed named constants zero and one.
 * 3/20/06 added compareTo(int) method.
 */
import java.util.StringTokenizer;
import java.lang.Character;
import java.lang.Math;

public class Natural implements Comparable
{

    /**
     * The implementation of Natural
     */
    private int value;
    private int MAXVALUE;

    //Constructors

    /**
     * Translates the decimal String representation of a Natural into a
     * Natural.  The String representation consists of an optional minus
     * sign followed by a sequence of one or more decimal digits.  The
     * character-to-digit mapping is provided by <tt>Character.digit</tt>.
     * The String may not contain any extraneous characters (whitespace, for
     * example).
     *
     * @param val decimal String representation of Natural.
     * @throws NumberFormatException <tt>val</tt> is not a valid representation
     *	       of a Natural.
     * @see    Character#digit
     */
    public Natural(String val)
    {

        StringTokenizer tokenizer = new StringTokenizer(val," ");

        if (tokenizer.countTokens() > 1)
        {
            throw new NumberFormatException();
        }

        if (val.charAt(0) == '-')
        {
            val = val.substring(1,val.length());
        }

        value = 0;
        for (int i=0; i<val.length(); i++)
        {

            if ( !Character.isDigit(val.charAt(i)) )
            {
                throw new NumberFormatException();
            }
            value = value + (int)(Character.digit(val.charAt(i),10)*
                                  (Math.pow(10,val.length() - i - 1)));
        }
        MAXVALUE = -1;

    } //end method Natural()

    /**
     * Constructs a Natural with the specified int value.
     *
     * @param val int representation of Natural.
     * @throws NumberFormatException if <tt>val</tt> is negative
     */
    public Natural(int val)
    {

        if (val < 0)
        {
            throw new NumberFormatException();
        }
        value = val;
        MAXVALUE = -1;
    }

    /**
     * Constructs a Natural with the specified int value and maximum.
     *
     * @param val int representation of Natural.
     * @param max int value that is the max this number can take.
     * @throws NumberFormatException if <tt>val</tt> is negative
     * @throws NumberFormatException if <tt>max</tt> is negative
     */
    public Natural(int val, int max)
    {

        if (val < 0 || max < 0)
        {
            throw new NumberFormatException();
        }
        value = val;
        MAXVALUE = max;
    }

    // Arithmetic Operations

    /**
     * Returns a Natural whose value is <tt>(this + val)</tt>.
     *
     * @param  val value to be added to this Natural.
     * @return <tt>this + val</tt>
     */
    public Natural add
        (Natural val)
    {
        if( value + val.intValue() > MAXVALUE && MAXVALUE != -1)
            throw new ArithmeticException();
        Natural answer = new Natural(val.intValue() + value);
        answer.MAXVALUE = MAXVALUE;
        return answer;

    }

    /**
     * Adds one to this Natural.
     * @throws ArithmeticException() if this natural has a maximum value
     * and the result of incrementing exceeds the maximum value.
     *
     */
    public void increment()
    {
        if (value + 1 > MAXVALUE && MAXVALUE != -1)
            throw new java.lang.ArithmeticException();  //OverflowException();
        value = value + 1;
    }


    /**
     * Returns a Natural whose value is <tt>(this - val)</tt>.
     *
     * @param  val value to be subtracted from this Natural.
     * @return <tt>this - val</tt>
     * @throws ArithmeticException if result would be negative.
     */
    public Natural subtract(Natural val)
    {

        if (value - val.value < 0)
        {
            throw new java.lang.ArithmeticException();
        }
        else
        {
            Natural answer = new Natural( value - val.value);
            answer.MAXVALUE = MAXVALUE;
            return answer;
        }
    }

    /**
     * Subtracts one from this Natural.
     * @throws ArithmeticException if result would be negative.
     */
    public void decrement()
    {
        if (value - 1 < 0)
            throw new ArithmeticException();
        value = value - 1;
    }

    /**
     * Returns a Natural whose value is <tt>(this * val)</tt>.
     *
     * @param  val value to be multiplied by this Natural.
     * @return <tt>this * val</tt>
     */
    public Natural multiply(Natural val)
    {
        if(MAXVALUE != -1 && value* val.intValue() > MAXVALUE)
        {
            throw new ArithmeticException();
        }
        Natural answer = new Natural(value * val.intValue());
        answer.MAXVALUE = MAXVALUE;
        return answer;
    }


    /**
     * Returns a Natural whose value is <tt>(this<sup>2</sup>)</tt>.
     *
     * @return <tt>this<sup>2</sup></tt>
     */
    public Natural square()
    {
        if(value*value > MAXVALUE && MAXVALUE != -1)
            throw new ArithmeticException();
        Natural answer =new Natural(value * value);
        answer.MAXVALUE = MAXVALUE;
        return answer;

    }


    /**
     * Returns a Natural whose value is <tt>(this / val)</tt>.
     *
     * @param  val value by which this Natural is to be divided.
     * @return <tt>this / val</tt>
     * @throws ArithmeticException <tt>val==0</tt>
     */
    public Natural divide(Natural val)
    {

        if (val.intValue() == 0)
        {
            throw new ArithmeticException();
        }
        Natural answer = new Natural(value / val.intValue());
        answer.MAXVALUE = MAXVALUE;
        return answer;

    }


    /**
     * Returns a Natural whose value is <tt>(this % val)</tt>.
     *
     * @param  val value by which this Natural is to be divided, and the
     *	       remainder computed.
     * @return <tt>this % val</tt>
     * @throws ArithmeticException <tt>val==0</tt>
     */
    public Natural remainder(Natural val)
    {

        if (val.value == 0)
        {

            throw new ArithmeticException();
        }

        // 3 line step to build and return the answer is not necessary here
        // because there is no MAXVALUE to set.  (3 line method is otherwise
        // necessary because of the case where MAXVALUE = -1
        return new Natural(value % val.intValue());

    }

    /**
     * Returns a Natural whose value is <tt>(this<sup>exponent</sup>)</tt>.
     * Note that <tt>exponent</tt> is an integer rather than a Natural.
     *
     * @param  exponent exponent to which this Natural is to be raised.
     * @return <tt>this<sup>exponent</sup></tt>
     * @throws ArithmeticException <tt>exponent</tt> is negative.  (This would
     *	       cause the operation to yield a non-integer value.)
     */
    public Natural pow(int exponent)
    {

        if (exponent < 0)
        {
            throw new ArithmeticException();
        }

        if (exponent == 0)
        {
            Natural answer =  new Natural(1);
            answer.MAXVALUE = MAXVALUE;
            return answer;
        }

        int temp = value;

        for (int i=1; i<exponent; i++)
        {
            temp = temp * value;
        }

        if (temp > MAXVALUE && MAXVALUE != -1)
            throw new ArithmeticException();

        Natural answer = new Natural(temp);
        answer.MAXVALUE = MAXVALUE;
        return answer;

    }


    // Comparison Operations

    /**
     * Compares this Natural with the specified Natural.  This method is
     * provided in preference to individual methods for each of the six
     * boolean comparison operators (&lt;, ==, &gt;, &gt;=, !=, &lt;=).  The
     * suggested idiom for performing these comparisons is:
     * <tt>(x.compareTo(y)</tt> &lt;<i>op</i>&gt; <tt>0)</tt>,
     * where &lt;<i>op</i>&gt; is one of the six comparison operators.
     *
     * @param  val Natural to which this Natural is to be compared.
     * @return -1, 0 or 1 as this Natural is numerically less than, equal
     *         to, or greater than <tt>val</tt>.
     */
    public int compareTo(Natural val)
    {

        if (value < val.value)
        {
            return (-1);
        }
        if (value == val.value)
        {
            return 0;
        }
        return 1;

    } //end method compareTo

    /**
     * Compares this Natural with the specified integer.  
     *
     * @param  val int to which this Natural is to be compared.
     * @pre    val >= 0
     * @return -1, 0 or 1 as this Natural is numerically less than, equal
     *         to, or greater than <tt>val</tt>.
     */
    public int compareTo(int val)
    {
        Natural natval = new Natural(val);
        return this.compareTo(natval);
    } //end method compareTo

    /**
     * Same as compareTo() above, just taking an object as parameter.
     */
    public int compareTo(Object x)
    {
        Natural temp = (Natural)(x);
        return this.compareTo(temp);
    }

    /**
     * Compares this Natural with the specified Object for equality.
     *
     * @param  x Object to which this Natural is to be compared.
     * @return <tt>true</tt> if and only if the specified Object is a
     *	       Natural whose value is numerically equal to this Natural.
     */
    public boolean equals(Object x)
    {
        if (x == null)
            return false;
        if (x.getClass() != getClass())
            return false;

        Natural temp = (Natural)(x);
        return ( temp.value == value );

    }

    /**
     * Returns the minimum of this Natural and <tt>val</tt>.
     *
     * @param  val value with with the minimum is to be computed.
     * @return the Natural whose value is the lesser of this Natural and 
     *	       <tt>val</tt>.  If they are equal, either may be returned.
     */
    public Natural min(Natural val)
    {
        Natural answer;

        if (value < val.value)
        {
            answer = new Natural(value);
            answer.MAXVALUE = MAXVALUE;
        }
        else
        {
            answer = new Natural(val.value);
            answer.MAXVALUE = val.MAXVALUE;
        }
        return answer;
    }

    /**
     * Returns the maximum of this Natural and <tt>val</tt>.
     *
     * @param  val value with with the maximum is to be computed.
     * @return the Natural whose value is the greater of this and
     *         <tt>val</tt>.  If they are equal, either may be returned.
     */
    public Natural max(Natural val)
    {
        Natural answer;
        if (value > val.value)
        {
            answer = new Natural(value);
            answer.MAXVALUE = MAXVALUE;
        }
        else
        {
            answer = new Natural(val.value);
            answer.MAXVALUE = val.MAXVALUE;
        }
        return answer;
    }



    /**
     * Returns the decimal String representation of this Natural.  The
     * digit-to-character mapping provided by <tt>Character.forDigit</tt> is
     * used, and a minus sign is prepended if appropriate.  (This
     * representation is compatible with the (String) constructor, and allows
     * for String concatenation with Java's + operator.)
     *
     * @return decimal String representation of this Natural.
     * @see    Character#forDigit
     */
    public String toString()
    {
        return String.valueOf(value);
    }


    /**
     * Converts this Natural to an int.  
     *
     * @return this Natural converted to an int.
     */
    public int intValue()
    {
        return value;
    }

    /**
     * Converts this Natural to a long.  
     *
     * @return this Natural converted to a long.
     */
    public long longValue()
    {
        return (long)(value);
    }

    /**
     * Converts this Natural to a float.  
     * @return this Natural converted to a float.
     */
    public float floatValue()
    {
        return (float)(value);
    }

    /**
     * Converts this Natural to a double.  
     *
     * @return this Natural converted to a double.
     */
    public double doubleValue()
    {
        return (double)(value);
    }


    /**
     * Returns the max value of the natural number (-1 means no max)
     *
     * @return <pre>-1</pre> if there is no max, otherwise the max
     */
    public int getMax()
    {
        return MAXVALUE;
    }

    // for future use
    //class OverflowException extends Exception {}

    /**
     *  A local test driver 
     */
    public static void main(String[] args)
    {

        Natural one = new Natural(2);
        Natural two = new Natural("4");
        Natural sum = new Natural("9");

        System.out.println("Unit test of Natural class.");
        System.out.println("First Natural: " + one + "\nSecond Natural: " + two);
        System.out.println("First + Second: " + one.add(two));
        System.out.println("Second - First: " + two.subtract(one));
        System.out.println("First * Second: " + one.multiply(two));
        System.out.println("Second / First: " + two.divide(one));
        System.out.println("First compareTo Second: " + one.compareTo(two));
        System.out.println("First compareTo 0 (int) " + one.compareTo(0));
        System.out.println("First compareTo 2 (int) " + one.compareTo(2));
        System.out.println("First compareTo 5 (int) " + one.compareTo(5));
        System.out.println("First compareTo Second (Object) " + one.compareTo((Object) two));
        System.out.println("First equals Second?: " + one.equals(two));
        System.out.println("First remainder() Second: " + one.remainder(two));
        System.out.println("First Squared: " + one.square());
        System.out.println("First^3: " + one.pow(3) + "\nSecond^4: " + two.pow(4));
        System.out.println("First/Second min?: " + one.min(two));
        System.out.println("First/Second max?: " + one.max(two));
        one.increment();
        System.out.println("First incremented: " + one);
        two.decrement();
        System.out.println("Second decremented: " + two);

        // throw an exception
        Natural big = new Natural(1,2);
        System.out.println("try to exceed MAX: ");
        big.increment();
        System.out.println("BIG = " + big);
        big.increment();
        System.out.println("BIG = " + big);
        // throw an exception
        System.out.println("try to make a negative: " + one.subtract(new Natural(999)));

    }

}


