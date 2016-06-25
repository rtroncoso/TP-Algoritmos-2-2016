package com.cst.events;

/**
 * Event interface
 * @package com.cst.events
 */
public interface Event<L> {

    /**
     * Event notifier implementation
     * @param listener
     */
    void notify(final L listener);

}
