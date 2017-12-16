package modelFx;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PlannedFixInVersionFx {

    private StringProperty plannedFixInVersion = new SimpleStringProperty();

    public StringProperty plannedFixInVersionProperty() {
        return plannedFixInVersion;
    }

    public void setPlannedFixInVersion(String plannedFixInVersion) {
        this.plannedFixInVersion.set(plannedFixInVersion);
    }

    public void setPlannedFixInVersion(StringProperty plannedFixInVersion) {
        this.plannedFixInVersion = plannedFixInVersion;
    }

    // Metoda ta jest wywolywana, gdy probujemy otworzyc ComboBoxa - bez nadpisania tej metody bedziemy miec w wynikach comboBoxa obiekty a nie wartosci
    @Override
    public String toString() {
        return plannedFixInVersion.getValue();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((plannedFixInVersion == null) ? 0 : plannedFixInVersion.toString().hashCode());
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
        PlannedFixInVersionFx other = (PlannedFixInVersionFx) obj;
        if (plannedFixInVersion == null) {
            if (other.plannedFixInVersion != null)
                return false;
        }
        else if (!plannedFixInVersion.toString().equals(other.plannedFixInVersion.toString()))
            return false;
        return true;
    }
    
    
}
