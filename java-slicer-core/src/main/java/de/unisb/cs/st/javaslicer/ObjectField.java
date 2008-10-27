package de.unisb.cs.st.javaslicer;

public class ObjectField implements Variable {

    private final long objectId;
    private final String fieldName;

    public ObjectField(final long objectId, final String fieldName) {
        this.objectId = objectId;
        this.fieldName = fieldName;
    }

    @Override
    public String toString() {
        return "field["+this.objectId+","+this.fieldName+"]";
    }

    @Override
    public int hashCode() {
        // the fieldName strings are internalized, so we can use identity comparison
        return System.identityHashCode(this.fieldName) + (int)this.objectId;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final ObjectField other = (ObjectField) obj;
        // the fieldName strings are internalized, so we can use identity comparison
        if (this.fieldName != other.fieldName)
            return false;
        if (this.objectId != other.objectId)
            return false;
        return true;
    }

}