package it.polito.tdp.anagrammi.model;

public class Lettera {

	private final char valore;
	private final int position;

	/**
	 * @param valore
	 * @param position
	 */
	public Lettera(char valore, int position) {
		this.valore = valore;
		this.position = position;
	}

	/**
	 * @return the valore
	 */
	public char getValore() {
		return valore;
	}

	/**
	 * @return the position
	 */
	public int getPosition() {
		return position;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Lettera [valore=" + valore + ", position=" + position + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + position;
		result = prime * result + valore;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lettera other = (Lettera) obj;
		if (position != other.position)
			return false;
		if (valore != other.valore)
			return false;
		return true;
	}
}
