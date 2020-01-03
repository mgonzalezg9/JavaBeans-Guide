# JavaBeans Creation Guide
Creation of a simple JavaBean component. The purpose of this repository is educational.

# Steps to follow
1. Create EventBeanValue class that inherits from EventObject. 
This class will store the old and new values.
2. Create BeanValueListener interface that extends from EventListener. 
This interface must have a method so that implementing classes must fill it with their reply to the event.
3. Create Bean class. This class must follow this points:
- Implement Serializable. This allows instances of this class to be saved at any time.
- Implement default (empty) constructor and have get, set and is methods.
- 
