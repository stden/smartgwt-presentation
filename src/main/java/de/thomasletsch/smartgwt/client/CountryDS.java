package de.thomasletsch.smartgwt.client;

import com.smartgwt.client.data.OperationBinding;
import com.smartgwt.client.data.RestDataSource;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceLinkField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.DSOperationType;
import com.smartgwt.client.types.DSProtocol;

public class CountryDS extends RestDataSource {

    private static CountryDS instance = null;

    public static CountryDS getInstance() {
        if (instance == null) {
            instance = new CountryDS("countryDS");
        }
        return instance;
    }

    public CountryDS(String id) {

        setID(id);

        DataSourceTextField countryCodeField = new DataSourceTextField("countryCode", "Code");
        countryCodeField.setRequired(true);
        countryCodeField.setPrimaryKey(true);
        countryCodeField.setCanEdit(false);

        DataSourceTextField countryNameField = new DataSourceTextField("countryName", "Country");
        countryNameField.setRequired(true);

        DataSourceTextField capitalField = new DataSourceTextField("capital", "Capital");
        DataSourceTextField governmentField = new DataSourceTextField("government", "Government", 500);
        DataSourceBooleanField memberG8Field = new DataSourceBooleanField("member_g8", "G8");
        DataSourceTextField continentField = new DataSourceTextField("continent", "Continent");
        DataSourceDateField independenceField = new DataSourceDateField("independence", "Nationhood");
        DataSourceFloatField areaField = new DataSourceFloatField("area", "Area (km²)");
        DataSourceIntegerField populationField = new DataSourceIntegerField("population", "Population");
        DataSourceFloatField gdpField = new DataSourceFloatField("gdp", "GDP ($M)");
        DataSourceLinkField articleField = new DataSourceLinkField("article", "Info");

        setFields(countryCodeField, countryNameField, capitalField, governmentField, memberG8Field, continentField, independenceField,
                areaField, populationField, gdpField, articleField);

        OperationBinding fetch = new OperationBinding();
        fetch.setOperationType(DSOperationType.FETCH);
        fetch.setDataProtocol(DSProtocol.POSTMESSAGE);
        OperationBinding add = new OperationBinding();
        add.setOperationType(DSOperationType.ADD);
        add.setDataProtocol(DSProtocol.POSTMESSAGE);
        OperationBinding update = new OperationBinding();
        update.setOperationType(DSOperationType.UPDATE);
        update.setDataProtocol(DSProtocol.POSTMESSAGE);
        OperationBinding remove = new OperationBinding();
        remove.setOperationType(DSOperationType.REMOVE);
        remove.setDataProtocol(DSProtocol.POSTMESSAGE);
        setOperationBindings(fetch, add, update, remove);

        setFetchDataURL("data/responses/country_fetch_rest.xml");
        setAddDataURL("data/responses/country_add_rest.xml");
        setUpdateDataURL("data/responses/country_update_rest.xml");
        setRemoveDataURL("data/responses/country_remove_rest.xml");
    }
}
