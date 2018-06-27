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
import golfbertAPIClient.models.Holeteebox;
import java.util.ArrayList;
import java.util.List;


/**
 * Scorecard
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-04-16T22:14:27.256-07:00")
public class Scorecard   {
  @SerializedName("courseid")
  private Integer courseid = null;

  @SerializedName("coursename")
  private String coursename = null;

  @SerializedName("holeteeboxes")
  private List<Holeteebox> holeteeboxes = new ArrayList<Holeteebox>();

  public Scorecard courseid(Integer courseid) {
    this.courseid = courseid;
    return this;
  }

   /**
   * Get courseid
   * @return courseid
  **/
  @ApiModelProperty(example = "null", required = true, value = "")
  public Integer getCourseid() {
    return courseid;
  }

  public void setCourseid(Integer courseid) {
    this.courseid = courseid;
  }

  public Scorecard coursename(String coursename) {
    this.coursename = coursename;
    return this;
  }

   /**
   * Get coursename
   * @return coursename
  **/
  @ApiModelProperty(example = "null", required = true, value = "")
  public String getCoursename() {
    return coursename;
  }

  public void setCoursename(String coursename) {
    this.coursename = coursename;
  }

  public Scorecard holeteeboxes(List<Holeteebox> holeteeboxes) {
    this.holeteeboxes = holeteeboxes;
    return this;
  }

  public Scorecard addHoleteeboxesItem(Holeteebox holeteeboxesItem) {
    this.holeteeboxes.add(holeteeboxesItem);
    return this;
  }

   /**
   * Get holeteeboxes
   * @return holeteeboxes
  **/
  @ApiModelProperty(example = "null", value = "")
  public List<Holeteebox> getHoleteeboxes() {
    return holeteeboxes;
  }

  public void setHoleteeboxes(List<Holeteebox> holeteeboxes) {
    this.holeteeboxes = holeteeboxes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Scorecard scorecard = (Scorecard) o;
    return Objects.equals(this.courseid, scorecard.courseid) &&
        Objects.equals(this.coursename, scorecard.coursename) &&
        Objects.equals(this.holeteeboxes, scorecard.holeteeboxes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(courseid, coursename, holeteeboxes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Scorecard {\n");
    
    sb.append("    courseid: ").append(toIndentedString(courseid)).append("\n");
    sb.append("    coursename: ").append(toIndentedString(coursename)).append("\n");
    sb.append("    holeteeboxes: ").append(toIndentedString(holeteeboxes)).append("\n");
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

