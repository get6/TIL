import 'package:firebase_auth_demo_flutter/constants/strings.dart';
import 'package:flutter/material.dart';

import 'auth_service_type_selector.dart';

class DeveloperMenu extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return SizedBox(
      width: MediaQuery.of(context).size.width * 0.85,
      child: Drawer(
        child: Column(
          children: [
            DrawerHeader(
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.stretch,
                children: [
                  Text(
                    Strings.developerMenu,
                    style: TextStyle(
                      fontSize: 22.0,
                      color: Colors.white,
                    ),
                  ),
                ],
              ),
              decoration: BoxDecoration(
                color: Colors.indigo,
              ),
            ),
            _buildOptions(context),
          ],
        ),
      ),
    );
  }

  Widget _buildOptions(BuildContext context) {
    return Expanded(
      child: ListView(
        children: [
          AuthServiceTypeSelector(),
        ],
      ),
    );
  }
}
