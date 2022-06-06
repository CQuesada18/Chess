package poker.multiplayer;

import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Creates a packet of information to transmit over the server.
 * Packets are data that are sent for every client to view.
 * @author Matthew Vandenberg
 *
 * @param <E> Helps to type-safe the type of data being sent. This needs to be
 * serializable because it will be sent over a data stream.
 */
public class Packet<E extends Serializable> implements Serializable, Comparable<Packet<?>> {

	private static final long serialVersionUID = 4580439434911605481L;

	/**
	 * Will store all packets ever created, acts as a history.
	 */
	public static ConcurrentHashMap<String, Object> allSentData = new ConcurrentHashMap<>();
	/**
	 * Time is only necessary for local uses (not sent), so it's marked as transient which 
	 * will not be Serialized.
	 */
	public transient long UID;
	public String key;
	public E data;
	
	/**
	 * Constructs a new Packet of data.
	 * @param key Key of data that refers to the data
	 * @param data Data to keep in packet
	 */
	public Packet(String key, E data) {
		this.key = key;
		this.data = data;
		this.UID = System.nanoTime();
		allSentData.put(key, (Object) this.data);
	}
	
	/**
	 * Return the data at a particular key
	 * @param key Key to search for
	 * @return Data at that object
	 * @throws IllegalStateException Packet does not exist
	 */
	public static Object getPacket(String key) {
		Object value = allSentData.get(key);
		if (value  == null) {
			throw new IllegalStateException("Packet " + key + " not found.");
		}
		return value;
	}
	
	/**
	 * Compares two packets together based on the time they were created.
	 * @param packet Packet to compare to this
	 * @return Negative if this comes before packet, positive otherwise
	 */
	public int compareTo(Packet<?> packet) {
		return (int) (this.UID - packet.UID);
	}
	
	public String toString() {
		return this.key + ", " + this.data + " : " + new Date(this.UID).toString();
	}
}
