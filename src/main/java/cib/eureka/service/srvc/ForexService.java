package cib.eureka.service.srvc;

import cib.eureka.service.model.RateRequest;
import cib.eureka.service.model.RateResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ForexService {

    @Value("${app.url:test}")
    private String url;

    @Value("${app.appId}")
    private String appId;

    @Autowired
    private ObjectMapper mapper;

    public RateResponse getRates(RateRequest request) {

        try {
            HttpUrl hurl = HttpUrl.parse(url)
                    .newBuilder()
                    .addQueryParameter("app_id", appId)
                    .addQueryParameter("symbols", StringUtils.join(request.getTo(), ","))
                    .build();

            Request req = new Request.Builder()
                    .url(hurl)
                    .build();

            Response res = new OkHttpClient.Builder().build().newCall(req).execute();
            String json = res.body().string();

            return mapper.readerFor(RateResponse.class).readValue(json);

        } catch (IOException | NullPointerException e) {
            //-- sed message
            e.printStackTrace();
        }

        return null;
    }

}
