package com.sklagat46.medis.model

//1
public class DataHolder {
    var houseHeadName: String? = null
    var status: String? = null
    var dateofData: String? = null


    public fun DataHolder() {

    }

    public fun DataHolder(houseHeadName: String, dateofData: String, status: String?) {
        this.houseHeadName = houseHeadName
        this.status = status
        this.dateofData = dateofData
    }

    fun getHouseheadName(): String? {
        return houseHeadName
    }

    fun getstatus(): String? {
        return status
    }

    fun getDateData(): String? {
        return dateofData
    }


    fun setHouseHeadName() {
        this.houseHeadName = houseHeadName
    }

    fun setStatus() {
        this.status = status
    }

    fun setDateofData() {
        this.dateofData = dateofData
    }

}