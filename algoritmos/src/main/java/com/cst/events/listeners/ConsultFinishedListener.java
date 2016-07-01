package com.cst.events.listeners;

import com.cst.model.clinic.Consult;

/**
 * ConsultFinishedListener interface
 */
public interface ConsultFinishedListener {

    /**
     * Method fired when a consult gets finished
     * @param consult
     */
    void onConsultFinished(Consult consult);

}
