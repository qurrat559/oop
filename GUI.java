package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class GUI extends Application {
    Stage window;
    //add memberlist list to array
    List<DefaultMember> memberArrayList = new ArrayList<DefaultMember>();
    //get tableview
    TableView<DefaultMember> tableView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("GYM MANAGER");

        //add table columns
        TableColumn<DefaultMember, String> MembershipID = new TableColumn<>("Membership ID");
        MembershipID.setMinWidth(200);
        MembershipID.setCellValueFactory(new PropertyValueFactory<>("MembershipID"));

        TableColumn<DefaultMember, String> MembershipName = new TableColumn<>("Membership Name");
        MembershipName.setMinWidth(200);
        MembershipName.setCellValueFactory(new PropertyValueFactory("MembershipName"));

        TableColumn<DefaultMember, Date> MembershipDate = new TableColumn<>("Membership Date");
        MembershipDate.setMinWidth(200);
        MembershipDate.setCellValueFactory(new PropertyValueFactory("MembershipDate"));

        tableView = new TableView<>();
        tableView.setItems(getMember());
        //add table to table columns
        tableView.getColumns().addAll(MembershipID, MembershipName, MembershipDate);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(txt1, tableView);


        Scene scene = new Scene(vbox);
        window.setScene(scene);
        window.show();
    }
    //create textField to search numbers
    TextField txt1 = new TextField("Search");

    public ObservableList<DefaultMember> getMember() {
        ObservableList<DefaultMember> defaultMember1 = FXCollections.observableArrayList();
        //add filtered list to search members
        FilteredList<DefaultMember> filteredList = new FilteredList<>(defaultMember1 , e->true);
        txt1.setOnKeyReleased(e ->{
            //add old value and new value
            txt1.textProperty().addListener((observableValue, oldValue, newValue) -> {
                filteredList.setPredicate((Predicate<? super DefaultMember>) defaultMember ->{
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    String lowerCaseFilter = newValue.toLowerCase();
                    //can search memberID
                    if (defaultMember.getMembershipID().contains(newValue)) {
                        return true;
                        //can search memberName
                    } else if (defaultMember.getMembershipName().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    }
                    return false;
                });
            });
            //create sorted list to get filtered list data
            SortedList<DefaultMember> sortedList = new SortedList<>(filteredList);
            sortedList.comparatorProperty().bind(tableView.comparatorProperty());
            tableView.setItems(sortedList);
        });
        try {
            //get data save in file
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("gym.txt"));
            while (true) {
                //save members objects to get read
                DefaultMember defaultMember = (DefaultMember)objectInputStream.readObject();
                if (defaultMember !=null){
                    //add members to array default member class
                    memberArrayList.add(defaultMember);
                }
                else {
                    //end the program
                    System.out.println("End......!");
                    break;
                }
            }
        } catch (IOException e) {
            // e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            //   e.printStackTrace();
        }
        for(int a=0; a<memberArrayList.size();a++){
            //count array list and get members details to the table
            DefaultMember member=memberArrayList.get(a);
            //get details to the table
            defaultMember1.add(new DefaultMember(member.getMembershipID(),member.getMembershipName(),member.getMembershipDate()));
        }
        return defaultMember1;
    }
}
