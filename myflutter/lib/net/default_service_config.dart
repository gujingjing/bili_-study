import 'package:dio/dio.dart';

///具体配置参考官网  https://github.com/flutterchina/dio/blob/master/README-ZH.md#%E8%AF%B7%E6%B1%82%E9%85%8D%E7%BD%AE
var baseOptions = new BaseOptions(
    connectTimeout: 5000,
    receiveTimeout: 3000,
    responseType: ResponseType.plain,
    contentType: Headers.formUrlEncodedContentType);

var baseInterceptors = [
  LogInterceptor(responseBody: true, requestBody: true)
];

Dio createDefaultDio(String baseUrl) {
  Dio dio = new Dio();
  dio.options = baseOptions..baseUrl = baseUrl;
  dio.interceptors.addAll(baseInterceptors);

  return dio;
}

