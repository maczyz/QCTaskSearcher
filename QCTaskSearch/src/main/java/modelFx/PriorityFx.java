package modelFx;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PriorityFx {

    private StringProperty priority = new SimpleStringProperty();

    public StringProperty priorityProperty() {
        return priority;
    }

    public void setPriority(StringProperty priority) {
        this.priority = priority;
    }

    public void setPriority(String priority) {
        this.priority.set(priority);
    }

    // Metoda ta jest wywolywana, gdy probujemy otworzyc ComboBoxa - bez nadpisania tej metody bedziemy miec w wynikach comboBoxa obiekty a nie wartosci
    @Override
    public String toString() {
        return priority.getValue();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((priority == null) ? 0 : priority.toString().hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PriorityFx other = (PriorityFx) obj;
        if (priority == null) {
            if (other.priority != null)
                return false;
        }
        else if (!priority.toString().equals(other.priority.toString()))
            return false;
        return true;
    }
}
