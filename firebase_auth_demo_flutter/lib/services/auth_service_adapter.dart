import 'dart:async';

import 'package:apple_sign_in/scope.dart';
import 'package:flutter/material.dart';

import 'auth_service.dart';
import 'firebase_auth_service.dart';
import 'mock_auth_service.dart';

enum AuthServiceType { firebase, mock }

class AuthServiceAdapter implements AuthService {
  AuthServiceAdapter({@required AuthServiceType initialAuthServiceType})
      : authServiceTypeNotifier =
            ValueNotifier<AuthServiceType>(initialAuthServiceType) {
    _setup();
  }
  final FirebaseAuthService _firebaseAuthService = FirebaseAuthService();
  final MockAuthService _mockAuthService = MockAuthService();

  // Value notifier used to switch between [FirebaseAuthService] and [MockAuthService]
  final ValueNotifier<AuthServiceType> authServiceTypeNotifier;
  AuthServiceType get authServiceType => authServiceTypeNotifier.value;
  AuthService get authService => authServiceType == AuthServiceType.firebase
      ? _firebaseAuthService
      : _mockAuthService;

  StreamSubscription<User> _firebaseAuthSubscription;
  StreamSubscription<User> _mockAuthSubscription;

  void _setup() {
    // Observable<User>.merge was considered here, but we need more fine grained control to ensure
    // that only events from the currently active service are processed
    _firebaseAuthSubscription =
        _firebaseAuthService.onAuthStateChanged.listen((User user) {
      if (authServiceType == AuthServiceType.firebase) {
        _onAuthStateChangedController.add(user);
      }
    }, onError: (dynamic error) {
      if (authServiceType == AuthServiceType.firebase) {
        _onAuthStateChangedController.addError(error);
      }
    });
    _mockAuthSubscription =
        _mockAuthService.onAuthStateChanged.listen((User user) {
      if (authServiceType == AuthServiceType.mock) {
        _onAuthStateChangedController.add(user);
      }
    }, onError: (dynamic error) {
      if (authServiceType == AuthServiceType.mock) {
        _onAuthStateChangedController.addError(error);
      }
    });
  }

  final StreamController<User> _onAuthStateChangedController =
      StreamController<User>.broadcast();

  @override
  Future<User> createUserWithEmailAndPassword(String email, String password) =>
      authService.createUserWithEmailAndPassword(email, password);

  @override
  Future<User> currentUser() => authService.currentUser();

  @override
  void dispose() {
    _firebaseAuthSubscription?.cancel();
    _mockAuthSubscription?.cancel();
    _onAuthStateChangedController?.close();
    _mockAuthService.dispose();
    authServiceTypeNotifier.dispose();
  }

  @override
  Future<bool> isSignInWithEmailLink(String link) =>
      authService.isSignInWithEmailLink(link);

  @override
  Stream<User> get onAuthStateChanged => _onAuthStateChangedController.stream;

  @override
  Future<void> sendPasswordResetEmail(String email) =>
      authService.sendPasswordResetEmail(email);

  @override
  Future<void> sendSignInWithEmailLink(
          {String email,
          String url,
          bool handleCodeInApp,
          String iOSBundleID,
          String androidPackageName,
          bool androidInstallIfNotAvailable,
          String androidMinimumVersion}) =>
      authService.sendSignInWithEmailLink(
          email: email,
          url: url,
          handleCodeInApp: handleCodeInApp,
          iOSBundleID: iOSBundleID,
          androidPackageName: androidPackageName,
          androidInstallIfNotAvailable: androidInstallIfNotAvailable,
          androidMinimumVersion: androidMinimumVersion);

  @override
  Future<User> signInAnonymously() => authService.signInAnonymously();

  @override
  Future<User> signInWithApple({List<Scope> scopes}) =>
      authService.signInWithApple();

  @override
  Future<User> signInWithEmailAndLink({String email, String link}) =>
      authService.signInWithEmailAndLink();

  @override
  Future<User> signInWithEmailAndPassword(String email, String password) =>
      authService.signInWithEmailAndPassword(email, password);

  @override
  Future<User> signInWithFacebook() => authService.signInWithFacebook();

  @override
  Future<User> signInWithGoogle() => authService.signInWithGoogle();

  @override
  Future<void> signOut() => authService.signOut();
}
