#import "ToastPlugin.h"
#if __has_include(<toast_plugin/toast_plugin-Swift.h>)
#import <toast_plugin/toast_plugin-Swift.h>
#else
// Support project import fallback if the generated compatibility header
// is not copied when this plugin is created as a library.
// https://forums.swift.org/t/swift-static-libraries-dont-copy-generated-objective-c-header/19816
#import "toast_plugin-Swift.h"
#endif

@implementation ToastPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftToastPlugin registerWithRegistrar:registrar];
}
@end
