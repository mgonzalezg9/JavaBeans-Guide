package component;

import java.util.EventListener;

/**
 * All subscribers to Bean's value must implement this interface
 * @author Manuel González
 */
public interface BeanValueListener extends EventListener {
	/**
	 * Method to be run when the event occurs
	 * @param ev Object that describes the change that has been made.
	 */
	public void awareOfChangeInValue(EventBeanValue ev);
}
