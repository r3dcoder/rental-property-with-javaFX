package helper;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class CustomDateCellFactory<S, T> implements Callback<TableColumn<S, T>, TableCell<S, T>> {
    private final DateFormat dateFormat;

    public CustomDateCellFactory(String dateFormatPattern) {
        this.dateFormat = new SimpleDateFormat(dateFormatPattern);
    }

    @Override
    public TableCell<S, T> call(TableColumn<S, T> param) {
        return new TableCell<S, T>() {
            @Override
            protected void updateItem(T item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(dateFormat.format(item));
                }
            }
        };
    }
}
