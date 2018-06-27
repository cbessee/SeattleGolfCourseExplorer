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


package golfbertAPIClient.models;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import golfbertAPIClient.models.Holepolygon;
import java.util.ArrayList;
import java.util.List;


/**
 * Listofholepolygons
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-04-16T22:14:27.256-07:00")
public class Listofholepolygons   {
  @SerializedName("resources")
  private List<Holepolygon> resources = new ArrayList<Holepolygon>();

  public Listofholepolygons resources(List<Holepolygon> resources) {
    this.resources = resources;
    return this;
  }

  public Listofholepolygons addResourcesItem(Holepolygon resourcesItem) {
    this.resources.add(resourcesItem);
    return this;
  }

   /**
   * Get resources
   * @return resources
  **/
  @ApiModelProperty(example = "null", required = true, value = "")
  public List<Holepolygon> getResources() {
    return resources;
  }

  public void setResources(List<Holepolygon> resources) {
    this.resources = resources;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Listofholepolygons listofholepolygons = (Listofholepolygons) o;
    return Objects.equals(this.resources, listofholepolygons.resources);
  }

  @Override
  public int hashCode() {
    return Objects.hash(resources);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Listofholepolygons {\n");
    
    sb.append("    resources: ").append(toIndentedString(resources)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
