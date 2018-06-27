/**
 * Golfbert API
 * This API allows you to access rich golf course information, including gps coordinates and geo polygons of courses holes. This API can only be used in conjunction with a valid api token, access key and secret. More information can be found [here](https://golfbert.com/api).
 *
 * OpenAPI spec version: 1.0.13
 *
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package golfbertAPIClient;

import com.development.cbessee.golfcoursecatalog.R;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-04-16T22:14:27.256-07:00")
public class Configuration {
    final static String ACCESS_KEY = "AKIAIJZCPDQZO4RYSYIA";
    final static String KEY_SECRET = "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";
    final static String API_KEY = "bwmTqxUPfFaMvKQ0rtwRi7Kv0CzCJ9zB12rknFiw";

    private static ApiClient GolfbertApiClient = initApiClient();

    private static ApiClient initApiClient() {
        ApiClient ap = new ApiClient();

        ap.setAccessKey(ACCESS_KEY);
        ap.setKeySecret(KEY_SECRET);
        ap.addDefaultHeader("x-api-key", API_KEY);

        ap.setDebugging(true);

        return ap;
    }

    /**
     * Get the default API client, which would be used when creating API
     * instances without providing an API client.
     *
     * @return Default API client
     */
    public static ApiClient getGolfbertApiClient() {
        return GolfbertApiClient;
    }

    /**
     * Set the default API client, which would be used when creating API
     * instances without providing an API client.
     *
     * @param apiClient API client
     */
    public static void setGolfbertApiClient(ApiClient apiClient) {
        GolfbertApiClient = apiClient;
    }
}
