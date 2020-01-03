package component;

import java.util.EventObject;

/**
 * Event that describes Bean's change in value 
 * @author Manuel González
 */
public class EventBeanValue extends EventObject {
	// Non direct implement of Serializable
	private static final long serialVersionUID = 1L;

	private int oldValue, newValue;

	/**
	 * Constructor
	 * @param source Object source of the event
	 * @param oldValue source's oldValue
	 * @param newValue source's newValue
	 */
	public EventBeanValue(Object source, int oldValue, int newValue) {
		super(source);
		this.oldValue = oldValue;
		this.newValue = newValue;
	}

	/**
	 * @return the oldValue
	 */
	public int getOldValue() {
		return oldValue;
	}

	/**
	 * @return the newValue
	 */
	public int getNewValue() {
		return newValue;
	}

}
