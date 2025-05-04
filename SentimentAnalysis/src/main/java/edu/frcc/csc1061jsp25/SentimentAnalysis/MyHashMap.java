package edu.frcc.csc1061jsp25.SentimentAnalysis;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyHashMap<K, V> implements Map<K, V> {

	private final static int INITIAL_NUM_BUCKETS = 4;
	
	private List<Entry<K,V>>[] buckets;
	private int size = 0;
	private static final double LOAD_FACTOR_THRESHHOLD = 0.5;

	private class Entry<K, V> implements Map.Entry<K, V> {
		K key;
		V value;
		
		public Entry (K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public K getKey() {
			return key;
		}

		@Override
		public V getValue() {
			return value;
		}

		@Override
		public V setValue(V value) {
			V oldval = this.value;
			this.value = value;
			return oldval;
		}

	}

	@SuppressWarnings("unchecked")
	public MyHashMap() {
		buckets = new LinkedList[INITIAL_NUM_BUCKETS];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean containsKey(Object key) {
	    return get(key) != null;
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public V get(Object key) {
	    int bucketIndex = Math.abs(key.hashCode()) % buckets.length;
	    if (buckets[bucketIndex] == null) return null;

	    for (Entry<K, V> entry : buckets[bucketIndex]) {
	        if (entry.key.equals(key)) return entry.getValue();
	    }
	    return null;
	}

	@Override
	public V put(K key, V value) {
		// Check if the load factor has exceeded the threshold
		if ((double) size / buckets.length > LOAD_FACTOR_THRESHHOLD) {
			rehash(); // Resize and rehash the entire table
		}

		int bucketIndex = Math.abs(key.hashCode()) % buckets.length;

		// Initialize the bucket if it hasn't been already
		if (buckets[bucketIndex] == null) {
			buckets[bucketIndex] = new LinkedList<>();
		}

		// Check if the key already exists, if so update it
		for (Entry<K, V> entry : buckets[bucketIndex]) {
			if (entry.key.equals(key)) {
				V oldVal = entry.getValue();
				entry.setValue(value);
				return oldVal;
			}
		}

		// Otherwise, add the new key-value pair
		buckets[bucketIndex].add(new Entry<>(key, value));
		size++;
		return null;
	}



	@SuppressWarnings("unchecked")
	private void rehash() {
	    // Save the old bucket array
	    List<Entry<K, V>>[] oldBuckets = buckets;

	    // Create a new bucket array with double the size
	    buckets = new LinkedList[oldBuckets.length * 2];
	    size = 0; // Reset size (it will be recalculated during re-insertion)

	    // Re-insert all existing entries into the new bucket array
	    for (List<Entry<K, V>> bucket : oldBuckets) {
	        if (bucket != null) {
	            for (Entry<K, V> entry : bucket) {
	                put(entry.key, entry.value); // Recalculate index using new size
	            }
	        }
	    }
	}

		@Override
		public V remove(Object key) {
			int bucketIndex = Math.abs(key.hashCode()) % buckets.length;
			if (buckets[bucketIndex] != null) {
				int listIndex = -1;
				for (Entry<K, V> entry : buckets[bucketIndex]) {
					listIndex++;
					if (entry.key.equals(key)) {
						break;
					}
				}
				V val = buckets[bucketIndex].get(listIndex).value;
				buckets[bucketIndex].remove(buckets[bucketIndex].get(listIndex));
				size--;
				return val;
			}
			return null;
		}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
