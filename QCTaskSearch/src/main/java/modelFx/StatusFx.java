package modelFx;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StatusFx {

    private StringProperty status = new SimpleStringProperty();

    public StringProperty statusProperty() {
        return status;
    }

    public void setStatus(StringProperty status) {
        this.status = status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    // Metoda ta jest wywolywana, gdy probujemy otworzyc ComboBoxa - bez nadpisania tej metody bedziemy miec w wynikach comboBoxa obiekty a nie wartosci
    @Override
    public String toString() {
        return status.getValue();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((status == null) ? 0 : status.toString().hashCode());
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
        StatusFx other = (StatusFx) obj;
        if (status == null) {
            if (other.status != null)
                return false;
        }
        else if (!status.toString().equals(other.status.toString()))
            return false;
        return true;
    }
}
