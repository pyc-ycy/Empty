package com.pyc.empty.facade;

public interface IFragmentCallback {
    void sendMsgToActivity(String key, String msg);
    String getMsgFromActivity(String key);
}
