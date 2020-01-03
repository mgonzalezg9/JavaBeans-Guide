# JavaBeans Creation Guide
Creation of a simple JavaBean component. The purpose of this repository is educational.

# Steps to follow
## Create EventBeanValue class that inherits from EventObject. 
This class will store the old and new values of the JavaBean.
## Create BeanValueListener interface that extends from EventListener. 
This interface must have a method forcing implementing classes to fill it with their response to the event.
## Create Bean class
This class must follow this points:
- Implement Serializable. This allows instances of this class to be saved at any time.
- Implement default (empty) constructor and have get, set and is methods.
- Have a List of BeanValueListeners. This list must have methods declared with <i>synchronized</i> modifier to add and remove a certain listener.
- A <i>setValue()</i> method that does the following when a new value is set:
	- Create an EventBeanValue describing the change
	- Create a copy of the listeners' list in a synchronized block
	- Notify each element of the copy using the method they inherit from BeanValueListener
