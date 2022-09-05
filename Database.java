package DB;

import javax.swing.*;
import java.sql.Connection;

public interface Database {
        void DatabaseSearch(Connection connection, String string, JTable table);
}
