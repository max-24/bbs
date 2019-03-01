package com.bbs.dto;

/*
 *web层与前台交互的对象，ajax把json传给controller，通过@RequestBody转为object
 */
public class ComResult {
    private int state;
    private int id;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getState() {
        return state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setState(int state) {
        this.state = state;
    }

    public ComResult(int state, int id,String message)
    {
        this.state=state;
        this.id=id;
        this.message=message;
    }
    public ComResult(int state,int id)
    {
        this.state=state;
        this.id=id;
    }

}
