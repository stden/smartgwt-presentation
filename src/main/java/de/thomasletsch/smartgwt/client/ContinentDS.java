package de.thomasletsch.smartgwt.client;

import com.smartgwt.client.data.OperationBinding;
import com.smartgwt.client.data.RestDataSource;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.DSOperationType;
import com.smartgwt.client.types.DSProtocol;

public class ContinentDS extends RestDataSource {

    private static ContinentDS instance = null;

    public static ContinentDS getInstance() {
        if (instance == null) {
            instance = new ContinentDS("continentDS");
        }
        return instance;
    }

    public ContinentDS(String id) {

        setID(id);

        DataSourceTextField continentField = new DataSourceTextField("name", "Name");
        continentField.setRequired(true);
        continentField.setPrimaryKey(true);
        continentField.setCanEdit(false);

        setFields(continentField);

        OperationBinding fetch = new OperationBinding();
        fetch.setOperationType(DSOperationType.FETCH);
        fetch.setDataProtocol(DSProtocol.POSTMESSAGE);
        setOperationBindings(fetch);

        setFetchDataURL("data/responses/continent_fetch_rest.xml");
    }
}
