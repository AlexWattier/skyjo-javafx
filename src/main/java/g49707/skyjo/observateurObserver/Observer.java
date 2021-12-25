package g49707.skyjo.observateurObserver;

/**
 * The interface Observer.
 *
 * @author alexandre
 */
public interface Observer {

    /**
     * Update the view to display the result of the Skyjo
     *
     * @param observable the observable
     * @param arg        the arg
     */
    void update(Observable observable , Object arg);

}
