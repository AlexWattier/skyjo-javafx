package g49707.skyjo.observateurObserver;

/**
 * The interface Observable.
 *
 * @author alexandre
 */
public interface Observable {

    /**
     * Register observer.
     * different view
     *
     * @param observer the observer
     */
    void registerObserver(Observer observer);

    /**
     * call the view for all new calcul
     * Notify observer.
     */
    void notifyObserver();

    /**
     * call the view for all new calcul
     * Notify observer.
     *
     * @param arg the arg
     */
    void notifyObserver(Object arg);

}
