import 'package:flutter/material.dart';

class LoadingImage extends StatelessWidget {
  const LoadingImage({Key key, @required this.url}) : super(key: key);
  final String url;

  @override
  Widget build(BuildContext context) {
    return Image.network(
      url,
      fit: BoxFit.cover,
      width: double.infinity,
      height: double.infinity,
      errorBuilder: (context, error, stackTrace) {
        return const Center(
          child: Text('error'),
        );
      },
      frameBuilder: (context, child, frame, wasSynchronouslyLoaded) {
        if (!wasSynchronouslyLoaded && frame == null) {
          return const Center(
            child: CircularProgressIndicator(),
          );
        }
        return child;
      },
    );
  }
}
