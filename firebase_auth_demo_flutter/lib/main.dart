import 'package:firebase_auth_demo_flutter/app/auth_widget_builder.dart';
import 'package:firebase_auth_demo_flutter/app/email_link_error_presenter.dart';
import 'package:firebase_auth_demo_flutter/app/auth_widget.dart';
import 'package:firebase_auth_demo_flutter/services/apple_sign_in_available.dart';
import 'package:firebase_auth_demo_flutter/services/auth_service.dart';
import 'package:firebase_auth_demo_flutter/services/auth_service_adapter.dart';
import 'package:firebase_auth_demo_flutter/services/firebase_email_link_handler.dart';
import 'package:firebase_auth_demo_flutter/services/email_secure_store.dart';
import 'package:firebase_dynamic_links/firebase_dynamic_links.dart';
import 'package:flutter/material.dart';
import 'package:flutter_secure_storage/flutter_secure_storage.dart';
import 'package:provider/provider.dart';

Future<void> main() async {
  WidgetsFlutterBinding.ensureInitialized();
  final appleSignInAvailable = await AppleSignInAvailable().check();
  runApp(MyApp(appleSignInAvailable: appleSignInAvailable));
}

class MyApp extends StatelessWidget {
  const MyApp(
      {this.initialAuthServuceType = AuthServiceType.firebase,
      this.appleSignInAvailable});

  final AuthServiceType initialAuthServiceType;
  final AppleSignInAvailable appleSignInAvailable;

  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    throw UnimplementedError();
  }
}
