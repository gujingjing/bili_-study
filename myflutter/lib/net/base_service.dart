import 'package:dio/dio.dart';

abstract class BaseService {

  Dio _dio;
  BaseService() {
    _dio = createDefaultDio(baseUrl());
    initDao(_dio);
  }

  String baseUrl();

  void initDao(Dio dio){

  }

//get请求结构
  Future get(String url, {Map<String, dynamic> params}) async {
    _dio.options.baseUrl = baseUrl();
    var response = await _dio.get(url, queryParameters: params);
    return response.data;
  }

  //post
  Future post(String url, Map<String, dynamic> params) async {
    _dio.options.baseUrl = baseUrl();
    var response = await _dio.post(url, data: params);
    return response.data;
  }


  ///具体配置参考官网  https://github.com/flutterchina/dio/blob/master/README-ZH.md#%E8%AF%B7%E6%B1%82%E9%85%8D%E7%BD%AE
  var baseOptions = new BaseOptions(
      connectTimeout: 5000,
      receiveTimeout: 3000,
      responseType: ResponseType.plain,
      contentType: Headers.formUrlEncodedContentType);

  var _baseInterceptors = [
    LogInterceptor(responseBody: true, requestBody: true)
  ];

  ///提供给外部使用的扩展适配器
  List<Interceptor> generateInterceptors(){
    return null;
  }

  Dio createDefaultDio(String baseUrl) {
    Dio dio = new Dio();
    dio.options = baseOptions..baseUrl = baseUrl;
    //base基础适配器
    dio.interceptors.addAll(_baseInterceptors);
    //扩展适配器
    var extendInterceptors=generateInterceptors();
    if(extendInterceptors!=null||extendInterceptors.length>0){
      dio.interceptors.addAll(extendInterceptors);
    }
    return dio;
  }

}
