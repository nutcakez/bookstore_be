package com.bookstore.bookstorebe.models.requestModels;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class addOrderModel {

    @NotNull(message = "user id must be present")
    @Min(value=1,message="userid must be present and must be bigger than 0")
    private int userid;

    @NotEmpty(message = "bookids must be present. example \"bookids:\":[10,11,13]")
    private int[] bookIds;

    public int getUserId() {
        return this.userid;
    }

    public void setid(int userid) {
        this.userid = userid;
    }

    public int[] getBookIds(){
        return this.bookIds;
    }

    public addOrderModel(int userid, int[] bookIds){
        this.userid=userid;
        this.bookIds=bookIds;
    }
}
