import 'dart:async';
import 'package:apple_sign_in/apple_sign_in.dart';
import 'package:meta/meta.dart';
import 'package:flutter/material.dart';

@immutable
class User {
  const User({
    @required this.uid,
    this.email,
    this.photoUrl,
    this.displayName,
  });

  final String uid;
  final String email;
  final String photoUrl;
  final String displayName;
}

abstract class AuthService {
  Future<User> currentUser(); // 현재 사용자
  Future<User> signInAnonymously(); // 익명 가입
  Future<User> signInWithEmailAndPassword(
      String email, String password); // 이메일 비밀번호로 접속
  Future<User> createUserWithEmailAndPassword(
      String email, String password); // 이메일 비밀번호로 가입
  Future<void> sendPasswordResetEmail(String email); // 이메일 보내서 비밀번호 초기화
  Future<User> signInWithEmailAndLink(
      {String email, String link}); // 이메일과 링크로 접속
  Future<bool> isSignInWithEmailLink(String link); // 이메일 링크로 접속한 여부
  Future<void> sendSignInWithEmailLink({
    @required String email,
    @required String url,
    @required bool handleCodeInApp,
    @required String iOSBundleID,
    @required String androidPackageName,
    @required bool androidInstallIfNotAvailable,
    @required String androidMinimumVersion,
  }); // 이메일 링크로 접속 보내기
  Future<User> signInWithGoogle();

  Future<User> signInWithFacebook();

  Future<User> signInWithApple({List<Scope> scopes});

  Future<void> signOut(); // 접속 해제
  Stream<User> get onAuthStateChanged;

  void dispose();
}
