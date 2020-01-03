package component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * JavaBean component class. This Bean implements Serializable in order to be
 * saved at any time in DB
 * 
 * @author Manuel González
 */
public class Bean implements Serializable {
	// Serializable
	private static final long serialVersionUID = 1203570644596306057L;

	// Attribute
	private int value;

	// Subscriber list to the event
	private List<BeanValueListener> listeners;

	/**
	 * Constructor. Randomizes the value
	 */
	public Bean() {
		value = new Random().nextInt();
		listeners = new ArrayList<>();
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Mutator set method that changes the value to a random new one.
	 */
	public void changeValue() {
		int newValue = new Random().nextInt();
		int oldValue = this.value;

		if (newValue != oldValue) {
			this.value = newValue;

			// Notifies the event of change to all subscribers
			EventBeanValue ev = new EventBeanValue(this, oldValue, newValue);
			notifyChange(ev);
		}
		this.value = newValue;
	}

	// Subscriber list management
	/**
	 * Firstly, creates a copy of the list in order to prevent concurrency problems.
	 * After that, notifies the value change to all subscribers
	 */
	private void notifyChange(EventBeanValue ev) {
		List<BeanValueListener> copy;
		synchronized (this) {
			copy = new ArrayList<>(listeners);
		}

		for (BeanValueListener listener : copy) {
			listener.awareOfChangeInValue(ev);
		}
	}

	/**
	 * Adds the listener to the subscriber list. Synchronized modifier prevents
	 * several threads from modifying the list
	 * 
	 * @param obj Object that will become an event subscriber
	 */
	public synchronized void addListener(BeanValueListener obj) {
		listeners.add(obj);
	}

	/**
	 * Removes the listener from the subscriber list. Synchronized modifier prevents
	 * several threads from modifying the list
	 * 
	 * @param obj Object that will become an event subscriber
	 */
	public synchronized void removeListener(BeanValueListener obj) {
		listeners.remove(obj);
	}

}
