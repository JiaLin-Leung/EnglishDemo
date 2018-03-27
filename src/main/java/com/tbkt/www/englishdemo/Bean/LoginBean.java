package com.tbkt.www.englishdemo.Bean;

import java.io.Serializable;

public class LoginBean implements Serializable{
    /**
     * {
     * "tbkt_token": "NDgwMDAyfTA0MzM3NzA2NjR9MDQzMjM2NTAwOA",
     * "next": "",
     * "error": "",
     * "message": "",
     * "data": {"flag": "0", "user_id": 591113},
     * "response": "ok"
     * }
     */
    private String tbkt_token;
    private String next;
    private String error;
    private String message;
    private String response;
    private Databean_Login data;

    @Override
    public String toString() {
        return "LoginBean{" +
                "tbkt_token='" + tbkt_token + '\'' +
                ", next='" + next + '\'' +
                ", error='" + error + '\'' +
                ", message='" + message + '\'' +
                ", response='" + response + '\'' +
                ", data=" + data +
                '}';
    }


    public class Databean_Login {

        private String flag;
        private String user_id;

        @Override
        public String toString() {
            return "Databean_Login{" +
                    "flag='" + flag + '\'' +
                    ", user_id='" + user_id + '\'' +
                    '}';
        }

        public String getFlag() {
            return flag;
        }

        public void setFlag(String flag) {
            this.flag = flag;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }
    }

    public String getTbkt_token() {
        return tbkt_token;
    }

    public void setTbkt_token(String tbkt_token) {
        this.tbkt_token = tbkt_token;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Databean_Login getData() {
        return data;
    }

    public void setData(Databean_Login data) {
        this.data = data;
    }

}
