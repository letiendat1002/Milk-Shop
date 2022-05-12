package com.example.milkshop.model;

import java.util.List;

public class DanhMucSpModel {
    boolean success;
    String message;
    List<DanhMucSp> result;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DanhMucSp> getResult() {
        return result;
    }

    public void setResult(List<DanhMucSp> result) {
        this.result = result;
    }
}
