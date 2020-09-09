enum GToastType { LENGTH_SHORT, LENGTH_LONG }

abstract class GToast {
  Future<dynamic> toast(String msg);

  Future<dynamic> toastLong(String msg);
}
