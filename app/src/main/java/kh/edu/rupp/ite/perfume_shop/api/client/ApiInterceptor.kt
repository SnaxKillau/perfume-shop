package kh.edu.rupp.ite.perfume_shop.api.client


import okhttp3.Interceptor
import okhttp3.Response

class ApiInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
//        val token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzZXloYSIsImlhdCI6MTcwMjgwMTEwMCwiZXhwIjoxNzAzMzUwODAwLCJhdXRob3JpdGllcyI6W3siYXV0aG9yaXR5IjoiUk9MRV9DVVNUT01FUiJ9LHsiYXV0aG9yaXR5IjoiYnJhbmQ6cmVhZCJ9LHsiYXV0aG9yaXR5IjoiY2F0ZWdvcnk6cmVhZCJ9XSwiaXNzIjoiU25hUGhvbmVT"
//        val request = if(token != null) {
//            chain.request().newBuilder().addHeader("Authorization", "Bearer $token").build()
//        } else {
//            chain.request()
//        }
        val request = chain.request().newBuilder().addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzZXloYSIsImlhdCI6MTcwMjgwMTEwMCwiZXhwIjoxNzAzMzUwODAwLCJhdXRob3JpdGllcyI6W3siYXV0aG9yaXR5IjoiUk9MRV9DVVNUT01FUiJ9LHsiYXV0aG9yaXR5IjoiYnJhbmQ6cmVhZCJ9LHsiYXV0aG9yaXR5IjoiY2F0ZWdvcnk6cmVhZCJ9XSwiaXNzIjoiU25hUGhvbmVTaG9wIn0.gsnzf1ppLMYjF1OVmU2BdBGrO5L2pc9DK86tOjgMrYQ").build()
        return chain.proceed(request)
    }
}
