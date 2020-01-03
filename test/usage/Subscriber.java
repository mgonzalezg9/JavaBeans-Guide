package usage;

import component.BeanValueListener;
import component.EventBeanValue;

public class Subscriber implements BeanValueListener {
	private int oldValue, newValue;

	@Override
	public void awareOfChangeInValue(EventBeanValue ev) {
		System.out.println("Detected change in value!");
		System.out.println("Old: " + ev.getOldValue() + " New: " + ev.getNewValue() + "\n");
		
		oldValue = ev.getOldValue();
		newValue = ev.getNewValue();
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
