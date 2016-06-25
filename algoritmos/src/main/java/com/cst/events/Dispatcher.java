package com.cst.events;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Event dispatcher class
 *
 * @package com.cst.events
 */
public final class Dispatcher {

    /**
     * Mapping of class events to active listeners
     */
    private final HashMap<Class, ArrayList> map = new HashMap<Class, ArrayList>( 10 );

    /**
     * Add a listener to an event class
     * @param evtClass
     * @param listener
     * @param <L>
     */
    public <L> void listen(Class<? extends Event<L>> evtClass, L listener) {
        final ArrayList<L> listeners = listenersOf(evtClass);
        synchronized(listeners) {
            if ( ! listeners.contains(listener)) {
                listeners.add(listener);
            }
        }
    }

    /**
     * Stop sending an event class to a given listener
     * @param evtClass
     * @param listener
     * @param <L>
     */
    public <L> void mute(Class<? extends Event<L>> evtClass, L listener) {
        final ArrayList<L> listeners = listenersOf(evtClass);
        synchronized(listeners) {
            listeners.remove( listener );
        }
    }

    /**
     * Gets listeners for a given event class
     * @param evtClass
     * @param <L>
     * @return
     */
    private <L> ArrayList<L> listenersOf(Class<? extends Event<L>> evtClass) {
        synchronized ( map ) {
            @SuppressWarnings("unchecked")
            final ArrayList<L> existing = map.get(evtClass);
            if (existing != null) {
                return existing;
            }

            final ArrayList<L> emptyList = new ArrayList<L>(5);
            map.put(evtClass, emptyList);
            return emptyList;
        }
    }


    /**
     * Notify a new event to registered listeners of this event class
     * @param evt
     * @param <L>
     */
    public <L> void notify(final Event<L> evt) {
        @SuppressWarnings("unchecked")
        Class<Event<L>> evtClass = (Class<Event<L>>) evt.getClass();

        for (L listener : listenersOf(evtClass)) {
            evt.notify(listener);
        }
    }

}