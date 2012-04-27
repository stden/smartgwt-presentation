package de.thomasletsch.smartgwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.layout.VLayout;

public class Presentation implements EntryPoint {

    @Override
    public void onModuleLoad() {
        VLayout layout = new VLayout(15);
        layout.setWidth("100%");
        layout.setMargin(15);

        final ListGrid grid = new ListGrid();
        grid.setHeight(350);
        grid.setDataSource(CountryDS.getInstance());
        grid.setAutoFetchData(true);
        grid.setCanEdit(true);
        grid.setCanRemoveRecords(true);

        Button addButton = new Button("Neu");
        addButton.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                grid.startEditingNew();
            }
        });

        final DynamicForm form = new DynamicForm();
        form.setNumCols(4);
        form.setIsGroup(true);
        form.setGroupTitle("Bearbeiten");
        form.setDataSource(CountryDS.getInstance());
        SelectItem continent = new SelectItem("continent");
        continent.setOptionDataSource(ContinentDS.getInstance());
        continent.setValueField("name");
        continent.setDisplayField("name");
        form.setFields(new FormItem("countryName"), continent);

        grid.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                form.editSelectedData(grid);
            }
        });

        Button saveButton = new Button("save");
        saveButton.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                form.saveData();
            }
        });

        layout.addMember(grid);
        layout.addMember(addButton);
        layout.addMember(form);
        layout.addMember(saveButton);
        layout.draw();
    }

}
