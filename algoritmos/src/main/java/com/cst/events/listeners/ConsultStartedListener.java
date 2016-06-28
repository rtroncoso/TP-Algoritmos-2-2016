package com.cst.events.listeners;

import com.cst.model.clinic.Consult;

/**
 * ConsultStartedListener interface
 */
public interface ConsultStartedListener {

    /**
     * Method fired when a consult gets started
     * @param consult
     */
    void onConsultStarted(Consult consult);

}
