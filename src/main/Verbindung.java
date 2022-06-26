package main;
import javafx.beans.InvalidationListener;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.util.Callback;

import java.sql.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Verbindung {
    BackgroundImage bground = new BackgroundImage(new Image("C:/Users/PC/Desktop/graybg.jpg",1970,
            605, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

    public static Connection connect() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:C:/Users/PC/Desktop/SQLite/TauTourDB.db";
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    public TableView getAdministratoren(){
        TableView tableView = new TableView<>();
        ObservableList<ObservableList> data = FXCollections.observableArrayList();
        Connection conn = connect();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("select * from administrator");
            ResultSet rs = ps.executeQuery();
            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });

                tableView.getColumns().addAll(col);
            }
            while(rs.next()){
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    row.add(rs.getString(i));
                }
                data.add(row);

            }

            tableView.setItems(data);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tableView;
    }

    public TableView getMitarbeitern(){
        TableView tableView = new TableView<>();
        ObservableList<ObservableList> data = FXCollections.observableArrayList();
        Connection conn = connect();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("select * from mitarbeiter");
            ResultSet rs = ps.executeQuery();
            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });

                tableView.getColumns().addAll(col);
            }
            while(rs.next()){
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    row.add(rs.getString(i));
                }
                data.add(row);

            }

            tableView.setItems(data);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tableView;
    }

    public TableView getKunden(){
        TableView tableView = new TableView<>();
        ObservableList<ObservableList> data = FXCollections.observableArrayList();
        Connection conn = connect();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("select * from kunde");
            ResultSet rs = ps.executeQuery();
            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });

                tableView.getColumns().addAll(col);
            }
            while(rs.next()){
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    row.add(rs.getString(i));
                }
                data.add(row);

            }

            tableView.setItems(data);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tableView;
    }

    public TableView getFirmen(){
        TableView tableView = new TableView<>();
        ObservableList<ObservableList> data = FXCollections.observableArrayList();
        Connection conn = connect();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("select * from firma");
            ResultSet rs = ps.executeQuery();
            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });

                tableView.getColumns().addAll(col);
            }
            while(rs.next()){
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    row.add(rs.getString(i));
                }
                data.add(row);

            }

            tableView.setItems(data);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tableView;
    }

    public TableView getVeranstaltungen(){
        TableView tableView = new TableView<>();
        ObservableList<ObservableList> data = FXCollections.observableArrayList();
        Connection conn = connect();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("select * from veranstaltung");
            ResultSet rs = ps.executeQuery();
            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });

                tableView.getColumns().addAll(col);
            }
            while(rs.next()){
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    row.add(rs.getString(i));
                }
                data.add(row);

            }

            tableView.setItems(data);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tableView;
    }

    public TableView getRechnungen(){
        TableView tableView = new TableView<>();
        ObservableList<ObservableList> data = FXCollections.observableArrayList();
        Connection conn = connect();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("select * from rechnung");
            ResultSet rs = ps.executeQuery();
            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });

                tableView.getColumns().addAll(col);
            }
            while(rs.next()){
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    row.add(rs.getString(i));
                }
                data.add(row);

            }

            tableView.setItems(data);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tableView;
    }

    public TableView getReservierungen(){
        TableView tableView = new TableView<>();
        ObservableList<ObservableList> data = FXCollections.observableArrayList();
        Connection conn = connect();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("select * from reservierung");
            ResultSet rs = ps.executeQuery();
            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });

                tableView.getColumns().addAll(col);
            }
            while(rs.next()){
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    row.add(rs.getString(i));
                }
                data.add(row);

            }

            tableView.setItems(data);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tableView;
    }

    public TableView showMonthlyIncome(){
        TableView tableView = new TableView<>();
        ObservableList<ObservableList> data = FXCollections.observableArrayList();
        Connection conn = connect();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT strftime('%m', datum) Monat, SUM(preis) AS Verdienst FROM reservierung GROUP BY monat");
            ResultSet rs = ps.executeQuery();
            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>, ObservableValue<String>>(){
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });

                tableView.getColumns().addAll(col);
            }
            while(rs.next()){
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    row.add(rs.getString(i));
                }
                data.add(row);

            }

            tableView.setItems(data);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tableView;
    }

    public TableView showYearlyIncome(){
        TableView tableView = new TableView<>();
        tableView.setBackground(new Background(bground));
        ObservableList<ObservableList> data = FXCollections.observableArrayList();
        Connection conn = connect();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT strftime('%Y', datum) Jahr, SUM(preis) AS Verdienst FROM reservierung GROUP BY Jahr");
            ResultSet rs = ps.executeQuery();
            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>, ObservableValue<String>>(){
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });

                tableView.getColumns().addAll(col);
            }
            while(rs.next()){
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    row.add(rs.getString(i));
                }
                data.add(row);

            }

            tableView.setItems(data);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tableView;
    }

}