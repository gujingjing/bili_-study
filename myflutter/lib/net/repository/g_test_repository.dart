
import 'package:dio/dio.dart';
import 'package:myflutter/net/api.dart';
import 'package:myflutter/net/base_service.dart';

class TestRepository extends BaseService{

  TestRepository._();
  static TestRepository _instance;
  static TestRepository instance() {
    if (_instance == null) {
      _instance = new TestRepository._();
    }
    return _instance;
  }

  @override
  String baseUrl() {
    return Api.TEST;
  }

  @override
  void initDao(Dio dio) {
    super.initDao(dio);
  }

}