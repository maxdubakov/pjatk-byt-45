package handlers;

import requests.Request;
import responses.Response;


public interface Handler {

    void setNext(Handler handler);

    Response process(Request request);
}
