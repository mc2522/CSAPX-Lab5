/**
 * Represents a database.
 *
 * @author Mike Cao
 * @date 10/22/18
 * @assignment Lab 5
 */

import java.util.Collection;

public interface DB<K,V> {

    V addValue​(V value);

    V getValue​(K key);

    boolean hasKey​(K key);

    Collection<V> getAllValues();

}
