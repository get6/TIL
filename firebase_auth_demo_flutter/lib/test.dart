import 'package:flutter/material.dart';
import 'package:shimmer/shimmer.dart';

main(List<String> args) {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key key}) : super(key: key);

  @override
  Widget build(BuildContext context) => MaterialApp(
        title: 'Flutter Demo',
        theme: ThemeData(primarySwatch: Colors.blue),
        home: Scaffold(
          body: SafeArea(
            child: SingleChildScrollView(
              child: Shimmer.fromColors(
                  child: FacebookPostWidget(
                    title: 'THis is a title',
                    content: 'This is a content, This is a content',
                    imageUrl:
                        'https://r-cf.bstatic.com/images/hotel/max1024x768/116/116281457.jpg',
                    backgroundColor: Colors.white,
                  ),
                  baseColor: null,
                  highlightColor: null),
            ),
          ),
        ),
      );
}

class FacebookPostWidget extends StatelessWidget {
  const FacebookPostWidget(
      {this.title, this.content, this.imageUrl, this.backgroundColor});

  final String title;
  final String content;
  final String imageUrl;
  final Color backgroundColor;

  @override
  Widget build(BuildContext context) => Column(
        children: [
          Align(
            alignment: Alignment.topLeft,
            child: Text(
              title,
              style: TextStyle(backgroundColor: backgroundColor, fontSize: 30),
            ),
          ),
          SizedBox(
            height: 8,
          ),
          Align(
            alignment: Alignment.topLeft,
            child: Text(
              content,
              style: TextStyle(backgroundColor: backgroundColor, fontSize: 20),
            ),
          ),
          SizedBox(
            height: 8,
          ),
          Image.network(
            imageUrl,
            width: double.infinity,
            height: 200,
            color: backgroundColor,
            fit: BoxFit.fitWidth,
          ),
          SizedBox(
            height: 8,
          ),
        ],
      );
}
