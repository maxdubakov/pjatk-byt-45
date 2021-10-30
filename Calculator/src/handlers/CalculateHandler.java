package handlers;

import requests.Request;
import responses.BaseResponse;
import responses.Response;
import util.CalculationMetaData;
import util.Sign;

public class CalculateHandler extends BaseHandler {

    @Override
    public Response process(Request request) {
        try {
            CalculationMetaData data = (CalculationMetaData) request.data().get("calcMetaData");
            Response response = new BaseResponse();

            if (data.sign() == Sign.PLUS) {
                response.addData("Success", data.n1()+data.n2());
            } else if (data.sign() == Sign.MINUS) {
                response.addData("Success", data.n1()-data.n2());
            } else if (data.sign() == Sign.DIVIDED_BY) {
                if (data.n2() == 0) {
                    response.addData("Failed", "Division by 0 is not allowed");
                } else {
                    response.addData("Success", data.n1()/data.n2());
                }
            } else {
                response.addData("Success", data.n1() * data.n2());
            }
            return response;

        } catch (Exception e) {
            Response response = new BaseResponse();
            response.addData("Error", "Unable to calculate");
            return response;
        }
    }
}
