package modelFx;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CommentsArchiveFx {
    private StringProperty commentsArchive = new SimpleStringProperty();

    public StringProperty commentsArchiveProperty() {
        return commentsArchive;
    }

    public void setCommentsArchive(StringProperty commentsArchive) {
        this.commentsArchive = commentsArchive;
    }
}
