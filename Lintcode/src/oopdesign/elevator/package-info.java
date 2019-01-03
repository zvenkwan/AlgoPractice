/**
 * 
 * 1. Our elevator has the basic function that all elevator systems have,
such as moving up and down, open and close doors, and of course, pick up passengers. 
	2. The elevator is supposed to be used in a building having floors numbered from 1 to MaxFloor, where
the first floor is the lobby. 
	3. There are car call buttons in the car corresponding to each floor. For every floor except for the top floor and the lobby, there are two hall call buttons for the
passengers to call for going up and down. There is only one down hall call button at the top floor
and one up hall call button in the lobby. 
	4. When the car stops at a floor, the doors are opened and the car lantern indicating the current direction the car is going is illuminated so that the
passengers can get to know the current moving direction of the car. 
	5. The car moves fast between floors, but it should be able to slow down early enough to stop at a desired floor. In order to
certificate system safety, emergency brake will be triggered and the car will be forced to stop
under any unsafe conditions. 
 */
/**
 * @author jguan
 *
 */
package oopdesign.elevator;