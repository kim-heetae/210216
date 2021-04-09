package book.ch12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ApiExamCaptchaNkey {
//ID - 5NNeHasY7KCWoMGm0suJ
//SECRET - 4zvlywLkoc
	   public static void main(String[] args) {
	        String clientId = "pBSTBEs12eGgstfobIiI"; //애플리케이션 클라이언트 아이디값";
	        String clientSecret = "dwwjvgwg_Y"; //애플리케이션 클라이언트 시크릿값";

	        String code = "0"; // 키 발급시 0,  캡차 이미지 비교시 1로 세팅
	        String apiURL = "https://openapi.naver.com/v1/captcha/nkey?code=" + code;

	        Map<String, String> requestHeaders = new HashMap<>();
	        requestHeaders.put("X-Naver-Client-Id", clientId);
	        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
	        String responseBody = get(apiURL, requestHeaders);
//	        ApiExamCaptchaImage acImage = new ApiExamCaptchaImage(responseBody);
	        System.out.println("main()에서 responseBody:"+responseBody);
	    }
/*
 * 가장 먼저 호출되는 메소드
 * - Map에 요청에 필요한 속성값
 * - connect호출 - 연결통로 확보
 * - 요청에 필요한 정보를 만들어서 전송보냄. -get
 * - 응답메시지가(200, 204, 302) 올때 까지 기다림
 * readBody호출(서버와 연결됨 후에 연결정보를 가진 커넥션에서 InputStream 생성함.
 * 이것을 활용하여 네이버에서 전송해주는 키값을 청취할 수 있다.
 */
	    private static String get(String apiUrl, Map<String, String> requestHeaders){
	        HttpURLConnection con = connect(apiUrl);
	        try {
	            con.setRequestMethod("GET");
	            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
	                con.setRequestProperty(header.getKey(), header.getValue());
	            }

	            int responseCode = con.getResponseCode();
	            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
	                return readBody(con.getInputStream());
	            } else { // 에러 발생
	                return readBody(con.getErrorStream());
	            }
	        } catch (IOException e) {
	            throw new RuntimeException("API 요청과 응답 실패", e);
	        } finally {
	            con.disconnect();
	        }
	    }

	    private static HttpURLConnection connect(String apiUrl){
	        try {
	            URL url = new URL(apiUrl);
	            return (HttpURLConnection)url.openConnection();
	        } catch (MalformedURLException e) {
	            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
	        } catch (IOException e) {
	            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
	        }
	    }

	    private static String readBody(InputStream body){
	    	System.out.println("readBody 호출 성공");
	        InputStreamReader streamReader = new InputStreamReader(body);

	        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
	            StringBuilder responseBody = new StringBuilder();

	            String line;
	            while ((line = lineReader.readLine()) != null) {
	                responseBody.append(line);
	            }
	            System.out.println("readBody()에서 responseBody : "+responseBody);
	            return responseBody.toString();
	        } catch (IOException e) {
	            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
	        }
	    }	

}