/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB;

/**
 *
 * @author User
 */
public class DashboardResponse {
    private String token;
    private String dashboardPage;
    private String userType;

    public DashboardResponse(String token, String userType) {
        this.token = token;
        this.userType = userType;
    }
   
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getDashboardPage() {
        return dashboardPage;
    }

    public void setDashboardPage(String dashboardPage) {
        this.dashboardPage = dashboardPage;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
    
}
