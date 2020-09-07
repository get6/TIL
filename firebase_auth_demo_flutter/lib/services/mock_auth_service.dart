import 'dart:async';

import 'package:apple_sign_in/scope.dart';
import 'package:firebase_auth_demo_flutter/services/auth_service.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

import 'package:random_string/random_string.dart' as random;

class MockAuthService implements AuthService {
  MockAuthService({
    this.startupTime = const Duration(milliseconds: 250),
    this.responseTime = const Duration(seconds: 2),
  }) {
    Future<void>.delayed(responseTime).then((_) => _add(null));
  }

  final Duration startupTime;
  final Duration responseTime;

  final Map<String, _UserData> _usersStore = <String, _UserData>{};

  User _currentUser;

  final StreamController<User> _onAuthStateChangedController =
      StreamController<User>();

  @override
  Future<User> createUserWithEmailAndPassword(
      String email, String password) async {
    await Future<void>.delayed(responseTime);
    if (_usersStore.keys.contains(email)) {
      throw PlatformException(
        code: 'ERROR_EMAIL_ALREADY_IN_USE',
        message: 'The email address is already registered. Sign in instead?',
      );
    }
    final User user = User(uid: random.randomAlphaNumeric(32), email: email);
    _usersStore[email] = _UserData(password: password, user: user);
    _add(user);
    return user;
  }

  @override
  Future<User> currentUser() async {
    await Future<void>.delayed(startupTime);
    return _currentUser;
  }

  @override
  void dispose() {}

  @override
  Future<bool> isSignInWithEmailLink(String link) async {
    return true;
  }

  @override
  Stream<User> get onAuthStateChanged => _onAuthStateChangedController.stream;

  @override
  Future<void> sendPasswordResetEmail(String email) async {}

  @override
  Future<void> sendSignInWithEmailLink(
      {String email,
      String url,
      bool handleCodeInApp,
      String iOSBundleID,
      String androidPackageName,
      bool androidInstallIfNotAvailable,
      String androidMinimumVersion}) async {}

  @override
  Future<User> signInAnonymously() async {
    await Future<void>.delayed(responseTime);
    final User user = User(uid: random.randomAlphaNumeric(32));
    _add(user);
    return user;
  }

  @override
  Future<User> signInWithApple({List<Scope> scopes}) async {
    await Future<void>.delayed(responseTime);
    final User user = User(uid: random.randomAlphaNumeric(32));
    _add(user);
    return user;
  }

  @override
  Future<User> signInWithEmailAndLink({String email, String link}) async {
    await Future<void>.delayed(responseTime);
    final User user = User(uid: random.randomAlphaNumeric(32));
    _add(user);
    return user;
  }

  @override
  Future<User> signInWithEmailAndPassword(String email, String password) async {
    await Future<void>.delayed(responseTime);
    if (!_usersStore.keys.contains(email)) {
      throw PlatformException(
        code: 'ERROR_USER_NOT_FOUND',
        message: 'The email address is not registered. Need and account?',
      );
    }
    final _UserData _userData = _usersStore[email];
    if (_userData.password != password) {
      throw PlatformException(
        code: 'ERROR_WRONG_PASSWORD',
        message: 'The password is incorrect. Please try again.',
      );
    }
    _add(_userData.user);
    return _userData.user;
  }

  @override
  Future<User> signInWithFacebook() async {
    await Future<void>.delayed(responseTime);
    final User user = User(uid: random.randomAlphaNumeric(32));
    _add(user);
    return user;
  }

  @override
  Future<User> signInWithGoogle() async {
    await Future<void>.delayed(responseTime);
    final User user = User(uid: random.randomAlphaNumeric(32));
    _add(user);
    return user;
  }

  @override
  Future<void> signOut() async {
    _add(null);
  }

  void _add(User user) {
    _currentUser = user;
    _onAuthStateChangedController.add(user);
  }
}

class _UserData {
  _UserData({@required this.password, @required this.user});
  final String password;
  final User user;
}
