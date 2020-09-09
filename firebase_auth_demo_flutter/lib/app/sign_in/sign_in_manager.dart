import 'package:firebase_auth_demo_flutter/services/auth_service.dart';
import 'package:flutter/material.dart';

class SignInManager {
  SignInManager({@required this.auth, @required this.isLoading});
  final AuthService auth;
  final ValueNotifier<bool> isLoading;

  Future<User> _signIn(Future<User> Function() signInMethod) async {
    try {
      isLoading.value = true;
      return await signInMethod();
    } catch (e) {
      isLoading.value = false;
      rethrow;
    }
  }

  Future<User> signInAnonymously() async {
    return _signIn(auth.signInAnonymously);
  }

  Future<void> signInWithGoogle() async {
    return _signIn(auth.signInWithGoogle);
  }

  Future<void> signInWithFacebook() async {
    return _signIn(auth.signInWithFacebook);
  }

  Future<void> signInWithApple() async {
    return _signIn(auth.signInWithApple);
  }
}
