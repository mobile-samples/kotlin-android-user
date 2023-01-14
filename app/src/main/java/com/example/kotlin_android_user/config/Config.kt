package com.example.kotlin_android_user.config

object Config {
 const val url = "http://10.0.2.2:8082"
 const val authentication_url = "http://10.0.2.2:8082"
 const val sigup_url = url + "/signup"
 const val password_url = url + "/password"
 const val oauth2_url = url + "/Oauth2"
 const val user_url = url + "/users"
 const val role_url = url + "/roles"
 const val privilege_url = url + "/privileges"
 const val audit_log_url = url + "/audit-logs"
 const val company_url = url + "/companies"
 const val company_rate_url = url + "/companies/rates"
 const val company_search_rate_url = url + "/companies/rates/search"
 const val company_rate_comment_url = url + "/companies/rates/comment"
 const val company_categories_url = url + "/companies/categories"
}
