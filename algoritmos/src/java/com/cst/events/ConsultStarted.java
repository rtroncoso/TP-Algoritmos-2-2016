package com.cst.events;


import com.cst.events.listeners.ConsultStartedListener;
import com.cst.model.clinic.Consult;

/**
 * ConsultStarted class
 */
public class ConsultStarted implements Event<ConsultStartedListener> {

    /** Consult corresponding to this event */
    private Consult consult;

    /**
     * ConsultStarted class consturctor
     * @param consult
     */
    public ConsultStarted(Consult consult) {
        this.consult = consult;
    }

    /**
     * Notify the listeners of the event
     * @param listener
     */
    public void notify(final ConsultStartedListener listener) {
        listener.onConsultStarted(this.consult);
    }

}
