import 'dart:async';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

class EmailLinkErrorPresenter extends StatefulWidget {
  const EmailLinkErrorPresenter({Key key, this.child, this.errorStream}) : super(key: key);
  final Widget child;
  final Stream<EmailLinkError> errorStream;
  @override
  _EmailLinkErrorPresenterState createState() => _EmailLinkErrorPresenterState();
}

class _EmailLinkErrorPresenterState extends State<EmailLinkErrorPresenter> {
  @override
  Widget build(BuildContext context) {
    return Container();
  }
}
