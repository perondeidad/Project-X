/*
 * @(#)MouseWheelEvent.java	1.7 03/01/23
 *
 * Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

//package java.awt.event;
package net.sourceforge.dvb.projectx.gui;

import java.awt.Component;
//import sun.awt.DebugHelper;


/**
 * An event which indicates that the mouse wheel was rotated in a component.
 * <P>
 * A wheel mouse is a mouse which has a wheel in place of the middle button.
 * This wheel can be rotated towards or away from the user.  Mouse wheels are
 * most often used for scrolling, though other uses are possible.
 * <P>
 * A MouseWheelEvent object is passed to every <code>MouseWheelListener</code>
 * object which registered to receive the "interesting" mouse events using the
 * component's <code>addMouseWheelListener</code> method.  Each such listener
 * object gets a <code>MouseEvent</code> containing the mouse event.
 * <P>
 * Due to the mouse wheel's special relationship to scrolling Components,
 * MouseWheelEvents are delivered somewhat differently than other MouseEvents.
 * This is because while other MouseEvents usually affect a change on 
 * the Component directly under the mouse
 * cursor (for instance, when clicking a button), MouseWheelEvents often have
 * an effect away from the mouse cursor (moving the wheel while
 * over a Component inside a ScrollPane should scroll one of the
 * Scrollbars on the ScrollPane).
 * <P>
 * MouseWheelEvents start delivery from the Component underneath the
 * mouse cursor.  If MouseWheelEvents are not enabled on the
 * Component, the event is delivered to the first ancestor 
 * Container with MouseWheelEvents enabled.  This will usually be
 * a ScrollPane with wheel scrolling enabled.  The source
 * Component and x,y coordinates will be relative to the event's
 * final destination (the ScrollPane).  This allows a complex
 * GUI to be installed without modification into a ScrollPane, and
 * for all MouseWheelEvents to be delivered to the ScrollPane for
 * scrolling.
 * <P>
 * Some AWT Components are implemented using native widgets which
 * display their own scrollbars and handle their own scrolling.  
 * The particular Components for which this is true will vary from
 * platform to platform.  When the mouse wheel is
 * moved over one of these Components, the event is delivered straight to
 * the native widget, and not propagated to ancestors.
 * <P>
 * Platforms offer customization of the amount of scrolling that
 * should take place when the mouse wheel is moved.  The two most
 * common settings are to scroll a certain number of "units"
 * (commonly lines of text in a text-based component) or an entire "block"
 * (similar to page-up/page-down).  The MouseWheelEvent offers
 * methods for conforming to the underlying platform settings.  These
 * platform settings can be changed at any time by the user.  MouseWheelEvents
 * reflect the most recent settings.
 *
 * @author Brent Christian
 * @version 1.7 01/23/03
 * @see MouseWheelListener
 * @see java.awt.ScrollPane
 * @see java.awt.ScrollPane#setWheelScrollingEnabled(boolean)
 * @see javax.swing.JScrollPane
 * @see javax.swing.JScrollPane#setWheelScrollingEnabled(boolean)
 * @since 1.4
 */

public class X_MouseWheelEvent extends java.awt.event.MouseEvent {

    //private static final DebugHelper dbg = DebugHelper.create(MouseWheelEvent.class);

    /**
     * Constant representing scrolling by "units" (like scrolling with the
     * arrow keys)
     * 
     * @see #getScrollType
     */
    public static final int WHEEL_UNIT_SCROLL = 0;

    /**
     * Constant representing scrolling by a "block" (like scrolling
     * with page-up, page-down keys) 
     *
     * @see #getScrollType
     */
    public static final int WHEEL_BLOCK_SCROLL = 1;

    /**
     * Indicates what sort of scrolling should take place in response to this
     * event, based on platform settings.  Legal values are:
     * <ul>
     * <li> WHEEL_UNIT_SCROLL
     * <li> WHEEL_BLOCK_SCROLL
     * </ul>
     * 
     * @see #getScrollType
     */
    int scrollType;

    /**
     * Only valid for scrollType WHEEL_UNIT_SCROLL.
     * Indicates number of units that should be scrolled per
     * click of mouse wheel rotation, based on platform settings.
     *
     * @see #getScrollAmount
     * @see #getScrollType
     */
    int scrollAmount;

    /**
     * Indicates how far the mouse wheel was rotated.
     *
     * @see #getWheelRotation
     */
    int wheelRotation;

    // serial version id?

    /**
     * Constructs a <code>MouseWheelEvent</code> object with the
     * specified source component, type, modifiers, coordinates,
     * scroll type, scroll amount, and wheel rotation.
     * <p>Note that passing in an invalid <code>id</code> results in
     * unspecified behavior.
     *
     * @param source         the <code>Component</code> that originated
     *                       the event
     * @param id             the integer that identifies the event
     * @param when           a long that gives the time the event occurred
     * @param modifiers      the modifier keys down during event
     *                       (shift, ctrl, alt, meta)
     * @param x              the horizontal x coordinate for the mouse location
     * @param y              the vertical y coordinate for the mouse location
     * @param clickCount     the number of mouse clicks associated with event
     * @param popupTrigger   a boolean, true if this event is a trigger for a
     *                       popup-menu 
     * @param scrollType     the type of scrolling which should take place in
     *                       response to this event;  valid values are
     *                       <code>WHEEL_UNIT_SCROLL</code> and
     *                       <code>WHEEL_BLOCK_SCROLL</code>
     * @param  scrollAmount  for scrollType <code>WHEEL_UNIT_SCROLL</code>,
     *                       the number of units to be scrolled
     * @param wheelRotation  the amount that the mouse wheel was rotated (the
     *                       number of "clicks")
     *
     * @see MouseEvent#MouseEvent(java.awt.Component, int, long, int, int, int, int, boolean)
     */
    public X_MouseWheelEvent (Component source, int id, long when, int modifiers,
                      int x, int y, int clickCount, boolean popupTrigger,
                      int scrollType, int scrollAmount, int wheelRotation) {

        super(source, id, when, modifiers, x, y, clickCount, popupTrigger);


        this.scrollType = scrollType;
        this.scrollAmount = scrollAmount;
        this.wheelRotation = wheelRotation;

        //if (dbg.on) {
         //   dbg.println("MouseWheelEvent constructor");
            // Thread.dumpStack();
        //}
    }

    /**
     * Returns the type of scrolling that should take place in response to this
     * event.  This is determined by the native platform.  Legal values are:
     * <ul>
     * <li> MouseWheelEvent.WHEEL_UNIT_SCROLL
     * <li> MouseWheelEvent.WHEEL_BLOCK_SCROLL
     * </ul>
     *
     * @return either MouseWheelEvent.WHEEL_UNIT_SCROLL or
     *  MouseWheelEvent.WHEEL_BLOCK_SCROLL, depending on the configuration of
     *  the native platform.
     * @see java.awt.Adjustable#getUnitIncrement
     * @see java.awt.Adjustable#getBlockIncrement
     * @see javax.swing.Scrollable#getScrollableUnitIncrement
     * @see javax.swing.Scrollable#getScrollableBlockIncrement
     */
    public int getScrollType() {
        return scrollType;
    }

    /**
     * Returns the number of units that should be scrolled in response to this
     * event.  Only valid if <code>getScrollType</code> returns 
     * <code>MouseWheelEvent.WHEEL_UNIT_SCROLL</code>
     *
     * @return number of units to scroll, or an undefined value if
     *  <code>getScrollType</code> returns
     *  <code>MouseWheelEvent.WHEEL_BLOCK_SCROLL</code>
     * @see #getScrollType
     */
    public int getScrollAmount() {
        return scrollAmount;
    }

    /**
     * Returns the number of "clicks" the mouse wheel was rotated.
     *
     * @return negative values if the mouse wheel was rotated up/away from
     * the user, and positive values if the mouse wheel was rotated down/
     * towards the user
     */
    public int getWheelRotation() {
        return wheelRotation;
    }

    /**
     * This is a convenience method to aid in the implementation of
     * the common-case MouseWheelListener - to scroll a ScrollPane or
     * JScrollPane by an amount which conforms to the platform settings.
     * (Note, however, that <code>ScrollPane</code> and
     * <code>JScrollPane</code> already have this functionality built in.)
     * <P>
     * This method returns the number of units to scroll when scroll type is
     * MouseWheelEvent.WHEEL_UNIT_SCROLL, and should only be called if
     * <code>getScrollType</code> returns MouseWheelEvent.WHEEL_UNIT_SCROLL.
     * <P>
     * Direction of scroll, amount of wheel movement,
     * and platform settings for wheel scrolling are all accounted for.
     * This method does not and cannot take into account value of the
     * Adjustable/Scrollable unit increment, as this will vary among
     * scrolling components.
     * <P>
     * A simplified example of how this method might be used in a
     * listener:
     * <pre> 
     *  mouseWheelMoved(MouseWheelEvent event) {
     *      ScrollPane sp = getScrollPaneFromSomewhere(); 
     *      Adjustable adj = sp.getVAdjustable()
     *      if (MouseWheelEvent.getScrollType() == WHEEL_UNIT_SCROLL) {
     *          int totalScrollAmount =
     *              event.getUnitsToScroll() *
     *              adj.getUnitIncrement();
     *          adj.setValue(adj.getValue() + totalScrollAmount);
     *      }
     *  }
     * </pre>
     *
     * @return the number of units to scroll based on the direction and amount
     *  of mouse wheel rotation, and on the wheel scrolling settings of the
     *  native platform
     * @see #getScrollType
     * @see #getScrollAmount
     * @see MouseWheelListener
     * @see java.awt.Adjustable
     * @see java.awt.Adjustable#getUnitIncrement
     * @see javax.swing.Scrollable
     * @see javax.swing.Scrollable#getScrollableUnitIncrement
     * @see java.awt.ScrollPane
     * @see java.awt.ScrollPane#setWheelScrollingEnabled
     * @see javax.swing.JScrollPane
     * @see javax.swing.JScrollPane#setWheelScrollingEnabled
     */
    public int getUnitsToScroll() {
        return scrollAmount * wheelRotation;
    }

    /**
     * Returns a parameter string identifying this event.
     * This method is useful for event-logging and for debugging.
     *
     * @return a string identifying the event and its attributes
     */
    public String paramString() {
        String scrollTypeStr = null;

        if (getScrollType() == WHEEL_UNIT_SCROLL) {
            scrollTypeStr = "WHEEL_UNIT_SCROLL";
        }
        else if (getScrollType() == WHEEL_BLOCK_SCROLL) {
            scrollTypeStr = "WHEEL_BLOCK_SCROLL";
        }
        else {
            scrollTypeStr = "unknown scroll type";
        }
        return super.paramString()+",scrollType="+scrollTypeStr+
         ",scrollAmount="+getScrollAmount()+",wheelRotation="+
         getWheelRotation();
    }
}

