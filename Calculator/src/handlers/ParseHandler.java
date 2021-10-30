package handlers;

import requests.BaseRequest;
import requests.Request;
import responses.BaseResponse;
import responses.Response;
import util.CalculationMetaData;
import util.Sign;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseHandler extends BaseHandler {

    @Override
    public Response process(Request request) {
        String regex = "^([0-9]+)\\s*([-+/*])\\s*([0-9]+)$";
        String input = (String)request.data().get("raw");

        Matcher matcher = Pattern.compile(regex).matcher(input);
        if (matcher.find()) {
            double n1 = Double.parseDouble(matcher.group(1));
            Sign sign = Sign.stringToSign(matcher.group(2));
            double n2 = Double.parseDouble(matcher.group(3));
            CalculationMetaData data = new CalculationMetaData(n1, sign, n2);
            request.addData("calcMetaData", data);

            return super.process(request);
        }
        Response response = new BaseResponse();
        response.addData("Error", "Encountered unrecognizable mathematical equation");
        return response;
    }
}
