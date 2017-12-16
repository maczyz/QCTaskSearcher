package modelFx;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class FocusAreaFx {

    private StringProperty focusArea = new SimpleStringProperty();

    public StringProperty focusAreaProperty() {
        return focusArea;
    }

    public void setFocusArea(StringProperty focusArea) {
        this.focusArea = focusArea;
    }

    public void setFocusArea(String focusArea) {
        this.focusArea.set(focusArea);
    }

    // Metoda ta jest wywolywana, gdy probujemy otworzyc ComboBoxa - bez nadpisania tej metody bedziemy miec w wynikach comboBoxa obiekty a nie wartosci
    @Override
    public String toString() {
        return focusArea.getValue();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((focusArea == null) ? 0 : focusArea.toString().hashCode());
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
        FocusAreaFx other = (FocusAreaFx) obj;
        if (focusArea == null) {
            if (other.focusArea != null)
                return false;
        }
        else if (!focusArea.toString().equals(other.focusArea.toString()))
            return false;
        return true;
    }
}
