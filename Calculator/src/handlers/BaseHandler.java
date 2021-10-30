package handlers;

import requests.Request;
import responses.Response;

public abstract class BaseHandler implements Handler {

    private Handler next;

    @Override
    public void setNext(Handler handler) {
        if (handler != null) {
            this.next = handler;
        }
    }

    @Override
    public Response process(Request request) {
        if (next != null) {
            return next.process(request);
        }
        System.out.println("The process stopped without any response.");
        return null;
    }

    public Handler getNext() {
        return this.next;
    }
}
