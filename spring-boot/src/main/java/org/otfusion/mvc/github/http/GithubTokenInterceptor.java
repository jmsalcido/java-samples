package org.otfusion.mvc.github.http;

import com.google.common.net.HttpHeaders;
import org.otfusion.mvc.github.GithubProperties;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
public class GithubTokenInterceptor implements ClientHttpRequestInterceptor {

    private final GithubProperties githubProperties;

    public GithubTokenInterceptor(GithubProperties githubProperties) {
        this.githubProperties = githubProperties;
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body,
                                        ClientHttpRequestExecution execution) throws IOException {
        String token = githubProperties.getToken();

        if (StringUtils.hasText(token)) {
            byte[] basicAuthValue = token.getBytes(StandardCharsets.UTF_8);
            request.getHeaders().set(HttpHeaders.AUTHORIZATION,
                    "Basic " + Base64Utils.encodeToString(basicAuthValue));
        }

        return execution.execute(request, body);
    }
}
