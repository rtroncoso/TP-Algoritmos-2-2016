package com.cst.model.clinic;

import com.cst.model.employee.Stretcher;

/**
 * Trip class
 * @package com.cst.model
 */
public class Trip {

    /** Status used when stretcher is on route to clinic */
    public final static int STATUS_ON_ROUTE = 1;

    /** Finished trip status */
    public final static int STATUS_FINISHED = 2;

    /** Distance from rescue point to clinic (kilometers) */
    private int distance;

    /** Current distance travelled in the trip (kilometers) */
    private int travelled;

    /** Status of the trip */
    private int status;

    /** Stretcher that carries on the trip */
    private Stretcher stretcher;

    /**
     * Trip class constructor
     * @param distance
     * @param stretcher
     */
    public Trip(int distance, Stretcher stretcher) {
        this.travelled = 0;
        this.distance = distance;
        this.stretcher = stretcher;

        // Trips start on route by default
        this.status = Trip.STATUS_ON_ROUTE;
    }

    /**
     * Default distance traveller (increments travelled distance by 1)
     * @return Trip
     */
    public Trip travel() {
        return this.travel(1);
    }

    /**
     * Performs the travel of a trip incrementing the distance travelled
     * @param distance
     * @return Trip
     */
    public Trip travel(int distance) {
        // TODO : Implement travel method and supply a travel
        //        event for every kilometer carried on the trip
        this.distance += distance;
        return this;
    }

    /**
     * Trip distance getter
     * @return int
     */
    public int getDistance() {
        return distance;
    }

    /**
     * Trip distance setter
     * @param distance
     */
    public void setDistance(int distance) {
        this.distance = distance;
    }

    /**
     * Trip status getter
     * @return int
     */
    public int getStatus() {
        return status;
    }

    /**
     * Trip status setter
     * @param status
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * Trip stretcher getter
     * @return
     */
    public Stretcher getStretcher() {
        return stretcher;
    }

    /**
     * Trip stretcher setter
     * @param stretcher
     */
    public void setStretcher(Stretcher stretcher) {
        this.stretcher = stretcher;
    }

}
