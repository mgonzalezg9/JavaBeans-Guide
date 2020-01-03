# JavaBeans Creation Guide
Creation of a simple JavaBean component. The purpose of this repository is educational.

# Steps to follow
## Create EventBeanValue class that inherits from EventObject. 
This class will store the old and new values of the JavaBean.

```java
public class EventBeanValue extends EventObject {
	private int oldValue, newValue;
}
```

## Create BeanValueListener interface that extends from EventListener. 
This interface must have a method forcing implementing classes to fill it with their response to the event.

```java
public interface BeanValueListener extends EventListener {
	/**
	 * Method to be run when the event occurs
	 * @param ev Object that describes the change that has been made.
	 */
	public void awareOfChangeInValue(EventBeanValue ev);
}
```

## Create Bean class
This class must follow this points:
- Implement Serializable. This allows instances of this class to be saved at any time.
- Implement default (empty) constructor and have get, set and is methods.
- Have a List of BeanValueListeners. This list must have methods declared with <i>synchronized</i> modifier to add and remove a certain listener.
- A <i>setValue()</i> method that does the following when a new value is set:
	- Create an EventBeanValue describing the change
	- Create a copy of the listeners' list in a <i>synchronized</i> block
	- Notify each element of the copy using the method they inherit from BeanValueListener

```java
// Notifies the change event to all subscribers
EventBeanValue ev = new EventBeanValue(this, oldValue, newValue);
notifyChange(ev);

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
```
