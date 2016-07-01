package com.cst.events;


import com.cst.events.listeners.ConsultFinishedListener;
import com.cst.model.clinic.Consult;

/**
 * ConsultFinished class
 */
public class ConsultFinished implements Event<ConsultFinishedListener> {

    /** Consult corresponding to this event */
    private Consult consult;

    /**
     * ConsultFinished class consturctor
     * @param consult
     */
    public ConsultFinished(Consult consult) {
        this.consult = consult;
    }

    /**
     * Notify the listeners of the event
     * @param listener
     */
    public void notify(final ConsultFinishedListener listener) {
        listener.onConsultFinished(this.consult);
    }

}
