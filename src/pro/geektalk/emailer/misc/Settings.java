package pro.geektalk.emailer.misc;

import java.util.HashMap;
import java.util.Map;

import pro.geektalk.emailer.util.MethodProvider;

public class Settings extends MethodProvider {

	private HashMap<String, String> map = new HashMap<String, String>();

	public Settings() {

	}

	public Settings(final String key, final String value) {
		this.map.put(key, value);
	}

	public Settings(final String[] keys, final String[] values) {
		if (keys.length != values.length) {
			throw new ArrayStoreException(
					"keys and values must match in length!");
		}
		for (int i = 0; i < keys.length; i++) {
			this.map.put(keys[i], values[1]);
			log(String.format("Sucessfully added %s settings!", keys.length));
		}
	}

	public void resetSettings() {
		this.map.clear();
	}

	public Map<String, String> getSettings() {
		return this.map;
	}

	public int getSettingsCount() {
		return this.map.size();
	}

	public String[] getAllKeys() {
		return (String[]) this.map.keySet().toArray();
	}

	public String[] getAllValues() {
		return (String[]) this.map.values().toArray();
	}

	public String getSetting(final String key) {
		if (!this.map.containsKey(key))
			throw new ArrayIndexOutOfBoundsException("Not a valid setting");
		return this.map.get(key);
	}

	public void changeSetting(final String key, final String newValue) {
		if (!this.map.containsKey(key))
			throw new ArrayIndexOutOfBoundsException("Not a valid setting");
		final String[] keys = (String[]) this.map.keySet().toArray();
		final String[] values = (String[]) this.map.values().toArray();
		this.map.clear();
		for (int i = 0; i < keys.length; i++) {
			if (keys[i].equals(key)) {
				values[i] = newValue;
			}
			this.map.put(keys[i], values[i]);
		}
	}

	public void addSetting(final String key, final String value) {
		this.map.put(key, value);
	}

	public void clearSetting(final String key) {
		changeSetting(key, "");
	}

	public String getInfoByKey(final String key) {
		return getInfoByKey(key, false);
	}

	public String getInfoByValue(final String value) {
		return getInfoByValue(value, false);
	}

	public String getInfoByKey(final String key, final boolean formatted) {
		if (!this.map.containsKey(key))
			throw new ArrayIndexOutOfBoundsException("Not a valid setting");
		return formatted ? String.format("Setting %s: %s", key,
				this.map.get(key)) : key + ":" + this.map.get(key);
	}

	public String getInfoByValue(final String value, final boolean formatted) {
		if (!this.map.containsValue(value))
			throw new ArrayIndexOutOfBoundsException("Not a valid setting");
		String retkey = null, retval = null;
		int count = 0;
		b: for (String s : this.map.values()) {
			if (s.equals(value)) {
				retval = s;
				retkey = (String) this.map.keySet().toArray()[count];
				break b;
			}
			count++;
		}

		return formatted ? String.format("Setting %s: %s", retkey, retval)
				: retkey + ":" + retval;
	}

}
