package com.example.bonnielu.hackthebarriersmessaging;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBIndexHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBIndexRangeKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBRangeKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

import java.util.List;
import java.util.Map;
import java.util.Set;

@DynamoDBTable(tableName = "penpals-mobilehub-90040233-PenPals")

public class PenPalsDO {
    private String _accountID;
    private String _name;
    private String _info;

    @DynamoDBHashKey(attributeName = "AccountID")
    @DynamoDBAttribute(attributeName = "AccountID")
    public String getAccountID() {
        return _accountID;
    }

    public void setAccountID(final String _accountID) {
        this._accountID = _accountID;
    }
    @DynamoDBAttribute(attributeName = "Name")
    public String getName() {
        return _name;
    }

    public void setName(final String _name) {
        this._name = _name;
    }
    @DynamoDBAttribute(attributeName = "info")
    public String getInfo() {
        return _info;
    }

    public void setInfo(final String _info) {
        this._info = _info;
    }

}
