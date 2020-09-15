import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:flutter_svg/flutter_svg.dart';

final marvelLogo = kIsWeb
    // workaround to https://github.com/dnfield/flutter_svg/issues/173
    ? Image.network(
        'lib/example/marvel/assets/marvel.svg',
        semanticLabel: 'Marvel Logo',
      )
    : SvgPicture.asset(
        'lib/example/marvel/assets/marvel.svg',
        semanticsLabel: 'Marvel Logo',
      );
