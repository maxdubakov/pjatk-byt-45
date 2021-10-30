package handlers;

import requests.Request;
import responses.BaseResponse;
import responses.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ReadHandler extends BaseHandler {

    BufferedReader reader;

    public ReadHandler() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public Response process(Request request) {
        try {
            System.out.print("\n\n\nYour example: ");
            String line = reader.readLine();

            if (line.equalsIgnoreCase("quit")) {
                return null;
            }
            request.addData("raw", line);
            return super.process(request);
        } catch (Exception e) {
            Response response = new BaseResponse();
            response.addData("Error", "Error occurred while reading");
            return response;
        }
    }

    public void close() {
        try {
            this.reader.close();
        } catch (IOException ignore) { }
    }
}
